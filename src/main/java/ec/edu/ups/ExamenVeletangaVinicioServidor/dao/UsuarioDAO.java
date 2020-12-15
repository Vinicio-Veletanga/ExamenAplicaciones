package ec.edu.ups.ExamenVeletangaVinicioServidor.dao;

import java.sql.Connection;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.ExamenVeletangaVinicioServidor.modelo.Usuario;
import ec.edu.ups.ExamenVeletangaVinicioServidor.utils.Resources;

@Stateless
public class UsuarioDAO {

//	@Inject
//	private Connection con;

	@Inject
	@PersistenceContext(name = "ExamenVeletangaVinicioServidorPersistenceUnit")
	private EntityManager em;

	/// Metodo para inserta con persistencia con JPQL
	public void insert(Usuario u) {
		em.persist(u);
	}

	public boolean update(Usuario u) {
		em.merge(u);
		return true;
	}

	public Usuario read(String nombre) {
		return em.find(Usuario.class, nombre);
	}

	public void delete(String nombre) {
		Usuario u = read(nombre);
		em.remove(u);
	}

	public List<Usuario> getClientes() {
		String jpql = "SELECT c FROM Cliente c ";

		Query q = em.createQuery(jpql, Usuario.class);
		return q.getResultList();
	}

}
