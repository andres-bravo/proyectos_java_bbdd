package presentacion.graficos;

import javax.swing.JFrame;

public class JVentana extends JFrame {
	public JVentana() {
		//definición de título para la ventana heredado de
		//constructor de JFrame
		super("Primera Ventana");
		//Especificamos que se cierre realmente si se cierra la ventana
		//para que finalize el programa.
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//posicionamiento desde posicion 100 ( 100,800,400)
		this.setBounds(100, 100, 800, 400);
		this.setVisible(true);
		
		
	}
}
