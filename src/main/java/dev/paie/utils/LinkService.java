package dev.paie.utils;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.service.EntrepriseService;
import dev.paie.service.GradeService;
import dev.paie.service.ProfilService;

public class LinkService {
	@Autowired
	EntrepriseService entrepriseService;
	@Autowired
	ProfilService profilService;
	@Autowired
	GradeService gradeService;
	
	
	
	public void linkedRemuneration(Integer idEntreprise, Integer idProfil, Integer idGrade) {
		Optional<Entreprise> entreprise = this.joinEntrepriseToRemuneration(idEntreprise);
		Optional<ProfilRemuneration> profilRemuneration = this.joinProfilToRemuneration(idProfil);
		Optional<Grade> grade = this.joinPGradeToRemuneration(idGrade);
		if(entreprise.isEmpty() && profilRemuneration.isPresent() && grade.isPresent()) {
			
			//return new RemunerationEmploye(entreprise, profilRemuneration, grade)
		}
	}
	
	private Optional<Entreprise> joinEntrepriseToRemuneration(Integer idEntreprise) {
		return this.entrepriseService.selectEntreprise(idEntreprise);
	}

	private Optional<ProfilRemuneration> joinProfilToRemuneration(Integer idProfil) {
		return this.profilService.selectProfil(idProfil);
	}
	
	private Optional<Grade> joinPGradeToRemuneration(Integer idGrade) {
		return this.gradeService.select(idGrade);
	}
}
