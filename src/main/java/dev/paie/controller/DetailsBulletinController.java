package dev.paie.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.dto.request.DetailsBulletinDtoRequest;
import dev.paie.dto.response.CotisationDtoResponse;
import dev.paie.dto.response.DetailsBulletinDtoResponse;
import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.exception.EntiteIntrouvableException;
import dev.paie.service.BulletinSalaireService;

@RestController
@RequestMapping("/paieapp")
public class DetailsBulletinController {
	@Autowired
	BulletinSalaireService bulletinService;
	
	@PostMapping("/detailsfiche")
	public ResponseEntity<?> generateFichePaie(@RequestBody @Valid DetailsBulletinDtoRequest detailsDto, BindingResult resValid) throws EntiteIntrouvableException {
		if(!resValid.hasErrors()) {
			BulletinSalaire bulletin = this.bulletinService.findBulletinById(detailsDto.getIdBulletin());
			List<Cotisation> cotisations = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisations();
			List<CotisationDtoResponse> cotisationResponse = cotisations.stream().map(coti -> new CotisationDtoResponse(coti)).collect(Collectors.toList());
			
			DetailsBulletinDtoResponse response = new DetailsBulletinDtoResponse(bulletin, cotisationResponse);
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.badRequest().body("Un problème est survenu");
		}
	}
}
