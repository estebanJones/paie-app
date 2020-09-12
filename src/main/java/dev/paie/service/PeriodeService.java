package dev.paie.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.Periode;
import dev.paie.repository.PeriodeRepository;

@Service
public class PeriodeService {
	@Autowired
	PeriodeRepository periodeRepository;
	
	@Transactional
	public Periode creerPeriode(LocalDate dateDebut, LocalDate dateFin) {
		return this.periodeRepository.save(new Periode(dateDebut, dateFin));
	}
	
	public List<Periode> selectPeriodeByDate(LocalDate dateDebut, LocalDate dateFin) {
		return this.periodeRepository.findByDateDebutGreaterThanEqualAndDateFinLessThanEqual(dateDebut, dateFin);
	}
}
