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

    // Método para remover cliente com ajuste na ordem dos clientes no array
public static boolean removerCliente(Cliente[] clientes, int idParaRemover) {
    // Ajusta o índice para ser baseado em zero (assumindo que o ID começa em 1)
    int index = idParaRemover - 1;
    
    if (index >= 0 && index < clientes.length && clientes[index] != null) {
        // Move todos os clientes após o índice index uma posição para a esquerda
        for (int j = index; j < clientes.length - 1; j++) {
            clientes[j] = clientes[j + 1];
        }
        clientes[clientes.length - 1] = null; // Define o último elemento como null
        System.out.println("Cliente removido com sucesso.");
        return true;
    } else {
        System.out.println("ID inválido ou cliente não encontrado.");
        return false;
    }
}
}