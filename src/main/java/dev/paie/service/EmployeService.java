package dev.paie.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.Employe;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.exception.EntiteIntrouvableException;
import dev.paie.repository.EmployeRepository;

@Service
public class EmployeService {
	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	RemunerationEmployeService remunerationEmployeService;
	
	@Transactional
	public Employe persistEmploye(Employe e) {
		return this.employeRepository.save(e);
	}
	
	public Employe creerEmploye(String matricule, Integer idEntreprise, Integer idProfil, Integer idGrade) {
		RemunerationEmploye remuneration = this.remunerationEmployeService.creerRemunerationEmploye(idEntreprise, idProfil, idGrade);
		remuneration.setMatricule(matricule);
		return new Employe(remuneration);
	}
		
	public Employe findEmployeById(Integer idEmploye) throws Exception {
		Optional<Employe> employe = this.employeRepository.findById(idEmploye);
		if(employe.isPresent()) {
			return employe.get();
		}else {
			throw new EntiteIntrouvableException("Employe introuvable dans la base donnée");
		}
	}
}
