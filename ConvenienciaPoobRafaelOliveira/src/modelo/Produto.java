package modelo;

public class Produto {
    private int codigoBarra;
    private String nome;
    private double preco;

    public Produto() {
    }

    public Produto(int codigoBarra, String nome, double preco) {
        this.codigoBarra = codigoBarra;
        this.nome = nome;
        this.preco = preco;
    }

    public int getCodigoBarra() {
        return codigoBarra;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setCodigoBarra(int codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return codigoBarra + " - " + nome + " - " + preco;
    }
    
    
}
