package Biblioteca;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

import common.ChangePage;
import common.vo.Utente;
import controller.action.ActionChangeRuolo;
import model.connectionDataBase.User;
import model.interfaces.InterfaceUser;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ModificaRuolo {

	private JFrame frmModificaRuoli;
	private JTextField txtNuovoRuolo;
	String username = "";
	Utente UtentePrecedente = null;
	InterfaceUser us = new User();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificaRuolo window = new ModificaRuolo();
					window.frmModificaRuoli.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void Ruolo(String u, Utente UtentePrec) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificaRuolo window = new ModificaRuolo(u, UtentePrec);
					window.frmModificaRuoli.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ModificaRuolo() {
		initialize();
	}
	
	public ModificaRuolo(String u, Utente UtentePrec) {
		this.UtentePrecedente = UtentePrec;
		this.username = u;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ActionChangeRuolo call = new ActionChangeRuolo();
		frmModificaRuoli = new JFrame();
		frmModificaRuoli.setResizable(false);
		frmModificaRuoli.setTitle("Biblioteca Digitale - Modifica Ruoli Utente");
		frmModificaRuoli.setBounds(100, 100, 620, 420);
		frmModificaRuoli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmModificaRuoli.getContentPane().setLayout(null);
		
		JLabel lblBibliotecaDigitaleModifica = new JLabel("Biblioteca Digitale Modifica Ruolo Di:");
		lblBibliotecaDigitaleModifica.setFont(new Font("Tekton Pro", Font.PLAIN, 22));
		lblBibliotecaDigitaleModifica.setBounds(42, 11, 386, 42);
		frmModificaRuoli.getContentPane().add(lblBibliotecaDigitaleModifica);
		
		txtNuovoRuolo = new JTextField();
		txtNuovoRuolo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtNuovoRuolo.setText("");
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(txtNuovoRuolo.getText().isEmpty())
					txtNuovoRuolo.setText("Nuovo Ruolo");
			}
		});
		txtNuovoRuolo.setToolTipText("Ruolo: admin - utente - menager - uploader - transcriber");
		txtNuovoRuolo.setText("Nuovo Ruolo");
		txtNuovoRuolo.setHorizontalAlignment(SwingConstants.CENTER);
		txtNuovoRuolo.setForeground(new Color(204, 204, 204));
		txtNuovoRuolo.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		txtNuovoRuolo.setColumns(10);
		txtNuovoRuolo.setBounds(199, 160, 193, 36);
		frmModificaRuoli.getContentPane().add(txtNuovoRuolo);
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ruolo = txtNuovoRuolo.getText();
				call.ChangeRuolo(username, ruolo);
				frmModificaRuoli.dispose();
				ChangePage.ListaUtenti(UtentePrecedente, 0);
			}
			
			
		});
		btnConferma.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnConferma.setBounds(238, 225, 108, 36);
		frmModificaRuoli.getContentPane().add(btnConferma);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmModificaRuoli.dispose();
				ChangePage.ListaUtenti(UtentePrecedente, 0);	
			}
		});
		btnAnnulla.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnAnnulla.setBounds(238, 293, 108, 36);
		frmModificaRuoli.getContentPane().add(btnAnnulla);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.LIGHT_GRAY);
		label.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(365, 11, 239, 27);
		frmModificaRuoli.getContentPane().add(label);
	}
}
