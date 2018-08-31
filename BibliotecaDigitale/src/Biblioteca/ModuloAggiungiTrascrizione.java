package Biblioteca;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.action.ActionAddTrascrizione;
import controller.action.getImg;
import controller.list.PaginaList;
import model.connectionDataBase.ConnectionOpera;
import model.interfaces.InterfaceOpera;

import javax.swing.JTextField;

import common.ChangePage;
import common.vo.Opera;
import common.vo.Utente;

public class ModuloAggiungiTrascrizione {
	Utente utente = null;
	Opera opera = null;
	int numero_pagina = 0;
	int cod_pagina = 0;
	
	ActionAddTrascrizione add = new ActionAddTrascrizione();
	PaginaList pl = new PaginaList();
	
	InterfaceOpera pagine = new ConnectionOpera();

	private JFrame frmBibliotecaDigitale;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloAggiungiTrascrizione window = new ModuloAggiungiTrascrizione();
					window.frmBibliotecaDigitale.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void AggiungiTrascrizione(Utente utente, Opera opera, int pagina) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloAggiungiTrascrizione window = new ModuloAggiungiTrascrizione(utente, opera, pagina);
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
	public ModuloAggiungiTrascrizione() {
		initialize();
	}

	
	public ModuloAggiungiTrascrizione(Utente utente, Opera opera, int pagina) {
		this.utente = utente;
		this.opera = opera;
		this.numero_pagina = pagina;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//String Trascrizione = "";
		//int cod_pagina = 0;
		getImg img = new getImg();
		int n = 0;
		frmBibliotecaDigitale = new JFrame();
		frmBibliotecaDigitale.setTitle("Biblioteca Digitale - Inserimento Trascrizione");
		frmBibliotecaDigitale.setResizable(false);
		frmBibliotecaDigitale.setBounds(100, 100, 620, 420);
		frmBibliotecaDigitale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBibliotecaDigitale.getContentPane().setLayout(null);
		

		cod_pagina = Integer.parseInt(pl.infoOpera(opera.getCod(), opera.getNome(), numero_pagina, 0));
		n = Integer.parseInt(pl.infoOpera(opera.getCod(), opera.getNome(), numero_pagina, 4));

		
		JButton button = new JButton("Indietro");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePage.changePage1("Opzioni", utente, opera, numero_pagina);
				frmBibliotecaDigitale.dispose();
			}
		});
		button.setToolTipText("Ritorna alla schermata di Login");
		button.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		button.setBounds(37, 333, 215, 36);
		frmBibliotecaDigitale.getContentPane().add(button);
		
		JLabel lblTrascrizione_1 = new JLabel("Trascrizione");
		lblTrascrizione_1.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblTrascrizione_1.setBounds(69, 33, 168, 14);
		frmBibliotecaDigitale.getContentPane().add(lblTrascrizione_1);
		
		JLabel lblNumeroPagina = new JLabel("Numero Pagina: " + n + " dell'opera: " + opera.getNome());
		lblNumeroPagina.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblNumeroPagina.setBounds(98, 11, 403, 14);
		frmBibliotecaDigitale.getContentPane().add(lblNumeroPagina);
		
		JLabel lblPagina = new JLabel("Pagina");
		lblPagina.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblPagina.setBounds(398, 33, 168, 14);
		frmBibliotecaDigitale.getContentPane().add(lblPagina);

			 
			 Panel panel = new Panel();

			 panel = img.getImmagine(cod_pagina);
             panel.setBounds(302, 54, 286, 271);
             frmBibliotecaDigitale.getContentPane().add(panel);
             
             JButton btnInserisci = new JButton("Inserisci");
             btnInserisci.addActionListener(new ActionListener() {
             	public void actionPerformed(ActionEvent e) {
             		if(!textField.getText().isEmpty())
             		{
             			
             			add.addTrascrizione(textField.getText(), cod_pagina);
             			ChangePage.changePage1("Opzioni", utente, opera, numero_pagina);
            			frmBibliotecaDigitale.dispose();
         			
             		}
             	}
             });
             btnInserisci.setToolTipText("Ritorna alla schermata di Login");
             btnInserisci.setFont(new Font("Myriad CAD", Font.BOLD, 11));
             btnInserisci.setBounds(351, 333, 215, 36);
             frmBibliotecaDigitale.getContentPane().add(btnInserisci);
             
             textField = new JTextField();
             textField.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 12));
             textField.setForeground(Color.GRAY);
             textField.setToolTipText("Inserire la trascrizione");
             textField.setBounds(37, 58, 215, 265);
             frmBibliotecaDigitale.getContentPane().add(textField);
             textField.setColumns(10);



	
	}
}
