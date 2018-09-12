package controller.list;

import java.sql.SQLException;

import model.connectionDataBase.ConnectionOpera;
import model.interfaces.InterfaceOpera;

public class PaginaList {
	InterfaceOpera pagine = null;
	
	/* numero righe tabella opera */
	public int numeroRighe(int cod, String nome) {
		
		if(pagine == null) {
			pagine = new ConnectionOpera();
		}
		
		
		// controllare
		int n = 0;
		try {		
			n = pagine.GetPagineOpera(cod, nome).getRowCount();
        } catch (SQLException e){
            e.printStackTrace();
        }
		
		return n;
	}
	
	/* info opera */
	public String infoOpera(int cod, String nome, int r, int c) {
		
		if(pagine == null) {
			pagine = new ConnectionOpera();
		}
		
		String s = "";
		
		try {		
			s = String.valueOf(pagine.GetPagineOpera(cod, nome).getValueAt(r, c));
        } catch (SQLException e){
            e.printStackTrace();
        }
		
		
		return s;
		
	}
}
