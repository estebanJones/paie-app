package dev.paie.dto;

public class EntrepriseDto {
	private String denomination;

	public EntrepriseDto(String denomination) {
		super();
		this.denomination = denomination;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
}
