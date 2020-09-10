package dev.paie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.MatriculeRepository;

@RestController
@RequestMapping("paie-app/")
public class MatriculeController {
	@Autowired
	private MatriculeRepository matriculeRepository;
	
	
	@PostMapping("/insert-matricule/")
	public void insertMatricule() {
		this.matriculeRepository.save(new RemunerationEmploye());
		
		
	}
}
