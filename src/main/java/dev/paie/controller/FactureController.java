package dev.paie.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.dto.FactureDtoRequest;
import dev.paie.dto.FactureDtoResponse;
import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Employe;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.service.BulletinSalaireService;
import dev.paie.service.EmployeService;
import dev.paie.service.PeriodeService;
import dev.paie.service.RemunerationEmployeService;
import dev.paie.utils.salaire.BulletinUtils;

@RestController
@RequestMapping("/paieapp")
public class FactureController {
	@Autowired
	private BulletinSalaireService bulletinSalaireService;
	@Autowired
	private PeriodeService periodeService;
	@Autowired
	private RemunerationEmployeService remunerationEmployeService;
	@Autowired
	private EmployeService employeService;
	@Autowired
	BulletinUtils bulletinUtils;
	
	
	@PostMapping("/createbulletin")
	public ResponseEntity<?> creerBulletinSalaire(@RequestBody @Valid FactureDtoRequest factureDtoRequest, BindingResult resValid) throws Exception {
		if(!resValid.hasErrors()) {
			Employe employe = this.employeService.findEmployeById(factureDtoRequest.getIdEmploye());
			Periode periode = this.periodeService.creerPeriode(factureDtoRequest.getDateDebut(), factureDtoRequest.getDateFin());
			BigDecimal primeExceptionnelle = factureDtoRequest.getPrimeExceptionnelle();
			
			
			RemunerationEmploye remunerationEmploye = this.remunerationEmployeService.creerRemunerationEmploye(employe.getRemunerationEmploye().getEntreprise().getId(), 
																											   employe.getRemunerationEmploye().getProfilRemuneration().getId(), 
																											   employe.getRemunerationEmploye().getGrade().getId());
			
			BulletinSalaire bulletin = this.bulletinSalaireService.creerBulletin(periode, primeExceptionnelle, remunerationEmploye);
			
			FactureDtoResponse response = new FactureDtoResponse(periode.getDateDebut(), 
																 periode.getDateFin(), 
																 employe.getRemunerationEmploye().getMatricule(), 
																 this.bulletinUtils.getSalaireBrut(bulletin, employe.getRemunerationEmploye().getGrade()), 
																 this.bulletinUtils.getNetImposable(bulletin, employe.getRemunerationEmploye().getGrade()), 
																 this.bulletinUtils.getNetAPayer(bulletin, employe.getRemunerationEmploye().getGrade()));
			
			return ResponseEntity.ok(response);
			
		} else {
			return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("Tout les champs de thé sont obligatoires");
		}
	}
}
