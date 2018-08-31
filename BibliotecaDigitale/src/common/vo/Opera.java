package common.vo;

public class Opera {
	int cod, anno, cod_categoria;
	String nome, autore, categoria;
	
	
	/* costruttori */
	public Opera() {
		this.cod = 0;
		this.anno = 0;
		this.cod_categoria = 0;
		this.nome = "";
		this.autore = "";
		this.categoria = "";
	}
	
	public Opera(int cod, int anno, String nome, String autore) {
		this.cod = cod;
		this.anno = anno;
		this.cod_categoria = 0;
		this.nome = nome;
		this.autore = autore;
		this.categoria = "";
	}
	
	public Opera(int cod, int anno, int cod_categoria, String nome, String autore, String categoria) {
		this.cod = cod;
		this.anno = anno;
		this.cod_categoria = cod_categoria;
		this.nome = nome;
		this.autore = autore;
		this.categoria = categoria;
	}
	
	
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
    
    public int getAnno() {
        return cod;
    }

    public void setAnno(int Anno) {
        this.anno = Anno;
    }
    
    public int getCodCategoria() {
        return cod_categoria;
    }

    public void setCodCategoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }
    
    
    public String getNome() {
    	return nome;
    }
    
    public void setNome(String nome) {
    	this.nome = nome;
    }
    
    public String getAutore() {
    	return autore;
    }
    
    public void setAutore(String autore) {
    	this.autore = autore;
    }
    
    public String getCategoria() {
    	return categoria;
    }
    
    public void setCategoria(String Categoria) {
    	this.categoria = Categoria;
    }
	

}
