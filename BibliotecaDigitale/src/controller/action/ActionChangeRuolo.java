package controller.action;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.connectionDataBase.User;
import model.interfaces.InterfaceUser;

public class ActionChangeRuolo {
	InterfaceUser us = new User();
	
	public void ChangeRuolo(String username, String ruolo) {
		
		try {
			
			if(ruolo.equals("admin") || ruolo.equals("utente") || ruolo.equals("menager") || ruolo.equals("uploader") || ruolo.equals("transcriver")) {
				us.setRuolo(username, ruolo);
				
			}
			else
				JOptionPane.showMessageDialog(null, "Inserire un ruolo corretto (admin - utente - menager - uploader - transcriber)");
        } catch (SQLException e1){
            e1.printStackTrace();
        }
	}
}
