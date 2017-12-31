package ec.edu.ups.appdis.pedidos.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.edu.ups.appdis.pedidos.dao.CategoriaDAO;
import ec.edu.ups.appdis.pedidos.modelo.Categoria;
import ec.edu.ups.appdis.pedidos.modelo.CategoriaTemp;
  
@Path("/pedidos")
public class PedidosService {
	
	@Inject
	private CategoriaDAO dao;	
	
	@GET
	@Path("/categoria")
	@Produces("application/json")
	public Categoria getCategoria(@QueryParam("id") int id) {
		Categoria cat = new Categoria();
		cat.setCategoriaid(id);
		cat.setNombrecat("Electrodomesticos");
		return cat;
	}
	
	@GET
	@Path("/categoriaid")
	@Produces("application/json")
	public Categoria getCategoriaId(@QueryParam("id") int id) {
		Categoria cat = dao.read(id);
		System.out.println(cat);
		return cat;
	}
	
	@GET
	@Path("/categorias")
	@Produces("application/json")
	public List<Categoria> getCategorias2() {
		List<Categoria> categorias = dao.getCategorias2();		
		return categorias;
	}
	
	@POST
	@Path("/guardar")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta saveCategoria(Categoria cat) {
		Respuesta resp = new Respuesta();
		try {
			dao.insert(cat);
			resp.setCodigo(1);
			resp.setMensaje("Registro satisfactorio");
		}catch(Exception e) {
			resp.setCodigo(-1);
			resp.setMensaje("Error en registro");
		}			
		return resp;
	}
	
	
	
	@GET
	@Path("/categorias2")
	@Produces("application/json")
	public List<CategoriaTemp> getCategorias() {
		List<Categoria> categorias = dao.getCategorias();
		List<CategoriaTemp> cats = new ArrayList<>();
		for(Categoria cat : categorias) {
			CategoriaTemp temp = new CategoriaTemp();
			temp.setCategoriaid(cat.getCategoriaid());
			temp.setNombrecat(cat.getNombrecat());
			cats.add(temp);
		}
		return cats;
	}
	
}
