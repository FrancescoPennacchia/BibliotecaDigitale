package ConnectionDataBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Interfaces.InterfaceOpera;
import Componenti.Opera;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class ConnectionOpera implements InterfaceOpera {
	
	
	/* Get Opera */
	 public Opera  GetOpera(int cod) throws SQLException{
		 int codice_opera = 0; 
		 int anno = 0;
		 String nome = "" ;
		 String autore = "";
		 //String categoria = "";
		 
	     Connection dbConnection = ConnectionDataBase.ConnectionDB.Connect();
	     PreparedStatement stmt = dbConnection.prepareStatement("SELECT * " + "FROM `opera`" + "WHERE  cod = ? ");
	     
	     stmt.setInt(1, cod);
	     ResultSet rs = stmt.executeQuery();
	     
	        if (rs.next()) {
	        	codice_opera = rs.getInt("cod");
	        	autore = rs.getString("autore");
	            nome = rs.getString("nome");
	            //categoria = rs.getString("categoria");
	            anno = rs.getInt("anno");

	        }

	        

		 
		 return new Opera(codice_opera, anno, nome, autore);
	 }
	 
	/* Lista Categorie */
    public TableModel GetCategorie () throws SQLException {
        // DB Connection
        Connection dbConnection = ConnectionDataBase.ConnectionDB.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT * FROM categoria_opera ");

        ResultSet rs = stmt.executeQuery();
        TableModel tm = DbUtils.resultSetToTableModel(rs);
        dbConnection.close();

        return tm;
    }
    
	/* Lista Categorie */
    public TableModel GetOperePerCategoria (String Categoria) throws SQLException {
        // DB Connection
        Connection dbConnection = ConnectionDataBase.ConnectionDB.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT * FROM opera INNER JOIN categoria_opera ON opera.cod_categoria = categoria_opera.cod_categoria WHERE categoria_opera.categoria = ?");
        stmt.setString(1, Categoria);

        ResultSet rs = stmt.executeQuery();
        TableModel tm = DbUtils.resultSetToTableModel(rs);
        dbConnection.close();

        return tm;
    }
    
    
	/* Lista Opere */
	public TableModel GetOpere () throws SQLException {
		
        Connection dbConnection = ConnectionDataBase.ConnectionDB.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT * FROM opera");

        ResultSet rs = stmt.executeQuery();
        TableModel tm = DbUtils.resultSetToTableModel(rs);
        dbConnection.close();

        return tm;
		
	}
	
	/* Lista pagine opere */ //da controllare
	public TableModel GetPagineOpera (int cod, String Opera) throws SQLException {
		
        Connection dbConnection = ConnectionDataBase.ConnectionDB.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT * FROM pagine_opera INNER JOIN opera ON pagine_opera.cod_opera = opera.cod WHERE opera.cod = ? AND opera.nome = ?");
        stmt.setInt(1, cod);
        stmt.setString(2, Opera);
        
        ResultSet rs = stmt.executeQuery();
        TableModel tm = DbUtils.resultSetToTableModel(rs);
        dbConnection.close();

        return tm;
		
	}
	
	
	/* Nuova Categoria */
	public boolean NewCategoria(String categoria) throws SQLException {
        PreparedStatement preparedStatement = null;

        // DB Connection
        Connection dbConnection = ConnectionDataBase.ConnectionDB.Connect();
        
        String insertTableSQL = "INSERT INTO categoria_opera" + "(categoria) VALUES" + "(?)";

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, categoria);

            // Inserimento DB verificia il corretto inserimento
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


	public int getCodCategoria(String categoria) throws SQLException {
		PreparedStatement preparedStatement = null;
		int cod = 0;

		// DB Connection
		Connection dbConnection = ConnectionDataBase.ConnectionDB.Connect();
    
		String insertTableSQL = "SELECT * FROM `categoria_opera`" + "WHERE `categoria` = ?";
	  

    // Insert the values into the DB
		try {
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, categoria);
			ResultSet rs = preparedStatement.executeQuery();
			
			//System.out.println(preparedStatement.getMaxRows());
			
			/* nel caso in cui non trova nulla.. crea la categoria altrimenti prende il codice*/
			
			if (rs.next()) {
	        	cod = rs.getInt("cod_categoria");
	        }
			else {
				NewCategoria(categoria);
				}
			
			
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
	        	cod = rs.getInt("cod_categoria");			
			}
			
			}catch (SQLException ex) {
				System.out.println(ex.getMessage());

			} finally {
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (dbConnection != null) {
					dbConnection.close();
				}
			}
			
			return cod;
		
	}


	/* Nuova Categoria */ // aggiungere
	public boolean NewOpera(String nome, String autore, int anno, String categoria) throws SQLException {
		PreparedStatement preparedStatement = null;
		int cod = getCodCategoria(categoria);
		// DB Connection
		Connection dbConnection = ConnectionDataBase.ConnectionDB.Connect();
		String insertTableSQL = "INSERT INTO opera" + "(nome, anno, autore, cod_categoria) VALUES" + "(?,?,?,?)";
		
	 
    // Insert the values into the DB
		try {

			
			/* Inserimento */			
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);		
			preparedStatement.setString(1, nome);
			preparedStatement.setInt(2, anno);
			preparedStatement.setString(3, autore);
			preparedStatement.setInt(4, cod);
			
			
        // Inserimento DB verificia il corretto inserimento
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
	
    /* Inserimento Imagine pagina */
    public boolean SetImgPagina (int Cod, File imgfile, int numero_pagina){
        try {

           
            Connection connect  = ConnectionDataBase.ConnectionDB.Connect();

            FileInputStream fin  = new FileInputStream(imgfile);

         
            PreparedStatement pre = connect.prepareStatement("INSERT INTO pagine_opera" + "(immagine_pagina, cod_opera, numero_pagina) VALUES (?,?,?)");

            pre.setInt(2,Cod);
            pre.setInt(3, numero_pagina);

            pre.setBinaryStream(1,(InputStream)fin,(int)imgfile.length());
            pre.executeUpdate();

         
            pre.close();
            connect.close();

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    /* Ritorna l'immagine della pagina */
    public boolean GetImgPagina(int cod, String filePathName) throws SQLException {
        try {

            Connection con = ConnectionDataBase.ConnectionDB.Connect();

          
            PreparedStatement stmt = con.prepareStatement("SELECT `immagine_pagina` FROM `pagine_opera` WHERE cod_pagina = ?");

            stmt.setInt(1, cod);
            ResultSet rs = stmt.executeQuery();


            while (rs.next()) {
                InputStream in = rs.getBinaryStream(1);
                OutputStream f = new FileOutputStream(new File(filePathName));
            
                int n = 0;
                while ((n = in.read()) > -1) {
                    f.write(n);
                }
                f.close();
                in.close();

                return true;
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    
    public boolean UpdateTrascrizione(String trascrizione, int cod) throws SQLException {
        Connection dbConnection = ConnectionDataBase.ConnectionDB.Connect();

        String approveReview = "UPDATE `pagine_opera` SET `trascrizione` = ? WHERE `cod_pagina` = ?";
        PreparedStatement preparedStatement = null;

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(approveReview);

            preparedStatement.setString(1, trascrizione);
            preparedStatement.setInt(2, cod);

        
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
    
    public boolean DeleteOpera(int cod) throws SQLException {
   	 PreparedStatement preparedStatement = null;
   	// DB Connection
       Connection dbConnection = ConnectionDataBase.ConnectionDB.Connect();
       try {
       	preparedStatement = dbConnection.prepareStatement("DELETE FROM opera WHERE cod = ?");
       	preparedStatement.setInt(1, cod);
       	preparedStatement.executeUpdate();
       	
       	
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

}
