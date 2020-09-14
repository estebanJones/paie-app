package dev.paie.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.dto.response.CotisationDtoResponse;
import dev.paie.dto.response.DetailsBulletinDtoResponse;
import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.exception.EntiteIntrouvableException;
import dev.paie.service.BulletinSalaireService;
import dev.paie.utils.logger.LoggerUtils;
import dev.paie.utils.salaire.BulletinUtils;

@RestController
@RequestMapping("/paieapp")
public class DetailsBulletinController {
	@Autowired
	BulletinSalaireService bulletinService;
	@Autowired 
	BulletinUtils bulletinUtils;
	
	@GetMapping("/detailsfiche")
	public ResponseEntity<?> generateFichePaie(@RequestParam("id_bulletin") Integer idBulletin) throws EntiteIntrouvableException {
			BulletinSalaire bulletin = this.bulletinService.findBulletinById(idBulletin);
			List<Cotisation> cotisations = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisations();
			
			BigDecimal base = this.bulletinUtils.getSalaireBrut(bulletin, bulletin.getRemunerationEmploye().getGrade());
			
			List<CotisationDtoResponse> cotisationResponse = 
					cotisations.stream()
							   .filter(cotisation -> cotisation.getTauxSalarial() != null && cotisation.getTauxPatronal() != null)	
							   .map(cotisation -> new CotisationDtoResponse(cotisation, 
																	        base, 
																	        cotisation.getTauxSalarial().add(this.bulletinUtils.getSalaireBrut(bulletin, bulletin.getRemunerationEmploye().getGrade()))))
							  
							   .collect(Collectors.toList());
			
			DetailsBulletinDtoResponse response = new DetailsBulletinDtoResponse(bulletin, cotisationResponse);

			return ResponseEntity.ok(response);
	}
}
