package Biblioteca;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;


import java.awt.Font;
import javax.swing.JLabel;

import controller.action.ActionAddPagina;
import exception.Exception;
import model.connectionDataBase.ConnectionOpera;
import model.interfaces.InterfaceOpera;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

import common.ChangePage;
import common.vo.Opera;
import common.vo.Utente;

public class ModuloAggiungiPagina {
	//File Immagine = null;
	Opera op = null;
	Utente utente = null;
	InterfaceOpera opera = new ConnectionOpera();
	ActionAddPagina ap = new ActionAddPagina();


	private JFrame frmBibliotecaDigitale;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloAggiungiPagina window = new ModuloAggiungiPagina();
					window.frmBibliotecaDigitale.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void InserimentoPagina(Utente utente, Opera op) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloAggiungiPagina window = new ModuloAggiungiPagina(utente, op);
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
	public ModuloAggiungiPagina() {
		initialize();
	}
	
	
	
	public ModuloAggiungiPagina(Utente utente, Opera op) {
		this.utente = utente;
		this.op = op;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBibliotecaDigitale = new JFrame();
		frmBibliotecaDigitale.setTitle("Biblioteca Digitale - Inserimento Pagina");
		frmBibliotecaDigitale.setResizable(false);
		frmBibliotecaDigitale.setBounds(100, 100, 620, 420);
		frmBibliotecaDigitale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBibliotecaDigitale.getContentPane().setLayout(null);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePage.changePage1("ElencoPagine", utente, op, 0);
                frmBibliotecaDigitale.dispose();			
			}
		});
		btnIndietro.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnIndietro.setBounds(189, 255, 199, 38);
		frmBibliotecaDigitale.getContentPane().add(btnIndietro);
		
		
		JButton btnScegliImmagine = new JButton("Scegli Immagine e inserisci");
		btnScegliImmagine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ap.setImage(op.getCod(), textField.getText());
				ChangePage.changePage1("ElencoPagine", utente, op, 0);				
				frmBibliotecaDigitale.dispose();
			}
		});
		btnScegliImmagine.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnScegliImmagine.setBounds(152, 194, 271, 38);
		frmBibliotecaDigitale.getContentPane().add(btnScegliImmagine);
		
		JLabel lblBibliotecaDigitaleInserimento = new JLabel("Biblioteca Digitale Inserimento Pagina");
		lblBibliotecaDigitaleInserimento.setFont(new Font("Tekton Pro", Font.PLAIN, 22));
		lblBibliotecaDigitaleInserimento.setBounds(108, 33, 390, 42);
		frmBibliotecaDigitale.getContentPane().add(lblBibliotecaDigitaleInserimento);
		
		JLabel lblNumeroPaginaDa = new JLabel("Numero Pagina da inserire");
		lblNumeroPaginaDa.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblNumeroPaginaDa.setBounds(183, 103, 218, 14);
		frmBibliotecaDigitale.getContentPane().add(lblNumeroPaginaDa);
		
		textField = new JTextField();
		textField.setToolTipText("Puoi inserire solo numeri interi");
		textField.setText((String) null);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(new Color(204, 204, 204));
		textField.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		textField.setColumns(10);
		textField.setBounds(172, 128, 229, 38);
		frmBibliotecaDigitale.getContentPane().add(textField);
	}
}
