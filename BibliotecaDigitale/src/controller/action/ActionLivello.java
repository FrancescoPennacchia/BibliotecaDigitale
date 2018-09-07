package controller.action;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.connectionDataBase.User;
import model.interfaces.InterfaceUser;

public class ActionLivello {
	InterfaceUser utente = new User();
	
	public void LvUp(String u, int lv) {

		try {
			if(lv >= 1 && lv < 5) {
				if(utente.updateLivello(u, lv + 1)) {
					JOptionPane.showMessageDialog(null,"Livello aumentato");
				} else JOptionPane.showMessageDialog(null,"Errore");
			}
			else
			  JOptionPane.showMessageDialog(null,"Già inserito il lv massimo.");
			
        } catch (SQLException e){
            e.printStackTrace();
        }

	}
	
	public void LvD(String u, int lv) {

		try {
			if(lv > 1) {
				if(utente.updateLivello(u, lv - 1)) {
					JOptionPane.showMessageDialog(null,"Livello Diminuito");
				} else JOptionPane.showMessageDialog(null,"Errore");
			}
			else
				JOptionPane.showMessageDialog(null,"Ha già il lv minimo");
			
        } catch (SQLException e){
            e.printStackTrace();
        }

	}
		
	
}
