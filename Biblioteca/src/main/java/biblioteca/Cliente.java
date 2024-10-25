package biblioteca;

public class Cliente {

    private String nome;
    private String email;
    private int id;

    public Cliente(String nome, String email, int id) {
        this.nome = nome;
        this.email = email;
        this.id = id;

    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public int getID(){
        return id;
    }
    
    public void getID(int id){
        this.id = id;
    }
}
