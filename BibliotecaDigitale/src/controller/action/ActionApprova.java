package controller.action;

import javax.swing.JOptionPane;

import model.connectionDataBase.ConnectionOpera;
import model.interfaces.InterfaceOpera;

public class ActionApprova {
	InterfaceOpera opera = null;
	
	public void appovazione(int cod) {
		
		
		if(opera == null) {
			opera = new ConnectionOpera();
		}
		
		try {
			if(opera.approvaTrascrizione(cod)) 
				JOptionPane.showMessageDialog(null, "Approvata");
			else
				JOptionPane.showMessageDialog(null, "Errore");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
