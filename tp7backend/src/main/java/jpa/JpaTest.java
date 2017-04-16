package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.ElectronicDevice;
import domain.Heater;
import domain.Home;
import domain.Person;


public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
			try{
		
				
				Home h = new Home("rue de Vaugirard", "Brest");
				
				Heater he = new Heater("24A", 35);
				List<Heater> hel = new ArrayList<Heater>();
				hel.add(he);
				
				List<ElectronicDevice> edl = new ArrayList<ElectronicDevice>();
				ElectronicDevice ed = new ElectronicDevice("TV", "SAMSUNG12", 12);
				edl.add(ed);
				
				Home h2 = new Home("rue de test","Lannion",4,100);
				manager.persist(h);
				manager.persist(h2);
				manager.persist(he);
				manager.persist(ed);
				
				test.createPerson();
				
			} catch(Exception e){
				e.printStackTrace();
			}		
				
		tx.commit();
		
		test.listPerson();

		manager.close();
		System.out.println("done");
	}
	
	private void createPerson(){
		int nomOfPerson = manager.createQuery("Select a From Person a",Person.class).getResultList().size();
		if(nomOfPerson == 0){
			Person af = new Person("Andy","Ferdinand");
			Person lf = new Person("Louis","Ferdinand");
			List<Person> lp = new ArrayList<Person>();
			List<Home> homeList = new ArrayList<Home>();
			// les listes correspondent à ce qu'on a créé
			lp.add(af);
			lp.add(lf);
//			homeList.add(h2);
//			homeList.add(h);
			ElectronicDevice ed = new ElectronicDevice("TV", "SAMSUNG12", 12);
			List<ElectronicDevice> edl = new ArrayList<ElectronicDevice>();
			edl.add(ed);
			Person gf = new Person("Guy","Ferdinand","jeandGuy@mescouilles.Fr",lp,homeList,edl);
			manager.persist(gf);
			manager.persist(lf);
			manager.persist(af);
		}
	}
	
	private void listPerson(){
		List<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();
		System.out.println("num of person : " + resultList.size());
		for(Person pers : resultList){
			System.out.println("next Person : " + pers.getName() + " " + pers.getSurname());
		}
	}

	


}
