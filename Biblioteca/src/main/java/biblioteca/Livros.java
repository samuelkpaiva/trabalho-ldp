package biblioteca;

public class Livros {
    public String titulo;
    public String autores;
    public String anoPublicacao;
    private int numExemplares;

    public Livros(String titulo, String autores, String anoPublicacao, int numExemplares) {
        this.titulo = titulo;
        this.autores = autores;
        this.anoPublicacao = anoPublicacao;
        this.numExemplares = numExemplares;
    }

    public int getnumExemplares() {
        return this.numExemplares;
    }

    public void setnumExemplares(int numExemplares) {
        this.numExemplares = numExemplares;
    }
    // Metodo que percorre os livros e printa o que é diferente de vazio
    public static void listarLivros(Livros[] livros) {
        System.out.println("Livros cadastrados:");
        for (Livros livro : livros) {
            if (livro != null) {
                System.out.println(livro.titulo);
            }
        }
    }
    //Verifica se o vetor de livros está preenchido e o titulo do livro
    //Caso ele encontre, ele passa os livros para a posição anterior no vetor a partir do livro a ser excluído e coloca o último espaço como vazio pra cadastrar um novo livro
    public static boolean removerLivro(Livros[] livros, String tituloParaRemover) {
        for (int i = 0; i < livros.length; i++) {
            if (livros[i] != null && livros[i].titulo.equalsIgnoreCase(tituloParaRemover)) {
                for (int j = i; j < livros.length - 1; j++) {
                    livros[j] = livros[j + 1];
                }
                livros[livros.length - 1] = null; 
                System.out.println("Livro removido");
                return true;
            }
        }
        System.out.println("Livro não encontrado");
        return false;
    }
    //Metodo verifica se o numero de exemplares é maior que zero e subtrai um
    public boolean emprestarExemplar() {
        if (numExemplares > 0) {
            numExemplares--;
            return true;
        } else {
            return false;
        }
    }
    // Metodo devolver soma um ao numero deexemplares
    public void devolverExemplar() {
        numExemplares++;
    }
}