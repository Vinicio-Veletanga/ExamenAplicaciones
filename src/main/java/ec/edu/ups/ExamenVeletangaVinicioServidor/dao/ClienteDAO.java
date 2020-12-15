package ec.edu.ups.ExamenVeletangaVinicioServidor.dao;

import java.io.Serializable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
 

import ec.ups.edu.parqueadero.parqueadero.modelos.Cliente;

/**
 * @author ADMINX
 *
 */
@Stateless
public class ClienteDAO {

	
	@Inject
	private Connection con;

	@Inject
	@PersistenceContext(name = "parqueaderoPersistenceUnit")
	private EntityManager em;
	
/// Metodo para inserta  con persistencia con JPQL
	public void insert(Cliente c) {
		em.persist(c);
	}

	public boolean update(Cliente cliente) {
		em.merge(cliente);
		return true;
	}

	public Cliente read(String cedulaCliente) {
		return em.find(Cliente.class, cedulaCliente);
	} 
	
	public void delete(String cedulaCliente) {
		Cliente c = read(cedulaCliente);
		em.remove(c);
	}
	
	public List<Cliente> getClientes() {
		String jpql = "SELECT c FROM Cliente c ";

		Query q = em.createQuery(jpql, Cliente.class);
		return q.getResultList();
	} 

}
