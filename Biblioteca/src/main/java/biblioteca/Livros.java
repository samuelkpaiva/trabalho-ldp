package biblioteca;

public class Livros {
  private String titulo;
   private String autores;
   private String anoPublicacao;
   private int numExemplares;
   
    public Livros(String titulo,String autores,String anoPublicacao,int numExemplares){
        this.titulo = titulo;
        this.autores = autores;
        this.anoPublicacao = anoPublicacao;
        this.numExemplares = numExemplares;
    } 
    public String gettitulo(){
    return this.titulo;
    }
    public String getautores(){
    return this.autores;
    }
    public String getanoPublicacao(){
    return this.anoPublicacao;
    }
    public int getnumExemplares(){
    return this.numExemplares;
    }
    public void settitulo(String titulo){
    this.titulo = titulo;
    }
    public void setautores(String autores){
    this.autores = autores;
    }
    public void setanoPublicacao(){
    this.anoPublicacao = anoPublicacao;
    }
    public void setnumExemplares(){
    this.numExemplares = numExemplares;
    }
}
