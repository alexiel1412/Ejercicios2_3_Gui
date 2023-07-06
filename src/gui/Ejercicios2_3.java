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
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JDesktopPane;

public class Ejercicios2_3 extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsu;
	private final String USUARIO = "admin";
	private final String PASSWORD = "1234";
	private JPasswordField password;
	private int cont = 0;
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][196.00,grow][grow][]", "[][][][][][][][]"));

		JLabel lblNewLabel = new JLabel("Usuario:");
		contentPane.add(lblNewLabel, "cell 2 1");

		txtUsu = new JTextField();
		contentPane.add(txtUsu, "cell 4 1,growx");
		txtUsu.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Contraseña:");
		contentPane.add(lblNewLabel_1, "cell 2 3");

		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});

		password = new JPasswordField();
		contentPane.add(password, "cell 4 3,growx");
		contentPane.add(btnNewButton, "cell 4 6,alignx right");
	}

	protected void login()
	{
		String pass = new String(this.password.getPassword());
		if (this.txtUsu.getText().equals(USUARIO) && pass.equals(PASSWORD))
		{
			JOptionPane.showMessageDialog(null, "~ Login correcto, bienvenido al sistema ~");
			System.exit(0);
		}
			//System.out.println("Bienvenido");
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
