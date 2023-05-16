package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Evento;

public class EventoDAO {
	// QUA DENTRO AVREMO PURE BISOGNO DELL'ENTITY MANAGER OLTRE CHE AI METODI , LO
	// CREERO NEL MAIN E LO PASSERO AI MIEI DAO
	private final EntityManager em;

	public EventoDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Evento e) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(e);
		transaction.commit(); // esecuzione del flash (invio dal persistence context al db)
	}

	public Evento getById(long id) {
		Evento found = em.find(Evento.class, id); // il primo parametro sarà la classe di pertinenza(Nomeclasse.class),
		// il secondo sarà l'id;
		if (found != null) {
			System.out.println("Evento" + " " + id + " " + "trovato");
		} else {
			System.out.println("Non abbiamo trovato niente");
		}
		return found;

	}

//	public void delete(long id, LocalDate date) {
//		Evento found = em.find(Evento.class, date);
//		if (found != null) {
//			EntityTransaction transaction = em.getTransaction();
//			transaction.begin();
//			em.remove(found);
//			transaction.commit();
//			System.out.println("Evento in data: " + date + " " + "è stato eliminato dal db");
//		} else {
//			System.out.println("non ho eliminato un bel  niente");
//		}
//	}

	public void delete(long id) {
		Evento found = em.find(Evento.class, id);
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			System.out.println("Evento " + id + " " + "è stato eliminato dal db");
		} else {
			System.out.println("non ho eliminato un bel  niente");
		}
	}

	public void refresh(long id) {
		Evento found = em.find(Evento.class, id);
		if (found != null) {

			found.setNumeroMassimoPartecipanti(120);
			System.out.println("Pre refresh");
			System.out.println(found);
			em.refresh(found);
			System.out.println("Post refresh");
			System.out.println(found);
		} else {
			System.out.println("non ho trovato niente e non ho refreshato");
		}
	}
}
