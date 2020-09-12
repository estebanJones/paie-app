package dev.paie.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.BulletinSalaire;

public interface BulletinSalaireRepository extends JpaRepository<BulletinSalaire, Integer> {
	public List<BulletinSalaire> findByPeriodeDateDebutAfterAndPeriodeDateFinBefore(LocalDate dateDebut, LocalDate dateFin);
	public BulletinSalaire findByPeriodeId(Integer idPeriode);
}
