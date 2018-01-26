package presentacion.graficos;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class JVentana extends JFrame {

	private JPanel contentPane;
	private JTextField tx1;
	private JTextField tx2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JVentana frame = new JVentana();
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
	public JVentana() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lb = new JLabel("Resultado");
		lb.setBounds(155, 170, 46, 14);
		contentPane.add(lb);
		
		//listeners
		//Implemento el interfaz ActionListener método actionPerformed con expresión lambda.
		ActionListener lst=e->lb.setText(String.valueOf(((Double.parseDouble(tx1.getText()))+Double.parseDouble(tx2.getText()))));
		ActionListener lst2=e->lb.setText(String.valueOf(((Double.parseDouble(tx1.getText()))*Double.parseDouble(tx2.getText()))));
		
		JButton bt = new JButton("Sumar");
		bt.addActionListener(lst);
		bt.setBounds(28, 114, 89, 23);
		contentPane.add(bt);
		

		
		JButton bt2 = new JButton("Multiplicar");
		bt2.addActionListener(lst2);
		bt2.setBounds(224, 114, 89, 23);
		contentPane.add(bt2);
		
		tx1 = new JTextField();
		tx1.setBounds(28, 11, 86, 20);
		contentPane.add(tx1);
		tx1.setColumns(10);
		
		tx2 = new JTextField();
		tx2.setBounds(28, 57, 86, 20);
		contentPane.add(tx2);
		tx2.setColumns(10);
	}
}
