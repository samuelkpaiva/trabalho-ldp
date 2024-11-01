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
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public int getID(){
        return id;
    }
    
    public void getID(int id){
        this.id = id;
    }
      // Método para adicionar cliente
    public static boolean adicionarCliente(Cliente[] clientes, String nome, String email) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) { // Encontrou um espaço vazio
                int id = i + 1; // ID simples baseado na posição
                clientes[i] = new Cliente(nome, email, id);
                return true; // Cliente adicionado com sucesso
            }
        }
        return false; // Sem espaço disponível
    }

    // Método para listar clientes
    public static void listarClientes(Cliente[] clientes) {
        System.out.println("Clientes cadastrados:");
        for (Cliente cliente : clientes) {
            if (cliente != null) {
                System.out.println("ID: " + cliente.getID() + " - Nome: " + cliente.getNome());
            }
        }
    }

    // Método para remover cliente
    public static boolean removerCliente(Cliente[] clientes, int idParaRemover) {
        if (idParaRemover > 0 && idParaRemover <= clientes.length && clientes[idParaRemover - 1] != null) {
            clientes[idParaRemover - 1] = null; // Remove o cliente
            System.out.println("Cliente removido com sucesso.");
            return true;
        } else {
            System.out.println("ID inválido ou cliente não encontrado.");
            return false;
        }
    }
}