import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.*;

public class Conta{
    private int codigo;
    private String tipo;
    private double saldo;
    private double limite;
    private double manutencao;
    private double rendimento;
    private String dataAniv;
    
    private ArrayList<String> transacoes = new ArrayList<>();
    
    public Conta(){
        
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public double getSaldo(){
        return this.saldo;
    }
    
    public void setLimite(double limite){
        this.limite = limite;
    }
    
    public double getLimite(){
        return this.limite;
    }
    
    public void setManutencao(double manutencao){
        this.manutencao = manutencao;
    }
    
    public double getmanutencao(){
        return this.manutencao;
    }
    
    public void setRendimento(double rendimento){
        this.rendimento = rendimento;
    }
    
    public double getRendimento(){
        return this.rendimento;
    }
    
    public void setDataAniv(String dataAniv){
        this.dataAniv = dataAniv;
    }
    
    public String getDataAniv(){
        return this.dataAniv;
    }
    
    public ArrayList<String> getTransacoes(){
        return this.transacoes;
    }
    
    public boolean devedor(){
        return (saldo < 0) ? true : false;
    }
    
    public boolean depositar(double valor){
        saldo = saldo + valor;
        transacoes.add("Data: " +LocalDateTime.now() + " Deposito: R$ " +valor + "Saldo: R$ +saldo");
        return true;
    }
        
    public boolean sacar(double valor){
        if(valor <= saldo +limite){
            saldo -= valor;
            transacoes.add("Data: " +LocalDateTime.now()+ " Saque: -R$" +valor+ " Saldo: R$" +saldo);
            return true;
        }
        return false;
    }
    
    public boolean taxaManutencao(){
        saldo = saldo - manutencao;
        if(transacoes
        .stream()
        .filter(t -> t.startsWith("Data: " +DateTimeFormatter.ofPattern("dd/MM/yyyy")
        .format(LocalDateTime.now()))
        && t.contains("Taxa de manutençao da conta"))
        .collect(Collectors.toList()).size()<1){
            transacoes.add("Data: " +LocalDateTime.now()+ " Taxa de manutencao: -R$" +manutencao+ " Saldo: R$" +saldo);
            return true;
        }
        return false;
    }
    
    public boolean render(){
        saldo += saldo*rendimento;
        transacoes.add("Data: "+LocalDateTime.now()+ "Rendimento: R$ " +manutencao+ "Saldo: R$" +saldo);
        return true;
    }
    
    public boolean transferir(double valor, Conta c){
        if(valor <= saldo + limite){
            saldo -= valor;
            c.saldo += valor;
            transacoes.add("Data: " +LocalDateTime.now()+ " Transferencia Enviada: -R$" +valor+ " Saldo: R$" +saldo);
            c.transacoes.add("Data: " +LocalDateTime.now()+ " Transferencia Recebida: +R$" +valor+ " Saldo: " +saldo);
            return true;
        }
        return false;
    }
    
}
