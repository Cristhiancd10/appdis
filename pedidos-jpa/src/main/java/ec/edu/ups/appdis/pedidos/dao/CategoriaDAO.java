package ec.edu.ups.appdis.pedidos.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.pedidos.modelo.Categoria;
import ec.edu.ups.appdis.pedidos.modelo.Ordene;

@Stateless
public class CategoriaDAO {

	@Inject
	private EntityManager em;
	
	public Categoria read(int id){
		Categoria categoria = em.find(Categoria.class, id);
		categoria.getProductos().size();
		return categoria;
	}
	
	public List<Categoria> getCategorias(){
		String jpql = "SELECT distinct c FROM Categoria c LEFT JOIN FETCH c.productos";
		Query query = em.createQuery(jpql, Categoria.class);
		List<Categoria> categorias = query.getResultList();
		return categorias;
	}
	
	public List<Categoria> getCategorias2(){
		String jpql = "SELECT distinct c FROM Categoria c";
		Query query = em.createQuery(jpql, Categoria.class);
		List<Categoria> categorias = query.getResultList();
		return categorias;
	}
	
	public void insert(Categoria c) {
		em.persist(c);
	}
	
	public void update(Categoria c) {
		em.merge(c);
	}
	
}
