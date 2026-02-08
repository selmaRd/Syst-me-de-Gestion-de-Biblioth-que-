package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class SystemInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemInterface frame = new SystemInterface();
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
	public SystemInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 419);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(249, 251, 151));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrWelcome = new JTextArea();
		txtrWelcome.setBackground(new Color(249, 251, 151));
		txtrWelcome.setEditable(false);
		txtrWelcome.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtrWelcome.setText("Welcome to DigitalShelf");
		txtrWelcome.setBounds(209, 77, 328, 37);
		contentPane.add(txtrWelcome);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(277, 166, 210, 30);
		contentPane.add(passwordField);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setText("Password");
		txtrPassword.setBackground(new Color(249, 251, 151));
		txtrPassword.setBounds(201, 168, 77, 28);
		contentPane.add(txtrPassword);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(239, 233, 91, 30);
		contentPane.add(btnNewButton);
		//action bouton 
		btnNewButton.addActionListener(e -> {
		    // Récupérer le mot de passe saisi
		    String enteredPassword = new String(passwordField.getPassword());
		    
		    // Vérifier si le mot de passe est correct
		    if(enteredPassword.equals("admin123")) {  // Remplace "admin123" par ton mot de passe réel
		        // Mot de passe correct, ouvrir MainDashboard
		        MainDashboard dashboard = new MainDashboard();
		        dashboard.setVisible(true);
		        
		        // Fermer l'interface actuelle
		        this.dispose();
		    } else {
		        // Mot de passe incorrect
		        javax.swing.JOptionPane.showMessageDialog(this, "Mot de passe incorrect!", "Erreur", javax.swing.JOptionPane.ERROR_MESSAGE);
		    }
		});
       
		
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setBounds(386, 233, 101, 30);
		contentPane.add(btnNewButton_1);
		
	}
}
