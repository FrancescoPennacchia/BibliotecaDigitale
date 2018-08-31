package controller.action;

import model.connectionDataBase.ConnectionOpera;
import model.interfaces.InterfaceOpera;

public class ActionAddCategoria {
	InterfaceOpera opera = new ConnectionOpera();
	
	public void addCat(String cat) {
		try {
			opera.NewCategoria(cat);
			//frmBibliotecaDigitale.di
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
