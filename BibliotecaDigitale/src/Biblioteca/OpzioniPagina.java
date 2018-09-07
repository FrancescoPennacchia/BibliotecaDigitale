package Biblioteca;

import java.awt.EventQueue;

import javax.swing.JFrame;

import common.ChangePage;
import common.vo.Opera;
import common.vo.Utente;
import controller.list.PaginaList;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class OpzioniPagina {
	Utente utente = null;
	Opera opera = null;
	int numero_pagina = 0;
	//OperaList ol = new OperaList();
	PaginaList pl = new PaginaList();

	private JFrame frmBibliotecaDigitale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpzioniPagina window = new OpzioniPagina();
					window.frmBibliotecaDigitale.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void Opzioni(Utente utente, Opera opera, int pagina) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpzioniPagina window = new OpzioniPagina(utente, opera, pagina);
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
	public OpzioniPagina() {
		initialize();
	}
	
	public OpzioniPagina(Utente utente, Opera opera, int pagina) {
		this.utente = utente;
		this.opera = opera;
		this.numero_pagina = pagina;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String approvazione = "";
		approvazione = pl.infoOpera(opera.getCod(), opera.getNome(), numero_pagina, 6);
		
		
		frmBibliotecaDigitale = new JFrame();
		frmBibliotecaDigitale.setTitle("Biblioteca Digitale - Opzioni Pagina");
		frmBibliotecaDigitale.setResizable(false);
		frmBibliotecaDigitale.setBounds(100, 100, 620, 420);
		frmBibliotecaDigitale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBibliotecaDigitale.getContentPane().setLayout(null);
		
		JButton btnVisualizzaopera = new JButton("Visualizza Pagina");
		btnVisualizzaopera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePage.changePage1("VisualizzaPagina", utente, opera, numero_pagina);
				frmBibliotecaDigitale.dispose();
			}
		});
		btnVisualizzaopera.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnVisualizzaopera.setBounds(175, 81, 232, 36);
		frmBibliotecaDigitale.getContentPane().add(btnVisualizzaopera);
		
		JButton btnInserisciModifica = new JButton("Inserisci trasciriozne");
		btnInserisciModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePage.changePage1("AggiugniTrascrizione", utente, opera, numero_pagina);
				frmBibliotecaDigitale.dispose();				
			}
		});
		btnInserisciModifica.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnInserisciModifica.setBounds(175, 138, 232, 36);
		frmBibliotecaDigitale.getContentPane().add(btnInserisciModifica);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangePage.changePage1("Elenco", utente, opera, 0);
				frmBibliotecaDigitale.dispose();
			}
		});
		btnIndietro.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnIndietro.setBounds(175, 304, 232, 36);
		frmBibliotecaDigitale.getContentPane().add(btnIndietro);
		
		JButton btnAssegnaPagina = new JButton("Assegna Pagina");
		btnAssegnaPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//inserire
				ChangePage.changePage1("setTrascrittore", utente, opera, numero_pagina);
				frmBibliotecaDigitale.dispose();
			}
		});
		btnAssegnaPagina.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnAssegnaPagina.setBounds(175, 195, 232, 36);
		frmBibliotecaDigitale.getContentPane().add(btnAssegnaPagina);
		
		
		//aggiungere permessi
		if(utente.getMansione().equals("admin") || utente.getMansione().equals("manager"))
			btnAssegnaPagina.setEnabled(true);
		else
			btnAssegnaPagina.setEnabled(false);
		
		
		if(utente.getMansione().equals("admin") || utente.getMansione().equals("manager") || utente.getMansione().equals("transcriber") || utente.getMansione().equals("trascittore"))
			btnInserisciModifica.setEnabled(true);
		else
			btnInserisciModifica.setEnabled(false);
		
		// da controllare
		if(approvazione.equals("no") && utente.getMansione().equals("utente")) {
			btnVisualizzaopera.setEnabled(false);			
		}
			

	}
}
