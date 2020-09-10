package dev.paie.dto;

import dev.paie.entite.Entreprise;

public class EntrepriseDto {
	private String denomination;

	public EntrepriseDto(Entreprise e) {
		super();
		this.denomination = e.getDenomination();
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
}
