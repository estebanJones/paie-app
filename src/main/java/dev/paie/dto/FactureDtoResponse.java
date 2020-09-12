package dev.paie.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class FactureDtoResponse {
	private static final LocalDateTime dateCreation = LocalDateTime.now();
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private String matricule;
	private BigDecimal salaireBrut;
	private BigDecimal netImposable;
	private BigDecimal netAPayer;
	
	public FactureDtoResponse(LocalDate dateDebut, LocalDate dateFin, String matricule,
			BigDecimal salaireBrut, BigDecimal netImposable, BigDecimal netAPayer) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.matricule = matricule;
		this.salaireBrut = salaireBrut;
		this.netImposable = netImposable;
		this.netAPayer = netAPayer;
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
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

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public BigDecimal getSalaireBrut() {
		return salaireBrut;
	}

	public void setSalaireBrut(BigDecimal salaireBrut) {
		this.salaireBrut = salaireBrut;
	}

	public BigDecimal getNetImposable() {
		return netImposable;
	}

	public void setNetImposable(BigDecimal netImposable) {
		this.netImposable = netImposable;
	}

	public BigDecimal getNetAPayer() {
		return netAPayer;
	}

	public void setNetAPayer(BigDecimal netAPayer) {
		this.netAPayer = netAPayer;
	}
}
