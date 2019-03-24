
package dcmoney;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Duarte
 */
public class ManipuladorArquivo<T> extends Cadastro {
    String file;
    Scanner in = new Scanner(System.in);
    public ManipuladorArquivo(String nome){
        file=nome;
        File arquivo = new File(file);
    }
    
    public void escreverArquivo(T var) throws FileNotFoundException, IOException{
        FileWriter arquivoEscrita = new FileWriter(file,true);
        BufferedWriter escreverArquivo = new BufferedWriter(arquivoEscrita);
        escreverArquivo.write(var+"");
        escreverArquivo.close();
    }
    
    public void lerArquivo() throws IOException{
        FileReader arquivoLeitura = new FileReader(file);
        BufferedReader lerArquivo = new BufferedReader(arquivoLeitura);
        String linha = lerArquivo.readLine();
        while(linha != null){
            System.out.print("\n"+linha+"\n");
            linha=lerArquivo.readLine();
        }
        lerArquivo.close();
    }
    
    public void procurarArquivo(ArrayList lista) throws IOException{
        FileReader arquivoLeitura = new FileReader(file);
        BufferedReader lerArquivo = new BufferedReader(arquivoLeitura);
        String linha = lerArquivo.readLine();
        String palavra = (""+linha.split(";"));
        while(linha != null){
            for(int i=0; i<lista.size(); i++){
                double variavel;
               // variavel=lista.get(i).getLimite();
                //if(palavra.equals(lista.get(i).getLimite())) {
                
                }
                System.out.print("\n"+linha+"\n");
                linha=lerArquivo.readLine();
            }
        
        lerArquivo.close();
    }
    
}
