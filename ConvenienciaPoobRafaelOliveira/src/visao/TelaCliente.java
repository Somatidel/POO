package visao;

import controle.ControleCliente;
import java.util.Scanner;
import modelo.Cliente;

public class TelaCliente {
    private ControleCliente controle;

    public TelaCliente(ControleCliente controle) {
        this.controle = controle;
    }

    public void menu() {
        int opcao;
        Scanner ler = new Scanner(System.in);
        
        do {
            System.out.println("------CLIENTE------");
            System.out.println("1. Incluir cliente;");
            System.out.println("2. Excluir cliente;");
            System.out.println("3. Listar clientes;");
            System.out.println("0. Voltar.");
            System.out.print("Selecione: ");
            opcao = ler.nextInt();
            System.out.println("");
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    incluir(); 
                    break;
                case 2:
                    excluir(); 
                    break;
                case 3:
                    listar(); 
                    break;
                default:
                    System.out.println("\nSelecione uma opcao valida!");
            }
        } while (opcao != 0);
    }

    public void incluir() {
        Scanner ler = new Scanner(System.in);
        
        System.out.print("CPF: ");
        String cpf = ler.nextLine();
        System.out.print("Nome: ");
        String nome = ler.nextLine();
        controle.addCliente(new Cliente(cpf, nome));
        System.out.println("Cliente incluído.");
    }

    public void excluir() {
        Scanner ler = new Scanner(System.in);
        
        System.out.print("CPF a excluir: ");
        String cpf = ler.nextLine();
        controle.removeCliente(cpf);
        System.out.println("Cliente excluído (se existia).");
    }

    public void listar() {
        System.out.println("Lista de Clientes:");
        for(Cliente c : controle.getClientes()){
            System.out.println(c);
        }
    }
}
