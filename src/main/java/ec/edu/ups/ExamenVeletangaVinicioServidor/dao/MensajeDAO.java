package ec.edu.ups.ExamenVeletangaVinicioServidor.dao;



import java.io.Serializable;
import java.sql.Connection;
//import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ExamenVeletangaVinicioServidor.modelo.Mensaje;

import ec.edu.ups.ExamenVeletangaVinicioServidor.modelo.Usuario;

@Stateless
public class MensajeDAO {

	@Inject
	private Connection con;

	@Inject
	@PersistenceContext(name = "ExamenVeletangaVinicioServidorPersistenceUnit")
	private EntityManager em;

	
	/// Metodo para inserta con persistencia con JPQL
	public void insert(Mensaje m) {
		em.persist(m);
	}

	public boolean update(Mensaje m) {
		em.merge(m);
		return true;
	}

	public Mensaje read(int id) {
		return em.find(Mensaje.class, id);
	}

	public void delete(int id) {
		Mensaje m = read(id);
		em.remove(m);
	}

//	public List<Usuario> getClientes() {
//		String jpql = "SELECT c FROM Usuario c ";
//
//		Query q = em.createQuery(jpql, Usuario.class);
//		return q.getResultList();
//	}

}
