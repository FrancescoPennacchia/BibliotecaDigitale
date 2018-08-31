package controller.list;

import java.sql.SQLException;

import model.connectionDataBase.ConnectionOpera;
import model.interfaces.InterfaceOpera;

public class PaginaList {
	InterfaceOpera pagine = new ConnectionOpera();
	
	/* numero righe tabella opera */
	public int numeroRighe(int cod, String nome) {
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
		String s = "";
		
		try {		
			s = String.valueOf(pagine.GetPagineOpera(cod, nome).getValueAt(r, c));
        } catch (SQLException e){
            e.printStackTrace();
        }
		
		
		return s;
		
	}
}
