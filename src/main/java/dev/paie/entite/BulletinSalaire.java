package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="bulletin_salaire")
public class BulletinSalaire extends BaseEntite {
	
	private RemunerationEmploye remunerationEmploye;
	
	private Periode periode;
	
	private BigDecimal primeExceptionnelle;
	
	public BulletinSalaire() {

	}
	
	
	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}
	
	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}
	
	public Periode getPeriode() {
		return periode;
	}
	
	public void setPeriode(Periode periode) {
		this.periode = periode;
	}
	
	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}
	
	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}
	
}
