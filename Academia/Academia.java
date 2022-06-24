import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Academia {
    private String nome;
    private String cnpj;
    private ArrayList<Cliente> clientes;
    
    private ArrayList<Metrica> metricas;
    
    
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
   
    public HashMap mapeiaGenero(){
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
    
    public HashMap clientesGenero() {
        HashMap<String, Integer> clientesGenero = new HashMap<String, Integer>();
    
        for(Cliente cli:clientes) {
            if(clientesGenero.get(cli.getGenero())!=null){
                clientesGenero.put(cli.getGenero(), clientesGenero.get(cli.getGenero())+1); 
            }else{
                clientesGenero.put(cli.getGenero(), 1); 
            }
        }
        return clientesGenero;
    }
    
    public HashMap classificacaoPesoTotal() {
        HashMap<String, List<Cliente>> pesoClientes = new HashMap<String, List<Cliente>>();
        pesoClientes.put("Abaixo do peso", clientes.stream().filter(c->c.adequacao().equals("Baixo Peso")).collect(Collectors.toList()));
        pesoClientes.put("Peso Normal", clientes.stream().filter(c->c.adequacao().equals("Peso Normal")).collect(Collectors.toList()));
        pesoClientes.put("Sobrepeso", clientes.stream().filter(c->c.adequacao().equals("Excesso de Peso")).collect(Collectors.toList()));
        pesoClientes.put("Obesidade Grau I", clientes.stream().filter(c->c.adequacao().equals("Obesidade")).collect(Collectors.toList()));
        pesoClientes.put("Obesidade Grau II", clientes.stream().filter(c->c.adequacao().equals("Obesidade Extrema")).collect(Collectors.toList()));
        pesoClientes.put("Obesidade Grau III", clientes.stream().filter(c->c.adequacao().equals("Obesidade Extrema")).collect(Collectors.toList()));
        
        return pesoClientes;
    }
    
    public HashMap maiorAlturaPorGenero() {
        HashMap<String, ArrayList<Cliente>> alturaGenero = new HashMap<String, ArrayList<Cliente>>();
        double maiorAltura = 0;
        
        for(Cliente cli:clientes) {
            if(cli.metricaAtual().getAltura()>=maiorAltura){
                if(alturaGenero.get(cli.getGenero())!=null){
                    alturaGenero.get(cli.getGenero()).add(cli); 
                }else{
                    alturaGenero.put(cli.getGenero(), new ArrayList<>()); 
                    alturaGenero.get(cli.getGenero()).add(cli);    
                }
            }
        }
        return alturaGenero;
    }
    
    public HashMap mediaDesvioPesoClientes() {
        HashMap<String, ArrayList<Double>> metricasClientes = new HashMap<String, ArrayList<Double>>();
        
        for(Cliente cli:clientes) {
            metricasClientes.put(cli.getNome(), new ArrayList<>());
            metricasClientes.get(cli.getNome()).add(cli.desvioPadrao()); 
            metricasClientes.get(cli.getNome()).add(cli.mediaPeso()); 
        }
        return metricasClientes;
    }
}
