import java.util.ArrayList;
import java.util.HashMap;

public class Academia {
    private String nome;
    private String cnpj;
    private ArrayList<Cliente> clientes;
    
    /*
    public Academia(String nome, String cnpj){
        this.nome = nome;
        this.cnpj = cnpj;
    } */
    
    public Academia(){
        clientes = new ArrayList<>();
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }
    
    public String getCnpj(){
        return cnpj;
    }
    
    public void setClientes(ArrayList<Cliente> clientes){
        this.clientes = clientes;
    }
    
    public ArrayList<Cliente> getClientes(){
        return this.clientes;
    }
    
    
    
    //             FAZER UM IMC GERAL DA ACADEMIA, SEM UTILIZAR FOR, WHILE
    public double imc(){
        double soma = 0;
        int i = 0;
        int parcela = 0;
        
        while (i<clientes.size()){
            if (clientes.get(i).imcAtual() != -1){
                soma += clientes.get(i).imcAtual();
                parcela++;
            }
            i++;
        }
        return parcela == 0 ? 0 : soma/parcela;
    }
   
    public HashMap mapeiaGenero(){        // RETIRAR O FOR E COLOCAR UM STREAM
        HashMap<String, Integer> generos = new HashMap<String, Integer>();
        
        for (Cliente c:clientes){
            String g = c.getGenero();
            Integer q = generos.get(g);
            if (g == null){
                generos.put(g, 1);
            } else {
                generos.put(g, q+1);
            }
        }
        return generos;
    }
    
    
}
