package controller.list;

import java.sql.SQLException;

import model.connectionDataBase.User;
import model.interfaces.InterfaceUser;

public class UserList {
	InterfaceUser u = new User();
	
	/* Ritorna l'username dell'utente  posizione RIGA COLONNA */
	public String UsernameUser(int cont, int n) {
		if(u == null) {
			u= new User();
		}
		
		String user = "";
		
		try {
			user = String.valueOf(u.GetUsers().getValueAt(cont, n));
        } catch (SQLException e){
            e.printStackTrace();
        }
		
		return user;
	}
	
	/* Numero di righe totali della tabella */
	public int NumeroRighe() {
		if(u == null) {
			u= new User();
		}
		
		
		
		int n = 0;
		
		try {
			n = u.GetUsers().getRowCount();
        } catch (SQLException e){
            e.printStackTrace();
        }
		
		return n;
	}
	
	/* livello */
	
	public int lv(int cod) {
		if(u == null) {
			u= new User();
		}
		
		
		int n = 0;
		try {
			n = u.lvTras(cod);
        } catch (SQLException e){
            e.printStackTrace();
        }
		
		return n;
	}

}
