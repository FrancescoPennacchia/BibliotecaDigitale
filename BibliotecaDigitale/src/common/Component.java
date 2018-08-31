package common;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import exception.Exception;

public class Component {
    /* Convert a date into a string */
    public static String dateToString(java.sql.Date date) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String text = df.format(date);

        return text;
    }
    
    
    /* Convert a string to a java.sql.date format */
    public static java.sql.Date stringToDate(String dateString) throws ParseException {

        // Date format
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date = formatter.parse(dateString);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        return sqlDate;
    }
    
    public static BufferedImage ResizeImmagine(BufferedImage originalImage, int type, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, width, null);
        g.dispose();

        return resizedImage;
    }
    
 
    public static String TipoImmagine(File file) throws IOException {
        String imageType = null;

        ImageInputStream iis = ImageIO.createImageInputStream(file);
        Iterator<ImageReader> imageReaders = ImageIO.getImageReaders(iis);

        // Read the image type
        while (imageReaders.hasNext()) {
            ImageReader reader = (ImageReader) imageReaders.next();
            imageType = reader.getFormatName();
        }

        if (imageType == null) {
            throw new Exception("Errore lettura File");
        }
        return imageType;
    }
}
