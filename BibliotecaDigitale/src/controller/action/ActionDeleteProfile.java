package controller.action;

import java.sql.SQLException;
import javax.swing.JOptionPane;


import model.connectionDataBase.User;
import model.interfaces.InterfaceUser;

public class ActionDeleteProfile {
	InterfaceUser utente = null;
	
	
	public void DeleteUser(String username){
		
		if(utente == null) {
			utente = new User();
		}
		
		try {
			if(utente.DeleteUser(username)) {
				JOptionPane.showMessageDialog(null, "Il tuo Account � stato eliminato ! :D");
			} else {
				JOptionPane.showMessageDialog(null, "Errore, durante la cancellazione !");
			}
			
		
		}	catch (SQLException e2) {
		e2.printStackTrace();
		}
	}
	

}
