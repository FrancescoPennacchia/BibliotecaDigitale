package Biblioteca;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.componenti.Opera;
import controller.componenti.Utente;
import controller.interfaces.InterfaceOpera;
import model.connectionDataBase.ConnectionOpera;

import javax.swing.JTextField;
import javax.swing.JTextPane;

public class ModuloAggiungiTrascrizione {
	Utente utente = null;
	Opera opera = null;
	int numero_pagina = 0;
	int cod_pagina = 0;
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
		int n = 0;
		frmBibliotecaDigitale = new JFrame();
		frmBibliotecaDigitale.setTitle("Biblioteca Digitale - Inserimento Trascrizione");
		frmBibliotecaDigitale.setResizable(false);
		frmBibliotecaDigitale.setBounds(100, 100, 620, 420);
		frmBibliotecaDigitale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBibliotecaDigitale.getContentPane().setLayout(null);
		
		try {
			cod_pagina = Integer.parseInt(String.valueOf(pagine.GetPagineOpera(opera.getCod(), opera.getNome()).getValueAt(numero_pagina, 0)));
			n = Integer.parseInt(String.valueOf(pagine.GetPagineOpera(opera.getCod(), opera.getNome()).getValueAt(numero_pagina, 4)));
			//Trascrizione = String.valueOf(pagine.GetPagineOpera(opera.getCod(), opera.getNome()).getValueAt(numero_pagina, 2));
			
		} catch (SQLException e1){
            e1.printStackTrace();
        }
		
		JButton button = new JButton("Indietro");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpzioniPagina OP = new OpzioniPagina(utente, opera, numero_pagina);
				OP.Opzioni(utente, opera, numero_pagina);
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
		
		 try {
			 
			 Panel panel = new Panel();
			 
             // Image name
             String imgName = "propic";
             String imgDir = "./src/img/";

             // Image path
             String imgPath = imgDir + imgName;
             File propicDir = new File(imgPath);

             pagine.GetImgPagina(cod_pagina, imgPath);

             File imgFile = new File(imgPath);
             String ext = null;
             
             try {
             	ext = controller.componenti.Component.TipoImmagine(imgFile);
             } catch (IOException e1) {
                 e1.printStackTrace();
             }


             if (ext.equals("JPEG")) {
            	 ext = "jpg";
             } else if (ext.equals("png")) {
            	 ext = "png";
             } else if (ext.equals("gif")) {
            	 ext = "gif";
             }
             
             imgPath = imgPath + ext;
             
             pagine.GetImgPagina(cod_pagina, imgPath);
             
             BufferedImage Immagine = null;
             
             try {

            	 Immagine = ImageIO.read(new File(imgPath));

                 JLabel lblImg = new JLabel(new ImageIcon(Immagine));
                 panel.add(lblImg);

             } catch (IOException e) {
                 e.printStackTrace();
             }
             
             panel.setBounds(302, 54, 286, 271);
             frmBibliotecaDigitale.getContentPane().add(panel);
             
             JButton btnInserisci = new JButton("Inserisci");
             btnInserisci.addActionListener(new ActionListener() {
             	public void actionPerformed(ActionEvent e) {
             		if(!textField.getText().isEmpty())
             		{
             			try {
             				pagine.UpdateTrascrizione(textField.getText(), cod_pagina);
             				
            				OpzioniPagina OP = new OpzioniPagina(utente, opera, numero_pagina);
            				OP.Opzioni(utente, opera, numero_pagina);
            				frmBibliotecaDigitale.dispose();
            				
             			} catch (SQLException e1) {
            	            e1.printStackTrace();
             		    }
             			
             			
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

             // Delete the files
             File directory = new File(imgDir);
             for(File f: directory.listFiles())
                 if(f.getName().startsWith("propi"))
                     f.delete();

             propicDir.delete();
             
             
			 
		 } catch (SQLException e) {
	            e.printStackTrace();
	     }

	
	}
}
