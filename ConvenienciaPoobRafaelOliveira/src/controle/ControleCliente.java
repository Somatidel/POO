package controle;

import java.util.ArrayList;
import modelo.Cliente;

public class ControleCliente {

    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public ControleCliente() {
        clientes.add(new Cliente("123.456.789-10", "Rodrigo"));
        clientes.add(new Cliente("987.654.321-00", "Romario"));
    }
    
    public ArrayList<Cliente> getClientes(){
        return clientes;
    }

    public Cliente getClienteCpf(String cpf) {
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                cliente = c;
            }
        }

        return cliente;
    }
    
    public void addCliente(Cliente c) {
        clientes.add(c);
    }

    public void removeCliente(String cpf){
        Cliente c = getClienteCpf(cpf);
        if(c != null)
            clientes.remove(c);
    }
}
