package dev.paie.entite;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import dev.paie.entite.base.BaseEntite;

@Entity
@Table(name="avantage")
public class Avantage extends BaseEntite{
	
	private String code;
	private String nom;
	private BigDecimal montant;
	
	@ManyToMany
	@JoinTable(name="profil_remuneration_cotisations", joinColumns = @JoinColumn(name="profil_remuneration_id", referencedColumnName = "id"),
														inverseJoinColumns = @JoinColumn(name="avantages_id", referencedColumnName = "id"))
	private List<ProfilRemuneration> profilRemunerations;
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

	public List<ProfilRemuneration> getProfilRemunerations() {
		return profilRemunerations;
	}

	public void setProfilRemunerations(List<ProfilRemuneration> profilRemunerations) {
		this.profilRemunerations = profilRemunerations;
	}

	
}
