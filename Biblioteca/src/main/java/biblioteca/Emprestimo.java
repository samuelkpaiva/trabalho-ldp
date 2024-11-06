package biblioteca;

public class Emprestimo {
    private Livros livro;
    private String dataEmprestimo;

    public Livros getLivro() {
        return livro;
    }
    public Emprestimo(Livros livro, String dataEmprestimo) {
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        
        // Realiza o empréstimo, caso tenha exemplares disponíveis
        if (!livro.emprestarExemplar()) {
            System.out.println("Empréstimo não realizado. Sem exemplares disponíveis.");
        } else {
            System.out.println("Empréstimo realizado com sucesso!");
        }
    }

    public void devolver() {
        livro.devolverExemplar();
        System.out.println("Livro devolvido com sucesso!");
    }
}

