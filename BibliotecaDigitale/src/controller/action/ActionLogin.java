package controller.action;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import common.ChangePage;
import common.vo.Utente;
import model.connectionDataBase.User;
import model.interfaces.InterfaceUser;

public class ActionLogin {
	
	InterfaceUser utente = null;
	//ActionLogin call = new ActionLogin();
	
	
	/* Login Action */
	public boolean UserLogin(String username, String password) {
		if(utente == null) {
			utente = new User();
		}
		
		 try {
				if(utente.UserLogin(username, password)){
					JOptionPane.showMessageDialog(null,"Loggato");
					Utente ut = GetUtente(username);
					ChangePage.changePage("ModuloLoggato", ut);
					return true;
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Username o password errati!");
					return false;
				}
		 }
		 catch (SQLException e) {
			 e.printStackTrace();
     }
		 return false;
	}
	
	/* Ritorna l'utente */
	 public Utente GetUtente(String username) throws SQLException {
		if(utente == null) {
			utente = new User();
		}
			
		 Utente ut = utente.GetUtente(username);
		 return ut;
	 }

}
