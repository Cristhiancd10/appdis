package ec.edu.ups.appdis.pedidosclientemovil.modelo;

import java.io.Serializable;

import java.math.BigDecimal;


public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer productoid;

	private String descripcion;

	private Integer existencia;

	private BigDecimal preciounit;

	public Producto() {
	}

	public Integer getProductoid() {
		return productoid;
	}

	public void setProductoid(Integer productoid) {
		this.productoid = productoid;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getExistencia() {
		return existencia;
	}

	public void setExistencia(Integer existencia) {
		this.existencia = existencia;
	}

	public BigDecimal getPreciounit() {
		return preciounit;
	}

	public void setPreciounit(BigDecimal preciounit) {
		this.preciounit = preciounit;
	}

	@Override
	public String toString() {
		return "Producto{" +
				"productoid=" + productoid +
				", descripcion='" + descripcion + '\'' +
				", existencia=" + existencia +
				", preciounit=" + preciounit +
				'}';
	}
}