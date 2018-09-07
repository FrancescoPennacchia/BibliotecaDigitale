package Biblioteca;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import controller.list.UserList;
import common.ChangePage;
import common.vo.Utente;
import controller.action.ActionLivello;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModuloLivello {
	Utente utente = null;
	String username;
	int n = 0;
	UserList ul = new UserList();
	ActionLivello al = new ActionLivello();

	private JFrame frmBibliotecadigitaleLivello;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloLivello window = new ModuloLivello();
					window.frmBibliotecadigitaleLivello.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void Livello(Utente utente, int n, String username) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloLivello window = new ModuloLivello(utente, n , username);
					window.frmBibliotecadigitaleLivello.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ModuloLivello() {
		initialize();
	}
	
	public ModuloLivello(Utente utente, int n, String username) {
		this.n = n;
		this.utente = utente;
		this.username = username;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int livello = ul.lv(n);
		
		frmBibliotecadigitaleLivello = new JFrame();
		frmBibliotecadigitaleLivello.setResizable(false);
		frmBibliotecadigitaleLivello.setTitle("BibliotecaDigitale - Livello");
		frmBibliotecadigitaleLivello.setBounds(100, 100, 620, 420);
		frmBibliotecadigitaleLivello.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBibliotecadigitaleLivello.getContentPane().setLayout(null);
		
		
		JLabel labelLv = new JLabel(" " + livello);
		labelLv.setForeground(Color.GRAY);
		labelLv.setFont(new Font("Tekton Pro", Font.PLAIN, 24));
		labelLv.setBounds(258, 77, 154, 36);
		frmBibliotecadigitaleLivello.getContentPane().add(labelLv);
		
		JButton btnAumentaLivello = new JButton("Aumenta Livello");
		btnAumentaLivello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				al.LvUp(username, livello);
				ChangePage.LvPage(utente, username, n);
				frmBibliotecadigitaleLivello.dispose();
			}
		});
		btnAumentaLivello.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnAumentaLivello.setBounds(167, 127, 232, 36);
		frmBibliotecadigitaleLivello.getContentPane().add(btnAumentaLivello);
		
		JButton btnDiminuisciLivello = new JButton("Diminuisci Livello");
		btnDiminuisciLivello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				al.LvD(username, livello);
				ChangePage.LvPage(utente, username, n);
				frmBibliotecadigitaleLivello.dispose();
			}
		});
		btnDiminuisciLivello.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnDiminuisciLivello.setBounds(167, 214, 232, 36);
		frmBibliotecadigitaleLivello.getContentPane().add(btnDiminuisciLivello);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangePage.changePage("ListaUtenti", utente);
				frmBibliotecadigitaleLivello.dispose();
			}
		});
		btnIndietro.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnIndietro.setBounds(167, 298, 232, 36);
		frmBibliotecadigitaleLivello.getContentPane().add(btnIndietro);
		
		JLabel lblCor = new JLabel("Livello corrente");
		lblCor.setFont(new Font("Tekton Pro", Font.PLAIN, 22));
		lblCor.setBounds(198, 21, 156, 45);
		frmBibliotecadigitaleLivello.getContentPane().add(lblCor);
		

	}
}
