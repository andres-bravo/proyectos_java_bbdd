package presentacion;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import beans.Contacto;
import modelo.GestionAgenda;
import presentacion.adaptadores.AdaptadorTabla;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class JVContactos extends JFrame {

	private JPanel contentPane;
	private JTable tbContactos;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JVContactos frame = new JVContactos();
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
	public JVContactos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JVContactos.this.dispose();
			}
		});
		btnSalir.setBounds(170, 227, 89, 23);
		contentPane.add(btnSalir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 414, 114);
		contentPane.add(scrollPane);
		
		tbContactos = new JTable();
		scrollPane.setViewportView(tbContactos);
		
		//carga del JTable
		GestionAgenda agenda=new GestionAgenda();
		List<Contacto> contactos=agenda.recuperarTodos();
		//creamos objeto adaptador
		AdaptadorTabla adp=new AdaptadorTabla(contactos);
		tbContactos.setModel(adp);
		
		this.setVisible(true);
	}
}
