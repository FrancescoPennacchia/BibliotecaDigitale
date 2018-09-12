package controller.action;

import model.connectionDataBase.ConnectionOpera;
import model.interfaces.InterfaceOpera;

public class ActionAddOpera {
	InterfaceOpera opera = null;
	
	public void addOpera(String nome, String autore, String anno, String cat) {
		
		if(opera == null) {
			opera = new ConnectionOpera();
		}
		
		try {
			
			int a = Integer.parseInt(anno);
			opera.NewOpera(nome, autore, a, cat);
			
		}   catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
}
