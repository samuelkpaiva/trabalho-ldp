package biblioteca;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Salvamentos {
    public static void salvarDadosEmArquivo(Cliente[] clientes, Livros[] livros, Emprestimo[] emprestimos) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("biblioteca.txt"))) {
            // Escrever informações dos clientes
            writer.println("Clientes Cadastrados:");
            for (Cliente cliente : clientes) {
                if (cliente != null) {
                    writer.println("ID: " + cliente.getID() + ", Nome: " + cliente.getNome() + ", Email: " + cliente.getEmail());
                }
            }

            // Escrever informações dos livros
            writer.println();  // Linha em branco entre clientes e livros
            writer.println("Livros Cadastrados:");
            for (Livros livro : livros) {
                if (livro != null) {
                    writer.println("Título: " + livro.gettitulo() + ", Autor: " + livro.getautores() + ", Ano: " + livro.getanoPublicacao() + ", Exemplares: " + livro.getnumExemplares());
                }
            }

            // Escrever informações dos empréstimos
            writer.println();  // Linha em branco entre livros e empréstimos
            writer.println("Empréstimos Realizados:");
            for (Emprestimo emprestimo : emprestimos) {
                if (emprestimo != null) {
                    writer.println("Livro: " + emprestimo.getLivro().gettitulo() + ", Data: " + emprestimo.getDataEmprestimo());
                }
            }

            System.out.println("Dados salvos no arquivo biblioteca.txt");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados em arquivo: " + e.getMessage());
        }
    }
}