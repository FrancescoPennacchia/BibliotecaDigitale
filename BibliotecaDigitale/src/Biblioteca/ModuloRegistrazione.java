package Biblioteca;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import common.ChangePage;
import controller.action.ActionRegistrazione;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JLabel;
import javax.swing.JPasswordField;

import exception.Exception;



public class ModuloRegistrazione {

	private JFrame frmBibliotecaDigitale;
	private JTextField txtUsername;
	private JTextField txtEmail;
	private JTextField txtDataDiNascita;
	private JTextField txtTitolodistudi;
	private JTextField txtProfessione;
	private JTextField txtResidenza;
	private JLabel label;
	private JLabel lblPassword;
	private JLabel lblEmail;
	private JLabel lblDataDiNascita;
	private JLabel lblTitoloDiStudi;
	private JLabel lblProfessione;
	private JLabel lblResidenza;
	private JPasswordField passwordField;
	private JLabel lblNome;
	private JTextField txtNome;
	private JTextField txtCognome;
	private JLabel lblCognome;

	/**
	 * Launch the application.
	 */
	public static void Registrazione() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloRegistrazione window = new ModuloRegistrazione();
					window.frmBibliotecaDigitale.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ModuloRegistrazione() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		ActionRegistrazione call = new ActionRegistrazione();

		
		frmBibliotecaDigitale = new JFrame();
		frmBibliotecaDigitale.setTitle("Biblioteca Digitale - Registrazione");
		frmBibliotecaDigitale.setResizable(false);
		frmBibliotecaDigitale.setBounds(100, 100, 620, 420);
		frmBibliotecaDigitale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBibliotecaDigitale.getContentPane().setLayout(null);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePage.Login();
				frmBibliotecaDigitale.dispose();
			}
		});
		btnIndietro.setFont(new Font("Myriad CAD", Font.BOLD, 12));
		btnIndietro.setBounds(325, 341, 97, 38);
		frmBibliotecaDigitale.getContentPane().add(btnIndietro);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtUsername.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().isEmpty())
					txtUsername.setText("Username");
			}
		});
		txtUsername.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		txtUsername.setForeground(new Color(204, 204, 204));
		txtUsername.setToolTipText("Username");
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setText("Username");
		txtUsername.setBounds(47, 50, 229, 38);
		frmBibliotecaDigitale.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtEmail.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEmail.getText().isEmpty())
					txtEmail.setText("Email");
			}
		});
		txtEmail.setForeground(new Color(204, 204, 204));
		txtEmail.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		txtEmail.setToolTipText("Email");
		txtEmail.setText("Email");
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setColumns(10);
		txtEmail.setBounds(47, 199, 229, 38);
		frmBibliotecaDigitale.getContentPane().add(txtEmail);
		
		txtDataDiNascita = new JTextField();
		txtDataDiNascita.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtDataDiNascita.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtDataDiNascita.getText().isEmpty())
					txtDataDiNascita.setText("Data Di Nascita");
			}
		});
		txtDataDiNascita.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		txtDataDiNascita.setForeground(new Color(204, 204, 204));
		txtDataDiNascita.setToolTipText("Giorno / Mese  / Anno");
		txtDataDiNascita.setText("Data Di Nascita");
		txtDataDiNascita.setHorizontalAlignment(SwingConstants.CENTER);
		txtDataDiNascita.setColumns(10);
		txtDataDiNascita.setBounds(47, 273, 229, 38);
		frmBibliotecaDigitale.getContentPane().add(txtDataDiNascita);
		
		txtTitolodistudi = new JTextField();
		txtTitolodistudi.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtTitolodistudi.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtTitolodistudi.getText().isEmpty())
					txtTitolodistudi.setText("Titolo Di Studi");
			}
		});
		txtTitolodistudi.setForeground(new Color(204, 204, 204));
		txtTitolodistudi.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		txtTitolodistudi.setToolTipText("Titolo Di Studi");
		txtTitolodistudi.setText("Titolo Di Studi");
		txtTitolodistudi.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitolodistudi.setColumns(10);
		txtTitolodistudi.setBounds(325, 121, 229, 38);
		frmBibliotecaDigitale.getContentPane().add(txtTitolodistudi);
		
		txtProfessione = new JTextField();
		txtProfessione.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtProfessione.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtProfessione.getText().isEmpty())
					txtProfessione.setText("Professione");
			}
		});
		txtProfessione.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		txtProfessione.setForeground(new Color(204, 204, 204));
		txtProfessione.setToolTipText("Professione");
		txtProfessione.setText("Professione");
		txtProfessione.setHorizontalAlignment(SwingConstants.CENTER);
		txtProfessione.setColumns(10);
		txtProfessione.setBounds(325, 199, 229, 38);
		frmBibliotecaDigitale.getContentPane().add(txtProfessione);
		
		txtResidenza = new JTextField();
		txtResidenza.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtResidenza.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtResidenza.getText().isEmpty())
					txtResidenza.setText("Residenza");
			}
		});
		txtResidenza.setForeground(new Color(204, 204, 204));
		txtResidenza.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		txtResidenza.setToolTipText("Citta, Provincia, Via, Indirizzo");
		txtResidenza.setText("Residenza");
		txtResidenza.setHorizontalAlignment(SwingConstants.CENTER);
		txtResidenza.setColumns(10);
		txtResidenza.setBounds(325, 273, 229, 38);
		frmBibliotecaDigitale.getContentPane().add(txtResidenza);
		
		JButton btnNewButton = new JButton("Registrati");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String Data = txtDataDiNascita.getText();
                String passText = new String(passwordField.getPassword());

	            call.Registrazione(txtUsername.getText(), passText, txtEmail.getText(), txtNome.getText(), txtCognome.getText(), Data, txtTitolodistudi.getText(), txtProfessione.getText(), txtResidenza.getText());				
				frmBibliotecaDigitale.dispose();
			}			
		});
		btnNewButton.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnNewButton.setBounds(432, 342, 125, 38);
		frmBibliotecaDigitale.getContentPane().add(btnNewButton);
		
		label = new JLabel("Username");
		label.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		label.setBounds(126, 25, 119, 14);
		frmBibliotecaDigitale.getContentPane().add(label);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblPassword.setBounds(126, 99, 119, 14);
		frmBibliotecaDigitale.getContentPane().add(lblPassword);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblEmail.setBounds(143, 166, 150, 22);
		frmBibliotecaDigitale.getContentPane().add(lblEmail);
		
		lblDataDiNascita = new JLabel("Data Di Nascita");
		lblDataDiNascita.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblDataDiNascita.setBounds(99, 248, 135, 14);
		frmBibliotecaDigitale.getContentPane().add(lblDataDiNascita);
		
		lblTitoloDiStudi = new JLabel("Titolo Di Studi");
		lblTitoloDiStudi.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblTitoloDiStudi.setBounds(386, 96, 186, 14);
		frmBibliotecaDigitale.getContentPane().add(lblTitoloDiStudi);
		
		lblProfessione = new JLabel("Professione");
		lblProfessione.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblProfessione.setBounds(388, 170, 119, 14);
		frmBibliotecaDigitale.getContentPane().add(lblProfessione);
		
		lblResidenza = new JLabel("Residenza");
		lblResidenza.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblResidenza.setBounds(388, 248, 119, 14);
		frmBibliotecaDigitale.getContentPane().add(lblResidenza);
		
		passwordField = new JPasswordField();		
        char c = 0;
        passwordField.setText("Password ");
        passwordField.setEchoChar(c);    													//Permette di rendere il campo visibile
		passwordField.setToolTipText("Password");
		passwordField.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
	               char c = '\u25CF';
	               passwordField.setEchoChar(c);
	               passwordField.setText("");            
			}
			@Override
			public void focusLost(FocusEvent e) {
                if(passwordField.getPassword().length == 0) {
                    char c = 0;
                    passwordField.setEchoChar(c);
                    passwordField.setText("Password ");
                }
			}
		});
		passwordField.setForeground(new Color(204, 204, 204));
		passwordField.setBounds(47, 124, 229, 38);
		frmBibliotecaDigitale.getContentPane().add(passwordField);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblNome.setBounds(141, 322, 135, 14);
		frmBibliotecaDigitale.getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtNome.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNome.getText().isEmpty())
					txtNome.setText("Nome");
			}
		});
		txtNome.setToolTipText("Nome");
		txtNome.setText("Nome");
		txtNome.setHorizontalAlignment(SwingConstants.CENTER);
		txtNome.setForeground(new Color(204, 204, 204));
		txtNome.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		txtNome.setColumns(10);
		txtNome.setBounds(47, 339, 229, 38);
		frmBibliotecaDigitale.getContentPane().add(txtNome);
		
		txtCognome = new JTextField();
		txtCognome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtCognome.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtCognome.getText().isEmpty())
					txtCognome.setText("Cognome");
			}
		});
		txtCognome.setToolTipText("Cognome");
		txtCognome.setText("Cognome");
		txtCognome.setHorizontalAlignment(SwingConstants.CENTER);
		txtCognome.setForeground(new Color(204, 204, 204));
		txtCognome.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		txtCognome.setColumns(10);
		txtCognome.setBounds(325, 50, 229, 38);
		frmBibliotecaDigitale.getContentPane().add(txtCognome);
		
		lblCognome = new JLabel("Cognome");
		lblCognome.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblCognome.setBounds(408, 25, 135, 14);
		frmBibliotecaDigitale.getContentPane().add(lblCognome);
	}

}
