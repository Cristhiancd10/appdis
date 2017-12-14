package ec.edu.ups.appdis.pedidos.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.appdis.pedidos.modelo.Direccion;

@Stateless
public class DireccionDAO {

	@Inject 
	private EntityManager em;
	
	public void insert(Direccion dir) {
		em.persist(dir);
	}
	
}
