package ec.edu.ups.ExamenVeletangaVinicioServidor.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import ec.edu.ups.ExamenVeletangaVinicioServidor.dao.UsuarioDAO;
import ec.edu.ups.ExamenVeletangaVinicioServidor.modelo.Usuario;
import ec.edu.ups.ExamenVeletangaVinicioServidor.on.GestionMensajeriaON;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vistausuario extends JFrame {

	private JPanel contentPane;
	
    private GestionMensajeriaON on;
    private JTextField txtNombres;
    private JTextField txtDireccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vistausuario frame = new Vistausuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vistausuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblnombres = new JLabel("Nombres:");
		lblnombres.setBounds(65, 27, 46, 14);
		contentPane.add(lblnombres);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(65, 74, 46, 14);
		contentPane.add(lblDireccion);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(142, 24, 86, 20);
		contentPane.add(txtNombres);
		txtNombres.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(142, 71, 86, 20);
		contentPane.add(txtDireccion);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(273, 147, 89, 23);
		contentPane.add(btnNewButton);
	}
	
	public void guardarCliente() {
		// TODO Auto-generated method stub
		Usuario c = new Usuario();
		on = new GestionMensajeriaON();
		c.setNombres(txtNombres.getText());
		c.setDireccion(txtDireccion.getText());
		try {
			on.registrarCliente(c);
			System.out.println("Guardar OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block

			System.out.println(c.toString());
			System.out.println("NO SE HA GUARDADO");
			e.printStackTrace();
		}
		
		
	}
}
