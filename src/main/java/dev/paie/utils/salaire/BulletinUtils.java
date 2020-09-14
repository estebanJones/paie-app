package dev.paie.utils.salaire;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Grade;
import dev.paie.repository.CotisationRepository;

@Component
public class BulletinUtils {
	@Autowired
	CotisationRepository cotisationRepository;
	
	/**
	 * Calcul le net à payer
	 * @param bulletin
	 * @param grade
	 * @return
	 */
	public BigDecimal getNetAPayer(BulletinSalaire bulletin, Grade grade) {
		List<Cotisation> cotisations = this.cotisationRepository.findByImposableIsFalse();
		BigDecimal somme = new BigDecimal("0");
		for(Cotisation c : cotisations) {
			if (c.getTauxSalarial() == null) {
				c.setTauxSalarial(new BigDecimal("0"));
			}
			somme.add(c.getTauxSalarial().multiply(this.getSalaireBrut(bulletin, grade)));
		}
		
		return this.getNetImposable(bulletin, grade).subtract(somme);
	}
	
	/**
	 * Calcul le net imposable
	 * @param bulletin
	 * @param grade
	 * @return
	 */
	public BigDecimal getNetImposable(BulletinSalaire bulletin, Grade grade) {
		return this.getSalaireBrut(bulletin, grade).subtract(this.getTotalRetenueSalarial(bulletin, grade));
	}
	
	/**
	 * Calcule le total retenue salarial
	 * @param bulletin
	 * @param grade
	 * @return
	 */
	public BigDecimal getTotalRetenueSalarial(BulletinSalaire bulletin, Grade grade) {
		List<Cotisation> cotisations = this.cotisationRepository.findByImposableIsTrue();
		BigDecimal totalRetenueSalarial = new BigDecimal("0");
		
		for(Cotisation c : cotisations) {
			totalRetenueSalarial.add(c.getTauxSalarial().multiply(this.getSalaireBrut(bulletin, grade)));
		}

		return totalRetenueSalarial;
		
	}
	
	/**
	 * Calcul le salaire brut
	 * @param bulletin
	 * @param grade
	 * @return
	 */
	public BigDecimal getSalaireBrut(BulletinSalaire bulletin, Grade grade) {
		return bulletin.getPrimeExceptionnelle().add(this.getSalaireBase(grade));
	}
	
	/**
	 * Calcule le salaire de base
	 * @param grade
	 * @return
	 */
	public BigDecimal getSalaireBase(Grade grade) {
		return grade.getNbHeuresBase().multiply(grade.getTauxBase());
	}

}
