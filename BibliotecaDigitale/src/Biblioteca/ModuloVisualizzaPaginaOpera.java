package Biblioteca;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.SwingConstants;

import common.ChangePage;
import common.vo.Opera;
import common.vo.Utente;
import controller.action.getImg;
import controller.action.ActionApprova;
import controller.list.PaginaList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModuloVisualizzaPaginaOpera {
	Utente utente = null;
	Opera opera = null;
	int numero_pagina;
	getImg img = new getImg();
	PaginaList pl = new PaginaList();
	ActionApprova ap = new ActionApprova();

	

	private JFrame frmBibliotecaDigitale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloVisualizzaPaginaOpera window = new ModuloVisualizzaPaginaOpera();
					window.frmBibliotecaDigitale.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void VisualizzaPagina(Utente utente, Opera opera, int pagina) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloVisualizzaPaginaOpera window = new ModuloVisualizzaPaginaOpera(utente, opera, pagina);
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
	public ModuloVisualizzaPaginaOpera() {
		initialize();
	}
	
	public ModuloVisualizzaPaginaOpera(Utente utente, Opera opera, int pagina) {
		this.utente = utente;
		this.opera = opera;
		this.numero_pagina = pagina;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String Trascrizione = "";
		int cod_pagina = 0;
		int n = 0;
		frmBibliotecaDigitale = new JFrame();
		frmBibliotecaDigitale.setTitle("Biblioteca Digitale - Visuallizza Pagina");
		frmBibliotecaDigitale.setResizable(false);
		frmBibliotecaDigitale.setBounds(100, 100, 620, 420);
		frmBibliotecaDigitale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBibliotecaDigitale.getContentPane().setLayout(null);
		
		/* recupera le info relative alla pagina */
		cod_pagina = Integer.parseInt(pl.infoOpera(opera.getCod(), opera.getNome(), numero_pagina, 0));
		n = Integer.parseInt(pl.infoOpera(opera.getCod(), opera.getNome(), numero_pagina, 4));
		Trascrizione = String.valueOf(pl.infoOpera(opera.getCod(), opera.getNome(), numero_pagina, 2));



		
		JLabel lblTrascrizione = new JLabel(Trascrizione);
		lblTrascrizione.setVerticalAlignment(SwingConstants.TOP);
		lblTrascrizione.setHorizontalAlignment(SwingConstants.LEFT);
		lblTrascrizione.setForeground(Color.LIGHT_GRAY);
		lblTrascrizione.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		lblTrascrizione.setBounds(29, 46, 236, 279);
		frmBibliotecaDigitale.getContentPane().add(lblTrascrizione);
		
		JButton button = new JButton("Indietro");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePage.changePage1("Opzioni", utente, opera, numero_pagina);
				frmBibliotecaDigitale.dispose();
			}
		});
		button.setToolTipText("Ritorna alla schermata di Login");
		button.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		button.setBounds(26, 336, 215, 36);
		frmBibliotecaDigitale.getContentPane().add(button);
		
		JLabel lblTrascrizione_1 = new JLabel("Trascrizione Pagina");
		lblTrascrizione_1.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblTrascrizione_1.setBounds(29, 33, 168, 14);
		frmBibliotecaDigitale.getContentPane().add(lblTrascrizione_1);
		
		JLabel lblNumeroPagina = new JLabel("Numero Pagina: " + n + " dell'opera: " + opera.getNome());
		lblNumeroPagina.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblNumeroPagina.setBounds(98, 11, 403, 14);
		frmBibliotecaDigitale.getContentPane().add(lblNumeroPagina);
		
		JLabel lblPagina = new JLabel("Pagina");
		lblPagina.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblPagina.setBounds(398, 33, 168, 14);
		frmBibliotecaDigitale.getContentPane().add(lblPagina);
		
		
		/* Pannello riguardante l'immagine */
		Panel panel = new Panel();
		panel = img.getImmagine(cod_pagina);
		panel.setBounds(302, 54, 286, 271);
		frmBibliotecaDigitale.getContentPane().add(panel);
		
		JButton btnApprova = new JButton("Approva");
		btnApprova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n = Integer.parseInt(pl.infoOpera(opera.getCod(), opera.getNome(), numero_pagina, 0));
				ap.appovazione(n);
			}
		});
		btnApprova.setToolTipText("Ritorna alla schermata di Login");
		btnApprova.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnApprova.setBounds(362, 336, 215, 36);
		frmBibliotecaDigitale.getContentPane().add(btnApprova);
		
		// inserire permessi

		if(utente.getMansione().equals("admin") || utente.getMansione().equals("manager"))
			btnApprova.setEnabled(true);
		else
			btnApprova.setEnabled(false);
	}
}
