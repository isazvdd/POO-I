import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private String dataNasc;
    private String genero;
    private ArrayList<Metrica> metricas;
    
    /*
    public Cliente(String nome, String cpf, String dataNasc, String genero){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.genero = genero;
    }*/
    
    public Cliente(){
        metricas = new ArrayList<>();
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public void setDataNasc(String dataNasc){
        this.dataNasc = dataNasc;
    }
    
    public String getDataNasc(){
        return dataNasc;
    }
    
    public void setGenero(String genero){
        this.genero = genero;
    }
    
    public String getGenero(){
        return genero;
    }
    
    public void setMetricas(ArrayList<Metrica> metricas){
        this.metricas = metricas;
    }
    
    public ArrayList<Metrica> getMetricas(){
        return this.metricas;
    }
    
    public double mediaPeso(){
        int cont = 0;
        double soma = 0;
        for (Metrica m:metricas){
            soma += m.getPeso();
            cont++;
        }
        return soma/cont;
    }
    
    //       FAZER UM IMC DE CLIENTES SEM UTILIZAR O FOR OU WHILE, UTILIZANDO A STREAM
    public double imcAtual(){
        return metricas.get(metricas.size() -1).imc();
    }
        
    public Metrica metricaAtual(){
        return metricas.get(metricas.size() -1);
    }
        
    public String adequacao(){
        if(imcAtual() < 18.5){
            return "IMC abaixo do peso";
        } else if(imcAtual() > 18.5 && imcAtual() < 24.9){
            return "IMC adequado";
        } else if(imcAtual() > 25 && imcAtual() < 29.9){
            return "Sobrepeso";
        } else if(imcAtual() > 30 && imcAtual() < 34.9){
            return "Obesidade Grau I";
        } if(imcAtual() > 35 && imcAtual() < 39.9){
            return "Obesidade Grau II";
        } else {
            return "Obesidade Grau III ou Morbida";
        }
    }
    
    public double desvioPadrao(){
        int cont = 0;
        double desvioPadrao = 0;
        for (Metrica m:metricas){
            desvioPadrao += Math.pow(m.getPeso() - mediaPeso(), 2);
            cont++;
        }
        return Math.sqrt(desvioPadrao / (cont - 1));
    }
}
