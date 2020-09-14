package dev.paie.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;

public class DetailsBulletinDtoResponse {
	private String entrepriseName;
	private String siret;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private String matricule;
	private BigDecimal baseGrade;
	private BigDecimal tauxSalarialGrade;
	List<CotisationDtoResponse> cotisations;
	
	public DetailsBulletinDtoResponse(BulletinSalaire bulletinSalaire, List<CotisationDtoResponse> cotisations) {
		super();
		this.entrepriseName = bulletinSalaire.getRemunerationEmploye().getEntreprise().getDenomination();
		this.siret = bulletinSalaire.getRemunerationEmploye().getEntreprise().getSiret();
		this.dateDebut = bulletinSalaire.getPeriode().getDateDebut();
		this.dateFin = bulletinSalaire.getPeriode().getDateFin();
		this.matricule = bulletinSalaire.getRemunerationEmploye().getMatricule();
		this.baseGrade = bulletinSalaire.getRemunerationEmploye().getGrade().getTauxBase();
		this.tauxSalarialGrade = bulletinSalaire.getRemunerationEmploye().getGrade().getNbHeuresBase();
		this.cotisations = cotisations;
	}

	public String getEntrepriseName() {
		return entrepriseName;
	}

	public void setEntrepriseName(String entrepriseName) {
		this.entrepriseName = entrepriseName;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
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

	public BigDecimal getBaseGrade() {
		return baseGrade;
	}

	public void setBaseGrade(BigDecimal baseGrade) {
		this.baseGrade = baseGrade;
	}

	public BigDecimal getTauxSalarialGrade() {
		return tauxSalarialGrade;
	}

	public void setTauxSalarialGrade(BigDecimal tauxSalarialGrade) {
		this.tauxSalarialGrade = tauxSalarialGrade;
	}

	public List<CotisationDtoResponse> getCotisations() {
		return cotisations;
	}

	public void setCotisations(List<CotisationDtoResponse> cotisations) {
		this.cotisations = cotisations;
	}

	@Override
	public String toString() {
		return "DetailsBulletinDtoResponse [entrepriseName=" + entrepriseName + ", siret=" + siret + ", dateDebut="
				+ dateDebut + ", dateFin=" + dateFin + ", matricule=" + matricule + ", baseGrade=" + baseGrade
				+ ", tauxSalarialGrade=" + tauxSalarialGrade + ", cotisations=" + cotisations + "]";
	}

	
}
