import java.util.ArrayList;

public class Banco{
    private String nome;
    private ArrayList<Agencia> agencias;
    
    public Banco(){
        agencias = new ArrayList<>();
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setAgencias(ArrayList<Agencia> agencias){
        this.agencias = agencias;
    }
    
    public ArrayList<Agencia> getAgencias(){
        return this.agencias;
    }
    
    public double totalDinheiro(){
        return agencias.stream().mapToDouble(a->a.totalDinheiro()).sum();
    }
    
    public void renderAnivs(){
        agencias.stream().forEach(a->a.renderAniv());
    }
}
