package Biblioteca;

import java.awt.EventQueue;

import javax.swing.JFrame;

import common.ChangePage;
import common.vo.Opera;
import common.vo.Utente;
import controller.action.ActionSetTrascrittore;
import controller.list.PaginaList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModuloAssegnaTrascrizione {
	Utente utente = null;
	Opera opera = null;
	int numero_pagina = 0;
	PaginaList pl = new PaginaList();

	private JFrame frmBibliotecadigitaleAssegna;
	private JTextField txtUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloAssegnaTrascrizione window = new ModuloAssegnaTrascrizione();
					window.frmBibliotecadigitaleAssegna.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public static void trascrizione(Utente utente, Opera opera, int pagina) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloAssegnaTrascrizione window = new ModuloAssegnaTrascrizione(utente, opera, pagina);
					window.frmBibliotecadigitaleAssegna.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public ModuloAssegnaTrascrizione() {
		initialize();
	}
	
	public ModuloAssegnaTrascrizione(Utente utente, Opera opera, int pagina) {
		this.utente = utente;
		this.opera = opera;
		this.numero_pagina = pagina;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ActionSetTrascrittore st = new ActionSetTrascrittore();
		frmBibliotecadigitaleAssegna = new JFrame();
		frmBibliotecadigitaleAssegna.setResizable(false);
		frmBibliotecadigitaleAssegna.setTitle("BibliotecaDigitale - Assegna trascrittore");
		frmBibliotecadigitaleAssegna.setBounds(100, 100, 620, 420);
		frmBibliotecadigitaleAssegna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBibliotecadigitaleAssegna.getContentPane().setLayout(null);
		
		JLabel lblBibliotecaDigitaleModifica = new JLabel("Biblioteca Digitale Modifica - Assegna a trascrittore");
		lblBibliotecaDigitaleModifica.setFont(new Font("Tekton Pro", Font.PLAIN, 22));
		lblBibliotecaDigitaleModifica.setBounds(45, 11, 490, 42);
		frmBibliotecadigitaleAssegna.getContentPane().add(lblBibliotecaDigitaleModifica);
		
		JLabel lblUsernameTrascrittore = new JLabel("Username trascrittore:");
		lblUsernameTrascrittore.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		lblUsernameTrascrittore.setBounds(218, 114, 165, 48);
		frmBibliotecadigitaleAssegna.getContentPane().add(lblUsernameTrascrittore);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtUsername.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().isEmpty())
					txtUsername.setText("Username");
			}
		});
		txtUsername.setToolTipText("Ruolo: admin - utente - menager - uploader - transcriber");
		txtUsername.setText("Username");
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setForeground(new Color(204, 204, 204));
		txtUsername.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		txtUsername.setColumns(10);
		txtUsername.setBounds(201, 156, 193, 36);
		frmBibliotecadigitaleAssegna.getContentPane().add(txtUsername);
		
		JButton btnConfe = new JButton("Conferma");
		btnConfe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtUsername.getText().equals("Username")) {
					int n = Integer.parseInt(pl.infoOpera(opera.getCod(), opera.getNome(), numero_pagina, 0));
					st.setTras(txtUsername.getText(), n);
					ChangePage.changePage1("Opzioni", utente, opera, numero_pagina);
					frmBibliotecadigitaleAssegna.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Inserire username!");
				}
									
			}
		});
		btnConfe.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnConfe.setBounds(239, 216, 108, 36);
		frmBibliotecadigitaleAssegna.getContentPane().add(btnConfe);
		
		JButton btnAnnul = new JButton("Annulla");
		btnAnnul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangePage.changePage1("Opzioni", utente, opera, numero_pagina);
			}
		});
		btnAnnul.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnAnnul.setBounds(239, 274, 108, 36);
		frmBibliotecadigitaleAssegna.getContentPane().add(btnAnnul);
	}
}
