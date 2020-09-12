package dev.paie.entite;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dev.paie.entite.base.BaseEntite;

/**
 * 
 * @author Jordan
 *
 */
@Entity
@Table(name="employe")
public class Employe extends BaseEntite  {
	@OneToOne
	private RemunerationEmploye remunerationEmploye;
	
	public Employe() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Employe(RemunerationEmploye remunerationEmploye) {
		super();
		this.remunerationEmploye = remunerationEmploye;
	}


	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}

	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}
	
	
	
}
