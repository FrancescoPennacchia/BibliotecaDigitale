package Biblioteca;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import common.ChangePage;
import common.vo.Utente;

import java.awt.Color;

public class ModuloLoggato {
	
	Utente utente = null;
	

	private JFrame frmBibliotecaDigitale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloLoggato window = new ModuloLoggato();
					window.frmBibliotecaDigitale.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	public static void Loggato(Utente user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloLoggato window = new ModuloLoggato(user);
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
	public ModuloLoggato(Utente user) {
		this.utente = user;
		//System.out.println(utente.getCognome());
		initialize();
	}
	
	public ModuloLoggato() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//System.out.println(utente.getCognome());
		frmBibliotecaDigitale = new JFrame();
		frmBibliotecaDigitale.setResizable(false);
		frmBibliotecaDigitale.setTitle("Biblioteca Digitale - Loggato - menu");
		frmBibliotecaDigitale.setBounds(100, 100, 620, 420);
		frmBibliotecaDigitale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBibliotecaDigitale.getContentPane().setLayout(null);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangePage.changePage("Logout", utente);
				frmBibliotecaDigitale.dispose();
			}
		});
		btnLogout.setToolTipText("Ritorna alla schermata di Login");
		btnLogout.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnLogout.setBounds(194, 332, 215, 36);
		frmBibliotecaDigitale.getContentPane().add(btnLogout);
		
		JLabel lblBenvenutoNellaBiblioteca = new JLabel("Benvenuto nella Biblioteca Digitale");
		lblBenvenutoNellaBiblioteca.setFont(new Font("Tekton Pro", Font.PLAIN, 22));
		lblBenvenutoNellaBiblioteca.setBounds(10, 11, 307, 42);
		frmBibliotecaDigitale.getContentPane().add(lblBenvenutoNellaBiblioteca);
		
		JLabel lblUsername = new JLabel("" + utente.getNome());
		lblUsername.setForeground(Color.GRAY);
		lblUsername.setFont(new Font("Tekton Pro", Font.PLAIN, 24));
		lblUsername.setBounds(327, 14, 154, 36);
		frmBibliotecaDigitale.getContentPane().add(lblUsername);
		
		JButton btnProfilo = new JButton("Profilo");
		btnProfilo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangePage.changePage("Profilo", utente);
				frmBibliotecaDigitale.dispose();
			}
		});
		btnProfilo.setToolTipText("Ritorna alla schermata di Login");
		btnProfilo.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnProfilo.setBounds(484, 16, 99, 36);
		frmBibliotecaDigitale.getContentPane().add(btnProfilo);
		
		JButton btnListaUtenti = new JButton("Lista Utenti");
		btnListaUtenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangePage.changePage("ListaUtenti", utente);
				frmBibliotecaDigitale.dispose();
			}
		});
		btnListaUtenti.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnListaUtenti.setBounds(403, 174, 169, 36);
		frmBibliotecaDigitale.getContentPane().add(btnListaUtenti);
		
		JButton btnElencoOpere = new JButton("Elenco Opere");
		btnElencoOpere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePage.changePage("TipoRicerca", utente);
				frmBibliotecaDigitale.dispose();
			}
		});
		btnElencoOpere.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnElencoOpere.setBounds(39, 174, 169, 36);
		frmBibliotecaDigitale.getContentPane().add(btnElencoOpere);
		
		/* Permessi */
		if(utente.getMansione().equals("admin") || utente.getMansione().equals("manager"))
			btnListaUtenti.setEnabled(true);
		else btnListaUtenti.setEnabled(false);
	}
}
