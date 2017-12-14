package ec.edu.ups.appdis.pedidos.modelo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ordenes database table.
 * 
 */
@Entity
@Table(name="ordenes")
@NamedQuery(name="Ordene.findAll", query="SELECT o FROM Ordene o")
public class Ordene implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer ordenid;

	private Integer descuento;

	@Temporal(TemporalType.DATE)
	private Date fechaorden;

	//bi-directional many-to-one association to DetalleOrdene
	@OneToMany(mappedBy="ordene", fetch=FetchType.LAZY)
	private List<DetalleOrdene> detalleOrdenes;

	//bi-directional many-to-one association to Direcciones
	@OneToMany(mappedBy="ordene", cascade= {CascadeType.ALL})
	private List<Direccion> direccions;


	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="clienteid")
	private Cliente cliente;

	//bi-directional many-to-one association to Empleado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="empleadoid")
	private Empleado empleado;

	

	public Ordene() {
	}

	public Integer getOrdenid() {
		return this.ordenid;
	}

	public void setOrdenid(Integer ordenid) {
		this.ordenid = ordenid;
	}

	public Integer getDescuento() {
		return this.descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}

	public Date getFechaorden() {
		return this.fechaorden;
	}

	public void setFechaorden(Date fechaorden) {
		this.fechaorden = fechaorden;
	}

	public List<DetalleOrdene> getDetalleOrdenes() {
		return this.detalleOrdenes;
	}

	public void setDetalleOrdenes(List<DetalleOrdene> detalleOrdenes1) {
		this.detalleOrdenes = detalleOrdenes1;
	}

	public DetalleOrdene addDetalleOrdenes(DetalleOrdene detalleOrdenes) {
		getDetalleOrdenes().add(detalleOrdenes);
		detalleOrdenes.setOrdene(this);

		return detalleOrdenes;
	}

	public DetalleOrdene removeDetalleOrdenes(DetalleOrdene detalleOrdenes) {
		getDetalleOrdenes().remove(detalleOrdenes);
		detalleOrdenes.setOrdene(null);

		return detalleOrdenes;
	}

	
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado1) {
		this.empleado = empleado1;
	}

	public List<Direccion> getDireccions() {
		return direccions;
	}

	public void setDireccions(List<Direccion> direccions) {
		this.direccions = direccions;
	}

	@Override
	public String toString() {
		return "Ordene [ordenid=" + ordenid + ", descuento=" + descuento + ", fechaorden=" + fechaorden
				+ ", detalleOrdenes=" + detalleOrdenes + ", direccions=" + direccions + ", cliente=" + cliente
				+ ", empleado=" + empleado + "]";
	}

	public void addDireccion(Direccion dir) {
		// TODO Auto-generated method stub
		if(direccions==null)
			this.direccions= new ArrayList<>();
		this.direccions.add(dir);
		dir.setOrdene(this);
	}

	

	

	

}