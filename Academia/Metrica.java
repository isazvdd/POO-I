import java.util.Date;

public class Metrica {
    private double peso;
    private double altura;
    private double biceps;
    private double perna;
    private double peito;
    private double cintura;
    private String data;
    
    /*
    public Metrica(double peso, double altura, double biceps,  double perna,  double peito, double cintura, String data){
        this.peso = peso;
        this.altura = altura;
        this.biceps = biceps;
        this.perna = perna;
        this.peito = peito;
        this.cintura = cintura;
        this.data = data;
    }
    */
   
    public Metrica(){
        
    }
    
    public void setPeso(double peso){
        this.peso = peso;
    }
    
    public double getPeso(){
        return peso;
    }
    
    public void setAltura(double altura){
        this.altura = altura;
    }
    
    public double getAltura(){
        return altura;
    }
    
    public void setBiceps(double biceps){
        this.biceps = biceps;
    }
    
    public double getBiceps(){
        return biceps;
    }
    
    public void setPerna(double perna){
        this.perna = perna;
    }
    
    public double getPerna(){
        return perna;
    }
    
    public void setPeito(double peito){
        this.peito = peito;
    }
    
    public double getPeito(){
        return peito;
    }
    
    public void setCintura(double cintura){
        this.cintura = cintura;
    }
    
    public double getCintura(){
        return cintura;
    }
    
    public void setData(String data){
        this.data = data;
    }
    
    public String getData(){
        return data;
    }
    
    public String dataNow(String data){ 
        // ACHO QUE TÁ ERRADO, PRECISA COLOCAR A DATA LIGADA AS MÉTRICAS
        // PRA SABER QUE DIA FOI COLETADA TAL METRICA
        Date dataNow = new Date();
        return dataNow + "";
    }
    
    // IMC
    public double imc(){
        double resultado = peso / (altura*altura);
        return resultado;
    }
}
