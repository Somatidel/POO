package modelo;

public class ItemVenda {
    //para associar o itemVenda ao Produto
    private Produto produto;
    
    private int quant;
    private double valorUnitario;

    public ItemVenda(Produto produto, int quant) {
        this.produto = produto;
        this.quant = quant;
        this.valorUnitario = produto.getPreco();
    }
    
    public Produto getProduto(){
        return this.produto;
    }

    public int getQuant() {
        return this.quant;
    }

    public double getValorUnitario() {
        return this.valorUnitario;
    }
    
    public Double getSubtotal(){
        return this.valorUnitario * this.quant;
    }

    @Override
    public String toString() {
        return produto.getNome() + " - " + quant + " - " + valorUnitario + " - " + (quant * valorUnitario);
    }
    
    
}
