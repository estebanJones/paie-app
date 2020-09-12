package dev.paie.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.exception.EntiteIntrouvableException;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;

@Service
public class BulletinSalaireService {
	@Autowired
	BulletinSalaireRepository bulletinRepository;
	@Autowired 
	PeriodeRepository periodeRepository;
	
	/**
	 * Persist un Bulletin en BDD
	 * @param periode
	 * @param primeExceptionnelle
	 * @param remunerationEmploye
	 * @return
	 */
	@Transactional
	public BulletinSalaire creerBulletin(Periode periode, BigDecimal primeExceptionnelle, 
							  RemunerationEmploye remunerationEmploye) {
		
		return this.bulletinRepository.save(new BulletinSalaire(periode, remunerationEmploye, primeExceptionnelle));
	}
	
	public BulletinSalaire findBulletinById(Integer id) throws EntiteIntrouvableException {
		Optional<BulletinSalaire> bulletin = this.bulletinRepository.findById(id);
		if(bulletin.isPresent()) {
			return bulletin.get();
		}else {
			
			throw new EntiteIntrouvableException("Introuvable en BDD");
		}
	}
	
	
	public List<BulletinSalaire> findBulletinByPeriode(LocalDate dateDebut, LocalDate dateFin) throws EntiteIntrouvableException {
		List<BulletinSalaire> bulletins = new ArrayList<>();
		List<Periode> periodes = this.periodeRepository.findByDateDebutGreaterThanEqualAndDateFinLessThanEqual(dateDebut, dateFin);
		
		for (Periode periode : periodes) {
			
			bulletins.add(this.bulletinRepository.findByPeriodeId(periode.getId()));
		}
		 
		if(!bulletins.isEmpty()) {
			return bulletins;
		}else {
			throw new EntiteIntrouvableException("Aucun bulletin pour cette periode");
		}
	}
	
}
