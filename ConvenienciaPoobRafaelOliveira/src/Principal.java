import java.util.Scanner;
import controle.ControleCliente;
import controle.ControleProduto;
import controle.ControleVenda;
import visao.TelaCliente;
import visao.TelaProduto;
import visao.TelaVenda;


public class Principal {
    public static void main(String[] args) {
        ControleCliente cc = new ControleCliente();
        ControleProduto cp = new ControleProduto();
        ControleVenda cv = new ControleVenda();

        TelaCliente tc = new TelaCliente(cc);
        TelaProduto tp = new TelaProduto(cp);
        TelaVenda tv = new TelaVenda(cv, cc, cp);
        Scanner ler = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("------MENU------");
            System.out.println("1. Clientes;");
            System.out.println("2. Produtos;");
            System.out.println("3. Vendas;");
            System.out.println("0. Sair do programa.");
            System.out.print("Selecione: ");
            opcao = ler.nextInt();
            System.out.println("");
            switch (opcao) {
                case 0:
                    System.out.println("Encerrando...");
                    break;
                case 1:
                    tc.menu();
                    break;
                case 2:
                    tp.menu();
                    break;
                case 3:
                    tv.menu();
                    break;
                default:
                    System.out.println("\nSelecione uma opcao valida!");
            }
        } while (opcao != 0);
    }
}
