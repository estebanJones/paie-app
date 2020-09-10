package dev.paie.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.Entreprise;
import dev.paie.repository.EntrepriseRepository;

@Service
public class EntrepriseService {
	@Autowired
	EntrepriseRepository entrepriseRepository;
	
	public Optional<Entreprise> selectEntreprise(Integer id) {
		return this.entrepriseRepository.findById(id);
	}
}
