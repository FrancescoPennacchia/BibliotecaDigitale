package Biblioteca;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import common.ChangePage;
import common.vo.Utente;
import controller.list.UserList;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModuloListaUtenti {

	private JFrame frmListaUtenti;
	Utente utente = null;
	int count;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloListaUtenti window = new ModuloListaUtenti();
					window.frmListaUtenti.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void ListaUtenti(Utente u, int c) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModuloListaUtenti window = new ModuloListaUtenti(u,c);
					window.frmListaUtenti.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ModuloListaUtenti() {
		initialize();
	}
	
	public ModuloListaUtenti(Utente u, int c) {
		this.utente = u;
		this.count = c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		UserList call = new UserList();
		frmListaUtenti = new JFrame();
		frmListaUtenti.setResizable(false);
		frmListaUtenti.setTitle("Biblioteca Digitale - Lista Utenti");
		frmListaUtenti.setBounds(100, 100, 620, 420);
		frmListaUtenti.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListaUtenti.getContentPane().setLayout(null);
		
		JLabel lblBibliotecaDigitale = new JLabel("Biblioteca Digitale - Lista Utenti");
		lblBibliotecaDigitale.setFont(new Font("Tekton Pro", Font.PLAIN, 22));
		lblBibliotecaDigitale.setBounds(127, 11, 363, 42);
		frmListaUtenti.getContentPane().add(lblBibliotecaDigitale);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Myriad CAD", Font.BOLD, 13));
		lblUser.setBounds(151, 64, 119, 14);
		frmListaUtenti.getContentPane().add(lblUser);
		
		JButton btnTor = new JButton("Torna al menu");
		btnTor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangePage.changePage("Menu", utente);
				frmListaUtenti.dispose();
			}
		});
		btnTor.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnTor.setBounds(442, 11, 162, 27);
		frmListaUtenti.getContentPane().add(btnTor);
		

		
		/* Pirmo utente */
				
		
			String user1, userM1 = "";
			user1 = call.UsernameUser(count, 1); // RIGA - COLONNA
			userM1 = call.UsernameUser(count, 10);
			
			JPanel panel = new JPanel();
			JLabel lblUser1 = new JLabel(user1);
			lblUser1.setHorizontalAlignment(SwingConstants.CENTER);
			lblUser1.setLabelFor(panel);
			
			lblUser1.setForeground(Color.LIGHT_GRAY);
			lblUser1.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
			lblUser1.setBounds(51, 75, 239, 27);
			frmListaUtenti.getContentPane().add(lblUser1);
			
			JButton btnRuolo = new JButton("Modifica Ruolo");
			btnRuolo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

						String User = call.UsernameUser(count, 1);
						ChangePage.ChangeRuolo(User, utente);
						frmListaUtenti.dispose();	
				}
			});
			btnRuolo.setFont(new Font("Myriad CAD", Font.BOLD, 11));
			btnRuolo.setBounds(368, 75, 154, 27);
			frmListaUtenti.getContentPane().add(btnRuolo);
			
			JButton btnLv = new JButton("Livello");
			btnLv.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

						String User = call.UsernameUser(count, 1);
						int n = Integer.parseInt(call.UsernameUser(count, 0));
						
						ChangePage.LvPage(utente, User, n);
						frmListaUtenti.dispose();	
				}
			});
			btnLv.setFont(new Font("Myriad CAD", Font.BOLD, 11));
			btnLv.setBounds(210, 75, 154, 27);
			frmListaUtenti.getContentPane().add(btnLv);
		
		
			
			if(userM1.equals("transcriber") || userM1.equals("trascrittore") || userM1.equals("admin")) {
				btnLv.setEnabled(true);
			}
			else {
				btnLv.setEnabled(false);
			}
		
				
		
		/* Secondo utente */	
		
			JLabel lblUser2 = null;
			if(count + 1 >= call.NumeroRighe())
				 lblUser2 = new JLabel("");
			else {
				String user2, userM2 = "";	
				user2 = call.UsernameUser(count + 1, 1);
				userM2 = call.UsernameUser(count + 1, 10);
			
			
				lblUser2 = new JLabel(user2);
				lblUser2.setHorizontalAlignment(SwingConstants.CENTER);
				lblUser2.setForeground(Color.LIGHT_GRAY);
				lblUser2.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
				lblUser2.setBounds(51, 129, 239, 27);
				frmListaUtenti.getContentPane().add(lblUser2);
				
				
				JButton btnRuolo2 = new JButton("Modifica Ruolo");
				btnRuolo2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
							String User = call.UsernameUser(count + 1, 1);
							ChangePage.ChangeRuolo(User, utente);
							frmListaUtenti.dispose();
					}
				});
				btnRuolo2.setFont(new Font("Myriad CAD", Font.BOLD, 11));
				btnRuolo2.setBounds(368, 129, 154, 27);
				frmListaUtenti.getContentPane().add(btnRuolo2);
				
				JButton btnLv2 = new JButton("Livello");
				btnLv2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

							String User = call.UsernameUser(count + 1, 1);
							int n = Integer.parseInt(call.UsernameUser(count + 1, 0));
						
							ChangePage.LvPage(utente, User, n);
							frmListaUtenti.dispose();	
					}
				});
				btnLv2.setFont(new Font("Myriad CAD", Font.BOLD, 11));
				btnLv2.setBounds(210, 129, 154, 27);
				frmListaUtenti.getContentPane().add(btnLv2);
				
				if(userM2.equals("transcriber") || userM2.equals("trascrittore") || userM2.equals("admin")) {
					btnLv2.setEnabled(true);
				}
				else {
					btnLv2.setEnabled(false);
				}
			
				
				
			}	
			

		
		
		
		/* Terzo utente */	
		
			JLabel lblUser3 = null;
			if(count + 2 >= call.NumeroRighe())
				 lblUser3 = new JLabel("");
			else {
				String user3, userM3 = "";	
				user3 = call.UsernameUser(count + 2, 1);
				userM3 = call.UsernameUser(count + 2, 10);
				//System.out.println(userM3);
			
				lblUser3 = new JLabel(user3);
				lblUser3.setHorizontalAlignment(SwingConstants.CENTER);
				lblUser3.setForeground(Color.LIGHT_GRAY);
				lblUser3.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
				lblUser3.setBounds(51, 183, 239, 27);
				frmListaUtenti.getContentPane().add(lblUser3);
				
				
				JButton btnRuolo3 = new JButton("Modifica Ruolo");
				btnRuolo3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					
							String User = call.UsernameUser(count + 2, 1);
							ChangePage.ChangeRuolo(User, utente);
							frmListaUtenti.dispose();
						}
					
				});
				btnRuolo3.setFont(new Font("Myriad CAD", Font.BOLD, 11));
				btnRuolo3.setBounds(368, 183, 154, 27);
				frmListaUtenti.getContentPane().add(btnRuolo3);
				
				JButton btnLv3 = new JButton("Livello");
				btnLv3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

							String User = call.UsernameUser(count + 2, 1);
							int n = Integer.parseInt(call.UsernameUser(count + 2, 0));
							
							ChangePage.LvPage(utente, User, n);
							frmListaUtenti.dispose();	
					}
				});
				btnLv3.setFont(new Font("Myriad CAD", Font.BOLD, 11));
				btnLv3.setBounds(210, 183, 154, 27);
				frmListaUtenti.getContentPane().add(btnLv3);
				
				if(userM3.equals("transcriber") || userM3.equals("trascrittore") || userM3.equals("admin")) {
					btnLv3.setEnabled(true);
				}
				else {
					btnLv3.setEnabled(false);
				}
			
			}	

		
		/* Quarto utente */	
	
			JLabel lblUser4 = null;
			if(count + 3 >= call.NumeroRighe())
				 lblUser4 = new JLabel("");
			else {
				String user4, userM4 = "";	
				user4 = call.UsernameUser(count + 3, 1);
				userM4 = call.UsernameUser(count + 3, 10);
			
			
				lblUser4 = new JLabel(user4);
				lblUser4.setHorizontalAlignment(SwingConstants.CENTER);
				lblUser4.setForeground(Color.LIGHT_GRAY);
				lblUser4.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
				lblUser4.setBounds(51, 237, 239, 27);
				frmListaUtenti.getContentPane().add(lblUser4);
				
				
				JButton btnRuolo4 = new JButton("Modifica Ruolo");
				btnRuolo4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
							String User = call.UsernameUser(count + 3, 1);
							ChangePage.ChangeRuolo(User, utente);
							frmListaUtenti.dispose();
					}
				});
				btnRuolo4.setFont(new Font("Myriad CAD", Font.BOLD, 11));
				btnRuolo4.setBounds(368, 237, 154, 27);
				frmListaUtenti.getContentPane().add(btnRuolo4);
				
				JButton btnLv4 = new JButton("Livello");
				btnLv4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

							String User = call.UsernameUser(count + 3, 1);
							int n = Integer.parseInt(call.UsernameUser(count + 3, 0));
						
							ChangePage.LvPage(utente, User, n);
							frmListaUtenti.dispose();	
					}
				});
				btnLv4.setFont(new Font("Myriad CAD", Font.BOLD, 11));
				btnLv4.setBounds(210, 237, 154, 27);
				frmListaUtenti.getContentPane().add(btnLv4);
				
				if(userM4.equals("transcriber") || userM4.equals("trascrittore") || userM4.equals("admin")) {
					btnLv4.setEnabled(true);
				}
				else {
					btnLv4.setEnabled(false);
				}
			}	

		
		
		/* QUinto utente */	
			JLabel lblUser5 = null;
			if(count + 4 >= call.NumeroRighe())
				 lblUser5 = new JLabel("");
			else {
				String user5, userM5 = "";	
				user5 = call.UsernameUser(count + 4, 1);
				userM5 = call.UsernameUser(count + 4, 10);
			
			
				lblUser5 = new JLabel(user5);
				lblUser5.setHorizontalAlignment(SwingConstants.CENTER);
				lblUser5.setForeground(Color.LIGHT_GRAY);
				lblUser5.setFont(new Font("Gadugi", Font.BOLD | Font.ITALIC, 14));
				lblUser5.setBounds(51, 291, 239, 27);
				frmListaUtenti.getContentPane().add(lblUser5);
				
				
				JButton btnRuolo5 = new JButton("Modifica Ruolo");
				btnRuolo5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
							String User = call.UsernameUser(count + 4, 1);
							ChangePage.ChangeRuolo(User, utente);
							frmListaUtenti.dispose();
					}
				});
				btnRuolo5.setFont(new Font("Myriad CAD", Font.BOLD, 11));
				btnRuolo5.setBounds(368, 291, 154, 27);
				frmListaUtenti.getContentPane().add(btnRuolo5);
				
				
				JButton btnLv5 = new JButton("Livello");
				btnLv5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

							String User = call.UsernameUser(count + 4, 1);
							int n = Integer.parseInt(call.UsernameUser(count + 4, 0));
						
							ChangePage.LvPage(utente, User, n);
							frmListaUtenti.dispose();	
					}
				});
				btnLv5.setFont(new Font("Myriad CAD", Font.BOLD, 11));
				btnLv5.setBounds(210, 291, 154, 27);
				frmListaUtenti.getContentPane().add(btnLv5);
				
				if(userM5.equals("transcriber") || userM5.equals("trascrittore") || userM5.equals("admin")) {
					btnLv5.setEnabled(true);
				}
				else {
					btnLv5.setEnabled(false);
				}
			}	
			
			
			JButton btnAvanti = new JButton("Avanti");
			btnAvanti.setFont(new Font("Myriad CAD", Font.BOLD, 11));
			btnAvanti.setBounds(426, 340, 162, 27);
			frmListaUtenti.getContentPane().add(btnAvanti);
			
	      
	        if (count + 5 >= call.NumeroRighe()) {
	            btnAvanti.setEnabled(false);
	        }

	        frmListaUtenti.getContentPane().add(btnAvanti);
			btnAvanti.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frmListaUtenti.dispose();
					count = count +5;
					ChangePage.ListaUtenti(utente, count);
				}
			});
			
			
			JButton btnIndietro = new JButton("Indietro");
			if (count == 0) btnIndietro.setEnabled(false);
			
			btnIndietro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					count = count -5;
					frmListaUtenti.dispose();
					ChangePage.ListaUtenti(utente, count);
				}
			});
			btnIndietro.setFont(new Font("Myriad CAD", Font.BOLD, 11));
			btnIndietro.setBounds(23, 341, 162, 27);
			frmListaUtenti.getContentPane().add(btnIndietro);
			
						
	}
}
