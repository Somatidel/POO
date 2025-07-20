package controle;

import java.util.ArrayList;
import modelo.Produto;

public class ControleProduto {
    public static ArrayList <Produto> produtos = new ArrayList <>();
    
    public ControleProduto(){
        produtos.add(new Produto(01, "Sabao em po OMO", 20.59));
        produtos.add(new Produto(02, "Amaciante Comfort", 19.35));
        produtos.add(new Produto(03, "Pacote bolacha Renata", 15.10));
    }
    
    public ArrayList <Produto> getProdutos(){
        return produtos;
    }
    
    public Produto getProdutoCodigo(int codigo){
        Produto produto = null;
        for(Produto p : produtos)
            if(p.getCodigoBarra() == codigo)
                produto = p;
                
        return produto;
    }
    
    public void addProduto(Produto p){
        produtos.add(p);
    }
    
    public boolean removeProduto(int codigo){
        Produto p = getProdutoCodigo(codigo);
        if(p != null){
            produtos.remove(p);
            return true;
        }
        return false;
    }
}
