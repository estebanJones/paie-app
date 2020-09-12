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
	
	public BigDecimal getNetAPayer(BulletinSalaire bulletin, Grade grade) {
		List<Cotisation> cotisations = this.cotisationRepository.findByImposableIsFalse();
		BigDecimal somme = new BigDecimal("0");
		for(Cotisation c : cotisations) {
			somme.add(c.getTauxSalarial().multiply(this.getSalaireBrut(bulletin, grade)));
		}
		
		return this.getNetAPayer(bulletin, grade).subtract(somme);
	}
	
	public BigDecimal getNetImposable(BulletinSalaire bulletin, Grade grade) {
		return this.getSalaireBrut(bulletin, grade).subtract(this.getTotalRetenueSalarial(bulletin, grade));
	}
	
	public BigDecimal getTotalRetenueSalarial(BulletinSalaire bulletin, Grade grade) {
		List<Cotisation> cotisations = this.cotisationRepository.findByImposableIsTrue();
		BigDecimal totalRetenueSalarial = new BigDecimal("0");
		
		for(Cotisation c : cotisations) {
			totalRetenueSalarial.add(c.getTauxSalarial().multiply(this.getSalaireBrut(bulletin, grade)));
		}

		return totalRetenueSalarial;
		
	}
	
	public BigDecimal getSalaireBrut(BulletinSalaire bulletin, Grade grade) {
		return bulletin.getPrimeExceptionnelle().add(this.getSalaireBase(grade));
	}
	
	public BigDecimal getSalaireBase(Grade grade) {
		return grade.getNbHeuresBase().multiply(grade.getTauxBase());
	}

}
