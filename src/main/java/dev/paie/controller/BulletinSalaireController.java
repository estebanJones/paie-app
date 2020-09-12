package dev.paie.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.dto.CreationBulletinDtoRequest;
import dev.paie.dto.CreationBulletinDtoResponse;
import dev.paie.dto.ListeBulletinDtoResponse;
import dev.paie.dto.ListeBulletinsDtoRequest;
import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Employe;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.exception.EntiteIntrouvableException;
import dev.paie.service.BulletinSalaireService;
import dev.paie.service.EmployeService;
import dev.paie.service.PeriodeService;
import dev.paie.service.RemunerationEmployeService;
import dev.paie.utils.salaire.BulletinUtils;

/**
 * 
 * @author Jordan
 *
 */
@RestController
@RequestMapping("/paieapp")
public class BulletinSalaireController {
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

	
	/**
	 * Créer un bulletinDeSalaire
	 * @param factureDtoRequest
	 * @param resValid
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/createbulletin")
	public ResponseEntity<?> creerBulletinSalaire(@RequestBody @Valid CreationBulletinDtoRequest factureDtoRequest, BindingResult resValid) throws Exception {
		if(!resValid.hasErrors()) {
			Employe employe = this.employeService.findEmployeById(factureDtoRequest.getIdEmploye());
			Periode periode = this.periodeService.creerPeriode(factureDtoRequest.getDateDebut(), factureDtoRequest.getDateFin());
			BigDecimal primeExceptionnelle = factureDtoRequest.getPrimeExceptionnelle();
			
			
			RemunerationEmploye remunerationEmploye = this.remunerationEmployeService.creerRemunerationEmploye(employe.getRemunerationEmploye().getEntreprise().getId(), 
																											   employe.getRemunerationEmploye().getProfilRemuneration().getId(), 
																											   employe.getRemunerationEmploye().getGrade().getId());
			
			BulletinSalaire bulletin = this.bulletinSalaireService.creerBulletin(periode, primeExceptionnelle, remunerationEmploye);
			
			CreationBulletinDtoResponse response = new CreationBulletinDtoResponse(periode.getDateDebut(), 
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
	
	@PostMapping("/listebulletins")
	public ResponseEntity<?> listerBulletinSalaire(@RequestBody @Valid ListeBulletinsDtoRequest listBulletinDto, BindingResult resValid) throws EntiteIntrouvableException {
		if(!resValid.hasErrors()) {
			List<ListeBulletinDtoResponse> responseListe = new ArrayList<>();
			List<BulletinSalaire> bulletins = this.bulletinSalaireService.findBulletinByPeriode(listBulletinDto.getDateDebut(), listBulletinDto.getDateFin());
			
			for(BulletinSalaire bulletin : bulletins) {
				responseListe.add(new ListeBulletinDtoResponse(bulletin.getPeriode(), 
						bulletin.getRemunerationEmploye().getMatricule(), 
						this.bulletinUtils.getSalaireBrut(bulletin, bulletin.getRemunerationEmploye().getGrade()), 
						this.bulletinUtils.getNetImposable(bulletin, bulletin.getRemunerationEmploye().getGrade()),
						this.bulletinUtils.getNetAPayer(bulletin,  bulletin.getRemunerationEmploye().getGrade())));
			}
			responseListe.forEach(e -> System.out.println("response " + e));
			return ResponseEntity.ok(responseListe);
		}else {
			
			return ResponseEntity.badRequest().body("Probleme survenu");
		}
	}
}
