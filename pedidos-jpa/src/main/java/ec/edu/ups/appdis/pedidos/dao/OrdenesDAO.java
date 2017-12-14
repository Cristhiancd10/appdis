package ec.edu.ups.appdis.pedidos.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.pedidos.modelo.Direccion;
import ec.edu.ups.appdis.pedidos.modelo.Ordene;

@Stateless
public class OrdenesDAO {

	@Inject
	private EntityManager em;
	
	public Ordene read(int id){
		Ordene orden = em.find(Ordene.class, id);
		orden.getDetalleOrdenes().size();
		orden.getDireccions().size();
		orden.getCliente().getClienteid();
		orden.getEmpleado().getEmpleadoid();
		return orden;
	}
	
	public Ordene read2(int id){
		String jpql = "SELECT o FROM Ordene o JOIN FETCH o.detalleOrdenes do "
						+ "JOIN FETCH o.direccions dir "
						+ "JOIN FETCH o.cliente c "
						+ "JOIN FETCH o.empleado e "
						+ "WHERE o.ordenid = :id "
						+ "  AND o.fehca > :fecha";
		Query query = em.createQuery(jpql, Ordene.class);
		query.setParameter("id", id);
		query.setParameter("fecha", id);
		Ordene orden = (Ordene) query.getSingleResult();
		return orden;
	}
	
	public Ordene read3(int id){
		String jpql = "SELECT o FROM Ordene o JOIN FETCH o.detalleOrdenes do "
						+ "JOIN FETCH o.direccions dir "
						+ "JOIN FETCH o.cliente c "
						+ "JOIN FETCH o.empleado e "
						+ "WHERE o.ordenid = ? "
						//+ "  AND o.fehca > ?"
						;
		Query query = em.createQuery(jpql, Ordene.class);
		query.setParameter(1, id);
		//query.setParameter(2, fecha);
		Ordene orden = (Ordene) query.getSingleResult();
		return orden;
	}
	
	public List<Ordene> getList(){
		String jpql = "SELECT o FROM Ordene o";
		Query query = em.createQuery(jpql, Ordene.class);
		List<Ordene> ordenes = query.getResultList();
		for(Ordene orden : ordenes) {
			orden.getDetalleOrdenes().size();
			orden.getDireccions().size();
			orden.getCliente().getClienteid();
			orden.getEmpleado().getEmpleadoid();
		}
		return ordenes;
	}
	
	public List<Ordene> getList2(){
		String jpql = "SELECT o FROM Ordene o";
		Query query = em.createQuery(jpql, Ordene.class);
		List<Ordene> ordenes = query.getResultList();
		return ordenes;
	}
	
	public List<Ordene> getList3(){
		String jpql = "SELECT o FROM Ordene o JOIN FETCH o.detalleOrdenes do "
						+ "JOIN FETCH o.direccions dir "
						+ "JOIN FETCH o.cliente c "
						+ "JOIN FETCH o.empleado e";
		Query query = em.createQuery(jpql, Ordene.class);
		List<Ordene> ordenes = query.getResultList();
		return ordenes;
	}
	
	public void insert(Ordene orden){
		em.persist(orden);
		
	}
}
