package dev.paie.service;

import javax.transaction.Transactional;

import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.ProfilRepository;

public class ProfilService {
	private ProfilRepository profilRepository;
	
	
	public ProfilService(ProfilRepository profilRepository) {
		this.profilRepository = profilRepository;
	}
	
	@Transactional
	public void insertMatricule(String code) {
		this.profilRepository.save(new ProfilRemuneration(code));
	}
}
