package dev.paie.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import dev.paie.entite.base.BaseEntite;

@Entity
@Table(name = "profil_remuneration")
public class ProfilRemuneration extends BaseEntite{

	private String code;
	
	@ManyToMany
	@JoinTable(name="profil_remuneration_cotisations", joinColumns = @JoinColumn(name="profil_remuneration_id", referencedColumnName = "id"),
														inverseJoinColumns = @JoinColumn(name="cotisations_id", referencedColumnName = "id"))
	private List<Cotisation> cotisations;
	
	@ManyToMany
	@JoinTable(name="profil_remuneration_cotisations", joinColumns = @JoinColumn(name="profil_remuneration_id", referencedColumnName = "id"),
														inverseJoinColumns = @JoinColumn(name="avantages_id", referencedColumnName = "id"))
	private List<Avantage> avantages;
	
	public ProfilRemuneration() {

	}
	
	public ProfilRemuneration(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisations() {
		return cotisations;
	}

	public void setCotisations(List<Cotisation> cotisations) {
		this.cotisations = cotisations;
	}

	public List<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}

}
