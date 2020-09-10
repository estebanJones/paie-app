package dev.paie.service;

import java.util.Optional;

import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.ProfilRepository;

public class ProfilService {
	private ProfilRepository profilRepository;
	
	
	public ProfilService(ProfilRepository profilRepository) {
		this.profilRepository = profilRepository;
	}

	public Optional<ProfilRemuneration> selectProfil(Integer idProfil) {
		return this.profilRepository.findById(idProfil);
	}
}
