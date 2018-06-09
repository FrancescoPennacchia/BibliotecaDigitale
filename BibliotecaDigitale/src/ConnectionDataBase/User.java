package ConnectionDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import Componenti.Component;
import Interfaces.InterfaceUser;
import net.proteanit.sql.DbUtils;
import Componenti.Utente;
import Exception.Exception;


public class User implements InterfaceUser {
	
    /* Get a id */
    public int GetUserID(String user) throws SQLException {

    	
        // User id that will be returned
        int id = 0;

        // DB Connection
        Connection dbConnection = ConnectionDataBase.ConnectionDB.Connect();


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
        Connection dbConnection = ConnectionDataBase.ConnectionDB.Connect();

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
        Connection conn = ConnectionDataBase.ConnectionDB.Connect();
        
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM utente WHERE id = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String hashedPass = rs.getString("password");

                //Check if the provided password and the hashed one are equal
                if (ConnectionDataBase.ConnectionDB.checkPassword(password, hashedPass))
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
        Connection dbConnection = ConnectionDataBase.ConnectionDB.Connect();

        // Password hashing
        password = ConnectionDataBase.ConnectionDB.hashPassword(password);

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
        Connection dbConnection = ConnectionDataBase.ConnectionDB.Connect();
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
        Connection dbConnection = ConnectionDataBase.ConnectionDB.Connect();

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
        Connection dbConnection = ConnectionDataBase.ConnectionDB.Connect();
        
        // Query
        String approveReview = "UPDATE utente \n" + "SET nome = ?" + " cognome = ?" + "email = ? " + "username = ? " + "residenza = ?" + "professione = ?" + "titolo_di_studi = ?" + "professione = ?"+ "professione = ?" + "id = ?"+ "WHERE id = ?";

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
            preparedStatement.setString(8, professione);
            preparedStatement.setString(9, password);
            preparedStatement.setInt(10, utente.getId());
            


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

        Connection dbConnection = ConnectionDataBase.ConnectionDB.Connect();

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


}
