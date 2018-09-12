package controller.list;

import java.sql.SQLException;

import common.vo.Opera;
import model.connectionDataBase.ConnectionOpera;
import model.interfaces.InterfaceOpera;

public class OperaListCat {
	InterfaceOpera opera = null;
	Opera op = null;
	
	public String getInfoOpera(String cat, int cont, int n) {
		if(opera == null) {
			opera = new ConnectionOpera();
		}
		
		String nome = "";
		try {
			nome = String.valueOf(opera.GetOperePerCategoria(cat).getValueAt(cont, n));
        } catch (SQLException e){
            e.printStackTrace();
		}
		return nome;
	}
	
	public int NumeroRigheOpera(String cat) {
		
		if(opera == null) {
			opera = new ConnectionOpera();
		}
		
		int n = 0;
		
		try {
			n = opera.GetOperePerCategoria(cat).getRowCount();
        } catch (SQLException e){
            e.printStackTrace();
        }
		
		return n;
	}
	
	public Opera getOpera(String cat, int cont, int n) {
		if(opera == null) {
			opera = new ConnectionOpera();
		}
		
		String s = "";
		
		try {
			s = String.valueOf(opera.GetOperePerCategoria(cat).getValueAt(cont, n));
			int cod = Integer.parseInt(s);
			op = opera.GetOpera(cod);
			
			
        } catch (SQLException e){
            e.printStackTrace();
        }
		
		return op;
	}
	
	
	public String getInfoOpera(int cont, int n) {
		if(opera == null) {
			opera = new ConnectionOpera();
		}
		
		String nome = "";
		try {
			nome = String.valueOf(opera.GetCategorie().getValueAt(cont, n));
        } catch (SQLException e){
            e.printStackTrace();
		}
		return nome;
	}
	
	public int NumeroRigheOpera() {
		if(opera == null) {
			opera = new ConnectionOpera();
		}
		
		int n = 0;
		
		try {
			n = opera.GetCategorie().getRowCount();
        } catch (SQLException e){
            e.printStackTrace();
        }
		
		return n;
	}
}
