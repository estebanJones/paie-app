package dev.paie.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.Employe;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EmployeRepository;

@Service
public class EmployeService {
		@Autowired
		EmployeRepository employeRepository;
	
		
	public Employe insert(String matricule, Entreprise entreprise, ProfilRemuneration profil, Grade grade) {
		RemunerationEmploye remuneration = new RemunerationEmploye(entreprise, profil, grade);
		remuneration.setMatricule(matricule);
		Employe e = new Employe(remuneration);
		
		return this.employeRepository.save(e);
	}
	
	

}
