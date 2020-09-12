package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dev.paie.entite.base.BaseEntite;

@Entity
@Table(name="bulletin_salaire")
public class BulletinSalaire extends BaseEntite {
	@ManyToOne
	@JoinColumn(name = "periode_id")
	private Periode periode;
	
	@ManyToOne
	@JoinColumn(name = "remuneration_id")
	private RemunerationEmploye remunerationEmploye;
	
	private BigDecimal primeExceptionnelle;
	
	
	public BulletinSalaire() {

	}
	
	
	public BulletinSalaire(Periode periode, RemunerationEmploye remunerationEmploye, BigDecimal primeExceptionnelle) {
		super();
		this.periode = periode;
		this.remunerationEmploye = remunerationEmploye;
		this.primeExceptionnelle = primeExceptionnelle;
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
