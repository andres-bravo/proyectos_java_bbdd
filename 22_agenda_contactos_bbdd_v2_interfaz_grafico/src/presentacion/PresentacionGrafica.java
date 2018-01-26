package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import beans.Contacto;
import modelo.GestionAgenda;
import presentacion.adaptadores.AdaptadorCombo;

public class PresentacionGrafica extends JFrame {

	private JPanel contentPane;
	private JTextField textEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PresentacionGrafica frame = new PresentacionGrafica();
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
	public PresentacionGrafica() {
		GestionAgenda ga = new GestionAgenda();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDatosContacto = new JLabel("con");
		lblDatosContacto.setBounds(41, 168, 383, 39);
		contentPane.add(lblDatosContacto);
		
		textEmail = new JTextField();
		textEmail.setBounds(158, 101, 233, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnAddContacto = new JButton("A\u00F1adir Contacto");
		btnAddContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Lo llamo con su método estático 
				AddContacto addcontacto = AddContacto.getAddContacto();
			}
		});
		btnAddContacto.setBounds(41, 57, 89, 23);
		contentPane.add(btnAddContacto);
		
		JButton btnBuscarContacto = new JButton("Buscar Contacto");
		btnBuscarContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contacto con = ga.buscar(textEmail.getText());
				if (con!=null) {
					lblDatosContacto.setText(con.getEmail() + " " + con.getNombre() + " " + con.getTelefono());
				}else {
					lblDatosContacto.setText("No existe el contacto");
				}
			}
		});
		btnBuscarContacto.setBounds(41, 100, 89, 23);
		contentPane.add(btnBuscarContacto);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	//finaliza Java la JVM
			}
		});
		btnSalir.setBounds(166, 218, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnLista = new JButton("ListaContactos");
		btnLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JVContactos v = new JVContactos();
			}
		});
		btnLista.setBounds(273, 218, 89, 23);
		contentPane.add(btnLista);
		
		JComboBox cbContactos = new JComboBox();
		cbContactos.setBounds(196, 36, 178, 23);
		contentPane.add(cbContactos);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(285, 11, 89, 23);
		contentPane.add(btnEliminar);
		
		//Carga del combo
		GestionAgenda agenda = new GestionAgenda();
		AdaptadorCombo<Contacto> adp = new AdaptadorCombo<>(agenda.recuperarTodos());
		cbContactos.setModel(adp);

	}
}
