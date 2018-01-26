package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.GestionAgenda;

public class AddContacto extends JFrame {
	private static AddContacto obj;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textEmail;
	private JTextField textTelefono;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddContacto frame = new AddContacto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	private AddContacto() {
		//Esta lleva DISPOSE_ON_CLOSE para que no finalice el programa
		//solo cierre la ventana
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(34, 33, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(34, 66, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(34, 102, 46, 14);
		contentPane.add(lblTelefono);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionAgenda agenda = new GestionAgenda();
				agenda.alta(textNombre.getText(), 
						textEmail.getText(), 
						Integer.parseInt(textTelefono.getText()));
				//Para salir de la ventana dentro de si misma
				//Como es el evento y estamos en clase anónima lo hago
				//ClaseContenedora.this.dispose()
				AddContacto.obj=null;
				AddContacto.this.dispose();
			}
		});
		btnGuardar.setBounds(172, 161, 89, 23);
		contentPane.add(btnGuardar);
		
		textNombre = new JTextField();
		textNombre.setBounds(111, 30, 270, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(111, 63, 270, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(111, 99, 270, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		WindowListener lstVentana = new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				obj=null;
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		};
		
		
		
		//Esto lo pongo yo para hacer visible la ventana
		//No lo hago desde el botón que la llama para que 
		//sea independiente de quien la llama
		this.setVisible(true);
	}
	public static AddContacto getAddContacto() {
		if(obj==null) {
			obj=new AddContacto();
		}
		return obj;
	}


}
