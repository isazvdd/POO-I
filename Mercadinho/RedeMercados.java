import java.util.ArrayList;

public class RedeMercados
{
    private String nome;
    private ArrayList <Mercadinho> mercados;
    
    public RedeMercados(){
        
    }
    
    public void setMercados(ArrayList<Mercadinho> mercados){
        this.mercados = mercados;
    }
    
    public ArrayList<Mercadinho> getMercados(){
        return this.mercados;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    } 
    
    public String getNome(){
        return this.nome;
    }
    
    public double total(){
        double soma = 0;
        for(Mercadinho m:mercados){
            soma+=m.total();
        }
        
        return soma;
    }
    
    public double total(String data){ 
        double soma = 0;
        for(Mercadinho m:mercados){
            soma+=m.total(data);
        }
        
        return soma;
    }
}
