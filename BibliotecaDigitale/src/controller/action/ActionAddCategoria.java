package controller.action;


import model.connectionDataBase.ConnectionOpera;
import model.interfaces.InterfaceOpera;

public class ActionAddCategoria {
	InterfaceOpera opera = null;

	
	public void addCat(String cat) {
		
		// singelton
		if(opera == null) {
			opera = new ConnectionOpera();
		}
		
		try {
			opera.NewCategoria(cat);
			
			//frmBibliotecaDigitale.di
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
