package ec.edu.ups.ExamenVeletangaVinicioServidor.modelo;

import java.io.Serializable;
//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mensaje implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String mensaje;
	private Usuario remitente;

//     private List< Usuario> destinoUsuarios;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Usuario getRemitente() {
		return remitente;
	}

	public void setRemitente(Usuario remitente) {
		this.remitente = remitente;
	}
//	public List<Usuario> getDestinoUsuarios() {
//		return destinoUsuarios;
//	}
//	public void setDestinoUsuarios(List<Usuario> destinoUsuarios) {
//		this.destinoUsuarios = destinoUsuarios;
//	}
//	@Override
//	public String toString() {
//		return "Mensaje [id=" + id + ", mensaje=" + mensaje + ", remitente=" + remitente + ", destinoUsuarios="
//				+ destinoUsuarios + "]";
//	}

}
