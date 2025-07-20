package controle;

import java.util.ArrayList;
import java.util.List;
import modelo.ItemVenda;
import modelo.Venda;

public class ControleVenda {
    private static List<Venda> vendas = new ArrayList<>();

    public void incluir(Venda v) {
        vendas.add(v);
    }

    public void excluir(Venda v) {
        vendas.remove(v);
    }

    public List<Venda> listarTodas() {
        return ControleVenda.vendas;
    }

    public List<Venda> listarPorCliente(String cpf) {
        List<Venda> resultado = new ArrayList<>();
        for (Venda v : vendas) {
            if (v.getCliente().getCpf().equals(cpf)) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    public int totalVendasProduto(int codigoBarra) {
        int total = 0;
        for (Venda v : vendas) {
            for (ItemVenda iv : v.getItensVenda()) {
                if (iv.getProduto().getCodigoBarra() == codigoBarra) {
                    total += iv.getQuant();
                }
            }
        }
        return total;
    }
}
