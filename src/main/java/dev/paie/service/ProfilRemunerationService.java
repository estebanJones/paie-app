package dev.paie.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.ProfilRemunerationRepository;

@Service
public class ProfilRemunerationService {
	private ProfilRemunerationRepository profilRepository;
	
	
	public ProfilRemunerationService(ProfilRemunerationRepository profilRepository) {
		this.profilRepository = profilRepository;
	}

	public Optional<ProfilRemuneration> selectProfil(Integer idProfil) {
		return this.profilRepository.findById(idProfil);
	}
}
