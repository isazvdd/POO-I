
public class Item extends Produto{
    private double quantidade;
    private Produto produto;
    private double preco;
    
    public Item(Produto produto)
    {
        produto = produto;
    }
    
    public void setQuantidade(double quantidade){
        this.quantidade=quantidade;
    }
    
    public double getQuantidade() {
        return quantidade;
    }    
    
    public void setProduto(Produto produto){
        this.produto = produto;
    }
    
    public Produto getProduto(){
        return this.produto;
    }
                   
    public void setPreco(double preco){
        this.preco = preco;
    }
    
    public double getPreco(){
        return this.preco;
    }
        
    public double total(){
        return quantidade*produto.getPreco();
    }
}
