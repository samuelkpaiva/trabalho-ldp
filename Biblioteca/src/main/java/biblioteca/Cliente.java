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

    public static boolean adicionarCliente(Cliente[] clientes, String nome, String email) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                int id = i + 1;
                clientes[i] = new Cliente(nome, email, id);
                return true;
            }
        }
        return false;
    }

    public static void listarClientes(Cliente[] clientes) {
        System.out.println("Clientes cadastrados:");
        for (Cliente cliente : clientes) {
            if (cliente != null) {
                System.out.println("ID: " + cliente.getID() + " - Nome: " + cliente.getNome());
            }
        }
    }

    public static boolean removerCliente(Cliente[] clientes, int idParaRemover) {
        int novoId = idParaRemover - 1;

        if (novoId >= 0 && novoId < clientes.length && clientes[novoId] != null) {
            for (int j = novoId; j < clientes.length - 1; j++) {
                clientes[j] = clientes[j + 1];
            }
            clientes[clientes.length - 1] = null;
            System.out.println("Cliente removido com sucesso.");
            return true;
        } else {
            System.out.println("ID inválido ou cliente não encontrado.");
            return false;
        }
    }
}