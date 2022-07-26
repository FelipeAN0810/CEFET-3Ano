import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class SubstitiuArquivo {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Scanner ler = new Scanner(System.in);

        String palavra, substituicao, linha, novaLinha = "";

        System.out.println("Digite a palavra que você deseja substituir: ");
        palavra = ler.nextLine();

        System.out.println("Digite a palavra que deseja colocar no lugar: ");
        substituicao = ler.nextLine();

        File arquivo = new File("MetalContraasNuvens.txt");

        File arquivo2 = new File("ArquivoTemporário.txt");
        System.out.println(args[0]);
        try{
            Scanner lerArquivo = new Scanner(arquivo /*Para buscar o arquivo pelo args é só colocar args[0] aqui*/ );

            PrintWriter print = new PrintWriter(arquivo2);

            while(lerArquivo.hasNextLine()){

                linha = lerArquivo.nextLine();
                String[] conjunto = linha.split("[ ,.?!;:()]");

                for(int i = 0; i < conjunto.length; i++){

                    if(conjunto[i].toUpperCase().equals(palavra.toUpperCase())){
                        conjunto[i] = substituicao;
                    }
                    
                    novaLinha += conjunto[i] + " ";
                }

                print.println(novaLinha);
                novaLinha = "";
            }
            
            print.close();

            ler.close();
            lerArquivo.close();

        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        arquivo.delete();
        arquivo2.renameTo(arquivo);
    }
}
