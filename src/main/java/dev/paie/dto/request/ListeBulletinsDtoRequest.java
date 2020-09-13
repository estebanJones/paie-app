package dev.paie.dto.request;

import java.time.LocalDate;

public class ListeBulletinsDtoRequest {
	LocalDate dateDebut;
	LocalDate dateFin;
	
	public ListeBulletinsDtoRequest(LocalDate dateDebut, LocalDate String) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
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

}
