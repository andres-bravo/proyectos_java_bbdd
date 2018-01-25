package presentacion.graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JVentana extends JFrame {
	public JVentana() {
		//definición de título para la ventana heredado de
		//constructor de JFrame
		super("Primera Ventana");
		//Especificamos que se cierre realmente si se cierra la ventana
		//para que finalize el programa.
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//posicionamiento desde posicion 100,100 Ancho y Alto 800,400
		this.setBounds(100, 100, 800, 400);
		//realizamos creación y colocacion de 
		//componentes gráficos
		iniciarComponentes();
		this.setVisible(true);
	}
	private void iniciarComponentes() {
		//Por defecto los componentes son mostrados ocupando todo el frame y unos encima de otros
		//Anulo este comportamiento, podría definir distintos comportamientos, en este caso lo anulo.
		this.setLayout(null);
		//Se saca a un metodo ya que tiene muchas instrucciones para mostrar todos los controles
		//Se le llama en el constructor antes de visualizar la ventana setVisible(true).
		JButton bt = new JButton("Pulsar");
		JButton bt2 = new JButton("Pulsar");
		JLabel lb = new JLabel("Mensaje");
		JTextField tx1 = new JTextField();
		JTextField tx2 = new JTextField();
	
		//Posicionamiento del ojeto
		tx1.setBounds(100, 50, 500, 50);
		tx2.setBounds(100, 150, 500, 50);
		bt.setBounds(150, 200, 120, 50);
		bt2.setBounds(500, 200, 120,50);
		lb.setBounds(300, 300, 120,50);
		//añadir control a la ventana
		this.add(bt);
		this.add(bt2);
		this.add(lb);
		this.add(tx1);
		this.add(tx2);
			
		//listeners
		//Implemento el interfaz ActionListener método actionPerformed con expresión lambda.
		ActionListener lst=e->lb.setText(String.valueOf(((Double.parseDouble(tx1.getText()))+Double.parseDouble(tx2.getText()))));
		ActionListener lst2=e->lb.setText(String.valueOf(((Double.parseDouble(tx1.getText()))*Double.parseDouble(tx2.getText()))));
		/*Implementación con clase anonima.
		ActionListener lst=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lb.setText("Bienvenido a swing");
				
			}
		};*/
		
		bt.addActionListener(lst);
		bt2.addActionListener(lst2);
		
	}
}
