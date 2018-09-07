package common;

import Biblioteca.BibliotecaDigitale;
import Biblioteca.ModificaRuolo;
import Biblioteca.ModuloAggiungiCategoria;
import Biblioteca.ModuloAggiungiOpera;
import Biblioteca.ModuloAggiungiPagina;
import Biblioteca.ModuloAggiungiTrascrizione;
import Biblioteca.ModuloElencoPagine;
import Biblioteca.ModuloListaOpere;
import Biblioteca.ModuloListaOperePerCategoria;
import Biblioteca.ModuloListaUtenti;
import Biblioteca.ModuloLoggato;
import Biblioteca.ModuloModificaProfilo;
import Biblioteca.ModuloProfilo;
import Biblioteca.ModuloRegistrazione;
import Biblioteca.ModuloRicercaCategoria;
import Biblioteca.ModuloVisualizzaPaginaOpera;
import Biblioteca.ModuloLivello;
import Biblioteca.ModuloAssegnaTrascrizione;
import Biblioteca.OpzioniPagina;
import Biblioteca.TipoRicerca;
import common.vo.Opera;
import common.vo.Utente;

public class ChangePage {
    
	public static void changePage(String page, Utente utente) {
        switch (page) {
        	/* pagina Iniziale */
        	case "BibliotecaDigitale":
				BibliotecaDigitale BD = new BibliotecaDigitale();
				BD.LoginPage();
        	break;
        	
        	/* Modulo Loggato */
        	case "ModuloLoggato":
				ModuloLoggato Log = new ModuloLoggato(utente);
				Log.Loggato(utente);
        	break;
        	
        	
        	/* Modulo Logout */
        	case "Logout":
				BibliotecaDigitale BDD = new BibliotecaDigitale();
				BDD.LoginPage();
        	break;
        	
        	case "Profilo":
				ModuloProfilo MP = new ModuloProfilo(utente);
				MP.Profilo(utente);;
			break;
			
        	case "ListaUtenti":
				ModuloListaUtenti MLU = new ModuloListaUtenti(utente, 0);
				MLU.ListaUtenti(utente, 0);
			break;
			
        	case "TipoRicerca":
				TipoRicerca TR = new TipoRicerca(utente);
				TR.Ricerca(utente);
			break;
			
        	case "ModificaProfilo":
				ModuloModificaProfilo MM = new ModuloModificaProfilo(utente);
				MM.Modifica(utente);
        	break;
        	
        	case "Menu":
				ModuloLoggato ML = new ModuloLoggato(utente);
				ML.Loggato(utente);
        	break;
        	
        	case "Categoria":
				ModuloRicercaCategoria MRC = new ModuloRicercaCategoria(utente, 0);
				MRC.RicercaCategoria(utente, 0);
        	break;
        	
        	case "TutteLeOpere":
				ModuloListaOpere MLO = new ModuloListaOpere(utente, 0);
				MLO.ElencoOpere(utente, 0);
        	break;
        	
        	case "AggiungiOpera":
				ModuloAggiungiOpera MAO = new ModuloAggiungiOpera(utente);
				MAO.AggiungiOpera(utente);
			break;
			
        	case "AggiungiCategoria":
        		ModuloAggiungiCategoria MAC = new ModuloAggiungiCategoria(utente);
				MAC.AggiungiCategoria(utente);
			break;
        }
        
        
    }
	
	public static void changePage1(String page, Utente utente, Opera opera, int n) {
        switch (page) {
    	case "ElencoPagine":
    		ModuloElencoPagine MEP = new ModuloElencoPagine(utente, opera,0);
			MEP.ElencoPagine(utente, opera, 0);
    	break;
    	
    	case "Elenco":
    		ModuloListaOpere MLO = new ModuloListaOpere(utente, n);
			MLO.ElencoOpere(utente, n);
    	break;
    	
    	case "AggiungiPagina":
    		ModuloAggiungiPagina OP = new ModuloAggiungiPagina(utente, opera);
			OP.InserimentoPagina(utente, opera);
    	break;
    	
    	case "Opzioni":
    		OpzioniPagina MV = new OpzioniPagina(utente, opera, n);
			MV.Opzioni(utente, opera, n);
    	break;
    	
    	case "VisualizzaPagina":
    		ModuloVisualizzaPaginaOpera MVV = new ModuloVisualizzaPaginaOpera(utente, opera, n);
			MVV.VisualizzaPagina(utente, opera, n);
    	break;
    	
    	case "AggiugniTrascrizione":
    		ModuloAggiungiTrascrizione MVCC = new ModuloAggiungiTrascrizione(utente, opera, n);
    		MVCC.AggiungiTrascrizione(utente, opera, n);
    	break;
    	
    	case "setTrascrittore":
    		ModuloAssegnaTrascrizione MAT = new ModuloAssegnaTrascrizione(utente, opera, n);
    		MAT.trascrizione(utente, opera, n);
    	break;
    	
        }
	}
	
	public static void Registrazione() {
        
		ModuloRegistrazione Reg = new ModuloRegistrazione();
	    Reg.Registrazione();
    }
	
	public static void Login() {
        BibliotecaDigitale BD = new BibliotecaDigitale();
        BD.LoginPage();
	}
	
	public static void ChangeRuolo(String s, Utente OldUtente) {
		ModificaRuolo MR = new ModificaRuolo(s, OldUtente);
		MR.Ruolo(s, OldUtente);
	}
	
	public static void LvPage(Utente u, String username, int n) {
		ModuloLivello ml = new ModuloLivello(u , n, username);
		ml.Livello(u, n, username);
	}
	
	public static void ListaUtenti(Utente u, int n) {
		ModuloListaUtenti MLU = new ModuloListaUtenti(u, n);
		MLU.ListaUtenti(u, n);
	}
	
	public static void cat(Utente u, int n) {
		ModuloRicercaCategoria MRC = new ModuloRicercaCategoria(u, n);
		MRC.RicercaCategoria(u, n);
	}
	
	
	
	public static void OperePerCat(String s, Utente utente, int n) {
		ModuloListaOperePerCategoria ML = new ModuloListaOperePerCategoria(utente, n, s);
		ML.OperePerCategoria(utente, 0, s);
	}
}
