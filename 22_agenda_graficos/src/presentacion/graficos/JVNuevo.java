package presentacion.graficos;

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


public class JVNuevo extends JFrame {
	private static JVNuevo obj;
	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfEmail;
	private JTextField tfTelefono;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JVNuevo frame = new JVNuevo();
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
	private JVNuevo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(49, 38, 63, 14);
		contentPane.add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(141, 35, 86, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(49, 92, 63, 14);
		contentPane.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(141, 89, 86, 20);
		contentPane.add(tfEmail);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(49, 150, 63, 14);
		contentPane.add(lblTelfono);
		
		tfTelefono = new JTextField();
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(141, 147, 86, 20);
		contentPane.add(tfTelefono);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionAgenda agenda=new GestionAgenda();
				agenda.alta(tfNombre.getText(), 
						tfEmail.getText(), 
						Integer.parseInt(tfTelefono.getText()));
				
				JVNuevo.this.dispose();
			}
		});
		btnGuardar.setBounds(150, 202, 89, 23);
		contentPane.add(btnGuardar);
		
		//escuchador de eventos de la ventana
		WindowListener lstVentana=new WindowListener() {
			
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
				
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				obj=null;
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		};
		
		this.addWindowListener(lstVentana);
		
		this.setVisible(true);
	}
	
	public static JVNuevo getVentana() {
		if(obj==null) {
			obj=new JVNuevo();
		}
		return obj;
	}
}
