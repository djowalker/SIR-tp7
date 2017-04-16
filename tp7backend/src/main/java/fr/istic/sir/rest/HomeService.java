package fr.istic.sir.rest;

import java.util.Iterator;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Home;
import jpa.EntityManagerHelper;;

@Path("/home")
public class HomeService {
	
	@POST
	@Path("/addHome")
	public void addHomeAngular(String json) throws JSONException {	
		// L'objet JSON permet de récupérer les valeurs créées en angular
		JSONObject object = new JSONObject(json);
		
		EntityManagerHelper.beginTransaction();
		
		//on associe à un nouvel objet les valeurs qui correspondent
		Home added = new Home(object.getString("address"),object.getString("town"),object.getInt("rooms"),object.getInt("surface"));
		EntityManagerHelper.getEntityManager().persist(added);

		EntityManagerHelper.commit();
		
	}
	
	@POST
	@Path("/add")
	public Response addHome(@FormParam("address") String address, @FormParam("town") String town,
			@FormParam("rooms") int rooms, @FormParam("surface") int surface) {
		EntityManagerHelper.getEntityManager();
		
		EntityManagerHelper.beginTransaction();
		Home addedHome = new Home(address, town, rooms, surface);
		EntityManagerHelper.getEntityManager().persist(addedHome);

		
		EntityManagerHelper.commit();

		EntityManagerHelper.closeEntityManager();
		return Response.status(200).entity("addHome is called, the data here has been added to the database address : "
				+ address + ", ville : " + town + ", pieces : " + rooms + ", surface : " + surface).build();
	}

	 @GET
	 @Path("/list")
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<Home> getHomes() {
	        
		EntityManagerHelper.getEntityManager();
			
		EntityManagerHelper.beginTransaction();
			
		List<Home> resultList = EntityManagerHelper.getEntityManager().createQuery("Select a From Home a", Home.class).getResultList();
		for (Iterator iterator = resultList.iterator(); iterator.hasNext();) {
			Home home = (Home) iterator.next();
			System.out.println(home);
		}
		System.out.println(resultList.size());

		EntityManagerHelper.commit();
					
		EntityManagerHelper.closeEntityManager();
		return resultList;
			
	 }

}
