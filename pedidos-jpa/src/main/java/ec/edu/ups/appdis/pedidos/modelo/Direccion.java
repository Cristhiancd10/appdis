package ec.edu.ups.appdis.pedidos.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Direccion" database table.
 * 
 */
@Entity
@Table(name="\"Direccion\"")
@NamedQuery(name="Direccion.findAll", query="SELECT d FROM Direccion d")
public class Direccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer codigo;

	private String ciudad;

	private String direccion;

	//bi-directional many-to-one association to Ordene
	@ManyToOne
	@JoinColumn(name="orden")
	private Ordene ordene;

	public Direccion() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Ordene getOrdene() {
		return this.ordene;
	}

	public void setOrdene(Ordene ordene) {
		this.ordene = ordene;
	}

}