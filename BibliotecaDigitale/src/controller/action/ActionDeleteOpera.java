package controller.action;

import java.sql.SQLException;

import model.connectionDataBase.ConnectionOpera;
import model.interfaces.InterfaceOpera;

public class ActionDeleteOpera {
	InterfaceOpera opera = null;
	
	public void deleteOpera(int c, int n) {
		
		
		if(opera == null) {
			opera = new ConnectionOpera();
		}
		
		try {
			String Opera = String.valueOf(opera.GetOpere().getValueAt(c, n));
			int cod = Integer.parseInt(Opera);
			//System.out.println(cod);
			opera.DeleteOpera(cod);
			
        } catch (SQLException e1){
            e1.printStackTrace();
        }
		
	}
	
	public void deleteOperaCat(String cat, int c, int n) {
		
		
		if(opera == null) {
			opera = new ConnectionOpera();
		}
		
		try {
			String Opera = String.valueOf(opera.GetOperePerCategoria(cat).getValueAt(c, n));
			int cod = Integer.parseInt(Opera);
			//System.out.println(cod);
			opera.DeleteOpera(cod);
			
        } catch (SQLException e1){
            e1.printStackTrace();
        }
		
	}
}
