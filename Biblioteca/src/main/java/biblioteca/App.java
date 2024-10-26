package biblioteca;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Selecione uma opção");
        System.out.println("1 - Cadastrar Livro" + "\n" 
                + "2 - Cadastrar Cliente" 
                + "\n" + "3 - Realizar empréstimo ou devolução" 
                + "\n" + "4 - Verificar clientes, livros ou empréstimos cadastrados");
        int opcao = scanner.nextInt();
        
        do{
            switch(opcao){
                case 1:{
                    System.out.println("Informe o título do livro");
                    System.out.println("Informe os autores do livro");
                    System.out.println("Informe o ano de publicação do livro");

                    break;
                }  
                case 2: {
                    System.out.println("Informe o nome do cliente");
                    System.out.println("Informe o email do cliente");

                    break;
                }
                case 3: {
                    System.out.println("Digite " + "\n" 
                            + "1 para empréstimo" + "\n" 
                            + "2 para devolução");
                    int emp_dev = scanner.nextInt();

                    if(emp_dev == 1){
                        System.out.println("Informe a data de empréstimo");
                        System.out.println("Informe o nome do livro");
                    } else {
                        System.out.println("Informe o código do livro");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Digite " + "\n" 
                            + "1 para vizualizar clientes cadastrados" + "\n" 
                            + "2 para vizualizar livros cadastrados" + "\n" 
                            + "3 para vizualizar empréstimos cadastrados");
                    int opc_vizu = scanner.nextInt();

                    if(opc_vizu == 1){

                    } else if(opc_vizu == 2){

                    } else {

                    }
                    break;
                }
            }
        } while(opcao != 5);
    }
}
