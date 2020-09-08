package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="avantage")
public class Avantage extends BaseEntite{
	
	private String code;
	private String nom;
	private BigDecimal montant;
	
	public Avantage() {
	
	}
	
	
	
	public Avantage(String code, String nom, BigDecimal montant) {
		super();
		this.code = code;
		this.nom = nom;
		this.montant = montant;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	
}
