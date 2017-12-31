package ec.edu.ups.appdis.pedidos.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/ejemplos")
public class Ejemplos {
	
	
	@GET
	@Path("/saludo")
	@Produces("application/json")
	public String saludo(@QueryParam("n") String nombre) {
		return "Hola " + nombre;
	}
	
	@GET
	@Path("/saludo/{nombre}/{edad}")
	@Produces("application/json")
	public String saludo2(@PathParam("nombre") String nombre, @PathParam("edad") int edad) {
		return "Hola " + nombre + ", edad "+ edad + " anios";
	}
	
	@GET
	@Path("/suma")
	@Produces("application/json")
	public int suma(@QueryParam("a") int a, @QueryParam("b") int b) {
		return a + b;
	}

}
