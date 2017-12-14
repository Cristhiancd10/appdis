package ec.edu.ups.appdis.pedidos.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detalle_ordenes database table.
 * 
 */
@Embeddable
public class DetalleOrdenePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private Integer ordenid;

	private Integer detalleid;

	public DetalleOrdenePK() {
	}
	public Integer getOrdenid() {
		return this.ordenid;
	}
	public void setOrdenid(Integer ordenid) {
		this.ordenid = ordenid;
	}
	public Integer getDetalleid() {
		return this.detalleid;
	}
	public void setDetalleid(Integer detalleid) {
		this.detalleid = detalleid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetalleOrdenePK)) {
			return false;
		}
		DetalleOrdenePK castOther = (DetalleOrdenePK)other;
		return 
			this.ordenid.equals(castOther.ordenid)
			&& this.detalleid.equals(castOther.detalleid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ordenid.hashCode();
		hash = hash * prime + this.detalleid.hashCode();
		
		return hash;
	}
}