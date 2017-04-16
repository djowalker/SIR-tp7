package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import domain.ElectronicDevice;
import domain.Home;
import domain.Person;
import jpa.EntityManagerHelper;
import jpa.JpaTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "personlist", urlPatterns = { "/PersonList" })
public class PersonList extends HttpServlet {


	@Override
	public void init() throws ServletException {
		EntityManagerHelper.getEntityManager();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		EntityManagerHelper.beginTransaction();
		try {
			PrintWriter out = response.getWriter();
			int nomOfPerson = EntityManagerHelper.getEntityManager().createQuery("Select a From Person a",Person.class).getResultList().size();
			if(nomOfPerson != 0){
			List<Person> resultList = EntityManagerHelper.getEntityManager().createQuery("Select a From Person a", Person.class).getResultList();
			
			System.out.println("num of person : " + resultList.size());
			out.println("<HTML>\n<BODY>\n" + 
					"<H1>Recapitulatif des personnes dans la base</H1>\n");
			for (Person pers : resultList) {		
				System.out.println("next Person : " + pers.getName() + " " + pers.getSurname());
				out.println("<UL>\n" + 
							" <LI>Nom: " + pers.getName() + "\n" 
							+ " <LI>Prenom: " + pers.getSurname() + "\n" 
							+ " <LI>Mail: " + pers.getMail() + "\n" 
						+ "</UL>\n");
			}
			out.println("</BODY></HTML>");
			}
			else{
				out.println("<HTML>\n<BODY>\n" + 
						"<H1>Il n'y a pas de personnes dans la BDD !</H1>\n"
						+"</BODY></HTML>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		EntityManagerHelper.commit();
	}

	@Override
	public void destroy() {
		System.out.println("destroy list");
		super.destroy();
		EntityManagerHelper.getEntityManager().close();
	}
}
