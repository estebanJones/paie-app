package dev.paie.utils;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import dev.paie.dto.EntrepriseDto;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
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
	
	
	

	public Optional<Entreprise> joinEntrepriseToRemuneration(Integer idEntreprise) {
		return this.entrepriseService.selectEntreprise(idEntreprise);

	}

	public Optional<ProfilRemuneration> joinProfilToRemuneration(Integer idProfil) {
		return this.profilService.selectProfil(idProfil);
	}
	
	public Optional<Grade> joinPGradeToRemuneration(Integer idGrade) {
		return this.gradeService.select(idGrade);
	}
}
