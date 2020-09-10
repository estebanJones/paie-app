package dev.paie.entite;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dev.paie.entite.base.BaseEntite;

@Entity
@Table(name="periode")
public class Periode extends BaseEntite{

	private LocalDate dateDebut;
	private LocalDate dateFin;
	
	@OneToMany(mappedBy = "periode")
	private Set<BulletinSalaire> bulletins;
	
	public Periode() {
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

	public Set<BulletinSalaire> getBulletins() {
		return bulletins;
	}

	public void setBulletins(Set<BulletinSalaire> bulletins) {
		this.bulletins = bulletins;
	}
}
