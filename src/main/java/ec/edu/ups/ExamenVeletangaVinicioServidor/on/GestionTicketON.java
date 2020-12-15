package ec.edu.ups.ExamenVeletangaVinicioServidor.on;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.parqueadero.parqueadero.modelos.Cliente;
import ec.ups.edu.parqueadero.parqueadero.modelos.Ticket;
import ec.ups.edu.parqueadero.parqueadero.modelos.Vehiculo;
import ec.ups.edu.parqueadero.parqueadero.dao.ClienteDAO;
import ec.ups.edu.parqueadero.parqueadero.dao.VehiculoDAO;
@Stateless
public class GestionTicketON  implements GestionTicketONRemoto{

	@Inject
	private ClienteDAO daoCliente;

	@Inject
	public VehiculoDAO daoVehiculo;

	

	public Ticket salidaVehiculo(int tikcet) {
		return null;
	}

	public double calcularTiempo(int idTicket) {
		return 0;
	}

	public Vehiculo buscarVehiculo(String placa) {
		return null;
	}

	public boolean registrarIngreso(Ticket ticket) {
		return true;
	}


	
	
public boolean registrarCliente(Cliente cliente) throws Exception {
	Cliente client =  cliente;
	if(client.getDni().length()!=10)
		throw new Exception("INGRESAR BIEN LOS DATOS DE CEDULA");
	//daoCliente.insert(client);
	System.out.println("SE LLAMA AL METODO ON ");
	daoCliente.insert(client);
	System.out.println(" SE INSERTO EL CLIENTE");
	return true;
}


	public boolean registrarVehiculo(Vehiculo vehiculo) throws Exception {
		
		if(validarPlaca(vehiculo.getPlaca()))
			try {
				daoVehiculo.insertar(vehiculo);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new Exception("error de regitrarse");
			}
		else
			throw new Exception("Numero de placa incorrecta");
		
		
		return false;
	}
	
//	public List<Cliente> listaclientes(){
//		 return daoCliente.getClientes();
//		
//	}

	private boolean validarPlaca(String placa) {
		// TODO Auto-generated method stub
		if(placa.length()==7)
			return true;
		return false;
	}

}
