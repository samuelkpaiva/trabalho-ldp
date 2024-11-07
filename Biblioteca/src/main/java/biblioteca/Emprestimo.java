package biblioteca;

public class Emprestimo {
    private Livros livro;
    private String dataEmprestimo;

    public Livros getLivro() {
        return livro;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Emprestimo(Livros livro, String dataEmprestimo) {
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
    }

    public static void listarEmprestimos(Emprestimo[] emprestimos) {
        System.out.println("Empréstimos realizados:");
        boolean encontrouEmprestimos = false;
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo != null) {
                System.out.println("Livro: " + emprestimo.getLivro().titulo + " - Data do Empréstimo: " + emprestimo.getDataEmprestimo());
                encontrouEmprestimos = true;
            }
        }

        if (!encontrouEmprestimos) {
            System.out.println("Nenhum empréstimo realizado.");
        }
    }

    public void devolver() {
        livro.devolverExemplar();
        System.out.println("Livro devolvido com sucesso!");
    }
}