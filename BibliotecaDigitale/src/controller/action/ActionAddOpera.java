package controller.action;

import model.connectionDataBase.ConnectionOpera;
import model.interfaces.InterfaceOpera;

public class ActionAddOpera {
	InterfaceOpera opera = new ConnectionOpera();
	
	public void addOpera(String nome, String autore, String anno, String cat) {
		try {
			
			int a = Integer.parseInt(anno);
			opera.NewOpera(nome, autore, a, cat);
			
		}   catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
}
