package ec.edu.ups.appdis.pedidos.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proveedores database table.
 * 
 */
@Entity
@Table(name="proveedores")
@NamedQuery(name="Proveedore.findAll", query="SELECT p FROM Proveedore p")
public class Proveedore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer proveedorid;

	@Column(length=12)
	private String celuprov;

	@Column(nullable=false, length=50)
	private String contacto;

	@Column(length=12)
	private String fijoprov;

	@Column(nullable=false, length=50)
	private String nombreprov;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="proveedore")
	private List<Producto> productos;

	public Proveedore() {
	}

	public Integer getProveedorid() {
		return this.proveedorid;
	}

	public void setProveedorid(Integer proveedorid) {
		this.proveedorid = proveedorid;
	}

	public String getCeluprov() {
		return this.celuprov;
	}

	public void setCeluprov(String celuprov) {
		this.celuprov = celuprov;
	}

	public String getContacto() {
		return this.contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getFijoprov() {
		return this.fijoprov;
	}

	public void setFijoprov(String fijoprov) {
		this.fijoprov = fijoprov;
	}

	public String getNombreprov() {
		return this.nombreprov;
	}

	public void setNombreprov(String nombreprov) {
		this.nombreprov = nombreprov;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setProveedore(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setProveedore(null);

		return producto;
	}

	@Override
	public String toString() {
		return "Proveedore [proveedorid=" + proveedorid + ", celuprov=" + celuprov + ", contacto=" + contacto
				+ ", fijoprov=" + fijoprov + ", nombreprov=" + nombreprov + "]";
	}

	
	
}