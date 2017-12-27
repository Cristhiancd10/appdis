package ec.edu.ups.appdis.pedidos.clienterest;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import ec.edu.ups.appdis.pedidos.model.Categoria;
import ec.edu.ups.appdis.pedidos.model.Respuesta;

public class CategoriasCli {

	private String WS_GET_CATEGORIA = "http://localhost:8080/pedidos-jpa/srv/pedidos/categoriaid";
	private String WS_GET_CATEGORIAS = "http://localhost:8080/pedidos-jpa/srv/pedidos/categorias";
	private String WS_SAVE_CATEGORIA = "http://localhost:8080/pedidos-jpa/srv/pedidos/guardar";
	
	public Categoria getCategoria(int id) {
		Client client = ClientBuilder.newClient();
		
		
		WebTarget target = client.target(
				WS_GET_CATEGORIA).queryParam("id", id);

		Categoria categoria = target.request().get(Categoria.class);
		
		client.close();
		
		return categoria;		
	}
	
	public List<Categoria> getCategorias() {
		Client client = ClientBuilder.newClient();		
		WebTarget target = client.target(WS_GET_CATEGORIAS);

		List<Categoria> categorias = target.request().get(new GenericType<List<Categoria>>() {});
		
		client.close();
		
		return categorias;		
	}
	
	public Respuesta saveCategogira(int id, String nombre) {
		Categoria cat = new Categoria();
		cat.setCategoriaid(id);
		cat.setNombrecat(nombre);
		
		Client client = ClientBuilder.newClient();		
		WebTarget target = client.target(WS_SAVE_CATEGORIA);
		Respuesta respuesta = target.request().post(Entity.json(cat), Respuesta.class);
			
		return respuesta;
	}
}
