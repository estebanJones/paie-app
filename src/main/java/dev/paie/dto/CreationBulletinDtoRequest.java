package dev.paie.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreationBulletinDtoRequest {
	private Integer idEmploye;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	BigDecimal primeExceptionnelle;
	
	
	public CreationBulletinDtoRequest(Integer idEmploye, LocalDate dateDebut, LocalDate dateFin, BigDecimal primeExceptionnelle) {
		super();
		this.idEmploye = idEmploye;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.primeExceptionnelle = primeExceptionnelle;
	}

	public Integer getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Integer idEmploye) {
		this.idEmploye = idEmploye;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}

	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}
	
	
}
