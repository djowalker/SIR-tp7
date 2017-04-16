package fr.istic.sir.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Heater;
import domain.Home;

@Path("/hello")
public class SampleWebService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }
 
    @GET
    @Path("/home")
    @Produces(MediaType.APPLICATION_JSON)
    public Home getHome() {
        Home h = new Home();
        h.setAddress("toto");
        Heater h1 = new Heater();
        h1.setConsommationAvg(500);
        Heater h2 = new Heater();
        h2.setConsommationAvg(600);
        h.addDevice(h1);
        h.addDevice(h2);
        return h;
    }

}
