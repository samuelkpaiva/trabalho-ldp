package biblioteca;

public class Cliente {

    private String nome;
    private String email;
    private int id;

    public Cliente(String nome, String email, int id) {
        this.nome = nome;
        this.email = email;
        this.id = id;

    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getID() {
        return id;
    }

    //Metodo que percorre os clientes e printa o que diferente de vazio
    public static void listarClientes(Cliente[] clientes) {
        System.out.println("Clientes cadastrados:");
        for (Cliente cliente : clientes) {
            if (cliente != null) {
                System.out.println("ID: " + cliente.getID() + " - Nome: " + cliente.getNome());
            }
        }
    }

    //Verifica se o idTeste é igual ao idParaRemover
   //Caso ele encontre, ele substitui o valor do idTeste para o Id que ele deseja remover, move os outros clientes para a posição anterior no vetor a partir do cliente a ser removido e coloca o último espaço como vazio para adicionar um novo cliente
    public static boolean removerCliente(Cliente[] clientes, int idParaRemover) {
        int idTeste = -1;

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null && clientes[i].getID() == idParaRemover) {
                idTeste = i;
                break;
            }
        }
        if (idTeste == -1) {
            System.out.println("Cliente não encontrado.");
            return false;
        }
        for (int j = idTeste; j < clientes.length - 1; j++) {
            clientes[j] = clientes[j + 1];
        }
        clientes[clientes.length - 1] = null;
        System.out.println("Cliente removido");
        return true;
    }
}
