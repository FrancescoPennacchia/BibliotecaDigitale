package Biblioteca;

import java.awt.EventQueue;

import javax.swing.JFrame;

import common.ChangePage;
import common.vo.Utente;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TipoRicerca {
	Utente utente = null;

	private JFrame frmTipoRicerca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TipoRicerca window = new TipoRicerca();
					window.frmTipoRicerca.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void Ricerca(Utente utente) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TipoRicerca window = new TipoRicerca(utente);
					window.frmTipoRicerca.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TipoRicerca() {
		initialize();
	}
	
	public TipoRicerca(Utente utente) {
		this.utente = utente;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTipoRicerca = new JFrame();
		frmTipoRicerca.setTitle("Biblioteca Digitale - Tipologia di ricerca");
		frmTipoRicerca.setResizable(false);
		frmTipoRicerca.setBounds(100, 100, 620, 420);
		frmTipoRicerca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTipoRicerca.getContentPane().setLayout(null);
		
		JButton btnListaOpere = new JButton("Tutte le opere");
		btnListaOpere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePage.changePage("TutteLeOpere", utente);
				frmTipoRicerca.dispose();
			}
		});
		btnListaOpere.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnListaOpere.setBounds(164, 79, 232, 36);
		frmTipoRicerca.getContentPane().add(btnListaOpere);
		
		JButton btnOperePerCategoria = new JButton("Categorie");
		btnOperePerCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePage.changePage("Categoria", utente);
				frmTipoRicerca.dispose();
			}
		});
		btnOperePerCategoria.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnOperePerCategoria.setBounds(164, 158, 232, 36);
		frmTipoRicerca.getContentPane().add(btnOperePerCategoria);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangePage.changePage("ModuloLoggato", utente);
				frmTipoRicerca.dispose();
			}
		});
		btnIndietro.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnIndietro.setBounds(164, 234, 232, 36);
		frmTipoRicerca.getContentPane().add(btnIndietro);
	}
}
