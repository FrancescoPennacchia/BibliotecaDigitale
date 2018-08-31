package common.vo;

import java.sql.Date;

public class Utente {
    int id;
    String username, nome, cognome, password, email, mansione, titolo_di_studi, residenza, professione;
    Date data;

    public Utente() {
    	
    	this.id = 0;
        this.username = "";
        this.password = "";
        this.nome = "";
        this.cognome = "";
        this.email = "";
        this.mansione = "";
        this.data = null;
        this.titolo_di_studi = "";
        this.residenza = "";
        this.professione = "";
        
    }

    public Utente(int id, String username, String password, String nome, String cognome, String email, String mansione, Date data, String titolo_di_studi, String residenza, String professione) {
    	
    	this.id = id;
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.mansione = mansione;
        this.data = data;
        this.titolo_di_studi = titolo_di_studi;
        this.professione = professione;
        this.residenza = residenza;
        
    }

    public String getProfessione() {
        return professione;
    }

    public void setProfessione(String professione) {
        this.professione = professione;
    }
    
    public String getResidenza() {
        return residenza;
    }

    public void setResidenza(String residenza) {
        this.residenza = residenza;
    }
    
    public String getTitoloDiStudi() {
        return titolo_di_studi;
    }

    public void setTitoloDiStudi(String titolo_di_studi) {
        this.titolo_di_studi = titolo_di_studi;
    }
    
    public String getMansione() {
        return mansione;
    }

    public void setMansione(String mansione) {
        this.mansione = mansione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String user) {
        this.username = user;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getData() {
        return data;
    }
}