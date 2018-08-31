package controller.action;

import java.sql.SQLException;

import model.connectionDataBase.ConnectionOpera;
import model.interfaces.InterfaceOpera;

public class ActionAddTrascrizione {
	InterfaceOpera pagine = new ConnectionOpera();
	
	public void addTrascrizione(String trascrizione, int cod) {
		
		try {
			pagine.UpdateTrascrizione(trascrizione, cod);
		} catch (SQLException e1) {
	        e1.printStackTrace();
 	    }
 			
	}
}
