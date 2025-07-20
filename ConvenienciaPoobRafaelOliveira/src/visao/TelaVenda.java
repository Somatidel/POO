package visao;

import controle.ControleCliente;
import controle.ControleProduto;
import controle.ControleVenda;
import java.util.List;
import java.util.Scanner;
import modelo.Cliente;
import modelo.ItemVenda;
import modelo.Produto;
import modelo.Venda;

public class TelaVenda {

    private ControleVenda controleVenda;
    private ControleCliente controleCliente;
    private ControleProduto controleProduto;

    public TelaVenda(ControleVenda cv, ControleCliente cc, ControleProduto cp) {
        this.controleVenda = cv;
        this.controleCliente = cc;
        this.controleProduto = cp;
    }

    public void menu() {
        int opcao;
        Scanner ler = new Scanner(System.in);
        do {
            System.out.println("------VENDA------");
            System.out.println("1. Incluir venda;");
            System.out.println("2. Excluir venda;");
            System.out.println("3. Listar vendas de um cliente;");
            System.out.println("4. Listar todas as vendas;");
            System.out.println("5. Total vendido de um produto;");
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
                    listarPorCliente();
                    break;
                case 4:
                    listarTodas();
                    break;
                case 5:
                    totalProduto();
                    break;
                default:
                    System.out.println("\nSelecione uma opcao valida!");
            }
        } while (opcao != 0);
    }

    public void incluir() {
        Scanner ler = new Scanner(System.in);

        System.out.print("CPF do cliente: ");
        String cpf = ler.nextLine();

        Cliente c = controleCliente.getClienteCpf(cpf);
        if (c == null) {
            System.out.println("Cliente nao encontrado.");
            return;
        }
        System.out.print("Forma de pagamento: ");
        String fp = ler.nextLine();
        Venda v = new Venda(c, fp);
        int cb;
        do {
            System.out.print("Codigo do produto (0 para fim): ");
            cb = ler.nextInt();
            if (cb != 0) {
                Produto p = controleProduto.getProdutoCodigo(cb);
                if (p == null) {
                    System.out.println("Produto nao encontrado.");
                    continue;
                }
                System.out.print("Quantidade: ");
                int q = ler.nextInt();
                v.addItemVenda(new ItemVenda(p, q));
            }
        } while (cb != 0);
        controleVenda.incluir(v);
        System.out.println("Venda registrada. Total: " + v.getTotal());
    }

    public void excluir() {
        Scanner ler = new Scanner(System.in);

        System.out.print("Indice da venda a excluir: ");
        int indice = ler.nextInt();
        List<Venda> lista = controleVenda.listarTodas();
        if (indice < 0 || indice >= lista.size()) {
            System.out.println("Indice invalido.");
        }
        else {
            controleVenda.excluir(lista.get(indice));
            System.out.println("Venda excluida.");
        }
    }

    public void listarPorCliente() {
        Scanner ler = new Scanner(System.in);

        System.out.print("CPF do cliente: ");
        String cpf = ler.nextLine();
        
        for(Venda v : controleVenda.listarPorCliente(cpf)){
            System.out.println(v);
        }
    }

    public void listarTodas() {
        for(Venda v : controleVenda.listarTodas()){
            System.out.println(v);
        }
    }

    public void totalProduto() {
        Scanner ler = new Scanner(System.in);

        System.out.print("Codigo do produto: ");
        int cb = ler.nextInt();
        int total = controleVenda.totalVendasProduto(cb);
        System.out.println("Total vendido do produto: " + total);
    }
}
