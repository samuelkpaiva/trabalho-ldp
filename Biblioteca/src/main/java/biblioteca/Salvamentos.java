package biblioteca;

import java.io.FileWriter; // escreve dados para salvar em arquivo de texto
import java.io.IOException; // trata erros de entrada e saida
import java.io.PrintWriter; // permite escrever texto de forma formatada em arquivos

public class Salvamentos {
    public static void salvarDados(Cliente[] clientes, Livros[] livros, Emprestimo[] emprestimos) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("biblioteca.txt"))) {
            writer.println("Clientes Cadastrados:");
            for (Cliente cliente : clientes) { // percorre o cliente e o que for diferente de vazio ele escreve no arquivo
                if (cliente != null) {
                    writer.println("ID: " + cliente.getID() + ", Nome: " + cliente.getNome() + ", Email: " + cliente.getEmail());
                }
            }

            writer.println();  
            writer.println("Livros Cadastrados:");
            for (Livros livro : livros) { // percorre o livro e o que for diferente de vazio ele escreve no arquivo
                if (livro != null) {
                    writer.println("Título: " + livro.titulo + ", Autor: " + livro.autores + ", Ano: " + livro.anoPublicacao + ", Exemplares: " + livro.getnumExemplares());
                }
            }

            writer.println();  
            writer.println("Empréstimos Ativos:");
            for (Emprestimo emprestimo : emprestimos) { //percorre os emprestimos e o que for diferente de vazio eke escreve no arquivo
                if (emprestimo != null) {
                    writer.println("Livro: " + emprestimo.getLivro().titulo + ", Cliente: " + emprestimo.getCliente().getNome() + ", Data: " + emprestimo.getDataEmprestimo());
                }
            }

            System.out.println("Dados salvos no arquivo biblioteca.txt");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados" + e.getMessage());
        }
    }
}
