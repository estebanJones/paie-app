package dev.paie.dto.response;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import dev.paie.entite.Cotisation;
import dev.paie.utils.salaire.BulletinUtils;

public class CotisationDtoResponse {
	private String rubrique;
	private BigDecimal baseCotisation;
	private BigDecimal tauxSalarialCotisation;
	private BigDecimal montantSalarialCotisation;
	private BigDecimal tauxPatronCotisation;
	private BigDecimal cotePatronales;
	
	public CotisationDtoResponse(Cotisation cotisation, BigDecimal base, BigDecimal montantSalarial) {
		this.rubrique = cotisation.getLibelle();
		this.baseCotisation = base; // quelle propriété
		this.tauxSalarialCotisation = cotisation.getTauxSalarial();
		this.montantSalarialCotisation = montantSalarial; // quelle propriété
		this.tauxPatronCotisation = cotisation.getTauxPatronal();
		this.cotePatronales = cotisation.getTauxPatronal().subtract(cotisation.getTauxSalarial());
	}

	public String getRubrique() {
		return rubrique;
	}

	public void setRubrique(String rubrique) {
		this.rubrique = rubrique;
	}

	public BigDecimal getBaseCotisation() {
		return baseCotisation;
	}

	public void setBaseCotisation(BigDecimal baseCotisation) {
		this.baseCotisation = baseCotisation;
	}

	public BigDecimal getTauxSalarialCotisation() {
		return tauxSalarialCotisation;
	}

	public void setTauxSalarialCotisation(BigDecimal tauxSalarialCotisation) {
		this.tauxSalarialCotisation = tauxSalarialCotisation;
	}

	public BigDecimal getMontantSalarialCotisation() {
		return montantSalarialCotisation;
	}

	public void setMontantSalarialCotisation(BigDecimal montantSalarialCotisation) {
		this.montantSalarialCotisation = montantSalarialCotisation;
	}

	public BigDecimal getTauxPatronCotisation() {
		return tauxPatronCotisation;
	}

	public void setTauxPatronCotisation(BigDecimal tauxPatronCotisation) {
		this.tauxPatronCotisation = tauxPatronCotisation;
	}

	public BigDecimal getCotePatronales() {
		return cotePatronales;
	}

	public void setCotePatronales(BigDecimal cotePatronales) {
		this.cotePatronales = cotePatronales;
	}

	@Override
	public String toString() {
		return "CotisationDtoResponse [rubrique=" + rubrique + ", baseCotisation=" + baseCotisation
				+ ", tauxSalarialCotisation=" + tauxSalarialCotisation + ", montantSalarialCotisation="
				+ montantSalarialCotisation + ", tauxPatronCotisation=" + tauxPatronCotisation + ", cotePatronales="
				+ cotePatronales + "]";
	}
	
	
}
