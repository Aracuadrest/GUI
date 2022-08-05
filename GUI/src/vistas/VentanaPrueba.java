package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrueba extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JLabel lblNumero2;
	private JTextField txt2;
	private JButton btnAceptar;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrueba frame = new VentanaPrueba();
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
	public VentanaPrueba() {
		setTitle("Suma de dos n\u00FAmeros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumero1 = new JLabel("Número 1:");
		lblNumero1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNumero1.setBounds(10, 20, 80, 22);
		contentPane.add(lblNumero1);
		
		txt1 = new JTextField();
		txt1.setFont(new Font("Verdana", Font.PLAIN, 14));
		txt1.setBounds(94, 21, 219, 19);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		lblNumero2 = new JLabel("Número 2:");
		lblNumero2.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNumero2.setBounds(10, 53, 80, 22);
		contentPane.add(lblNumero2);
		
		txt2 = new JTextField();
		txt2.setFont(new Font("Verdana", Font.PLAIN, 14));
		txt2.setColumns(10);
		txt2.setBounds(94, 53, 219, 19);
		contentPane.add(txt2);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sumar();
			}
		});
		btnAceptar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnAceptar.setBounds(155, 156, 108, 37);
		contentPane.add(btnAceptar);
		
		 lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblResultado.setBounds(10, 96, 303, 22);
		contentPane.add(lblResultado);
		
		this.getRootPane().setDefaultButton(btnAceptar);
	}

	protected void sumar() {
		int num1, num2;
		
		try {
		num1= Integer.parseInt(txt1.getText());
		num2=Integer.parseInt(txt2.getText());
		int res=num1+num2;
		lblResultado.setText("La suma es: "+res);
	} catch(NumberFormatException e) {
		JOptionPane.showMessageDialog(this, 
				"Introduzca un número válido", 
				"Número incorrecto", 
				JOptionPane.INFORMATION_MESSAGE );
		}
	}
}
