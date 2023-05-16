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
		return found;

	}

//	public void findByIdAndDelete(long id) {
//		Student found = em.find(Nomeclasse.class,id);
//		if(found != null) {
//			EntityTransacction transaction = em.getTransaction();
//			transaction.begin();
//			em.remove(found);
//			transaction.commit();
//			System.out.println("studente eliminato");
//		}else {
//			System.out.println("non ho fatto niente");
//		}
//	} ELIMINARE STUDENTE TROVANDOLO PER ID;

	// ORA FAREMO IL REFRESH
//	public void refresh(long id) {
//		Student found = em.find(Nomeclasse.class,id);
//		found.setFirstName("Giovanni");
//		em.refresh(found);
//		System.out.println(found);
//	}
}
