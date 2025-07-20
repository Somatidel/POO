package visao;

import controle.ControleProduto;
import java.util.Scanner;
import modelo.Produto;

public class TelaProduto {
    private ControleProduto controle;

    public TelaProduto(ControleProduto controle) {
        this.controle = controle;
    }

    public void menu() {
        int opcao;
        Scanner ler = new Scanner(System.in);
        
        do {
            System.out.println("------PRODUTO------");
            System.out.println("1. Incluir produto;");
            System.out.println("2. Excluir produto;");
            System.out.println("3. Listar produtos;");
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
        
        System.out.print("Codigo de Barra: ");
        int cb = ler.nextInt();
        ler.nextLine();
        
        System.out.print("Nome...........: ");
        String nome = ler.nextLine();
        
        System.out.print("Preco..........: ");
        double preco = ler.nextDouble();
        
        controle.addProduto(new Produto(cb, nome, preco));
        System.out.println("Produto incluido.");
    }

    public void excluir() {
        Scanner ler = new Scanner(System.in);
        
        System.out.print("Codigo de Barra a excluir: ");
        int cb = ler.nextInt();
        boolean valida = controle.removeProduto(cb);
        if(valida){
            System.out.println("Produto excluido (se existia).");
        }
        else
            System.out.println("Produto nao encontrado...");
    }

    public void listar() {
        System.out.println("Lista de Produtos:");
        for(Produto p : controle.getProdutos()){
            System.out.println(p);
        }
    }
}
