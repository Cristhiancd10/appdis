package ec.edu.ups.appdis.pedidos.modelo;

import javax.persistence.Column;

public class CategoriaTemp {

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
}
