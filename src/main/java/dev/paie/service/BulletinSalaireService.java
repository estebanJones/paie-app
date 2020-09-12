package dev.paie.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Employe;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.BulletinSalaireRepository;

@Service
public class BulletinSalaireService {
	@Autowired
	BulletinSalaireRepository bulletinRepository;
	
	

	@Transactional
	public BulletinSalaire creerBulletin(Periode periode, BigDecimal primeExceptionnelle, 
							  RemunerationEmploye remunerationEmploye) {
		
		return this.bulletinRepository.save(new BulletinSalaire(periode, remunerationEmploye, primeExceptionnelle));
	}
}
