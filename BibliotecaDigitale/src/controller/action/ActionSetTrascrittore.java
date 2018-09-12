package controller.action;

import javax.swing.JOptionPane;

import model.connectionDataBase.ConnectionOpera;
import model.interfaces.InterfaceOpera;

public class ActionSetTrascrittore {
	InterfaceOpera opera = null;
	
	public void setTras(String username, int n) {
		if(opera == null) {
			opera = new ConnectionOpera();
		}
		try {
			if(opera.assegnaTrascrizione(username, n)) {
				JOptionPane.showMessageDialog(null, "Assegnata"); // da controllare
			}
			else
				JOptionPane.showMessageDialog(null, "Errore, username inesistente");
			
			//frmBibliotecaDigitale.di
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
