package Biblioteca;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import common.ChangePage;
import common.vo.Opera;
import common.vo.Utente;
import controller.list.PaginaList;


public class ModuloElencoPagine {
	Utente utente = null;
	Opera opera = null;
	int count = 0;
	PaginaList pl = new PaginaList();
	

	private JFrame frmBibliotecaDigitale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloElencoPagine window = new ModuloElencoPagine();
					window.frmBibliotecaDigitale.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void ElencoPagine(Utente utente, Opera opera, int n) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloElencoPagine window = new ModuloElencoPagine(utente, opera, n);
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
	public ModuloElencoPagine() {
		initialize();
	}
	
	public ModuloElencoPagine(Utente utente, Opera opera, int n) {
		this.count = n;
		this.utente = utente;
		this.opera = opera;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBibliotecaDigitale = new JFrame();
		frmBibliotecaDigitale.setTitle("Biblioteca Digitale - Elenco Pagine");
		frmBibliotecaDigitale.setResizable(false);
		frmBibliotecaDigitale.setBounds(100, 100, 620, 420);
		frmBibliotecaDigitale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBibliotecaDigitale.getContentPane().setLayout(null);
		
		JButton btnTornaIndietro = new JButton("Torna Indietro");
		btnTornaIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePage.changePage("TipoRicerca", utente);
				frmBibliotecaDigitale.dispose();
			}
		});
		btnTornaIndietro.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnTornaIndietro.setBounds(437, 10, 156, 27);
		frmBibliotecaDigitale.getContentPane().add(btnTornaIndietro);
		
		JLabel lblNumeroPagina = new JLabel("Numero Pagina");
		lblNumeroPagina.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblNumeroPagina.setBounds(86, 50, 147, 14);
		frmBibliotecaDigitale.getContentPane().add(lblNumeroPagina);
		
		
		JButton btnAggiungiPagina = new JButton("Aggiungi Pagina");
		btnAggiungiPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//inserire aggiungere la categoria
				ChangePage.changePage1("AggiungiPagina", utente, opera, 0);
				frmBibliotecaDigitale.dispose();
			}
		});
		btnAggiungiPagina.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnAggiungiPagina.setBounds(170, 341, 267, 27);
		frmBibliotecaDigitale.getContentPane().add(btnAggiungiPagina);
		
		
		
		/* Permessi */
		if(utente.getMansione().equals("admin") || utente.getMansione().equals("uploader"))
			btnAggiungiPagina.setEnabled(true);
		else
			btnAggiungiPagina.setEnabled(false);
		
		JLabel lblBibliotecaDigitaleElenco = new JLabel("Biblioteca Digitale Elenco Pagine " + opera.getNome());
		lblBibliotecaDigitaleElenco.setFont(new Font("Tekton Pro", Font.PLAIN, 22));
		lblBibliotecaDigitaleElenco.setBounds(10, 10, 426, 42);
		frmBibliotecaDigitale.getContentPane().add(lblBibliotecaDigitaleElenco);

		
		

			if(pl.numeroRighe(opera.getCod(), opera.getNome()) != 0) {
				
				/* lisa opere */ //Nome Anno Autore
		
					String opera1 = pl.infoOpera(opera.getCod(), opera.getNome(), count, 4); // RIGA - COLONNA
					
					
					
					JPanel panel = new JPanel();
					JLabel lblopera1 = new JLabel(opera1);
					lblopera1.setHorizontalAlignment(SwingConstants.CENTER);
					lblopera1.setLabelFor(panel);
					
					lblopera1.setForeground(Color.LIGHT_GRAY);
					lblopera1.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
					lblopera1.setBounds(10, 75, 239, 27);
					frmBibliotecaDigitale.getContentPane().add(lblopera1);


					
					JButton btnAccedi = new JButton("Opzioni");
					btnAccedi.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
								ChangePage.changePage1("Opzioni", utente, opera, count);
								frmBibliotecaDigitale.dispose();
						}
					});
					btnAccedi.setFont(new Font("Myriad CAD", Font.BOLD, 11));
					btnAccedi.setBounds(200, 75, 400, 27);
					frmBibliotecaDigitale.getContentPane().add(btnAccedi);

				
				
				

					JLabel lblOpera2 = null;
					if(count + 1 >= pl.numeroRighe(opera.getCod(), opera.getNome()))
						 lblOpera2 = new JLabel("");
					else {
						String Opera2 = "";	
						Opera2 = pl.infoOpera(opera.getCod(), opera.getNome(), count + 1, 4);
				
					
					
						lblOpera2 = new JLabel(Opera2);
						lblOpera2.setHorizontalAlignment(SwingConstants.CENTER);
						lblOpera2.setForeground(Color.LIGHT_GRAY);
						lblOpera2.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
						lblOpera2.setBounds(10, 129, 239, 27);
						frmBibliotecaDigitale.getContentPane().add(lblOpera2);
						

						
						
						JButton btnOpera2 = new JButton("Opzioni");
						btnOpera2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								ChangePage.changePage1("Opzioni", utente, opera, count + 1);
								frmBibliotecaDigitale.dispose();
							}
						});
						btnOpera2.setFont(new Font("Myriad CAD", Font.BOLD, 11));
						btnOpera2.setBounds(200, 129, 400, 27);
						frmBibliotecaDigitale.getContentPane().add(btnOpera2);
						}


				
					

					JLabel lblOpera3 = null;
					if(count + 2 >= pl.numeroRighe(opera.getCod(), opera.getNome()))
						 lblOpera3 = new JLabel("");
					else {
						String Opera3 = "";	
						Opera3 = pl.infoOpera(opera.getCod(), opera.getNome(), count + 2, 4);
						
					
						lblOpera3 = new JLabel(Opera3);
						lblOpera3.setHorizontalAlignment(SwingConstants.CENTER);
						lblOpera3.setForeground(Color.LIGHT_GRAY);
						lblOpera3.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
						lblOpera3.setBounds(10, 183, 239, 27);
						frmBibliotecaDigitale.getContentPane().add(lblOpera3);
						

						
						
						
						JButton btnOpera3 = new JButton("Opzioni");
						btnOpera3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								ChangePage.changePage1("Opzioni", utente, opera, count + 2);
								frmBibliotecaDigitale.dispose();
							}
						});
						btnOpera3.setFont(new Font("Myriad CAD", Font.BOLD, 11));
						btnOpera3.setBounds(200, 183, 400, 27);
						frmBibliotecaDigitale.getContentPane().add(btnOpera3);
					}	

				
	
					JLabel lblOpera4= null;
					if(count + 3 >= pl.numeroRighe(opera.getCod(), opera.getNome()))
						 lblOpera4  = new JLabel("");
					else {
						String Opera4= "";	
						Opera4 = pl.infoOpera(opera.getCod(), opera.getNome(), count + 3, 4);
						
					
					
						lblOpera4 = new JLabel(Opera4);
						lblOpera4.setHorizontalAlignment(SwingConstants.CENTER);
						lblOpera4.setForeground(Color.LIGHT_GRAY);
						lblOpera4.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
						lblOpera4.setBounds(10, 237, 239, 27);
						frmBibliotecaDigitale.getContentPane().add(lblOpera4);
						
						
						
						JButton btnOpera4= new JButton("Opzioni");
						btnOpera4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								ChangePage.changePage1("Opzioni", utente, opera, count + 3);
								frmBibliotecaDigitale.dispose();
							}
						});
						btnOpera4.setFont(new Font("Myriad CAD", Font.BOLD, 11));
						btnOpera4.setBounds(200, 237, 400, 27);
						frmBibliotecaDigitale.getContentPane().add(btnOpera4);
					}	
					

				
					
		
					JLabel lblOpera5 = null;
					if(count + 4 >= pl.numeroRighe(opera.getCod(), opera.getNome()))
						lblOpera5 = new JLabel("");
					else {
						String Opera5= "";	
						Opera5 = pl.infoOpera(opera.getCod(), opera.getNome(), count + 4, 4);
						
					
						lblOpera5 = new JLabel(Opera5);
						lblOpera5.setHorizontalAlignment(SwingConstants.CENTER);
						lblOpera5.setForeground(Color.LIGHT_GRAY);
						lblOpera5.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
						lblOpera5.setBounds(10, 291, 239, 27);
						frmBibliotecaDigitale.getContentPane().add(lblOpera5);
						
						
						
						JButton btnOpera5 = new JButton("Opzioni");
						btnOpera5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								ChangePage.changePage1("Opzioni", utente, opera, count + 4);
								frmBibliotecaDigitale.dispose();
							}
						});
						btnOpera5.setFont(new Font("Myriad CAD", Font.BOLD, 11));
						btnOpera5.setBounds(200, 291, 400, 27);
						frmBibliotecaDigitale.getContentPane().add(btnOpera5);
					}	
					
					
					JButton btnAvanti = new JButton("Avanti");
					btnAvanti.setFont(new Font("Myriad CAD", Font.BOLD, 11));
					btnAvanti.setBounds(447, 341, 137, 27);
					frmBibliotecaDigitale.getContentPane().add(btnAvanti);
					
		
			            if (count + 5 >= pl.numeroRighe(opera.getCod(), opera.getNome())) {
			            	btnAvanti.setEnabled(false);
			            }
			
			        frmBibliotecaDigitale.getContentPane().add(btnAvanti);
					btnAvanti.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							frmBibliotecaDigitale.dispose();
							count = count +5;
							ChangePage.changePage1("ElencoPagine", utente, opera, count);
						}
					});
					
					
					JButton btnIndietro = new JButton("Indietro");
					if (count == 0) btnIndietro.setEnabled(false);
					
					btnIndietro.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							count = count -5;
							frmBibliotecaDigitale.dispose();
							ChangePage.changePage1("ElencoPagine", utente, opera, count);
						}
					});
					btnIndietro.setFont(new Font("Myriad CAD", Font.BOLD, 11));
					btnIndietro.setBounds(23, 341, 137, 27);
					frmBibliotecaDigitale.getContentPane().add(btnIndietro);
					
			}

		
		
	}

}
