package controller.action;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import common.vo.Utente;
import exception.Exception;
import model.connectionDataBase.User;
import model.interfaces.InterfaceUser;

public class ActionModificaProfilo {
	InterfaceUser ut = new User();
	
	
	
	
	public void Modifica(Utente utente, String u, String n, String c, String ts, String pro, String res, String em, String pa) {
		try {
			String email = utente.getEmail();
			String user = utente.getUsername();
			String nome = utente.getNome();
			String cognome = utente.getCognome();
			String studi = utente.getTitoloDiStudi();
			String professione = utente.getProfessione();
			String residenza = utente.getResidenza();
        
        
			/* Controllo se ci sono state modifiche */
			if (n.equals(nome) && c.equals(cognome)
					&& em.equals(email) &&
					u.equals(user) && pa.equals(utente.getPassword()) && ts.equals(studi) && pro.equals(professione)
					&& res.equals(residenza))  {
				//JOptionPane.showMessageDialog(null, "Non sono state fatte modifiche!");
				throw new Exception("Non sono state fatte modifiche!");
			}
		
        
			if (pa.length() == 0) {
				JOptionPane.showMessageDialog(null, "Inserisci una password!");
				throw new Exception("Inserire la Password");
			}               
        
			if (!n.equals(nome) || !c.equals(cognome)
					|| !em.equals(email) ||
					!u.equals(user) || !pa.equals("") || !ts.equals(studi) || !pro.equals(professione)
					|| !res.equals(residenza)) {
				
				
				/* Inserimento delle modifiche */
				Utente NuovoUtente = new Utente();
           
				NuovoUtente = new Utente(utente.getId(), u, pa, n, c, em, utente.getMansione(), utente.getData(), ts, res, pro);
               //System.out.println(NuovoUtente.getId());
              // System.out.println(NuovoUtente.getProfessione());
				ut.SetUtente(NuovoUtente, pa);
               
				
         

           
				JOptionPane.showMessageDialog(null, "Modifiche effettuate");
			} else {
				throw new Exception("Errore DB");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
