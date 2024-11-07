package biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente[] clientes = new Cliente[3];
        Livros[] livros = new Livros[3];
        Emprestimo[] emprestimos = new Emprestimo[3];
        int contadorLivro = 0, contadorCliente = 0, contadorEmprestimo = 0;
        int proximoID = 1;

        int opcao = 0;
        do {
            System.out.println("Selecione uma opção");
            System.out.println("1 - Cadastrar Livro"
                    + "\n" + "2 - Cadastrar Cliente"
                    + "\n" + "3 - Realizar Empréstimo"
                    + "\n" + "4 - Realizar Devolução"
                    + "\n" + "5 - Verificar clientes, livros ou empréstimos cadastrados"
                    + "\n" + "6 - Salvar e Sair");

            boolean entrada = false;
            while (!entrada) {
                try {
                    opcao = scanner.nextInt();
                    scanner.nextLine(); 
                    if (opcao < 1 || opcao > 6) {
                        System.out.println("Por favor, digite uma opção válida entre 1 e 6.");
                    } else {
                        entrada = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, digite um número entre 1 e 6.");
                    scanner.nextLine(); 
                }
            }

            switch (opcao) {
                case 1: {
                    if (contadorLivro < livros.length) {
                        System.out.println("Informe o título do livro:");
                        String titulo = scanner.nextLine();

                        System.out.println("Informe os autores do livro:");
                        String autores = scanner.nextLine();

                        System.out.println("Informe o ano de publicação do livro:");
                        String anoPublicacao = scanner.nextLine();

                        System.out.println("Informe o número de exemplares do livro:");
                        int numExemplares = scanner.nextInt();
                        scanner.nextLine();

                        livros[contadorLivro] = new Livros(titulo, autores, anoPublicacao, numExemplares);
                        contadorLivro++;
                    } else {
                        System.out.println("Limite de livros atingido.");
                        System.out.println("Deseja apagar algum livro? S ou N");
                        String resposta = scanner.nextLine();
                        if (resposta.equalsIgnoreCase("S")) {
                            Livros.listarLivros(livros);
                            System.out.println("Digite o título do livro que deseja remover:");
                            String tituloParaRemover = scanner.nextLine();
                            if (Livros.removerLivro(livros, tituloParaRemover)) {
                                contadorLivro--;
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    if (contadorCliente < clientes.length) {
                        System.out.println("Informe o nome do cliente:");
                        String nome = scanner.nextLine();

                        System.out.println("Informe o email do cliente:");
                        String email = scanner.nextLine();

                        clientes[contadorCliente] = new Cliente(nome, email, proximoID);
                        contadorCliente++;
                        proximoID++;
                    } else {
                        System.out.println("Limite de clientes atingido.");
                        System.out.println("Deseja apagar algum cliente? S ou N");
                        String resposta = scanner.nextLine();
                        if (resposta.equalsIgnoreCase("S")) {
                            Cliente.listarClientes(clientes);
                            System.out.println("Digite o ID do cliente que deseja remover:");
                            int idParaRemover = scanner.nextInt();
                            scanner.nextLine();
                            if (Cliente.removerCliente(clientes, idParaRemover)) {
                                contadorCliente--;
                                System.out.println("Cliente removido");
                            } else {
                                System.out.println("Não foi encontrado um cliente com esses dados.");
                            }
                        }
                    }
                    break;
                }
                case 3: {
                    if (contadorEmprestimo < emprestimos.length) {
                        System.out.println("Informe o ID do cliente:");
                        int clienteId = scanner.nextInt();
                        scanner.nextLine();

                        if (clienteId > 0 && clienteId <= clientes.length && clientes[clienteId - 1] != null) {
                            Cliente cliente = clientes[clienteId - 1];

                            System.out.println("Informe o título do livro:");
                            String tituloLivro = scanner.nextLine();

                            Livros livro = null;
                            for (Livros l : livros) {
                                if (l != null && l.titulo.equalsIgnoreCase(tituloLivro)) {
                                    livro = l;
                                    break;
                                }
                            }

                            if (livro != null) {
                                if (livro.emprestarExemplar()) {
                                    emprestimos[contadorEmprestimo] = new Emprestimo(livro, "Data do Empréstimo");
                                    contadorEmprestimo++;
                                    System.out.println("Empréstimo realizado");
                                } else {
                                    System.out.println("Não há exemplares disponíveis para empréstimo.");
                                }
                            } else {
                                System.out.println("Livro não encontrado.");
                            }
                        } else {
                            System.out.println("ID de cliente não encontrado.");
                        }
                    } else {
                        System.out.println("Limite de empréstimos atingido.");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Informe o título do livro para devolução:");
                    String tituloLivro = scanner.nextLine();

                    Livros livro = null;
                    for (Livros l : livros) {
                        if (l != null && l.titulo.equalsIgnoreCase(tituloLivro)) {
                            livro = l;
                            break;
                        }
                    }

                    if (livro != null) {
                        livro.devolverExemplar();
                        System.out.println("Livro devolvido");

                        boolean emprestimoRemovido = false;
                        for (int i = 0; i < emprestimos.length; i++) {
                            if (emprestimos[i] != null && emprestimos[i].getLivro().titulo.equalsIgnoreCase(tituloLivro)) {
                                emprestimos[i] = null;
                                emprestimoRemovido = true;
                                contadorEmprestimo--;
                                break;
                            }
                        }

                        if (emprestimoRemovido) {
                            System.out.println("Empréstimo removido");
                        } else {
                            System.out.println("Empréstimo não encontrado");
                        }
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Digite " + "\n"
                            + "1 para visualizar clientes cadastrados" + "\n"
                            + "2 para visualizar livros cadastrados" + "\n"
                            + "3 para visualizar empréstimos cadastrados");
                    int opcVizu = scanner.nextInt();
                    scanner.nextLine();

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
                    Salvamentos.salvarDadosEmArquivo(clientes, livros, emprestimos);
                    break;
                }
            }
        } while (opcao != 6);

        scanner.close();
    }
}