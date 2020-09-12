package dev.paie.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import dev.paie.entite.Periode;

public class ListeBulletinDtoResponse {
	private final static LocalDateTime dateCreation = LocalDateTime.now();
	private Periode periode;
	private String matricule;
	private BigDecimal salaireBrut;
	private BigDecimal netImposable;
	private BigDecimal netAPayer;
	
	public ListeBulletinDtoResponse(Periode periode, String matricule, BigDecimal salaireBrut,
			BigDecimal netImposable, BigDecimal netAPayer) {
		super();
		this.periode = periode;
		this.matricule = matricule;
		this.salaireBrut = salaireBrut;
		this.netImposable = netImposable;
		this.netAPayer = netAPayer;
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public Periode getPeriode() {
		return periode;
	}

	public void setPeriode(Periode periode) {
		this.periode = periode;
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

	@Override
	public String toString() {
		return "ListeBulletinDtoResponse [periode=" + periode + ", matricule=" + matricule + ", salaireBrut="
				+ salaireBrut + ", netImposable=" + netImposable + ", netAPayer=" + netAPayer + "]";
	}
	
	
}
