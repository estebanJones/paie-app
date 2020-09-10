package dev.paie.dto;

public class EmployeDto {
	private String matricule;
	private Integer idEntreprise;
	private Integer idProfil;
	private Integer idGrade;
	
	
	public EmployeDto(String matricule, Integer idEntreprise, Integer idProfil, Integer idGrade) {
		super();
		this.matricule = matricule;
		this.idEntreprise = idEntreprise;
		this.idProfil = idProfil;
		this.idGrade = idGrade;
	}


	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	public Integer getIdEntreprise() {
		return idEntreprise;
	}


	public void setIdEntreprise(Integer idEntreprise) {
		this.idEntreprise = idEntreprise;
	}


	public Integer getIdProfil() {
		return idProfil;
	}


	public void setIdProfil(Integer idProfil) {
		this.idProfil = idProfil;
	}


	public Integer getIdGrade() {
		return idGrade;
	}


	public void setIdGrade(Integer idGrade) {
		this.idGrade = idGrade;
	}
	
	
}
