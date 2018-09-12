package controller.list;

import java.sql.SQLException;

import common.vo.Opera;
import model.connectionDataBase.ConnectionOpera;
import model.interfaces.InterfaceOpera;

public class OperaList {
	InterfaceOpera opera = null;
	Opera op = null;
	
	/* Ritorna i dati contenuti nella tabella opera RIGA COLONNA */
	public String getInfoOpera(int cont, int n) {
		if(opera == null) {
			opera = new ConnectionOpera();
		}
		
		String nome = "";
		
		try {
			nome = String.valueOf(opera.GetOpere().getValueAt(cont, n));
        } catch (SQLException e){
            e.printStackTrace();
        }
		
		return nome;
	}
	
	/* Numero di righe totali della tabella */
	public int NumeroRigheOpera() {
		if(opera == null) {
			opera = new ConnectionOpera();
		}
		
		int n = 0;
		
		try {
			n = opera.GetOpere().getRowCount();
        } catch (SQLException e){
            e.printStackTrace();
        }
		
		return n;
	}	
	
	public Opera getOpera(int cont, int n) {
		if(opera == null) {
			opera = new ConnectionOpera();
		}
		
		String cat = "";
		
		try {
			cat = String.valueOf(opera.GetCategorie().getValueAt(cont, n));
			int cod = Integer.parseInt(cat);
			op = opera.GetOpera(cod);
			
			
        } catch (SQLException e){
            e.printStackTrace();
        }
		
		return op;
	}
	
}
