package controller.interfaces;

import java.io.File;
import java.sql.SQLException;

import javax.swing.table.TableModel;

import controller.componenti.Opera;

public interface InterfaceOpera {
	
	/* Lista Categorie */
	public TableModel GetCategorie () throws SQLException;
	
	/* Lista Opere per Categorie */
	public TableModel GetOperePerCategoria (String Categoria) throws SQLException;
	
	/* Lista Opere */
	public TableModel GetOpere () throws SQLException;
	
	/* Iserimento Categoria */
	 public boolean NewCategoria(String categoria) throws SQLException;
	
	/* Inserimento Opera */
	 public boolean NewOpera(String nome, String autore, int anno, String categoria) throws SQLException;
	 
	/* Lista pagine opere */
	public TableModel GetPagineOpera (int cod, String Opera) throws SQLException;
	
	/* Ritorno immagine dal DB */
	public boolean GetImgPagina(int cod, String filePathName) throws SQLException;
	
	/* Inserisce immagine dal DB */
	public boolean SetImgPagina (int Cod, File imgfile, int numero_pagina);
	
	/* inizializza opera */
	public Opera  GetOpera(int cod) throws SQLException;
	
	/* Inserimento Trascrizione */
    public boolean UpdateTrascrizione(String trascrizione, int cod) throws SQLException;
    
    /* Delete Opera */
    public boolean DeleteOpera(int cod) throws SQLException;
	

}
