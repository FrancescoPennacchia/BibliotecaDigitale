package model.interfaces;

import java.sql.SQLException;

import javax.swing.table.TableModel;

import common.vo.Utente;

public interface InterfaceUser {
		
    /* Login */
    boolean UserLogin(String username, String password) throws SQLException;
    
    /* Registrazione */
    boolean NewUser(String username, String password, String email, String nome, String cognome, String data_di_nascita, String titolo_di_studi, String professione, String residenza) throws SQLException;
        
    /* Ritorno informazione utente */
    Utente GetUtente(String username) throws SQLException;
    
    /* Eliminazione Utente */
    boolean DeleteUser(String username) throws SQLException;
    
    /* Modifica Dati */
    public boolean SetUtente(Utente utente, String password) throws SQLException;
    
    /* Recupero lista utenti (TableModel fa parte della Swing)*/
    public TableModel GetUsers () throws SQLException;
    
    /* Modifica Dei Ruoli */
    public boolean setRuolo(String username, String ruolo) throws SQLException;
    
    
}


