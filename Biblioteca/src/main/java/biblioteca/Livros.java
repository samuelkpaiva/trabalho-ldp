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

    public static boolean adicionarLivro(Livros[] livros, String titulo, String autores, String anoPublicacao, int numExemplares) {
        for (int i = 0; i < livros.length; i++) {
            if (livros[i] == null) { 
                livros[i] = new Livros(titulo, autores, anoPublicacao, numExemplares);
                return true; 
            }
        }
        return false;
    }

    public static void listarLivros(Livros[] livros) {
        System.out.println("Livros cadastrados:");
        for (Livros livro : livros) {
            if (livro != null) {
                System.out.println(livro.titulo);
            }
        }
    }

    public static boolean removerLivro(Livros[] livros, String tituloParaRemover) {
        for (int i = 0; i < livros.length; i++) {
            if (livros[i] != null && livros[i].titulo.equalsIgnoreCase(tituloParaRemover)) {
                for (int j = i; j < livros.length - 1; j++) {
                    livros[j] = livros[j + 1];
                }
                livros[livros.length - 1] = null; 
                System.out.println("Livro removido com sucesso.");
                return true;
            }
        }
        System.out.println("Livro não encontrado com esse título.");
        return false;
    }

    public boolean emprestarExemplar() {
        if (numExemplares > 0) {
            numExemplares--;
            return true;
        } else {
            return false;
        }
    }

    public void devolverExemplar() {
        numExemplares++;
    }
}