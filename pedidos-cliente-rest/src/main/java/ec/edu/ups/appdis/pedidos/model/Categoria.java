package ec.edu.ups.appdis.pedidos.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Categoria implements Serializable {

	private Integer categoriaid;
	private String nombrecat;
	
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
	@Override
	public String toString() {
		return "Categoria [categoriaid=" + categoriaid + ", nombrecat=" + nombrecat + "]";
	}
	
	
}
