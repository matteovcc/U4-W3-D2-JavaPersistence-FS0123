package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.EventoDAO;
import util.JpaUtil;

public class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
//		NomeclasseDAO sd = new NomeclasseDao(em);
//		Student aldo = new Student("Aldo","Baglio",LocalDate.now);
//		sd.save(aldo);
		EventoDAO sd = new EventoDAO(em);
//		Evento e1 = new Evento("Festival", LocalDate.of(2023, 2, 5), "Festival di musica", "Pubblico", 2150);
//		sd.save(e1);
//		Evento e2 = new Evento("Concerto", LocalDate.of(2022, 11, 4), "Concerto Vasco Rossi", "Pubblico", 200000);
//		sd.save(e2);
//		Evento e3 = new Evento("Festa", LocalDate.of(12, 1, 23), "Festa di compleanno", "Privato", 50);
//		sd.save(e3);

		System.out.println(sd.getById(2));
		em.close();
		emf.close();

	}

}
