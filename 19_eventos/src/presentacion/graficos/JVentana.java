package presentacion.graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
		JLabel lb = new JLabel("Mensaje");
		//Posicionamiento del ojeto
		bt.setBounds(150, 100, 120, 50);
		lb.setBounds(300, 50, 120,50);
		//añadir control a la ventana
		this.add(bt);
		this.add(lb);
			
		//listeners
		//Implemento el interfaz ActionListener método actionPerformed con expresión lambda.
		//ActionListener lst=e->lb.setText("Bienvenido a swing");
		//Implementación con clase anonima.
		ActionListener lst=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lb.setText("Bienvenido a swing");
				
			}
		};
		
		bt.addActionListener(lst);
	}
}
