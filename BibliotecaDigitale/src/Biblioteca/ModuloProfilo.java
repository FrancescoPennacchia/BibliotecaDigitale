package Biblioteca;

import java.awt.EventQueue;

import javax.swing.JFrame;

import model.connectionDataBase.User;
import model.interfaces.InterfaceUser;

import javax.swing.JLabel;

import common.ChangePage;
import common.vo.Utente;

import java.awt.Font;

import controller.action.ActionDeleteProfile;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModuloProfilo {
	
	Utente utente = null;
	InterfaceUser u = new User();

	private JFrame frmProfilo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloProfilo window = new ModuloProfilo();
					window.frmProfilo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public static void Profilo(Utente user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloProfilo window = new ModuloProfilo(user);
					window.frmProfilo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public ModuloProfilo(Utente user) {
		this.utente = user;
		initialize();
	}
	
	public ModuloProfilo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ActionDeleteProfile call = new ActionDeleteProfile();
		
		frmProfilo = new JFrame();
		frmProfilo.setTitle("Bibilioteca Digitale - Profilo");
		frmProfilo.setResizable(false);
		frmProfilo.setBounds(100, 100, 620, 420);
		frmProfilo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProfilo.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblUsername.setBounds(31, 42, 119, 14);
		frmProfilo.getContentPane().add(lblUsername);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblNome.setBounds(31, 105, 135, 14);
		frmProfilo.getContentPane().add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome:");
		lblCognome.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblCognome.setBounds(31, 161, 135, 14);
		frmProfilo.getContentPane().add(lblCognome);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblEmail.setBounds(289, 38, 150, 22);
		frmProfilo.getContentPane().add(lblEmail);
		
		JLabel lblDataDiNascita = new JLabel("Data Di Nascita:");
		lblDataDiNascita.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblDataDiNascita.setBounds(31, 225, 150, 14);
		frmProfilo.getContentPane().add(lblDataDiNascita);
		
		JLabel lblResidenza = new JLabel("Residenza:");
		lblResidenza.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblResidenza.setBounds(31, 283, 119, 14);
		frmProfilo.getContentPane().add(lblResidenza);
		
		JLabel lblProfessione = new JLabel("Professione:");
		lblProfessione.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblProfessione.setBounds(289, 161, 119, 14);
		frmProfilo.getContentPane().add(lblProfessione);
		
		JLabel lblTitoloDiStudi = new JLabel("Titolo Di Studi:");
		lblTitoloDiStudi.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblTitoloDiStudi.setBounds(289, 105, 186, 14);
		frmProfilo.getContentPane().add(lblTitoloDiStudi);
		
		JLabel lblUser = new JLabel("" + utente.getUsername());
		lblUser.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		lblUser.setForeground(Color.LIGHT_GRAY);
		lblUser.setBounds(30, 67, 239, 27);
		frmProfilo.getContentPane().add(lblUser);
		
		JLabel labelNome = new JLabel("" + utente.getNome());
		labelNome.setForeground(Color.LIGHT_GRAY);
		labelNome.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		labelNome.setBounds(31, 123, 239, 27);
		frmProfilo.getContentPane().add(labelNome);
		
		JLabel LabelCognome = new JLabel("" + utente.getCognome());
		LabelCognome.setForeground(Color.LIGHT_GRAY);
		LabelCognome.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		LabelCognome.setBounds(31, 186, 239, 27);
		frmProfilo.getContentPane().add(LabelCognome);
		
		JLabel labelData = new JLabel("" + utente.getData());
		labelData.setForeground(Color.LIGHT_GRAY);
		labelData.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		labelData.setBounds(31, 250, 239, 27);
		frmProfilo.getContentPane().add(labelData);
		
		JLabel labelResidenza = new JLabel("" + utente.getResidenza());
		labelResidenza.setForeground(Color.LIGHT_GRAY);
		labelResidenza.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		labelResidenza.setBounds(30, 306, 239, 27);
		frmProfilo.getContentPane().add(labelResidenza);
		
		JLabel labelEmail = new JLabel("" + utente.getEmail());
		labelEmail.setForeground(Color.LIGHT_GRAY);
		labelEmail.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		labelEmail.setBounds(289, 56, 239, 27);
		frmProfilo.getContentPane().add(labelEmail);
		
		JLabel labelStudi = new JLabel("" + utente.getTitoloDiStudi());
		labelStudi.setForeground(Color.LIGHT_GRAY);
		labelStudi.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		labelStudi.setBounds(289, 123, 239, 27);
		frmProfilo.getContentPane().add(labelStudi);
		
		JLabel labelProfessione = new JLabel("" + utente.getProfessione());
		labelProfessione.setForeground(Color.LIGHT_GRAY);
		labelProfessione.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		labelProfessione.setBounds(289, 173, 239, 27);
		frmProfilo.getContentPane().add(labelProfessione);
		
		JButton Indietro = new JButton("Indietro");
		Indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				ChangePage.changePage("ModuloLoggato", utente);
				frmProfilo.dispose();				
			}
		});
		Indietro.setToolTipText("Ritorna alla schermata di Login");
		Indietro.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		Indietro.setBounds(31, 344, 215, 36);
		frmProfilo.getContentPane().add(Indietro);
		
		JButton btnModifica = new JButton("Modifica");
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				ChangePage.changePage("ModificaProfilo", utente);
				frmProfilo.dispose();
			}
		});
		btnModifica.setToolTipText("Ritorna alla schermata di Login");
		btnModifica.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnModifica.setBounds(289, 215, 215, 36);
		frmProfilo.getContentPane().add(btnModifica);
		
		/* Pulsante di Logout */
		JButton Logout = new JButton("Logout");
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProfilo.dispose();
				ChangePage.Login();
			}
		});
		Logout.setToolTipText("Ritorna alla schermata di Login");
		Logout.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		Logout.setBounds(289, 344, 215, 36);
		frmProfilo.getContentPane().add(Logout);
		
		/* Cancellazione profilo */
		JButton btnCancellaProfilo = new JButton("Cancella profilo");
		btnCancellaProfilo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				call.DeleteUser(utente.getUsername());
				frmProfilo.dispose();
				ChangePage.Login();
			}
		});
		btnCancellaProfilo.setForeground(Color.RED);
		btnCancellaProfilo.setToolTipText("Ritorna alla schermata di Login");
		btnCancellaProfilo.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnCancellaProfilo.setBounds(289, 283, 215, 36);
		frmProfilo.getContentPane().add(btnCancellaProfilo);
	}
}
