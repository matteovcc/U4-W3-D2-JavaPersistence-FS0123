package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.EventoDAO;
import entities.Evento;
import util.JpaUtil;

public class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		EventoDAO sd = new EventoDAO(em);
//		Evento e1 = new Evento("Festival", LocalDate.of(2023, 2, 5), "Festival di musica", "Pubblico", 2150);
//		sd.save(e1);
//		Evento e2 = new Evento("Concerto", LocalDate.of(2022, 11, 4), "Concerto Vasco Rossi", "Pubblico", 200000);
//		sd.save(e2);
//		Evento e3 = new Evento("Festa", LocalDate.of(12, 1, 23), "Festa di compleanno", "Privato", 50);
//		sd.save(e3);

		System.out.println(sd.getById(2));

//		Evento e4 = new Evento("Evento da cancellare", LocalDate.of(2004, 04, 04), "Prova delete", "Pubblico", 0);
//		sd.save(e4);

//		System.out.print(sd.delete(LocalDate.of(2004, 04, 04)));
//		sd.delete(6);

		Evento e5 = new Evento("Evento da refreshare", LocalDate.of(2010, 02, 11), "Prova refresh", "Privato", 0);
		sd.save(e5);
		sd.refresh(8);

		em.close();
		emf.close();

	}

}
