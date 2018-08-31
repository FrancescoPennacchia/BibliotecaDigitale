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
import controller.action.ActionAddOpera;

import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModuloAggiungiOpera {
	Utente utente = null;
	
	ActionAddOpera ao = new ActionAddOpera();

	private JFrame frmBibliotecaDigitale;
	private JTextField txtNome;
	private JTextField txtNomeAutore;
	private JTextField txtAnno;
	private JTextField txtCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloAggiungiOpera window = new ModuloAggiungiOpera();
					window.frmBibliotecaDigitale.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void AggiungiOpera(Utente utente) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloAggiungiOpera window = new ModuloAggiungiOpera(utente);
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
	public ModuloAggiungiOpera() {
		initialize();
	}

	
	public ModuloAggiungiOpera(Utente utente) {
		this.utente = utente;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBibliotecaDigitale = new JFrame();
		frmBibliotecaDigitale.setTitle("Biblioteca Digitale - Aggiungi Opera");
		frmBibliotecaDigitale.setResizable(false);
		frmBibliotecaDigitale.setBounds(100, 100, 620, 420);
		frmBibliotecaDigitale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBibliotecaDigitale.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome opera");
		lblNome.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblNome.setBounds(34, 21, 119, 14);
		frmBibliotecaDigitale.getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtNome.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNome.getText().isEmpty())
					txtNome.setText("Nome Opera");
			}
		});
		txtNome.setToolTipText("Nome opera");
		txtNome.setText("Nome Opera");
		txtNome.setHorizontalAlignment(SwingConstants.CENTER);
		txtNome.setForeground(new Color(204, 204, 204));
		txtNome.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		txtNome.setColumns(10);
		txtNome.setBounds(31, 43, 229, 38);
		frmBibliotecaDigitale.getContentPane().add(txtNome);
		
		JLabel lblNomeAutore = new JLabel("Nome autore");
		lblNomeAutore.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblNomeAutore.setBounds(34, 92, 119, 14);
		frmBibliotecaDigitale.getContentPane().add(lblNomeAutore);
		
		txtNomeAutore = new JTextField();
		txtNomeAutore.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtNomeAutore.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNomeAutore.getText().isEmpty())
					txtNomeAutore.setText("Nome Autore");
			}
		});
		txtNomeAutore.setToolTipText("Nome autore");
		txtNomeAutore.setText("Nome Autore");
		txtNomeAutore.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomeAutore.setForeground(new Color(204, 204, 204));
		txtNomeAutore.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		txtNomeAutore.setColumns(10);
		txtNomeAutore.setBounds(31, 117, 229, 38);
		frmBibliotecaDigitale.getContentPane().add(txtNomeAutore);
		
		JLabel lblAnno = new JLabel("Anno");
		lblAnno.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblAnno.setBounds(34, 166, 119, 14);
		frmBibliotecaDigitale.getContentPane().add(lblAnno);
		
		txtAnno = new JTextField();
		txtAnno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtAnno.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtAnno.getText().isEmpty())
					txtAnno.setText("Anno");
			}
		});
		txtAnno.setToolTipText("Anno YYYY");
		txtAnno.setText("Anno");
		txtAnno.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnno.setForeground(new Color(204, 204, 204));
		txtAnno.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		txtAnno.setColumns(10);
		txtAnno.setBounds(31, 191, 229, 38);
		frmBibliotecaDigitale.getContentPane().add(txtAnno);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblCategoria.setBounds(34, 240, 119, 14);
		frmBibliotecaDigitale.getContentPane().add(lblCategoria);
		
		txtCategoria = new JTextField();
		txtCategoria.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtCategoria.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtCategoria.getText().isEmpty())
					txtCategoria.setText("Categoria");
			}
		});
		txtCategoria.setToolTipText("Categoria opera");
		txtCategoria.setText("Categoria");
		txtCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		txtCategoria.setForeground(new Color(204, 204, 204));
		txtCategoria.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(31, 265, 229, 38);
		frmBibliotecaDigitale.getContentPane().add(txtCategoria);
		
		JButton btnInserisci_1 = new JButton("Inserisci");
		btnInserisci_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ao.addOpera(txtNome.getText(), txtNomeAutore.getText(), txtAnno.getText(),txtCategoria.getText());
			}
		});
		btnInserisci_1.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnInserisci_1.setBounds(340, 88, 199, 38);
		frmBibliotecaDigitale.getContentPane().add(btnInserisci_1);
		
		JButton btnInserisci = new JButton("Indietro");
		btnInserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePage.changePage("TipoRicerca", utente);
				frmBibliotecaDigitale.dispose();
			}
		});
		btnInserisci.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnInserisci.setBounds(340, 162, 199, 38);
		frmBibliotecaDigitale.getContentPane().add(btnInserisci);
	}

}
