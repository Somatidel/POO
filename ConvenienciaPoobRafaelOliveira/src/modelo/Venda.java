package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Venda {
    //relacionamento com o cliente
    private Cliente cliente;
    
    //lista para associar os itens de venda
    private ArrayList<ItemVenda> itensVenda = new ArrayList<>();
            
    private Date data;
    private double total;
    private String formaPagto;

    public Venda(Cliente cliente, String formaPagto) {
        this.data = new Date();
        this.cliente = cliente;
        this.total = 0;
        this.formaPagto = formaPagto;
    }
    
    public void addItemVenda(ItemVenda item){
        itensVenda.add(item);
        this.total += item.getSubtotal();
    }
    
    public void removeItemVenda(Produto p, int quant){
        ItemVenda item = new ItemVenda(p, quant);
        this.itensVenda.remove(item);
    }
    
    public ArrayList<ItemVenda> getItensVenda(){
        return this.itensVenda;
    }
    
    public Cliente getCliente(){
        return this.cliente;
    }

    public Date getData() {
        return data;
    }

    public double getTotal() {
        return this.total;
    }

    public String getFormaPagto() {
        return this.formaPagto;
    }

    @Override
    public String toString() {
        return cliente.getNome() + " - " + data + " - " + total + " - " + formaPagto;
    }
}
