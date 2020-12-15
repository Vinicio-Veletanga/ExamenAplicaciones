package ec.edu.ups.ExamenVeletangaVinicioServidor.on;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.ExamenVeletangaVinicioServidor.dao.MensajeDAO;
import ec.edu.ups.ExamenVeletangaVinicioServidor.dao.UsuarioDAO;
import ec.edu.ups.ExamenVeletangaVinicioServidor.modelo.Usuario;

@Stateless
public class GestionMensajeriaON  implements GestionMensajeriaRemotoON{
	
	@Inject
	private UsuarioDAO usuario;
	
	@Inject
	private MensajeDAO mensaje;
	
	
	public boolean registrarCliente(Usuario usua) {
		Usuario usu =  usua;
		usuario.insert(usu);
		System.out.println(" SE INSERTO EL Usuario");
		return true;
	}

}
