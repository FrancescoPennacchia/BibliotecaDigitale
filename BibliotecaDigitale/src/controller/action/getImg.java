package controller.action;

import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.connectionDataBase.ConnectionOpera;
import model.interfaces.InterfaceOpera;

public class getImg {
	InterfaceOpera pagine = new ConnectionOpera();
	
	public Panel getImmagine(int cod_pagina) {
		Panel panel = new Panel();
		try {
			 
			
			 
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
            	ext = common.Component.TipoImmagine(imgFile);
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
            
            
            

            // Delete the files
            File directory = new File(imgDir);
            for(File f: directory.listFiles())
                if(f.getName().startsWith("propi"))
                    f.delete();

            propicDir.delete();
            
            return panel;
            
			 
		 } catch (SQLException e) {
	            e.printStackTrace();
	     }
		return panel;
	}

}
