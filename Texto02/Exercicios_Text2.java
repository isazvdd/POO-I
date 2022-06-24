import java.lang.Math;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class Exercicios_Text2 {
    
    // Receber dois inteiros e retorná-los em ordem crescente
    public int[] e2_2(int y, int z){
        int[] resultado  = new int[2];
        if (y > z){
            resultado[0] = z;
            resultado[1] = y;
        } else {
            resultado[1] = z;
            resultado[0] = y;
        }
        return resultado;
    }
    
    
    // Receber três números reais e retorná-los em ordem decrescente FALTA TERMINAR
    public int[] e2_3(int a, int b, int c){
        int[] resultado  = new int[3];
        if(a>b & a>c){
            if(b>c) return new int[]{a, b, c};
            return new int[]{a, b, c};
        }else if(b>a & b>c){
            if(a>c) return new int[]{b, a, c};
            return new int[]{b, c, a};
        }else if(c>a & c>b){
            if(a>b) return new int[]{c, a, b};
            return new int[]{c, b, a};
        }        
        return new int[]{a, b, c};
    }
    
    
    // Receber um número real e retornar sua raiz quadrada
    public double e2_4(double a){
        double resultado = Math.sqrt(a); 
        return resultado;
    }
    
    
    // Receber dois Strings e informar se o primeiro String está contido 
    // no segundo (use o método indexOf)
    public String e2_5(String a1, String a2){        
        int resultado = a1.indexOf(a2);
        if(resultado == -1){
            return null;
        }
        return "ta tudo ok";
    }
    
    
    // Receber dois Strings e retorná-los em ordem alfabética (use o método compareTo)
    public String[] e2_6(String a1, String a2){
        if(a1.compareTo(a2)<0) 
            return new String[] {a1, a2};
        return new String[] {a1, a2};
    }
    
    
    // Receber três Strings e retorná-los em ordem alfabética (use o método compareTo)
    public String[] e2_7(String a, String b, String c){   
        if(a.compareTo(b)<0 & a.compareTo(c)<0){
            if(b.compareTo(c)<0) return new String[]{a, b, c};
            return new String[]{a, c, b};
        }else if(b.compareTo(a)<0 & b.compareTo(c)<0){
            if(a.compareTo(c)<0) return new String[]{b, a, c};
            return new String[]{b, c, a};
        }else if(c.compareTo(a)<0 & c.compareTo(b)<0){
            if(a.compareTo(b)<0) return new String[]{c, a, b};
            return new String[]{c, b, a};
        }        
        return new String[]{a, b, c};
    }
    
    
    // Receber um array de Strings na forma "nome sobrenome" e retornar um array na 
    // forma "sobrenome, nome" (use os métodos indexOf e substring)
    public String[] e2_8(String[] nomes) {
        String[] invertidos = new String[nomes.length];
        
        for(int i=0; i<nomes.length; i++){
            invertidos[i] = inverterNomes(nomes[i]);
        }
        
        return invertidos;
    }
    
         
    // Receber um array de Strings e modificá-lo de forma que todos os seus itens 
    // fiquem com todas as letras maiúsculas (use o método toUpperCase)
    public String[] e2_9(String[] letras){
        for(int i=0; i<letras.length; i++){
            letras[i] = letras[i].toUpperCase();
        }
        
        return letras;
    }
    
    
    // Receber um array de Strings e retornar um array com os mesmos Strings mas 
    // com todas as letras maiúsculas (use o método toUpperCase)
    public String[] e2_10(String[] names){   
        String[] maior = new String[names.length];
        
        for(int i=0; i<names.length; i++){
            maior[i] = names[i].toUpperCase();
        }
        
        return maior;
    }
    
    
    
    // Receber um vetor de inteiros. Percorrer o vetor com um comando for. A cada repetição, 
    // troque o elemento corrente com o que estiver uma posição à frente sempre que o 
    // elemento da frente for menor que o elemento corrente. 
    public int[] e2_11(int[] num){   
        int troca;
        
        for(int i=0; i<num.length-1; i++){
            if(num[i]<num[i+1]){
                troca = num[i+1];
                num[i+1] = num[i];
                num[i] = troca;
            }
        }        
        return num;
    }
    
    
    
    // Adapte o exercício anterior de forma que as trocas sejam efetuadas e, além disso, 
    // o método retorne a quantidade de trocas realizadas. 
    public int e2_12(int[] num){   
        int troca;
        int qtd = 0;
        
        for(int i=0; i<num.length-1; i++){
            if(num[i]<num[i+1]){
                troca = num[i+1];
                num[i+1] = num[i];
                num[i] = troca;
                qtd++;
            }
        }        
        return qtd;
    }
    
    
    
    // Adapte o exercício anterior para que funcione com um vetor de Strings e faça as trocas 
    // sempre que um String for lexicograficamente maior que o String que está à sua frente no 
    // vetor. Lembre de retornar o número de trocas.
    public int e2_13(String[] strings){   
        String troca;
        int qtd = 0;
        
        for(int i=0; i<strings.length-1; i++){
            if(strings[i].compareTo(strings[i+1])>0){
                troca = strings[i+1];
                strings[i+1] = strings[i];
                strings[i] = troca;
                qtd++;
            }
        }        
        return qtd;
    }
    
    public String[] e2_13_1(String[] palavras)
    {   
        String troca;
        int qtd = 0;
        
        for(int i=0; i<palavras.length-1; i++){
            if(palavras[i].compareTo(palavras[i+1])>0){
                troca = palavras[i+1];
                palavras[i+1] = palavras[i];
                palavras[i] = troca;
                qtd++;
            }
        }        
        return palavras;
    }
    
    
    
    // Receber um vetor de inteiros e modificá-lo para que fique em ordem decrescente. 
    // Dica de amigo: se você usar o método do exercício 2.12 e a quantidade de trocas retornada 
    // for 0 (zero), o vetor estará ordenado. É possível chamar um método de dentro de outro, 
    // assim como em qualquer linguagem de programação que você já estudou.
     public int[] e2_14(int[] num){   
        while(e2_12(num)>0){
            num = e2_11(num);
        }        
        return num;
    }
    
    
    // Receber um vetor de Strings e modificá-lo para que fique ordem alfabética. 
    // Dica de amigo: veja a dica de amigo da questão anterior.
    public String[] e2_15(String[] strings){   
        while(e2_13(strings)>0){
            strings = e2_13_1(strings);
        }        
        return strings;
    }
    
        
    
    // Receber um vetor de Strings na forma "nome sobrenome" e modificá-lo para que 
    // fique ordenado alfabeticamente por sobrenome. Por exemplo: se o vetor {"robert plant", 
    // "ian gillan", "neil young"} for passado como parâmetro, após a execução do método, o 
    // conteúdo do vetor deve ser {"ian gillan", "robert plant",  "neil young"}. Sem dicas, 
    // se vire sozinho.     
    public String[] e2_16(String[] nomes)
    {   
        String[] invertidos = e2_8(nomes);
        
        nomes = ordenarPalavras(invertidos);
        for(int i=0; i<nomes.length; i++){
            nomes[i] = nomes[i].substring(nomes[i].indexOf(',')+2, nomes[i].length()) + " " + nomes[i].substring(0, nomes[i].indexOf(','));
        }
        return nomes;
    }
    
    public String[] e2_17(String[] nomes)
    {   
        String[] invertidos = e2_8(nomes);
        
        return ordenarPalavras(invertidos);
    }
    
    public String inverterNomes(String s){
        return s.substring(s.indexOf(' ')+1, s.length()) + ", " + s.substring(0, s.indexOf(' '));
    }
    
    public String[] ordenarPalavras(String[] palavras){
        for(int i=1; i<palavras.length; i++){
            String k = palavras[i];
            int j = i-1;
            while(j>=0 && palavras[j].compareTo(k)>0){
                palavras[j+1] = palavras[j];
                j = j-1;
            }
            palavras[j+1] = k;
        }        
        return palavras;
    }
      
    
}
