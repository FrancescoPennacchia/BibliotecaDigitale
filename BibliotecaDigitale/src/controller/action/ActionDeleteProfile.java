package controller.action;

import java.sql.SQLException;
import javax.swing.JOptionPane;


import model.connectionDataBase.User;
import model.interfaces.InterfaceUser;

public class ActionDeleteProfile {
	InterfaceUser utente = new User();
	
	
	public void DeleteUser(String username){
		
		try {
			if(utente.DeleteUser(username)) {
				JOptionPane.showMessageDialog(null, "Il tuo Account è stato eliminato ! :D");
			} else {
				JOptionPane.showMessageDialog(null, "Errore, durante la cancellazione !");
			}
			
		
		}	catch (SQLException e2) {
		e2.printStackTrace();
		}
	}
	

}
