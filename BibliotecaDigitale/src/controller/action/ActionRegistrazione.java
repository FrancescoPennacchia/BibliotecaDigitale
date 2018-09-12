package controller.action;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import common.ChangePage;
import exception.Exception;
import model.connectionDataBase.User;
import model.interfaces.InterfaceUser;

public class ActionRegistrazione {
	InterfaceUser utente = null;

	public void Registrazione(String username, String pass, String email, String nome, String cognome, String Data, String studi, String professione, String residenza){
		if(utente == null) {
			utente = new User();
		}
		
		try {
			          
            

            // Controllo Formato data
            if (Data.matches("\\d{2}/\\d{2}/\\d{4}")) {
            	Data = Data.replaceAll("/", "-");
            }
            
            if (!Data.matches("\\d{2}-\\d{2}-\\d{4}")) {
                throw new Exception("Formato data non valido!");
            }
            
 
            if (utente.NewUser(username, pass, email, nome, cognome, Data, studi, professione, residenza)) {
                JOptionPane.showMessageDialog(null, "Registrato con successo");
            } else  
            	JOptionPane.showMessageDialog(null, "Errore DB");
              
              
            //frmBibliotecaDigitale.dispose();
            ChangePage.Login();
        
		
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
		
	

}
