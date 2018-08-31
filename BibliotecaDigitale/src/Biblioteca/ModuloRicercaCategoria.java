package Biblioteca;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import common.ChangePage;
import common.vo.Utente;
import controller.list.OperaListCat;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class ModuloRicercaCategoria {
	Utente utente = null;
	int count;
	OperaListCat ol = new OperaListCat();

	private JFrame frmListaCategorie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloRicercaCategoria window = new ModuloRicercaCategoria();
					window.frmListaCategorie.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void RicercaCategoria(Utente utente, int n) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloRicercaCategoria window = new ModuloRicercaCategoria(utente, n);
					window.frmListaCategorie.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ModuloRicercaCategoria() {
		initialize();
	}
	
	public ModuloRicercaCategoria(Utente utente, int n) {
		this.count = n;
		this.utente = utente;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListaCategorie = new JFrame();
		frmListaCategorie.setTitle("Biblioteca Digitale - Lista Categorie");
		frmListaCategorie.setResizable(false);
		frmListaCategorie.setBounds(100, 100, 620, 420);
		frmListaCategorie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListaCategorie.getContentPane().setLayout(null);
		
		JLabel lblBibliotecaDigitale = new JLabel("Biblioteca Digitale - Lista Categorie");
		lblBibliotecaDigitale.setFont(new Font("Tekton Pro", Font.PLAIN, 22));
		lblBibliotecaDigitale.setBounds(122, 0, 363, 42);
		frmListaCategorie.getContentPane().add(lblBibliotecaDigitale);
		
		JButton btnTornaIndietro = new JButton("Torna Indietro");
		btnTornaIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePage.changePage("TipoRicerca", utente);
				frmListaCategorie.dispose();
			}
		});
		btnTornaIndietro.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnTornaIndietro.setBounds(447, 10, 146, 27);
		frmListaCategorie.getContentPane().add(btnTornaIndietro);
		
		JLabel lblNomeCategoria = new JLabel("Nome Categoria");
		lblNomeCategoria.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblNomeCategoria.setBounds(122, 62, 147, 14);
		frmListaCategorie.getContentPane().add(lblNomeCategoria);
		

		
		
		JButton btnAggiungiNuovaCategoria = new JButton("Aggiungi Nuova Categoria");
		btnAggiungiNuovaCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//inserire aggiungere la categoria
				ChangePage.changePage("AggiungiCategoria", utente);
				frmListaCategorie.dispose();
			}
		});
		btnAggiungiNuovaCategoria.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnAggiungiNuovaCategoria.setBounds(170, 341, 267, 27);
		frmListaCategorie.getContentPane().add(btnAggiungiNuovaCategoria);
		

		
	
			if(ol.NumeroRigheOpera() != 0) {
				
				
					String categoria1 = "";
					categoria1 = ol.getInfoOpera(count, 1); // RIGA - COLONNA
					
					JPanel panel = new JPanel();
					JLabel lblcategoria1 = new JLabel(categoria1);
					lblcategoria1.setHorizontalAlignment(SwingConstants.CENTER);
					lblcategoria1.setLabelFor(panel);
					
					lblcategoria1.setForeground(Color.LIGHT_GRAY);
					lblcategoria1.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
					lblcategoria1.setBounds(51, 72, 239, 27); 
					frmListaCategorie.getContentPane().add(lblcategoria1);
					
					JButton btnAccedi = new JButton("Accedi");
					btnAccedi.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
				
						
								String Opera = ol.getInfoOpera(count, 1);
								ChangePage.OperePerCat(Opera, utente, 0);
								frmListaCategorie.dispose();
					  

						}
					});
					btnAccedi.setFont(new Font("Myriad CAD", Font.BOLD, 11));
					btnAccedi.setBounds(368, 75, 154, 27);
					frmListaCategorie.getContentPane().add(btnAccedi);
					
        }
		/* lisa categorie */
		
		
		
		/* lisa categorie */
	
			JLabel lblCategoria2 = null;
			if(count + 1 >= ol.NumeroRigheOpera())
				 lblCategoria2 = new JLabel("");
			else {
				String user2 = "";	
				user2 = ol.getInfoOpera(count + 1, 1);
			
			
				lblCategoria2 = new JLabel(user2);
				lblCategoria2.setHorizontalAlignment(SwingConstants.CENTER);
				lblCategoria2.setForeground(Color.LIGHT_GRAY);
				lblCategoria2.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
				lblCategoria2.setBounds(51, 129, 239, 27);
				frmListaCategorie.getContentPane().add(lblCategoria2);
				
				
				JButton btnRuolo2 = new JButton("Accedi");
				btnRuolo2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					
							String Opera = ol.getInfoOpera(count + 1, 1);
							ChangePage.OperePerCat(Opera, utente, 0);
					
							frmListaCategorie.dispose();

					}
				});
				btnRuolo2.setFont(new Font("Myriad CAD", Font.BOLD, 11));
				btnRuolo2.setBounds(368, 129, 154, 27);
				frmListaCategorie.getContentPane().add(btnRuolo2);
				}

		
			

			JLabel lblCategoria3 = null;
			if(count + 2 >= ol.NumeroRigheOpera())
				 lblCategoria3 = new JLabel("");
			else {
				String Categoria3 = "";	
				Categoria3 = ol.getInfoOpera(count + 2, 1);
			
			
				lblCategoria3 = new JLabel(Categoria3);
				lblCategoria3.setHorizontalAlignment(SwingConstants.CENTER);
				lblCategoria3.setForeground(Color.LIGHT_GRAY);
				lblCategoria3.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
				lblCategoria3.setBounds(51, 183, 239, 27);
				frmListaCategorie.getContentPane().add(lblCategoria3);
				
				
				JButton btnCategoria3 = new JButton("Accedi");
				btnCategoria3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
				
							String Opera = ol.getInfoOpera(count + 2, 1);
							ChangePage.OperePerCat(Opera, utente, 0);
							frmListaCategorie.dispose();
					}
				});
				btnCategoria3.setFont(new Font("Myriad CAD", Font.BOLD, 11));
				btnCategoria3.setBounds(368, 183, 154, 27);
				frmListaCategorie.getContentPane().add(btnCategoria3);
			}	
			

		/* Quarto utente */	

			JLabel lblCategoria4 = null;
			if(count + 3 >= ol.NumeroRigheOpera())
				 lblCategoria4 = new JLabel("");
			else {
				String Categoria4 = "";	
				Categoria4 = ol.getInfoOpera(count + 3, 1);
			
			
				lblCategoria4 = new JLabel(Categoria4);
				lblCategoria4.setHorizontalAlignment(SwingConstants.CENTER);
				lblCategoria4.setForeground(Color.LIGHT_GRAY);
				lblCategoria4.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
				lblCategoria4.setBounds(51, 237, 239, 27);
				frmListaCategorie.getContentPane().add(lblCategoria4);
				
				
				JButton btnCategoria4= new JButton("Accedi");
				btnCategoria4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

							String Opera = ol.getInfoOpera(count + 3, 1);
							
							ChangePage.OperePerCat(Opera, utente, 0);
							frmListaCategorie.dispose();

					}
				});
				btnCategoria4.setFont(new Font("Myriad CAD", Font.BOLD, 11));
				btnCategoria4.setBounds(368, 237, 154, 27);
				frmListaCategorie.getContentPane().add(btnCategoria4);
			}	

		
		
		/* QUinto utente */	

			JLabel lblCategoria5 = null;
			if(count + 4 >= ol.NumeroRigheOpera())
				lblCategoria5 = new JLabel("");
			else {
				String Categoria5 = "";	
				Categoria5 = ol.getInfoOpera(count + 4, 1);
			
			
				lblCategoria5 = new JLabel(Categoria5);
				lblCategoria5.setHorizontalAlignment(SwingConstants.CENTER);
				lblCategoria5.setForeground(Color.LIGHT_GRAY);
				lblCategoria5.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
				lblCategoria5.setBounds(51, 291, 239, 27);
				frmListaCategorie.getContentPane().add(lblCategoria5);
				
				
				JButton btnCategoria5 = new JButton("Accedi");
				btnCategoria5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					
							String Opera = ol.getInfoOpera(count + 4, 1);
							ChangePage.OperePerCat(Opera, utente, 0);
							frmListaCategorie.dispose();
					}
				});
				btnCategoria5.setFont(new Font("Myriad CAD", Font.BOLD, 11));
				btnCategoria5.setBounds(368, 291, 154, 27);
				frmListaCategorie.getContentPane().add(btnCategoria5);
			}	
			
			
			JButton btnAvanti = new JButton("Avanti");
			btnAvanti.setFont(new Font("Myriad CAD", Font.BOLD, 11));
			btnAvanti.setBounds(447, 341, 137, 27);
			frmListaCategorie.getContentPane().add(btnAvanti);
			
	     
	            if (count + 5 >= ol.NumeroRigheOpera()) {
	            	btnAvanti.setEnabled(false);
	            }

	        frmListaCategorie.getContentPane().add(btnAvanti);
			btnAvanti.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frmListaCategorie.dispose();
					count = count +5;
					ChangePage.cat(utente, count);
				}
			});
			
			
			JButton btnIndietro = new JButton("Indietro");
			if (count == 0) btnIndietro.setEnabled(false);
			
			btnIndietro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					count = count -5;
					frmListaCategorie.dispose();
					ChangePage.cat(utente, count);
				}
			});
			btnIndietro.setFont(new Font("Myriad CAD", Font.BOLD, 11));
			btnIndietro.setBounds(23, 341, 137, 27);
			frmListaCategorie.getContentPane().add(btnIndietro);
			
			

		
		/* Permessi */
		if(utente.getMansione().equals("admin") || utente.getMansione().equals("uploader"))
			btnAggiungiNuovaCategoria.setEnabled(true);
		else
			btnAggiungiNuovaCategoria.setEnabled(false);
		
		
		
	}
}
