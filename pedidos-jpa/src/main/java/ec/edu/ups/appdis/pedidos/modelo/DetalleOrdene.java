package ec.edu.ups.appdis.pedidos.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_ordenes database table.
 * 
 */
@Entity
@Table(name="detalle_ordenes")
@NamedQuery(name="DetalleOrdene.findAll", query="SELECT d FROM DetalleOrdene d")
public class DetalleOrdene implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalleOrdenePK id;

	private Integer cantidad;

	//bi-directional many-to-one association to Ordene
	@ManyToOne
	@JoinColumn(name="ordenid", insertable=false, updatable=false)
	private Ordene ordene;



	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="productoid")
	private Producto producto;

	

	public DetalleOrdene() {
	}

	public DetalleOrdenePK getId() {
		return this.id;
	}

	public void setId(DetalleOrdenePK id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Ordene getOrdene() {
		return this.ordene;
	}

	public void setOrdene(Ordene ordene1) {
		this.ordene = ordene1;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto1) {
		this.producto = producto1;
	}

	@Override
	public String toString() {
		return "DetalleOrdene [id=" + id + ", cantidad=" + cantidad + ", producto=" + producto + "]";
	}



}