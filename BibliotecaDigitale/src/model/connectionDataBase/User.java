package model.connectionDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import common.Component;
import common.vo.Utente;
import net.proteanit.sql.DbUtils;
import exception.Exception;
import model.interfaces.InterfaceUser;


public class User implements InterfaceUser {
	
    /* Get a id */
    public int GetUserID(String user) throws SQLException {

    	
        // User id that will be returned
        int id = 0;

        // DB Connection
        Connection dbConnection = model.connectionDataBase.ConnectionDB.Connect();


        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT id FROM utente WHERE username = ?");
        
        
        stmt.setString(1, user);
        ResultSet rs = stmt.executeQuery();


        
        if (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }
    
    public TableModel GetUsers () throws SQLException {
        // DB Connection
        Connection dbConnection = model.connectionDataBase.ConnectionDB.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT * FROM utente ");

        ResultSet rs = stmt.executeQuery();
        TableModel tm = DbUtils.resultSetToTableModel(rs);
        dbConnection.close();

        return tm;
    }

    public boolean UserLogin(String username, String password)  throws SQLException {

    	
        // Get the id given the username
        int id = new User().GetUserID(username);

       
        // DB Connection
        Connection conn = model.connectionDataBase.ConnectionDB.Connect();
        
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM utente WHERE id = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String hashedPass = rs.getString("password");

                //Check if the provided password and the hashed one are equal
                if (model.connectionDataBase.ConnectionDB.checkPassword(password, hashedPass))
                    return true;
                else return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
    
    /* Convert a date into a string */
    public static String dateToString(java.sql.Date date) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String text = df.format(date);

        return text;
    }
    
    public boolean NewUser(String username, String password, String email, String nome, String cognome, String data_di_nascita, String titolo_di_studi, String professione, String residenza) throws SQLException {

        // Convert the date string to a  java.sql.Date format
        java.sql.Date data = null;
        try {
            data = Component.stringToDate(data_di_nascita);
        } catch (ParseException e) {
            throw new Exception("Formato data non valido");
        }

        PreparedStatement preparedStatement = null;

        // DB Connection
        Connection dbConnection = model.connectionDataBase.ConnectionDB.Connect();

        // Password hashing
        password = model.connectionDataBase.ConnectionDB.hashPassword(password);

        String insertTableSQL = "INSERT INTO utente" + "(username, password, email,nome, cognome, data_di_nascita, titolo_di_studi, professione, residenza, mansione) VALUES" + "(?,?,?,?,?,?,?,?,?,?)";

        // Insert the values into the DB
        try {
        	String mansione = "utente";
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, nome);
            preparedStatement.setString(5, cognome);
            preparedStatement.setDate(6, data);
            preparedStatement.setString(7, titolo_di_studi);
            preparedStatement.setString(8, professione);
            preparedStatement.setString(9, residenza);
            preparedStatement.setString(10, mansione);

            // Inserimento DB verificia il corretto inserimento
            if (preparedStatement.executeUpdate() != 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
        }

        return false;
    }
    
    /*Elimnazione Utente dal DB */
    public boolean DeleteUser(String username) throws SQLException {
    	 PreparedStatement preparedStatement = null;
    	// DB Connection
        Connection dbConnection = model.connectionDataBase.ConnectionDB.Connect();
        try {
        	preparedStatement = dbConnection.prepareStatement("DELETE FROM utente WHERE username = ?");
        	preparedStatement.setString(1, username);
        	preparedStatement.executeUpdate();
        	//String insertTableSQL = "DELETE FROM utente WHERE id=" + id ;
            if (preparedStatement.executeUpdate() != 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return false;
    }
    
    
    /* Prende tutte le informazioni dell'utente */
    public Utente GetUtente(String username) throws SQLException {

        String nome = "", password = "", cognome = "", email = "", mansione = "", titolo_di_studi = "", residenza = "", professione = "";
        java.sql.Date data = null;
        

        int id = 0;

        // DB Connection
        Connection dbConnection = model.connectionDataBase.ConnectionDB.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT * \n" + "FROM   `utente` \n" + "WHERE  username = ? ");

        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
        	id = rs.getInt("id");
        	password = rs.getString("password");
            nome = rs.getString("nome");
            cognome = rs.getString("cognome");
            email = rs.getString("email");
            data = rs.getDate("data_di_nascita");
            mansione = rs.getString("mansione");
            titolo_di_studi = rs.getString("titolo_di_studi");
            professione = rs.getString("professione");
            residenza = rs.getString("residenza");
            
            /*
            System.out.println(nome);
            System.out.println(id);
            System.out.println(cognome);*/
        }
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String textDate = df.format(data);
        java.sql.Date DataFinale = null;

        try {
            DataFinale = Component.stringToDate(textDate);

        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
        }

        return new Utente(id, username, password, nome, cognome, email, mansione, data, titolo_di_studi, residenza, professione);
    }
    
    /* Edit login info */
    public boolean SetUtente(Utente utente, String password) throws SQLException {

        
    	String nome = utente.getNome();
    	String cognome = utente.getCognome();
    	String email = utente.getEmail();
    	String username = utente.getUsername();
    	String residenza = utente.getResidenza();
    	String professione = utente.getProfessione();
    	String studi = utente.getTitoloDiStudi();
        


        // DB Connection
        Connection dbConnection = model.connectionDataBase.ConnectionDB.Connect();
        
        // Query
        String approveReview = "UPDATE utente SET nome = ?, cognome = ?, email = ?, username = ?, residenza = ?, professione = ?, titolo_di_studi = ?, password = ?"+ "WHERE id = ?";

        //System.out.println("!UI");
        PreparedStatement preparedStatement = null;

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(approveReview);

            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, cognome);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, residenza);
            preparedStatement.setString(6, professione);
            preparedStatement.setString(7, studi);
            preparedStatement.setString(8, password);
            preparedStatement.setInt(9, utente.getId());
            


            // Insert SQL statement
            /* executeUpdate returns either the row count for SQL Data Manipulation Language (DML) statements or
            0 for SQL statements that return nothing
            */
            if (preparedStatement.executeUpdate() != 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return false;

    }
    
    /* Modifica Ruolo */
    public boolean setRuolo(String username, String ruolo) throws SQLException {

        Connection dbConnection = model.connectionDataBase.ConnectionDB.Connect();

        String approveReview = "UPDATE `utente` SET `mansione` = ? WHERE `username` = ?";
        PreparedStatement preparedStatement = null;

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(approveReview);

            preparedStatement.setString(1, ruolo);
            preparedStatement.setString(2, username);

        
            if (preparedStatement.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Effettuato!");
                return true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return false;
    }
    
    public boolean setTrascrittore(String username) throws SQLException {

        Connection dbConnection = model.connectionDataBase.ConnectionDB.Connect();
        int livello = 1;
        int cod = 0;
        
        /* recuepra id utente */
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT id \n" + "FROM   `utente` \n" + "WHERE  username = ? ");
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
        	cod = rs.getInt("id");
        }
        
        System.out.println(cod);
        /* inserisce intrascrittori */
        String approveReview = "INSERT INTO trascrittore (cod_trascrittore, livello) VALUES (?,?)";
        PreparedStatement preparedStatement = null;

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(approveReview);

            preparedStatement.setInt(1, cod);
            preparedStatement.setInt(2, livello);
            
            if (preparedStatement.executeUpdate() != 0) {
                return true;
            }

        

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        } finally {
            if (stmt != null) { //Ric
                stmt.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        
        return false;
       
    }
    
    public boolean updateLivello(String username, int livello) throws SQLException {

        Connection dbConnection = model.connectionDataBase.ConnectionDB.Connect();
        int cod = 0;
        
        /* recuepra id utente */
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT id \n" + "FROM   `utente` \n" + "WHERE  username = ? ");
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
        	cod = rs.getInt("id");
        }
        
        
        /* inserisce intrascrittori */
        String approveReview = "UPDATE trascrittore SET livello = ? WHERE cod_trascrittore = ?";
        PreparedStatement preparedStatement = null;

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(approveReview);

            preparedStatement.setInt(1, livello);
            preparedStatement.setInt(2, cod);
            
            if (preparedStatement.executeUpdate() != 0) {
                return true;
            }

        

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        } finally {
            if (stmt != null) { //Ric
                stmt.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return false;
       
    }
    
    
    public int lvTras (int cod) throws SQLException {
        int n = 0;
    	// DB Connection
        Connection dbConnection = model.connectionDataBase.ConnectionDB.Connect();
        
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT livello \n" + "FROM   `trascrittore` \n" + "WHERE  cod_trascrittore = ? ");
        stmt.setInt(1, cod);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
        	n = rs.getInt("livello");
        }

        if (stmt != null) { //Ric
            stmt.close();
        }
        
        
        return n;

    }


}
