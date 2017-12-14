package ec.edu.ups.appdis.pedidos.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the productos database table.
 * 
 */
@Entity
@Table(name="productos")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer productoid;

	@Column(length=50)
	private String descripcion;

	@Column(nullable=false)
	private Integer existencia;

	@Column(nullable=false, precision=131089)
	private BigDecimal preciounit;

	//bi-directional many-to-one association to DetalleOrdene
	@OneToMany(mappedBy="producto")
	private List<DetalleOrdene> detalleOrdenes;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="categoriaid", nullable=false)
	private Categoria categoria;

	//bi-directional many-to-one association to Proveedore
	@ManyToOne
	@JoinColumn(name="proveedorid", nullable=false)
	private Proveedore proveedore;

	public Producto() {
	}

	public Integer getProductoid() {
		return this.productoid;
	}

	public void setProductoid(Integer productoid) {
		this.productoid = productoid;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getExistencia() {
		return this.existencia;
	}

	public void setExistencia(Integer existencia) {
		this.existencia = existencia;
	}

	public BigDecimal getPreciounit() {
		return this.preciounit;
	}

	public void setPreciounit(BigDecimal preciounit) {
		this.preciounit = preciounit;
	}

	public List<DetalleOrdene> getDetalleOrdenes() {
		return this.detalleOrdenes;
	}

	public void setDetalleOrdenes(List<DetalleOrdene> detalleOrdenes) {
		this.detalleOrdenes = detalleOrdenes;
	}

	public DetalleOrdene addDetalleOrdene(DetalleOrdene detalleOrdene) {
		getDetalleOrdenes().add(detalleOrdene);
		detalleOrdene.setProducto(this);

		return detalleOrdene;
	}

	public DetalleOrdene removeDetalleOrdene(DetalleOrdene detalleOrdene) {
		getDetalleOrdenes().remove(detalleOrdene);
		detalleOrdene.setProducto(null);

		return detalleOrdene;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Proveedore getProveedore() {
		return this.proveedore;
	}

	public void setProveedore(Proveedore proveedore) {
		this.proveedore = proveedore;
	}

	@Override
	public String toString() {
		return "Producto [productoid=" + productoid + ", descripcion=" + descripcion + ", existencia=" + existencia
				+ ", preciounit=" + preciounit + ", categoria=" + categoria + ", proveedore=" + proveedore + "]";
	}

	

	
}