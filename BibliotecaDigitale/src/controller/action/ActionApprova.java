package controller.action;

import javax.swing.JOptionPane;

import model.connectionDataBase.ConnectionOpera;
import model.interfaces.InterfaceOpera;

public class ActionApprova {
	InterfaceOpera opera = new ConnectionOpera();
	
	public void appovazione(int cod) {
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
