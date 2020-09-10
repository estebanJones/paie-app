package dev.paie.entite;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dev.paie.entite.base.BaseEntite;

@Entity
@Table(name = "remuneration_employe")
public class RemunerationEmploye extends BaseEntite{

	private String matricule;
	
	@OneToOne
	private Entreprise entreprise;
	
	@OneToOne
	private ProfilRemuneration profilRemuneration;
	
	@OneToOne
	private Grade grade;
	
	@OneToMany(mappedBy = "remunerationEmploye")
	Set<BulletinSalaire> bulletins;
	
	public RemunerationEmploye() {
	}
	
	
	public RemunerationEmploye(Entreprise entreprise, ProfilRemuneration profilRemuneration,
			Grade grade) {
		super();
		this.entreprise = entreprise;
		this.profilRemuneration = profilRemuneration;
		this.grade = grade;
	}

	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}
	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}


	@Override
	public String toString() {
		return "RemunerationEmploye [matricule=" + matricule + ", entreprise=" + entreprise + ", profilRemuneration="
				+ profilRemuneration + ", grade=" + grade + ", bulletins=" + bulletins + "]";
	}
	
	
}
