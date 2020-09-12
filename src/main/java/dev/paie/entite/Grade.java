package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import dev.paie.entite.base.BaseEntite;

/**
 * 
 * @author Jordan
 *
 */
@Entity
@Table(name="grade")
public class Grade extends BaseEntite{
	private String code;
	private BigDecimal nbHeuresBase;
	private BigDecimal tauxBase;
	
	public Grade() {
		// TODO Auto-generated constructor stub
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getNbHeuresBase() {
		return nbHeuresBase;
	}
	public void setNbHeuresBase(BigDecimal nbHeuresBase) {
		this.nbHeuresBase = nbHeuresBase;
	}
	public BigDecimal getTauxBase() {
		return tauxBase;
	}
	public void setTauxBase(BigDecimal tauxBase) {
		this.tauxBase = tauxBase;
	}
}
