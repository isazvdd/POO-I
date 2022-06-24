import java.util.ArrayList;
public class Venda
{
    private String data;
    private ArrayList <Item> itens;
    
    public Venda(){
        
    }
    
    public void setData(String data){
        this.data = data;
    }
    
    public String getData(){
        return this.data;
    }
       
    public void setItens(ArrayList<Item> itens){
        this.itens = itens;
    }
    
    public ArrayList<Item> getItens(){
        return this.itens;
    }
    
    public double total(){
        double res=0 ;
        for(Item i:itens){
            res+=i.total();    
        }
        return res;
    }
}
