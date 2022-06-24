import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.io.File;
import java.nio.file.*;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.io.IOException;

public class Exercicios_Text3 {
    
    // Obter a data atual do sistema e retorná-la na forma de String.
    public String e3_1(){
        Date now = new Date();
        
        String dataForm = new SimpleDateFormat("dd/MM/yyyy").format(now);   
        return dataForm;
    }

    
    // Receber uma data (como String) no formato dd/mm/aaaa e retornar a 
    // mesma data (como String) no formato "<dia da semana>, <dia> de <nome do mês> 
    // de <ano>"
    public String e3_2(){
        Date now = new Date();         
        SimpleDateFormat dataFormat = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy");
        String dataForm = dataFormat.format(now);
        return dataForm;
    }
    
    
    // Receber um caminho de diretório como parâmetro e retornar um vetor com todos os 
    // itens do diretório. Dica: objetos da classe File podem ser usados para realizar 
    // operações sobre diretórios, entre várias outras coisas. Analise a documentação da 
    // classe File para saber além do que já foi descrito no conteúdo deste texto.
    public String[] e3_3(){
        File diretorioUf = new File("E:\\UFRN");
        
        String[] arquivos = diretorioUf.list();
        return arquivos;
    }
    
    
    // Receber um caminho de diretório como parâmetro e retornar um vetor com todos os 
    // itens do diretório. Cada item do vetor retornado deve estar precedido por "[A]", 
    // caso seja arquivo, e "D", caso seja diretório. Retorne um valor nulo caso o String 
    // recebido como parâmetro não corresponda a um diretório existente no disco. Mais uma vez, 
    // você precisará de um objeto da classe File para fazer o trabalho sujo para você.
    public String[] e3_4(){
        File diretorioDown = new File("E:\\UFRN");
        String[] conteudo = diretorioDown.list();
        if (diretorioDown.exists()) {
            for (int i = 0; i <= conteudo.length -1;i++) {
                if (conteudo[i].contains(".")) { 
                    conteudo[i] = "A"+ conteudo[i];
                } else {
                    conteudo[i] = "D"+ conteudo[i];
                }
            }
        }
        return conteudo;
    }
    
    
    
    // Receber um caminho para um arquivo como parâmetro e deletar o arquivo. 
    public String[] e3_5(){
        File dirDel = new File("E:\\pasta\teste.txt");
        dirDel.delete();
        String[] conteudo = dirDel.list();
        return conteudo;
    }
    
    
    
    // (Desafio) Escreva um programa que mostre uma janela com dois menus - Arquivo e Editar. 
    // Dica: você deverá utilizar objetos das classes JFrame, JMenuBar e JMenu). 
    public void e3_6(){
        // adicionando uma janela 
        JFrame jan = new JFrame("Uma janela aqui");
        jan.setSize(600, 400); //tamanho da janela
        jan.setVisible(true); // tornando visível 
               
        
        // adicionando uma barra de menu
        JMenuBar menuBar = new JMenuBar();
        jan.add(menuBar);
        jan.setJMenuBar(menuBar);
        
        
        // adicionando os menus 
        JMenu fileMenu = new JMenu("Arquivos");
        menuBar.add(fileMenu);
        JMenu editMenu = new JMenu("Editar");
        menuBar.add(editMenu);
        //menuBar.setVisible(true);
        

        // adicionar os submenus do menu arquivos
        JMenuItem openAction = new JMenuItem("abra");
        JMenuItem yourAction = new JMenuItem("seu");
        JMenuItem fileAction = new JMenuItem("arquivo");
        JMenuItem hereAction = new JMenuItem("aqui");
        
        // adicionar os submenus do menu editar
        JMenuItem editAction = new JMenuItem("edite");
        JMenuItem heresAction = new JMenuItem("aqui");
        JMenuItem yoursAction = new JMenuItem("seus");
        JMenuItem filesAction = new JMenuItem("docs");
        
        // botões dos submenus de menu arquivos
        ButtonGroup bg = new ButtonGroup();
        fileMenu.add(openAction);
        fileMenu.add(yourAction);
        fileMenu.add(fileAction);
        fileMenu.add(hereAction);
        
        // adicionando um separador para os menus
        fileMenu.addSeparator();
        
        // botões dos submenus de menu editar
        editMenu.add(editAction);
        editMenu.add(heresAction);
        editMenu.add(yoursAction);
        editMenu.add(filesAction);
        
        jan.setVisible(true);
        
    }
    
    
    
    // Escreva um método que receba como parâmetro um String representando
    // um caminho para um arquivo executável e execute tal arquivo.    
    public void e3_7(String exer) throws Exception{
        String[] comando = {"cmd", "/c", "start", exer};
        Runtime.getRuntime().exec(comando);
    }
    
    
    // Escreva um método que receba o caminho de um arquivo de texto (txt) 
    // e abra o arquivo no bloco de notas 
    public void e3_8(String exer) throws Exception{
        String[] comando = {"notepad", exer};
        Runtime.getRuntime().exec(comando);
    }
    
    
    // Faça um método que mostre uma Janela (vazia) do tamanho da tela. 
    // O programa deve funcionar em monitores com diferentes resoluções. 
    public void e3_9(){
        JFrame jan = new JFrame("Uma janela aqui");
        jan.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jan.setVisible(true); // tornando visível 
        
    }
    
    
    
    // Receber duas datas como parâmetro e retornar a mais recente
    public String e3_10(String d1, String d2){
        if (d1.compareTo(d2) < 0) {
            return d1;           
        }
        return d2;
    }
    
    
    
    // Receber um array de Dates e modificar o array de forma que fique 
    // em ordem cronológica. Dica: use o método compareTo da classe Date
    public String[] e3_11(String[] datas) throws Exception{
        Date[] dates = new Date[datas.length];
        for (int k=0; k<datas.length; k++){
            dates[k] = dates[k];
            Date i = dates[k];
            String is = datas[k];
            int j = k-1;
            while (j>=0 && dates[j].compareTo(i)>0){
                dates[j+1] = dates[j];
                datas[j+1] = datas[j];
                j = j-1;
            }
            dates[j+1] = i;
            datas[j+1] = is;
        }
        return datas;
    }
    
    
    // Receber uma data, na forma de String, no formato dd/mm/aaaa, 
    // e retornar o dia da semana referente à data
    public String e3_12(String data) throws Exception{
        SimpleDateFormat formatador = new SimpleDateFormat("dd/mm/yyyy");
        Date dataDia = new Date();
        dataDia = formatador.parse(data);
        data = ""+dataDia;
        data = data.substring(0, 3);
        return data;
    }
}
