import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.nio.file.*;

public class SubstituiPalavra {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Scanner leitura = new Scanner(System.in);
        String palavra,palavra2;
        System.out.print("Digite a palavra que você deseja que seja alterada no arquivo: ");
        palavra = leitura.nextLine();
        System.out.print("Digite a palavra que será a substituta para a palavra anterior:  ");
        palavra2 = leitura.nextLine();

        try{
            File file = new File(args[0]);
            Scanner ler = new Scanner(file);
            PrintWriter pw = new PrintWriter("MetalContraasNuvens2.txt");
            String linha, linhaNova = "";
            while (ler.hasNextLine()) {
                linha = ler.nextLine();
                String[] palavras = linha.split(" ");

                for (int i = 0; i < palavras.length; i++) {
                    if (palavras[i].toUpperCase().equals(palavra.toUpperCase())) {
                        palavras[i] = palavra2;
                    }
                    linhaNova += palavras[i] + " ";
                }
                pw.println(linhaNova);
                linhaNova = "";
                
            }
            pw.close();
        

            File novoArquvio = new File("MetalContraasNuvens2.txt");
            ler = new Scanner(novoArquvio);
            PrintWriter pw2 = new PrintWriter(file);
            while (ler.hasNextLine()) {
                linha = ler.nextLine();
                pw2.println(linha);
                linha = "";
                
            }
            pw2.close();
            ler.close();
            Path local = novoArquvio.toPath();
            Files.delete(local);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }

    }
}
