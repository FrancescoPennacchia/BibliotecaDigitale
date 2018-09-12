package controller.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

import exception.Exception;
import model.connectionDataBase.ConnectionOpera;
import model.interfaces.InterfaceOpera;

public class ActionAddPagina {
	final String[] img = {""};
	JFileChooser jfc = null;
	InterfaceOpera opera = null;
	
	public void setImage(int cod, String n) {
		
		if(opera == null) {
			opera = new ConnectionOpera();
		}
		
		if(jfc == null) {
			jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		}
		
		
        int retVal = jfc.showOpenDialog(null);
        if (retVal == JFileChooser.APPROVE_OPTION) {
            File selectedfile = jfc.getSelectedFile();
            String tempFileExt = null;
            File tempFile = null;
        
        try {
        	img[0] = common.Component.TipoImmagine(selectedfile);
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
                BufferedImage buffimg = common.Component.ResizeImmagine(originalImage, type, 286, 271);  // Cambiare dimensioni
               // System.out.println("errore4");
                ImageIO.write(buffimg, tempFileExt, tempFile);
              //  System.out.println("errore5");
            

            } catch (IOException e1) {
                e1.printStackTrace();
            }
            
            int NumeroPagina = 0;
            NumeroPagina = Integer.parseInt(n);
           
            
            if(opera.SetImgPagina(cod, tempFile, NumeroPagina)){
            	
         
                JOptionPane.showMessageDialog(null, "Operazione riuscita");

                tempFile.delete();
            } else throw new Exception("Errore");
        }
		
	}

}
