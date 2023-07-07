package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.Color;

public class Ejercicios2_3 extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsu;
	private final String USUARIO = "admin";
	private final String PASSWORD = "1234";
	private JPasswordField password;
	private int cont = 0;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicios2_3 frame = new Ejercicios2_3();
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
	public Ejercicios2_3() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 191);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][196.00,grow][45.00]", "[][][][][][]"));

		JLabel lblNewLabel = new JLabel("Usuario:");
		contentPane.add(lblNewLabel, "cell 1 1");

		txtUsu = new JTextField();
		txtUsu.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if (txtUsu.getText()==null || txtUsu.getText().isBlank()) {
					btnNewButton.setEnabled(false);
				} else {
					btnNewButton.setEnabled(true);
				}
			}
		});
		contentPane.add(txtUsu, "cell 3 1,growx");
		txtUsu.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Contraseña:");
		contentPane.add(lblNewLabel_1, "cell 1 3");

		password = new JPasswordField();
		contentPane.add(password, "cell 3 3,growx");
		
		btnNewButton = new JButton("Aceptar");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				login();
			}
		});
		contentPane.add(btnNewButton, "cell 1 5 3 1,alignx center");
		getRootPane().setDefaultButton(btnNewButton);

	}

	protected void login()
	{
		String pass = new String(this.password.getPassword());
		if (this.txtUsu.getText().equals(USUARIO) && pass.equals(PASSWORD))
		{
			JOptionPane.showMessageDialog(null, "~ Login correcto, bienvenido al sistema ~");
			System.exit(0);
		}
		else
		{
			cont++;
			if (cont < 3)
			{
				JOptionPane.showMessageDialog(null, "Login incorrecto, le quedan " + (3 - cont) + " / " + 3 + " intentos");
				this.txtUsu.setText("");
				this.password.setText("");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Número de intentos excedido. Saliendo...");
				System.exit(0);
			}
		}
	}
}
