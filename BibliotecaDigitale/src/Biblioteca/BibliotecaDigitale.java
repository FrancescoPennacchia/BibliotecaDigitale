package Biblioteca;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import common.ChangePage;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.Color;

import controller.action.ActionLogin;

public class BibliotecaDigitale {

	private JFrame frmLoginBiblioteca;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BibliotecaDigitale window = new BibliotecaDigitale();
					window.frmLoginBiblioteca.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/* Return LoginPage */
	public static void LoginPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BibliotecaDigitale window = new BibliotecaDigitale();
					window.frmLoginBiblioteca.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BibliotecaDigitale() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		

		ActionLogin call = new ActionLogin();
		
		frmLoginBiblioteca = new JFrame();
		frmLoginBiblioteca.setTitle("Biblioteca Digitale - Login");
		frmLoginBiblioteca.setResizable(false);
		frmLoginBiblioteca.setBounds(100, 100, 620, 420);
		frmLoginBiblioteca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginBiblioteca.getContentPane().setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setForeground(new Color(204, 204, 204));
		usernameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				usernameField.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (usernameField.getText().isEmpty())
					usernameField.setText("Username");
			}
		});
		usernameField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameField.setText("Username");
		usernameField.setToolTipText("Username");
		usernameField.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		usernameField.setBounds(190, 124, 193, 36);
		frmLoginBiblioteca.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblBibliotecaDigitale = new JLabel("Biblioteca Digitale");
		lblBibliotecaDigitale.setFont(new Font("Tekton Pro", Font.PLAIN, 22));
		lblBibliotecaDigitale.setBounds(208, 28, 233, 42);
		frmLoginBiblioteca.getContentPane().add(lblBibliotecaDigitale);
		
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblUsername.setBounds(252, 104, 119, 14);
		frmLoginBiblioteca.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblPassword.setBounds(252, 194, 119, 14);
		frmLoginBiblioteca.getContentPane().add(lblPassword);
		
		
		/* PULSANTE DI LOGIN */
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 String GetPassText = new String (passwordField.getPassword());
				 
				 if(call.UserLogin(usernameField.getText(), GetPassText))
					 frmLoginBiblioteca.dispose();			  
			}
		});
		
		btnLogin.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnLogin.setBounds(236, 274, 108, 36);
		frmLoginBiblioteca.getContentPane().add(btnLogin);
		
		JButton btnRegistrati = new JButton("Registrati");
		btnRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePage.Registrazione();
				frmLoginBiblioteca.dispose();
			}
		});
		btnRegistrati.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnRegistrati.setBounds(236, 331, 108, 36);
		frmLoginBiblioteca.getContentPane().add(btnRegistrati);
		
		passwordField = new JPasswordField();
        char c = 0;
        passwordField.setText("Password ");
        passwordField.setEchoChar(c);

        passwordField.addFocusListener(new FocusListener() {

            public void focusGained(FocusEvent e) {

                char c = '\u25CF';
                passwordField.setEchoChar(c);
                passwordField.setText("");
            }

            public void focusLost(FocusEvent e) {
                if(passwordField.getPassword().length == 0) {
                    char c = 0;
                    passwordField.setEchoChar(c);
                    passwordField.setText("Password ");
                }
            }


        });
        
		
		passwordField.setToolTipText("Password");
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		passwordField.setForeground(Color.GRAY);
		passwordField.setBounds(190, 219, 193, 36);
		frmLoginBiblioteca.getContentPane().add(passwordField);
	   
		
	}
}

