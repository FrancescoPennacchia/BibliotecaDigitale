package controller.action;

import java.sql.SQLException;

import model.connectionDataBase.ConnectionOpera;
import model.interfaces.InterfaceOpera;

public class ActionAddTrascrizione {
	InterfaceOpera pagine = null;
	
	public void addTrascrizione(String trascrizione, int cod) {
		
		if(pagine == null) {
			pagine = new ConnectionOpera();
		}
		
		try {
			pagine.UpdateTrascrizione(trascrizione, cod);
		} catch (SQLException e1) {
	        e1.printStackTrace();
 	    }
 			
	}
}
