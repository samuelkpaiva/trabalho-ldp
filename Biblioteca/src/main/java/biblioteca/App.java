package biblioteca;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente[] clientes = new Cliente[3];
        Livros[] livros = new Livros[3];
        String[] emprestimos = new String[3]; // Array para armazenar os empréstimos
        int  contadorLivro = 0, contadorCliente = 0, contadorEmprestimo = 0;

        int opcao;
        do {
            System.out.println("Selecione uma opção");
            System.out.println("1 - Cadastrar Livro" 
                    + "\n" + "2 - Cadastrar Cliente" 
                    + "\n" + "3 - Realizar empréstimo ou devolução" 
                    + "\n" + "4 - Verificar clientes, livros ou empréstimos cadastrados"
                    + "\n" + "5 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

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
                        scanner.nextLine(); // Limpar o buffer

                        livros[contadorLivro] = new Livros(titulo, autores, anoPublicacao, numExemplares);
                        contadorLivro++;
                    } else {
                        System.out.println("Limite de livros atingido.");
                        System.out.println("Deseja apagar algum livro? S ou N");
                        String resposta = scanner.nextLine();
                        if (resposta.equalsIgnoreCase("S")) {
                            Livros.listarLivros(livros);
                            System.out.println("Digite o ID do livro que deseja remover:");
                            int idParaRemover = scanner.nextInt();
                            scanner.nextLine(); // Limpar o buffer
                            Livros.removerLivro(livros, contadorLivro);
                            contadorLivro--;
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

                        // Gerando um ID simples
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
                            Cliente.removerCliente(clientes,contadorCliente);
                            contadorCliente--;
                        }
                    }
                    break;
                }
                
                case 3: {
                    if (contadorEmprestimo < emprestimos.length) {
                        System.out.println("Digite " + "\n" 
                                + "1 para empréstimo" + "\n" 
                                + "2 para devolução");
                        int empDev = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer

                        if (empDev == 1) {
                            System.out.println("Informe a data de empréstimo:");
                            String dataEmprestimo = scanner.nextLine();

                            System.out.println("Informe o nome do livro:");
                            String nomeLivro = scanner.nextLine();

                            emprestimos[contadorEmprestimo] = "Empréstimo de " + nomeLivro + " em " + dataEmprestimo;
                            contadorEmprestimo++;
                        } else {
                            System.out.println("Informe o código do livro:");
                            int codigoLivro = scanner.nextInt();
                        }
                    } else {
                        System.out.println("Limite de empréstimos atingido.");
                    }
                    break;
                }
                case 4: {
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
                        for (String emprestimo : emprestimos) {
                            if (emprestimo != null) {
                                System.out.println(emprestimo);
                            }
                        }
                    }
                    break;
                }
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);
        scanner.close(); // Fechar o scanner
    }
}