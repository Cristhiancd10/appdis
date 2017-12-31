package ec.edu.ups.appdis.pedidos.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Categoria implements Serializable {

	private Integer categoriaid;
	private String nombrecat;
	private List<Producto> productos;
	
	public Integer getCategoriaid() {
		return categoriaid;
	}
	public void setCategoriaid(Integer categoriaid) {
		this.categoriaid = categoriaid;
	}
	public String getNombrecat() {
		return nombrecat;
	}
	public void setNombrecat(String nombrecat) {
		this.nombrecat = nombrecat;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	@Override
	public String toString() {
		return "Categoria [categoriaid=" + categoriaid + ", nombrecat=" + nombrecat + ", productos=" + productos + "]";
	}
	
}
