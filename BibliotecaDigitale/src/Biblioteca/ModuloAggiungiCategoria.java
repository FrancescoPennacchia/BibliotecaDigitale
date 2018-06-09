package Biblioteca;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Componenti.Utente;
import ConnectionDataBase.ConnectionOpera;
import Interfaces.InterfaceOpera;

public class ModuloAggiungiCategoria {

	InterfaceOpera opera = new ConnectionOpera();
	Utente utente = null;
	private JFrame frmBibliotecaDigitale;
	private JTextField txtNomeCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloAggiungiCategoria window = new ModuloAggiungiCategoria();
					window.frmBibliotecaDigitale.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void AggiungiCategoria(Utente utente) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloAggiungiCategoria window = new ModuloAggiungiCategoria(utente);
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
	public ModuloAggiungiCategoria() {
		initialize();
	}
	
	public ModuloAggiungiCategoria(Utente utente) {
		this.utente = utente;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBibliotecaDigitale = new JFrame();
		frmBibliotecaDigitale.setTitle("Biblioteca Digitale - Aggiungi Categoria");
		frmBibliotecaDigitale.setResizable(false);
		frmBibliotecaDigitale.setBounds(100, 100, 620, 420);
		frmBibliotecaDigitale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBibliotecaDigitale.getContentPane().setLayout(null);
		
		JLabel lblBibliotecaDigitaleAggiungi = new JLabel("Biblioteca Digitale Aggiungi Categoria");
		lblBibliotecaDigitaleAggiungi.setFont(new Font("Tekton Pro", Font.PLAIN, 22));
		lblBibliotecaDigitaleAggiungi.setBounds(98, 11, 386, 42);
		frmBibliotecaDigitale.getContentPane().add(lblBibliotecaDigitaleAggiungi);
		
		txtNomeCategoria = new JTextField();
		txtNomeCategoria.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtNomeCategoria.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNomeCategoria.getText().isEmpty())
					txtNomeCategoria.setText("Nome Categoria");
			}
		});
		txtNomeCategoria.setToolTipText("Ruolo: admin - utente - menager - uploader - transcriber");
		txtNomeCategoria.setText("Nome Categoria");
		txtNomeCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomeCategoria.setForeground(new Color(204, 204, 204));
		txtNomeCategoria.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		txtNomeCategoria.setColumns(10);
		txtNomeCategoria.setBounds(187, 144, 193, 36);
		frmBibliotecaDigitale.getContentPane().add(txtNomeCategoria);
		
		JButton button = new JButton("Conferma");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					opera.NewCategoria(txtNomeCategoria.getText());
					//frmBibliotecaDigitale.di
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		button.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		button.setBounds(231, 228, 108, 36);
		frmBibliotecaDigitale.getContentPane().add(button);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModuloRicercaCategoria MRC = new ModuloRicercaCategoria(utente, 0);
				MRC.RicercaCategoria(utente, 0);
				frmBibliotecaDigitale.dispose();
			}
		});
		btnIndietro.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnIndietro.setBounds(231, 292, 108, 36);
		frmBibliotecaDigitale.getContentPane().add(btnIndietro);
	}
}
