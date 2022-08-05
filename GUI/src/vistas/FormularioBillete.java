package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Billete;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioBillete extends JFrame {

	private JPanel contentPane;
	private JTextField txtnombre;
	private JTextField txtApellidos;
	private JTextField txtDni;
	private JSpinner spinner_edad;
	private JComboBox comboBox_Billete;
	private JSpinner spinner_NumPasajeros;
	private JRadioButton rdbtnIda;
	private JRadioButton rdbtnIdayVuelta;
	
	private final ButtonGroup grupoTipo = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioBillete frame = new FormularioBillete();
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
	public FormularioBillete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][210.00,grow][]", "[][][][][][][][][26.00,grow][-6.00][]"));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNombre, "cell 1 1,alignx trailing");
		
		txtnombre = new JTextField();
		txtnombre.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(txtnombre, "cell 2 1,growx");
		txtnombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblApellidos, "cell 1 2,alignx trailing");
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(txtApellidos, "cell 2 2,growx");
		txtApellidos.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblEdad, "cell 1 3,alignx right");
		
		spinner_edad = new JSpinner();
		spinner_edad.setModel(new SpinnerNumberModel(18, 0, 99, 1));
		spinner_edad.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(spinner_edad, "cell 2 3,growx");
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblDni, "cell 1 4,alignx trailing");
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtDni.setColumns(10);
		contentPane.add(txtDni, "cell 2 4,growx");
		
		JLabel lblBillete = new JLabel("Billete:");
		lblBillete.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblBillete, "cell 1 5,alignx trailing");
		
		comboBox_Billete = new JComboBox();
		comboBox_Billete.setFont(new Font("Verdana", Font.PLAIN, 14));
		comboBox_Billete.setModel(new DefaultComboBoxModel(new String[] {"Normal", "Joven", "3\u00AAEdad"}));
		contentPane.add(comboBox_Billete, "cell 2 5,growx");
		
		JLabel lblNumPasajeros = new JLabel("Num. Pasajeros:");
		lblNumPasajeros.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNumPasajeros, "cell 1 6");
		
		spinner_NumPasajeros = new JSpinner();
		spinner_NumPasajeros.setModel(new SpinnerNumberModel(1, 1, 15, 1));
		spinner_NumPasajeros.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(spinner_NumPasajeros, "cell 2 6,growx");
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblTipo, "cell 1 7,alignx right");
		
		 rdbtnIda = new JRadioButton("Ida");
		grupoTipo.add(rdbtnIda);
		rdbtnIda.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(rdbtnIda, "flowx,cell 2 7");
		
		rdbtnIdayVuelta = new JRadioButton("Ida y Vuelta");
		grupoTipo.add(rdbtnIdayVuelta);
		rdbtnIdayVuelta.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(rdbtnIdayVuelta, "cell 2 7");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 1 8 2 1,grow");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesarBillete();
			}
		});
		panel.add(btnAceptar);
		btnAceptar.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarDatos();
			}
		});
		panel.add(btnLimpiar);
		btnLimpiar.setFont(new Font("Verdana", Font.PLAIN, 14));
	}

	protected void procesarBillete() {
		String nombre= txtnombre.getText();
		String apellidos=txtApellidos.getText();
		String dni=txtDni.getText();
		
		if (nombre==null || nombre.isBlank() || 
			apellidos==null || apellidos.isBlank() ||
			dni==null || dni.isBlank()) {
			JOptionPane.showMessageDialog(this, "Los campos Nombre, Apellidos y DNI son obligatorios", "Campos obligatorios", JOptionPane.WARNING_MESSAGE);
		}
		int edad = (int) spinner_edad.getValue();
		int modalidad= comboBox_Billete.getSelectedIndex()+1;
		int numPasajeros=(int) spinner_NumPasajeros.getValue();
		boolean idayVuelta=rdbtnIdayVuelta.isSelected();
		
		Billete b = new Billete(nombre, apellidos, edad, modalidad,
				dni, numPasajeros, idayVuelta);
		
		JOptionPane.showMessageDialog(this, "El importe total del billete es: "+b.getImporteTotal(), 
				"Importe del billete", JOptionPane.INFORMATION_MESSAGE);
		
				
		
	}

	protected void limpiarDatos() {
		txtnombre.setText("");
		txtApellidos.setText("");
		txtDni.setText("");
		spinner_edad.setValue(Integer.valueOf(18));
		comboBox_Billete.setSelectedIndex(0);
		spinner_NumPasajeros.setValue(Integer.valueOf(1));
		//rdbtnIda.setSelected(true); si señalamos una opcion por defecto y que al limpiar vuelva a cogerlo
		grupoTipo.clearSelection();
		
	}
	

}
