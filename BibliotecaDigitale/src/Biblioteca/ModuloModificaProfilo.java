package Biblioteca;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Componenti.Utente;
import ConnectionDataBase.User;
import Interfaces.InterfaceUser;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import java.text.ParseException;
import Exception.Exception;

public class ModuloModificaProfilo {

	Utente utente = null;
	//String s = Componenti.Component.dateToString(utente.getData());
	InterfaceUser u= new User();
	
	private JFrame frmModificaProfilo;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloModificaProfilo window = new ModuloModificaProfilo();
					window.frmModificaProfilo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void Modifica(Utente user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloModificaProfilo window = new ModuloModificaProfilo(user);
					window.frmModificaProfilo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ModuloModificaProfilo(Utente user) {
		this.utente = user;
		initialize();
	}
	
	public ModuloModificaProfilo() {
		initialize();
	}
	
		
	
	
	
	
	private JTextField txtUsername;
	private JTextField txtEmail;
	private JPasswordField passwordField;
	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtTitoloDiStudi;
	private JTextField TxtProfessione;
	private JTextField txtResidenza;
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmModificaProfilo = new JFrame();
		frmModificaProfilo.setTitle("BibliotecaDigitale - Modifica Profilo");
		frmModificaProfilo.setResizable(false);
		frmModificaProfilo.setBounds(100, 100, 620, 420);
		frmModificaProfilo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmModificaProfilo.getContentPane().setLayout(null);
		
		
		
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModuloLoggato ML = new ModuloLoggato(utente);
				ML.Loggato(utente);
				frmModificaProfilo.dispose();
			}
		});
		btnIndietro.setFont(new Font("Myriad CAD", Font.BOLD, 12));
		btnIndietro.setBounds(286, 341, 97, 38);
		frmModificaProfilo.getContentPane().add(btnIndietro);
		
		JLabel label = new JLabel("Username");
		label.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		label.setBounds(20, 25, 119, 14);
		frmModificaProfilo.getContentPane().add(label);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtUsername.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
                if (txtUsername.getText().isEmpty())
                	txtUsername.setText(utente.getUsername());
			}
		});
		txtUsername.setToolTipText("Username");
		txtUsername.setText(utente.getUsername());
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setForeground(new Color(204, 204, 204));
		txtUsername.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		txtUsername.setColumns(10);
		txtUsername.setBounds(10, 50, 229, 38);
		frmModificaProfilo.getContentPane().add(txtUsername);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		label_1.setBounds(20, 99, 119, 14);
		frmModificaProfilo.getContentPane().add(label_1);
		
		txtEmail = new JTextField();
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtEmail.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEmail.getText().isEmpty())
					txtEmail.setText(utente.getEmail());
			}
		});
		txtEmail.setToolTipText("Email");
		txtEmail.setText(utente.getEmail());
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setForeground(new Color(204, 204, 204));
		txtEmail.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 189, 229, 38);
		frmModificaProfilo.getContentPane().add(txtEmail);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		char c = 0;
        passwordField.setText(utente.getPassword());
        passwordField.setEchoChar(c);
        
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
                char c = '\u25CF';
                passwordField.setEchoChar(c);
                passwordField.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
                if (passwordField.getPassword().length == 0) {
                    char c = 0;
                    passwordField.setEchoChar(c);
                    passwordField.setText("Password ");
                }
			}
		});
		
		passwordField.setToolTipText("Password");
		passwordField.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		passwordField.setForeground(Color.LIGHT_GRAY);
		passwordField.setBounds(10, 124, 229, 38);
		frmModificaProfilo.getContentPane().add(passwordField);
		
		JLabel label_2 = new JLabel("Email");
		label_2.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		label_2.setBounds(20, 165, 150, 22);
		frmModificaProfilo.getContentPane().add(label_2);
		
		JLabel label_4 = new JLabel("Nome");
		label_4.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		label_4.setBounds(20, 238, 135, 14);
		frmModificaProfilo.getContentPane().add(label_4);
		
		txtNome = new JTextField();
		txtNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtNome.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNome.getText().isEmpty())
					txtNome.setText(utente.getNome());
			}
		});
		txtNome.setToolTipText("Nome");
		txtNome.setText(utente.getNome());
		txtNome.setHorizontalAlignment(SwingConstants.CENTER);
		txtNome.setForeground(new Color(204, 204, 204));
		txtNome.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		txtNome.setColumns(10);
		txtNome.setBounds(10, 263, 229, 38);
		frmModificaProfilo.getContentPane().add(txtNome);
		
		JLabel label_5 = new JLabel("Cognome");
		label_5.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		label_5.setBounds(295, 25, 135, 14);
		frmModificaProfilo.getContentPane().add(label_5);
		
		txtCognome = new JTextField();
		txtCognome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtCognome.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtCognome.getText().isEmpty())
					txtCognome.setText(utente.getCognome());
			}
		});
		txtCognome.setToolTipText("Cognome");
		txtCognome.setText(utente.getCognome());
		txtCognome.setHorizontalAlignment(SwingConstants.CENTER);
		txtCognome.setForeground(new Color(204, 204, 204));
		txtCognome.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		txtCognome.setColumns(10);
		txtCognome.setBounds(286, 50, 229, 38);
		frmModificaProfilo.getContentPane().add(txtCognome);
		
		JLabel label_6 = new JLabel("Titolo Di Studi");
		label_6.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		label_6.setBounds(295, 99, 186, 14);
		frmModificaProfilo.getContentPane().add(label_6);
		
		txtTitoloDiStudi = new JTextField();
		txtTitoloDiStudi.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtTitoloDiStudi.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtTitoloDiStudi.getText().isEmpty())
					txtTitoloDiStudi.setText(utente.getTitoloDiStudi());
			}
		});
		txtTitoloDiStudi.setToolTipText("Titolo Di Studi");
		txtTitoloDiStudi.setText(utente.getTitoloDiStudi());
		txtTitoloDiStudi.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitoloDiStudi.setForeground(new Color(204, 204, 204));
		txtTitoloDiStudi.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		txtTitoloDiStudi.setColumns(10);
		txtTitoloDiStudi.setBounds(286, 122, 229, 38);
		frmModificaProfilo.getContentPane().add(txtTitoloDiStudi);
		
		JLabel label_7 = new JLabel("Professione");
		label_7.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		label_7.setBounds(295, 169, 119, 14);
		frmModificaProfilo.getContentPane().add(label_7);
		
		TxtProfessione = new JTextField();
		TxtProfessione.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				TxtProfessione.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(TxtProfessione.getText().isEmpty())
					TxtProfessione.setText(utente.getProfessione());
			}
		});
		TxtProfessione.setToolTipText("Professione");
		TxtProfessione.setText(utente.getProfessione());
		TxtProfessione.setHorizontalAlignment(SwingConstants.CENTER);
		TxtProfessione.setForeground(new Color(204, 204, 204));
		TxtProfessione.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		TxtProfessione.setColumns(10);
		TxtProfessione.setBounds(286, 189, 229, 38);
		frmModificaProfilo.getContentPane().add(TxtProfessione);
		
		JLabel label_8 = new JLabel("Residenza");
		label_8.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		label_8.setBounds(295, 238, 119, 14);
		frmModificaProfilo.getContentPane().add(label_8);
		
		txtResidenza = new JTextField();
		txtResidenza.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtResidenza.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtResidenza.getText().isEmpty())
					txtResidenza.setText(utente.getResidenza());
			}
		});
		txtResidenza.setToolTipText("Citta, Provincia, Via, Indirizzo");
		txtResidenza.setText(utente.getResidenza());
		txtResidenza.setHorizontalAlignment(SwingConstants.CENTER);
		txtResidenza.setForeground(new Color(204, 204, 204));
		txtResidenza.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		txtResidenza.setColumns(10);
		txtResidenza.setBounds(286, 263, 229, 38);
		frmModificaProfilo.getContentPane().add(txtResidenza);
		
		JButton btnModifica = new JButton("Modifica");
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 try {
				String pass= new String(passwordField.getPassword());
                String email = utente.getEmail();
                String user = utente.getUsername();
                String nome = utente.getNome();
                String cognome = utente.getCognome();
                String studi = utente.getTitoloDiStudi();
                String professione = utente.getProfessione();
                String residenza = utente.getResidenza();
                

                /* Controllo se ci sono state modifiche*/
                if (txtNome.getText().equals(nome) && txtCognome.getText().equals(cognome)
                        && txtEmail.getText().equals(email) &&
                        txtUsername.getText().equals(user) && pass.equals(utente.getPassword()) && txtTitoloDiStudi.getText().equals(studi) && TxtProfessione.getText().equals(professione)
                        && txtResidenza.getText().equals(residenza))  {
                	JOptionPane.showMessageDialog(frmModificaProfilo,"Non sono state fatte modifiche!");
                    throw new Exception("Non sono state fatte modifiche!");
                }


                if (pass.length() == 0) {
                	  JOptionPane.showMessageDialog(frmModificaProfilo,"Inserisci una password!");
                      throw new Exception("Inserire la Password");
                 }
                


                
                
                if (!txtNome.getText().equals(nome) || !txtCognome.getText().equals(cognome)
                        || !txtEmail.getText().equals(email) ||
                        !txtUsername.getText().equals(user) || !pass.equals("") || !txtTitoloDiStudi.getText().equals(studi) || !TxtProfessione.getText().equals(professione)
                        || !txtResidenza.getText().equals(residenza)) {
                    Utente NuovoUtente = new Utente();
                    
                    NuovoUtente = new Utente(utente.getId(), user, pass, nome, cognome, email, utente.getMansione(), utente.getData(), studi, residenza, professione);
                        
                    u.SetUtente(NuovoUtente, pass);
                        
                    BibliotecaDigitale BD = new BibliotecaDigitale();
                    BD.LoginPage();
                    frmModificaProfilo.dispose();

                    
                    JOptionPane.showMessageDialog(frmModificaProfilo, "Modifiche effettuate");
                } else {
                    throw new Exception("Errore DB");
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
			

		}
		});
			
		
		btnModifica.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnModifica.setBounds(393, 342, 125, 38);
		frmModificaProfilo.getContentPane().add(btnModifica);
	}
}
