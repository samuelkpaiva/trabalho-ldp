package biblioteca;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente[] clientes = new Cliente[3];
        Livros[] livros = new Livros[3];
        Emprestimo[] emprestimos = new Emprestimo[3];
        int contadorLivro = 0, contadorCliente = 0, contadorEmprestimo = 0;

        int opcao;
        do {
            System.out.println("Selecione uma opção");
            System.out.println("1 - Cadastrar Livro"
                    + "\n" + "2 - Cadastrar Cliente"
                    + "\n" + "3 - Realizar Empréstimo"
                    + "\n" + "4 - Realizar Devolução"
                    + "\n" + "5 - Verificar clientes, livros ou empréstimos cadastrados"
                    + "\n" + "6 - Salvar e Sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1: { // Cadastrar Livro
                    if (contadorLivro < livros.length) {
                        System.out.println("Informe o título do livro:");
                        String titulo = scanner.nextLine();

                        System.out.println("Informe os autores do livro:");
                        String autores = scanner.nextLine();

                        System.out.println("Informe o ano de publicação do livro:");
                        String anoPublicacao = scanner.nextLine();

                        System.out.println("Informe o número de exemplares do livro:");
                        int numExemplares = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer

                        livros[contadorLivro] = new Livros(titulo, autores, anoPublicacao, numExemplares);
                        contadorLivro++;
                    } else {
                        System.out.println("Limite de livros atingido.");
                        System.out.println("Deseja apagar algum livro? S ou N");
                        String resposta = scanner.nextLine();
                        if (resposta.equalsIgnoreCase("S")) {
                            Livros.listarLivros(livros);
                            System.out.println("Digite o nome do livro que deseja remover:");
                            String nomeParaRemover = scanner.nextLine();
                            if (Livros.removerLivro(livros, nomeParaRemover)) {
                                contadorLivro--;
                            }
                        }
                    }
                    break;
                }
                case 2: { // Cadastrar Cliente
                    if (contadorCliente < clientes.length) {
                        System.out.println("Informe o nome do cliente:");
                        String nome = scanner.nextLine();

                        System.out.println("Informe o email do cliente:");
                        String email = scanner.nextLine();

                        int id = contadorCliente + 1;
                        clientes[contadorCliente] = new Cliente(nome, email, id);
                        contadorCliente++;
                    } else {
                        System.out.println("Limite de clientes atingido.");
                        System.out.println("Deseja apagar algum cliente? S ou N");
                        String resposta = scanner.nextLine();
                        if (resposta.equalsIgnoreCase("S")) {
                            Cliente.listarClientes(clientes);
                            System.out.println("Digite o ID do cliente que deseja remover:");
                            int idParaRemover = scanner.nextInt();
                            scanner.nextLine(); // Limpar o buffer
                            if (Cliente.removerCliente(clientes, idParaRemover)) {
                                contadorCliente--;
                                System.out.println("Cliente removido com sucesso.");
                            } else {
                                System.out.println("ID inválido ou cliente não encontrado.");
                            }
                        }
                    }
                    break;
                }
                case 3: { // Realizar Empréstimo
                    if (contadorEmprestimo < emprestimos.length) {
                        System.out.println("Informe o ID do cliente:");
                        int clienteId = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer

                        if (clienteId > 0 && clienteId <= clientes.length && clientes[clienteId - 1] != null) {
                            Cliente cliente = clientes[clienteId - 1];

                            System.out.println("Informe o título do livro:");
                            String tituloLivro = scanner.nextLine();

                            Livros livro = null;
                            // Procurar o livro pelo título
                            for (Livros l : livros) {
                                if (l != null && l.gettitulo().equalsIgnoreCase(tituloLivro)) {
                                    livro = l;
                                    break;
                                }
                            }

                            if (livro != null) {
                                // Verificar se há exemplares disponíveis antes de criar o empréstimo
                                if (livro.emprestarExemplar()) {
                                    emprestimos[contadorEmprestimo] = new Emprestimo(livro, "Data do Empréstimo");
                                    contadorEmprestimo++;
                                    System.out.println("Empréstimo realizado com sucesso!");
                                } else {
                                    System.out.println("Não há exemplares disponíveis para empréstimo.");
                                }
                            } else {
                                System.out.println("Livro com o título informado não encontrado.");
                            }
                        } else {
                            System.out.println("ID de cliente inválido.");
                        }
                    } else {
                        System.out.println("Limite de empréstimos atingido.");
                    }
                    break;
                }
                case 4: { // Realizar Devolução
                    System.out.println("Informe o título do livro para devolução:");
                    String tituloLivro = scanner.nextLine();

                    Livros livro = null;
                    // Procurar o livro pelo título
                    for (Livros l : livros) {
                        if (l != null && l.gettitulo().equalsIgnoreCase(tituloLivro)) {
                            livro = l;
                            break;
                        }
                    }

                    if (livro != null) {
                        // Devolvendo o livro e aumentando o número de exemplares
                        livro.devolverExemplar();  // Aumenta o número de exemplares
                        System.out.println("Livro devolvido com sucesso!");

                        // Remover o empréstimo correspondente
                        boolean emprestimoRemovido = false;
                        for (int i = 0; i < emprestimos.length; i++) {
                            if (emprestimos[i] != null && emprestimos[i].getLivro().gettitulo().equalsIgnoreCase(tituloLivro)) {
                                emprestimos[i] = null; // Remover o empréstimo
                                emprestimoRemovido = true;
                                contadorEmprestimo --;
                                break;
                            }
                        }

                        if (emprestimoRemovido) {
                            System.out.println("Empréstimo removido com sucesso!");
                        } else {
                            System.out.println("Empréstimo não encontrado.");
                        }

                    } else {
                        System.out.println("Livro com o título informado não encontrado.");
                    }
                    break;
                }

                case 5: { // Verificação
                    System.out.println("Digite " + "\n"
                            + "1 para visualizar clientes cadastrados" + "\n"
                            + "2 para visualizar livros cadastrados" + "\n"
                            + "3 para visualizar empréstimos cadastrados");
                    int opcVizu = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    if (opcVizu == 1) {
                        Cliente.listarClientes(clientes);
                    } else if (opcVizu == 2) {
                        Livros.listarLivros(livros);
                    } else if (opcVizu == 3) {
                        Emprestimo.listarEmprestimos(emprestimos);
                    }
                    break;
                }
                case 6: {
                    // Salvar dados no arquivo e sair
                    Salvamentos.salvarDadosEmArquivo(clientes, livros, emprestimos);
                    System.out.println("Saindo...");
                    break;
                }
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 6);
        scanner.close(); // Fechar o scanner
    }
}