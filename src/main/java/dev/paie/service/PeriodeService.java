package dev.paie.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.Periode;
import dev.paie.repository.PeriodeRepository;

@Service
public class PeriodeService {
	@Autowired
	PeriodeRepository periodeRepository;
	
	public Periode creerPeriode(LocalDate dateDebut, LocalDate dateFin) {
		return this.periodeRepository.save(new Periode(dateDebut, dateFin));
	}
	

}
