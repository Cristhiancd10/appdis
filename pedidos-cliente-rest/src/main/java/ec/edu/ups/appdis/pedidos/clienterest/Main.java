package ec.edu.ups.appdis.pedidos.clienterest;

import java.util.List;

import ec.edu.ups.appdis.pedidos.model.Categoria;
import ec.edu.ups.appdis.pedidos.model.Respuesta;

public class Main {

	public static void main(String args[]) {
		
		CategoriasCli cli = new CategoriasCli();
		
		//Cosumiendo WS-REST de tipo GET que retorna un objeto 
		Categoria cat = cli.getCategoria(1000);
		System.out.println(cat);
		
		//Cosumiendo WS-REST de tipo GET que retorna una colección de objeto 
		List<Categoria> categorias = cli.getCategorias();
		System.out.println(categorias);
		
		//Consumiento un WS-REST de tipo POST enviando una entidad como parametro
		Respuesta respuesta = cli.saveCategogira(66, "Linea Blanca");
		System.out.println(respuesta);
	}
}
