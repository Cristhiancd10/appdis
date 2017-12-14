package ec.edu.ups.appdis.pedidos.controller;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ec.edu.ups.appdis.pedidos.dao.DireccionDAO;
import ec.edu.ups.appdis.pedidos.dao.OrdenesDAO;
import ec.edu.ups.appdis.pedidos.modelo.Cliente;
import ec.edu.ups.appdis.pedidos.modelo.Direccion;
import ec.edu.ups.appdis.pedidos.modelo.Ordene;

@ManagedBean
public class OrdenesBean {
	
	private int id;

	@Inject
	private OrdenesDAO dao;
	
	@Inject
	private DireccionDAO daoDir;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String doRead(){
		Ordene orden = dao.read(this.id);
		System.out.println(orden.toString());
		
		return null;
	}
	
	public String doList(){		
		List<Ordene> ordenes = dao.getList();
		for(Ordene aux : ordenes) {
			System.out.println(aux.toString());
		}		
		return null;
	}	
	
	public String doList2(){		
		List<Ordene> ordenes = dao.getList2();
		for(Ordene aux : ordenes) {
			System.out.println("Ordene=[id="+aux.getOrdenid()+", "
					+ "descuento="+aux.getDescuento()+","
					+ "cliente="+aux.getCliente()+","
					+ "direccion="+aux.getDireccions()+"]");
		}		
		return null;
	}	
	
	public String doList3(){		
		List<Ordene> ordenes = dao.getList3();
		for(Ordene aux : ordenes) {
			System.out.println("Ordene=[id="+aux.getOrdenid()+", "
					+ "descuento="+aux.getDescuento()+","
					+ "detelleOrdenes="+aux.getDetalleOrdenes()+","
					+ "cliente="+aux.getCliente()+","
					+ "empleado="+aux.getEmpleado()+"]");
		}		
		return null;
	}
	
	
	public String save() {
		
		Ordene orden = new Ordene();
		orden.setOrdenid(this.id);
		orden.setDescuento(10);
		orden.setFechaorden(new Date());
		
		Direccion dir1 = new Direccion();
		dir1.setCodigo(1*this.id);
		dir1.setCiudad("Cuenca");
		dir1.setDireccion("Monay");
		
		
		orden.addDireccion(dir1);
		
		Direccion dir2 = new Direccion();
		dir2.setCodigo(2*this.id);
		dir2.setCiudad("Quito");
		dir2.setDireccion("Sangolqui");
		
		orden.addDireccion(dir2);
		
		Cliente cliente = new Cliente();
		cliente.setClienteid(1);
		
		orden.setCliente(cliente);
		
		dao.insert(orden);
		
		return null;
	}
	
	
	public String save2() {
		
		Direccion dir1 = new Direccion();
		dir1.setCodigo(1*this.id);
		dir1.setCiudad("Cuenca");
		dir1.setDireccion("Monay");
		
		Ordene orden = new Ordene();
		orden.setOrdenid(878);
		orden.setDescuento(10);
		orden.setFechaorden(new Date());
		
		dir1.setOrdene(orden);
		
		daoDir.insert(dir1);
		
		return null;
	}
	
	
}
