package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "eventi")
@Getter
@Setter
@ToString
public class Evento {
	@Id
	@GeneratedValue
	private long id;
	private String titolo;
	private LocalDate date;
	private String descrizione;
	private String tipoEvento;
	private int numeroMassimoPartecipanti;

	public Evento(String titolo, LocalDate date, String descrizione, String tipoEvento, int numeroMassimoPartecipanti) {
		super();
		this.titolo = titolo;
		this.date = date;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.setNumeroMassimoPartecipanti(numeroMassimoPartecipanti);
	}

	public Evento() {

	}

//	public int getNumeroMassimoPartecipanti() {
//		return numeroMassimoPartecipanti;
//	}
//
//	public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
//		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
//	}

//	@Override
//	public String toString() {
//		return titolo + " " + descrizione + " " + "in data" + " " + date + " " + "Num Partecipanti" + " "
//				+ numeroMassimoPartecipanti;
//	}

}
