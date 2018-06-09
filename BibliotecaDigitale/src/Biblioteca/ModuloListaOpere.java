package Biblioteca;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Componenti.Opera;
import Componenti.Utente;
import ConnectionDataBase.ConnectionOpera;
import Interfaces.InterfaceOpera;

public class ModuloListaOpere {
	
	Utente utente = null;
	Opera op = null;
	int count;
	InterfaceOpera opera = new ConnectionOpera();

	private JFrame frmBibliotecaDigitale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloListaOpere window = new ModuloListaOpere();
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
	public ModuloListaOpere() {
		initialize();
	}
	
	public static void ElencoOpere(Utente utente, int n) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloListaOpere window = new ModuloListaOpere(utente, n);
					window.frmBibliotecaDigitale.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ModuloListaOpere(Utente utente, int n) {
		this.utente = utente;
		this.count = n;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBibliotecaDigitale = new JFrame();
		frmBibliotecaDigitale.setTitle("Biblioteca Digitale - Elenco Opere");
		frmBibliotecaDigitale.setResizable(false);
		frmBibliotecaDigitale.setBounds(100, 100, 620, 420);
		frmBibliotecaDigitale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBibliotecaDigitale.getContentPane().setLayout(null);
		
		
		
		JButton btnTornaIndietro = new JButton("Torna Indietro");
		btnTornaIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipoRicerca TR = new TipoRicerca(utente);
				TR.Ricerca(utente);
				frmBibliotecaDigitale.dispose();
			}
		});
		btnTornaIndietro.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnTornaIndietro.setBounds(447, 10, 146, 27);
		frmBibliotecaDigitale.getContentPane().add(btnTornaIndietro);
		
		JLabel lblNomeCategoria = new JLabel("Nome Opera");
		lblNomeCategoria.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblNomeCategoria.setBounds(118, 63, 119, 14);
		frmBibliotecaDigitale.getContentPane().add(lblNomeCategoria);
		
		
		JButton btnAggiungiNuovaCategoria = new JButton("Aggiungi Nuova Opera");
		btnAggiungiNuovaCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//inserire aggiungere la categoria
				ModuloAggiungiOpera MAO = new ModuloAggiungiOpera(utente);
				MAO.AggiungiOpera(utente);
				frmBibliotecaDigitale.dispose();
			}
		});
		btnAggiungiNuovaCategoria.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnAggiungiNuovaCategoria.setBounds(170, 341, 267, 27);
		frmBibliotecaDigitale.getContentPane().add(btnAggiungiNuovaCategoria);
		
		
		JLabel lblBibliotecaDigitaleElenco = new JLabel("Biblioteca Digitale Elenco Opere");
		lblBibliotecaDigitaleElenco.setFont(new Font("Tekton Pro", Font.PLAIN, 22));
		lblBibliotecaDigitaleElenco.setBounds(62, 10, 351, 42);
		frmBibliotecaDigitale.getContentPane().add(lblBibliotecaDigitaleElenco);
		
		JLabel lblAutore = new JLabel("Autore");
		lblAutore.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblAutore.setBounds(266, 63, 119, 14);
		frmBibliotecaDigitale.getContentPane().add(lblAutore);

		
		
		try {
			if(opera.GetOpere().getRowCount() != 0) {
				
				/* lisa opere */ //Nome Anno Autore
				try {
					String opera1, autore1 = "";
					opera1 = String.valueOf(opera.GetOpere().getValueAt(count, 1)); // RIGA - COLONNA
					autore1 = String.valueOf(opera.GetOpere().getValueAt(count, 3));
					
					JPanel panel = new JPanel();
					JLabel lblopera1 = new JLabel(opera1);
					lblopera1.setHorizontalAlignment(SwingConstants.CENTER);
					lblopera1.setLabelFor(panel);
					
					lblopera1.setForeground(Color.LIGHT_GRAY);
					lblopera1.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
					lblopera1.setBounds(51, 75, 239, 27);
					frmBibliotecaDigitale.getContentPane().add(lblopera1);
					
					JLabel lblautore1 = new JLabel(autore1);
					lblautore1.setHorizontalAlignment(SwingConstants.CENTER);
					lblautore1.setLabelFor(panel);
					
					lblautore1.setForeground(Color.LIGHT_GRAY);
					lblautore1.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
					lblautore1.setBounds(166, 75, 239, 27);
					frmBibliotecaDigitale.getContentPane().add(lblautore1);
					
					JButton btnAccedi = new JButton("Accedi");
					btnAccedi.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
				
							try {
								String Opera = String.valueOf(opera.GetCategorie().getValueAt(count, 0));
								int cod = Integer.parseInt(Opera);
								op = opera.GetOpera(cod);
								ModuloElencoPagine MEP = new ModuloElencoPagine(utente, op,0);
								MEP.ElencoPagine(utente, op, 0);
							
								
								
								
								//Inserire caricamento pagina
								frmBibliotecaDigitale.dispose();
								
					        } catch (SQLException e1){
					            e1.printStackTrace();
					        }

						}
					});
					btnAccedi.setFont(new Font("Myriad CAD", Font.BOLD, 11));
					btnAccedi.setBounds(368, 75, 120, 27);
					frmBibliotecaDigitale.getContentPane().add(btnAccedi);
					
					JButton btnDelete = new JButton("X");
					btnDelete.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
				
							try {
								String Opera = String.valueOf(opera.GetCategorie().getValueAt(count, 0));
								int cod = Integer.parseInt(Opera);
							
								opera.DeleteOpera(cod);
								ModuloListaOpere ML = new ModuloListaOpere(utente,0);
								ML.ElencoOpere(utente, 0);
							
								frmBibliotecaDigitale.dispose();
								
					        } catch (SQLException e1){
					            e1.printStackTrace();
					        }

						}
					});
					btnDelete.setFont(new Font("Myriad CAD", Font.BOLD, 11));
					btnDelete.setBounds(490, 75, 50, 27);
					frmBibliotecaDigitale.getContentPane().add(btnDelete);
					
					
					if(utente.getMansione().equals("admin") || utente.getMansione().equals("manager"))
						btnDelete.setEnabled(true);
					else
						btnDelete.setEnabled(false);
					

					
		        } catch (SQLException e){
		            e.printStackTrace();
		        }
				
				
				
				try {
					JLabel lblOpera2 = null;
					if(count + 1 >= opera.GetOpere().getRowCount())
						 lblOpera2 = new JLabel("");
					else {
						String Opera2 = "";	
						Opera2 = String.valueOf(opera.GetOpere().getValueAt(count + 1, 1));
						String  autore2 = String.valueOf(opera.GetOpere().getValueAt(count +1 , 3));
					
					
						lblOpera2 = new JLabel(Opera2);
						lblOpera2.setHorizontalAlignment(SwingConstants.CENTER);
						lblOpera2.setForeground(Color.LIGHT_GRAY);
						lblOpera2.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
						lblOpera2.setBounds(51, 129, 239, 27);
						frmBibliotecaDigitale.getContentPane().add(lblOpera2);
						
						JLabel lblautore2 = new JLabel(autore2);
						lblautore2.setHorizontalAlignment(SwingConstants.CENTER);
						lblautore2.setForeground(Color.LIGHT_GRAY);
						lblautore2.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
						lblautore2.setBounds(166, 129, 239, 27);
						frmBibliotecaDigitale.getContentPane().add(lblautore2);
						
						
						JButton btnOpera2 = new JButton("Accedi");
						btnOpera2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								try {
									String Opera = String.valueOf(opera.GetOpere().getValueAt(count + 1, 0));
									int cod = Integer.parseInt(Opera);
									op = opera.GetOpera(cod);
									ModuloElencoPagine MEP = new ModuloElencoPagine(utente, op,0);
									MEP.ElencoPagine(utente, op, 0);
									frmBibliotecaDigitale.dispose();
									
						        } catch (SQLException e1){
						            e1.printStackTrace();
						        }
							}
						});
						btnOpera2.setFont(new Font("Myriad CAD", Font.BOLD, 11));
						btnOpera2.setBounds(368, 129, 120, 27);
						frmBibliotecaDigitale.getContentPane().add(btnOpera2);
						
						JButton btnDelete1 = new JButton("X");
						btnDelete1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
					
								try {
									String Opera = String.valueOf(opera.GetCategorie().getValueAt(count + 1, 0));
									int cod = Integer.parseInt(Opera);
								
									opera.DeleteOpera(cod);
									ModuloListaOpere ML = new ModuloListaOpere(utente,0);
									ML.ElencoOpere(utente, 0);
								
									frmBibliotecaDigitale.dispose();
									
						        } catch (SQLException e1){
						            e1.printStackTrace();
						        }

							}
						});
						btnDelete1.setFont(new Font("Myriad CAD", Font.BOLD, 11));
						btnDelete1.setBounds(490, 129, 50, 27);
						frmBibliotecaDigitale.getContentPane().add(btnDelete1);
						
						if(utente.getMansione().equals("admin") || utente.getMansione().equals("manager"))
							btnDelete1.setEnabled(true);
						else
							btnDelete1.setEnabled(false);
						
						}
					


					
		        } catch (SQLException e){
		            e.printStackTrace();
		        }
				
					
				try {
					JLabel lblOpera3 = null;
					if(count + 2 >= opera.GetOpere().getRowCount())
						 lblOpera3 = new JLabel("");
					else {
						String Opera3 = "";	
						Opera3 = String.valueOf(opera.GetOpere().getValueAt(count + 2, 1));
						String  autore3 = String.valueOf(opera.GetOpere().getValueAt(count + 2 , 3));
					
					
						lblOpera3 = new JLabel(Opera3);
						lblOpera3.setHorizontalAlignment(SwingConstants.CENTER);
						lblOpera3.setForeground(Color.LIGHT_GRAY);
						lblOpera3.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
						lblOpera3.setBounds(51, 183, 239, 27);
						frmBibliotecaDigitale.getContentPane().add(lblOpera3);
						
						JLabel lblautore3 = new JLabel(autore3);
						lblautore3.setHorizontalAlignment(SwingConstants.CENTER);
						lblautore3.setForeground(Color.LIGHT_GRAY);
						lblautore3.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
						lblautore3.setBounds(166, 183, 239, 27);
						frmBibliotecaDigitale.getContentPane().add(lblautore3);
						
						
						
						JButton btnOpera3 = new JButton("Accedi");
						btnOpera3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								try {
									String Opera = String.valueOf(opera.GetOpere().getValueAt(count + 2, 0));
									int cod = Integer.parseInt(Opera);
									op = opera.GetOpera(cod);
									ModuloElencoPagine MEP = new ModuloElencoPagine(utente, op,0);
									MEP.ElencoPagine(utente, op, 0);
									frmBibliotecaDigitale.dispose();
									
						        } catch (SQLException e1){
						            e1.printStackTrace();
						        }
							}
						});
						btnOpera3.setFont(new Font("Myriad CAD", Font.BOLD, 11));
						btnOpera3.setBounds(368, 183, 120, 27);
						frmBibliotecaDigitale.getContentPane().add(btnOpera3);
						
						JButton btnDelete3 = new JButton("X");
						btnDelete3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
					
								try {
									String Opera = String.valueOf(opera.GetCategorie().getValueAt(count + 2, 0));
									int cod = Integer.parseInt(Opera);
								
									opera.DeleteOpera(cod);
									ModuloListaOpere ML = new ModuloListaOpere(utente,0);
									ML.ElencoOpere(utente, 0);
								
									frmBibliotecaDigitale.dispose();
									
						        } catch (SQLException e1){
						            e1.printStackTrace();
						        }

							}
						});
						btnDelete3.setFont(new Font("Myriad CAD", Font.BOLD, 11));
						btnDelete3.setBounds(490, 183, 50, 27);
						frmBibliotecaDigitale.getContentPane().add(btnDelete3);
						
						
						if(utente.getMansione().equals("admin") || utente.getMansione().equals("manager"))
							btnDelete3.setEnabled(true);
						else
							btnDelete3.setEnabled(false);
					}	
					
					
		        } catch (SQLException e){
		            e.printStackTrace();
		        }
				
				
				try {
					JLabel lblOpera4= null;
					if(count + 3 >= opera.GetOpere().getRowCount())
						 lblOpera4  = new JLabel("");
					else {
						String Opera4= "";	
						Opera4 = String.valueOf(opera.GetOpere().getValueAt(count + 3, 1));
						String  autore4 = String.valueOf(opera.GetOpere().getValueAt(count + 3 , 3));
					
					
						lblOpera4 = new JLabel(Opera4);
						lblOpera4.setHorizontalAlignment(SwingConstants.CENTER);
						lblOpera4.setForeground(Color.LIGHT_GRAY);
						lblOpera4.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
						lblOpera4.setBounds(51, 237, 239, 27);
						frmBibliotecaDigitale.getContentPane().add(lblOpera4);
						
						JLabel lblautore4 = new JLabel(autore4);
						lblautore4.setHorizontalAlignment(SwingConstants.CENTER);
						lblautore4.setForeground(Color.LIGHT_GRAY);
						lblautore4.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
						lblautore4.setBounds(166, 237, 239, 27);
						frmBibliotecaDigitale.getContentPane().add(lblautore4);
						
						
						JButton btnOpera4= new JButton("Accedi");
						btnOpera4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								try {
									String Opera = String.valueOf(opera.GetOpere().getValueAt(count + 3, 0));
									int cod = Integer.parseInt(Opera);
									op = opera.GetOpera(cod);
									ModuloElencoPagine MEP = new ModuloElencoPagine(utente, op,0);
									MEP.ElencoPagine(utente, op, 0);
									frmBibliotecaDigitale.dispose();
									
						        } catch (SQLException e1){
						            e1.printStackTrace();
						        }
							}
						});
						btnOpera4.setFont(new Font("Myriad CAD", Font.BOLD, 11));
						btnOpera4.setBounds(368, 237, 120, 27);
						frmBibliotecaDigitale.getContentPane().add(btnOpera4);
						
						JButton btnDelete4 = new JButton("X");
						btnDelete4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
					
								try {
									String Opera = String.valueOf(opera.GetCategorie().getValueAt(count + 3, 0));
									int cod = Integer.parseInt(Opera);
								
									opera.DeleteOpera(cod);
									ModuloListaOpere ML = new ModuloListaOpere(utente,0);
									ML.ElencoOpere(utente, 0);
								
									frmBibliotecaDigitale.dispose();
									
						        } catch (SQLException e1){
						            e1.printStackTrace();
						        }

							}
						});
						btnDelete4.setFont(new Font("Myriad CAD", Font.BOLD, 11));
						btnDelete4.setBounds(490, 237, 50, 27);
						frmBibliotecaDigitale.getContentPane().add(btnDelete4);
						
						
						if(utente.getMansione().equals("admin") || utente.getMansione().equals("manager"))
							btnDelete4.setEnabled(true);
						else
							btnDelete4.setEnabled(false);
					}	
					

					
					
					
					
					
		        } catch (SQLException e){
		            e.printStackTrace();
		        }
				
					
				try {
					JLabel lblOpera5 = null;
					if(count + 4 >= opera.GetOpere().getRowCount())
						lblOpera5 = new JLabel("");
					else {
						String Opera5= "";	
						Opera5 = String.valueOf(opera.GetOpere().getValueAt(count + 4, 1));
						String  autore5= String.valueOf(opera.GetOpere().getValueAt(count + 4 , 3));
					
					
						lblOpera5 = new JLabel(Opera5);
						lblOpera5.setHorizontalAlignment(SwingConstants.CENTER);
						lblOpera5.setForeground(Color.LIGHT_GRAY);
						lblOpera5.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
						lblOpera5.setBounds(51, 291, 239, 27);
						frmBibliotecaDigitale.getContentPane().add(lblOpera5);
						
						JLabel lblautore5 = new JLabel(autore5);
						lblautore5.setHorizontalAlignment(SwingConstants.CENTER);
						lblautore5.setForeground(Color.LIGHT_GRAY);
						lblautore5.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
						lblautore5.setBounds(166, 291, 239, 27);
						frmBibliotecaDigitale.getContentPane().add(lblautore5);
						
						
						JButton btnOpera5 = new JButton("Accedi");
						btnOpera5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								try {
									String Opera = String.valueOf(opera.GetOpere().getValueAt(count + 4, 0));
									int cod = Integer.parseInt(Opera);
									op = opera.GetOpera(cod);
									ModuloElencoPagine MEP = new ModuloElencoPagine(utente, op,0);
									MEP.ElencoPagine(utente, op, 0);
									frmBibliotecaDigitale.dispose();
									
						        } catch (SQLException e1){
						            e1.printStackTrace();
						        }
							}
						});
						btnOpera5.setFont(new Font("Myriad CAD", Font.BOLD, 11));
						btnOpera5.setBounds(368, 291, 120, 27);
						frmBibliotecaDigitale.getContentPane().add(btnOpera5);
						
						JButton btnDelete5 = new JButton("X");
						btnDelete5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
					
								try {
									String Opera = String.valueOf(opera.GetCategorie().getValueAt(count + 4, 0));
									int cod = Integer.parseInt(Opera);
								
									opera.DeleteOpera(cod);
									ModuloListaOpere ML = new ModuloListaOpere(utente,0);
									ML.ElencoOpere(utente, 0);
								
									frmBibliotecaDigitale.dispose();
									
						        } catch (SQLException e1){
						            e1.printStackTrace();
						        }

							}
						});
						btnDelete5.setFont(new Font("Myriad CAD", Font.BOLD, 11));
						btnDelete5.setBounds(490, 291, 50, 27);
						frmBibliotecaDigitale.getContentPane().add(btnDelete5);
						
						
						if(utente.getMansione().equals("admin") || utente.getMansione().equals("manager"))
							btnDelete5.setEnabled(true);
						else
							btnDelete5.setEnabled(false);
					}	
					
					
					JButton btnAvanti = new JButton("Avanti");
					btnAvanti.setFont(new Font("Myriad CAD", Font.BOLD, 11));
					btnAvanti.setBounds(447, 341, 137, 27);
					frmBibliotecaDigitale.getContentPane().add(btnAvanti);
					
			        try {
			            if (count + 5 >= opera.GetOpere().getRowCount()) {
			            	btnAvanti.setEnabled(false);
			            }
			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
			        frmBibliotecaDigitale.getContentPane().add(btnAvanti);
					btnAvanti.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							frmBibliotecaDigitale.dispose();
							count = count +5;
							ModuloListaOpere MLO = new ModuloListaOpere(utente, count);
							MLO.ElencoOpere(utente, count);
						}
					});
					
					
					JButton btnIndietro = new JButton("Indietro");
					if (count == 0) btnIndietro.setEnabled(false);
					
					btnIndietro.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							count = count -5;
							frmBibliotecaDigitale.dispose();
							ModuloListaOpere MLO = new ModuloListaOpere(utente, count);
							MLO.ElencoOpere(utente, count);
						}
					});
					btnIndietro.setFont(new Font("Myriad CAD", Font.BOLD, 11));
					btnIndietro.setBounds(23, 341, 137, 27);
					frmBibliotecaDigitale.getContentPane().add(btnIndietro);
					
					
		        } catch (SQLException e){
		            e.printStackTrace();
		        }	
				
			} //else JOptionPane.showMessageDialog(null, "Elenco Vuoto!");
        } catch (SQLException e){
            e.printStackTrace();
        }
		
		/* Permessi */
		if(utente.getMansione().equals("admin") || utente.getMansione().equals("uploader"))
			btnAggiungiNuovaCategoria.setEnabled(true);
		else
			btnAggiungiNuovaCategoria.setEnabled(false);
		
	}

}
