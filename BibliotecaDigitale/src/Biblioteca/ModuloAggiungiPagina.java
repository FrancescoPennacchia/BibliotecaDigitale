package Biblioteca;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

import controller.componenti.Opera;
import controller.componenti.Utente;
import controller.interfaces.InterfaceOpera;
import exception.Exception;
import model.connectionDataBase.ConnectionOpera;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class ModuloAggiungiPagina {
	//File Immagine = null;
	Opera op = null;
	Utente utente = null;
	InterfaceOpera opera = new ConnectionOpera();


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
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		frmBibliotecaDigitale = new JFrame();
		frmBibliotecaDigitale.setTitle("Biblioteca Digitale - Inserimento Pagina");
		frmBibliotecaDigitale.setResizable(false);
		frmBibliotecaDigitale.setBounds(100, 100, 620, 420);
		frmBibliotecaDigitale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBibliotecaDigitale.getContentPane().setLayout(null);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                ModuloElencoPagine MEP = new ModuloElencoPagine(utente, op, 0);
                MEP.ElencoPagine(utente, op, 0);
                frmBibliotecaDigitale.dispose();			
			}
		});
		btnIndietro.setFont(new Font("Myriad CAD", Font.BOLD, 11));
		btnIndietro.setBounds(189, 255, 199, 38);
		frmBibliotecaDigitale.getContentPane().add(btnIndietro);
		final String[] img = {""};
		
		JButton btnScegliImmagine = new JButton("Scegli Immagine e inserisci");
		btnScegliImmagine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
                int retVal = jfc.showOpenDialog(frmBibliotecaDigitale);
                if (retVal == JFileChooser.APPROVE_OPTION) {
                    File selectedfile = jfc.getSelectedFile();
                    String tempFileExt = null;
                    File tempFile = null;
                
                try {
                	img[0] = controller.componenti.Component.TipoImmagine(selectedfile);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                // Save the image type to resize it later
                if (img[0].equals("JPEG")) {
                    tempFileExt = "jpg";
                } else if (img[0].equals("png")) {
                    tempFileExt = "png";
                } else if (img[0].equals("gif")) {
                    tempFileExt = "gif";
                }
                
                if (!img[0].equals("png") && !img[0].equals("JPEG")) {
                    throw new Exception("File non compatibile");
                }
                
                    //System.out.println("errore");
                    try {
                    	tempFile = new File("./src/img/Imma.png");
                    	
                        BufferedImage originalImage = ImageIO.read(selectedfile);
                        //System.out.println("errore");
                        int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
                      //  System.out.println("errore");                                                286, 271
                        BufferedImage buffimg = controller.componenti.Component.ResizeImmagine(originalImage, type, 286, 271);  // Cambiare dimensioni
                       // System.out.println("errore4");
                        ImageIO.write(buffimg, tempFileExt, tempFile);
                      //  System.out.println("errore5");
                    

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    
                    int NumeroPagina = 0;
                    NumeroPagina = Integer.parseInt(textField.getText());
                   
                    
                    if(opera.SetImgPagina(op.getCod(), tempFile, NumeroPagina)){
                    	
                 
                        JOptionPane.showMessageDialog(null, "Operazione riuscita");
                        ModuloElencoPagine MEP = new ModuloElencoPagine(utente, op, 0);
                        MEP.ElencoPagine(utente, op, 0);
                        frmBibliotecaDigitale.dispose();
                        tempFile.delete();
                    } else throw new Exception("Errore");
                      

                }
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
