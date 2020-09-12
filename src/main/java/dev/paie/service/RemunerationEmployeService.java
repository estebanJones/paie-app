package dev.paie.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.RemunerationEmployeRepository;

@Service
public class RemunerationEmployeService {
	@Autowired
	LinkService link;
	@Autowired
	RemunerationEmployeRepository remunerationEmployeRepository;
	
	
	
	/**
	 * Créer un objet RemunerationEmploye
	 * @param idEntreprise
	 * @param idProfil
	 * @param idGrade
	 * @return
	 */
	public RemunerationEmploye creerRemunerationEmploye(Integer idEntreprise, Integer idProfil, Integer idGrade) {
		RemunerationEmploye remunerationEmploye = null;
		
		Optional<Entreprise> entreprise = this.link.joinEntrepriseToRemuneration(idEntreprise);
		Optional<ProfilRemuneration> profilRemuneration = this.link.joinProfilToRemuneration(idProfil);
		Optional<Grade> grade = this.link.joinPGradeToRemuneration(idGrade);
		
		if(entreprise.isPresent() && profilRemuneration.isPresent() && grade.isPresent()) {
			remunerationEmploye = new RemunerationEmploye(entreprise.get(), profilRemuneration.get(), grade.get());
		}
		return this.remunerationEmployeRepository.save(remunerationEmploye);
	}
}
