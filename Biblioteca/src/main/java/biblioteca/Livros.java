package biblioteca;


public class Livros {
    private String titulo;
    private String autores;
    private String anoPublicacao;
    private int numExemplares;

    public Livros(String titulo, String autores, String anoPublicacao, int numExemplares) {
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
    
     // Método para adicionar livro
    public static boolean adicionarLivro(Livros[] livros, String titulo, String autores, String anoPublicacao, int numExemplares) {
        for (int i = 0; i < livros.length; i++) {
            if (livros[i] == null) { // Encontrou um espaço vazio
                livros[i] = new Livros(titulo, autores, anoPublicacao, numExemplares);
                return true; // Livro adicionado com sucesso
            }
        }
        return false; // Sem espaço disponível
    }
   // Método para listar livros
    public static void listarLivros(Livros[] livros) {
        System.out.println("Livros cadastrados:");
        for (Livros livro : livros) {
            if (livro != null) {
                System.out.println(livro.gettitulo());
            }
        }
    }

    // Método para remover livro com ajuste na ordem dos livros no array
public static boolean removerLivro(Livros[] livros, String tituloParaRemover) {
    for (int i = 0; i < livros.length; i++) {
        if (livros[i] != null && livros[i].gettitulo().equalsIgnoreCase(tituloParaRemover)) {
            // Move todos os livros após o índice i uma posição para a esquerda
            for (int j = i; j < livros.length - 1; j++) {
                livros[j] = livros[j + 1];
            }
            livros[livros.length - 1] = null; // Define o último elemento como null
            System.out.println("Livro removido com sucesso.");
            return true;
        }
    }
    System.out.println("Livro não encontrado com esse título.");
    return false;
}


    public boolean emprestarExemplar(){
       if (numExemplares > 0) {
           numExemplares--;
            return true;
        } else {
           System.out.println("Não há exemplares disponíveis para empréstimo.");
           return false;
       }
    }
 
    public void devolverExemplar() {
        numExemplares++;
        
    }
}