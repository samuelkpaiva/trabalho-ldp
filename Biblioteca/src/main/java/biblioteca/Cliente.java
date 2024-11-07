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
            System.out.println("Cliente removido");
            return true;
        } else {
            System.out.println("Cliente não encontrado.");
            return false;
        }
    }
}