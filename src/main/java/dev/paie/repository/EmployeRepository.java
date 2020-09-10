package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {

}
