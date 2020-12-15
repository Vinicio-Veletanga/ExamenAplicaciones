package ec.edu.ups.ExamenVeletangaVinicioServidor.on;

import javax.ejb.Remote;

import ec.edu.ups.ExamenVeletangaVinicioServidor.modelo.Usuario;
@Remote
public interface GestionMensajeriaRemotoON {

	public boolean registrarCliente(Usuario usua)  throws Exception ;
}
