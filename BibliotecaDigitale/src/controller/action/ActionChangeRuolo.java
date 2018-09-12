package controller.action;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.connectionDataBase.User;
import model.interfaces.InterfaceUser;

public class ActionChangeRuolo {
	InterfaceUser us = null;
	
	public void ChangeRuolo(String username, String ruolo) {
		
		if(us == null) {
			us = new User();
		}
		
		try {
			
			if(ruolo.equals("admin") || ruolo.equals("utente") || ruolo.equals("menager") || ruolo.equals("uploader") || ruolo.equals("transcriber")) {
				us.setRuolo(username, ruolo);
				
				//visionare questa parte
				if(ruolo.equals("transcriber") || ruolo.equals("admin")) {
					us.setTrascrittore(username);
				}
				
			}
			else
				JOptionPane.showMessageDialog(null, "Inserire un ruolo corretto (admin - utente - menager - uploader - transcriber)");
        } catch (SQLException e1){
            e1.printStackTrace();
        }
	}
}
