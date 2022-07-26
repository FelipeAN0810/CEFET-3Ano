import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PesquisaArquivo{
    public static void main(String[] args) throws FileNotFoundException{
        for(String i : args){
            System.out.println(i);
        }
        Scanner ler = new Scanner(System.in);
        String palavra;
        System.out.print("Digite a palavra que você deseja procurar: ");
        palavra = ler.nextLine();

        try{
            FileReader file = new FileReader(args[0]);
            Scanner lerArquivo = new Scanner(file);

            String linha;
            int contador = 0;
            int contadorlinha = 0;

            System.out.print("A palavra " + palavra + " aparece nas linhas ");

            while(lerArquivo.hasNextLine()){
                contador = 0;
                contadorlinha++;

                linha = lerArquivo.nextLine();

                String[] palavras = linha.split("[ , . : ; ! ? - ()]");

                for(int i = 0; i < palavras.length; i++){
                    if (palavras[i].toUpperCase().equals(palavra.toUpperCase())){
                        contador++;
                    }
                }
                if(contador > 0){
                    System.out.print(" " + contadorlinha);
                }
            }
            lerArquivo.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        ler.close();
    }
}


/* Primeira tentativa (Tudo errado)
public class PesquisaArquivo {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Scanner ler = new Scanner(System.in);

        System.out.println("Qual a palavra: ");

        String palavra = ler.nextLine();

        int qnt = 0;

        File arquivo = new File(args[0]);

        try (FileReader reader = new FileReader(arquivo)) {

            BufferedReader buff = new BufferedReader(reader);
            String conteudo;

            while ((conteudo = buff.readLine()) != null) {


                    String[] linha = conteudo.split(" ");

                    if(linha[0].equals(palavra)){
                        qnt++;
                        System.out.println(palavra + " aparece " + qnt + " no texto.");
                    }else{

                        System.out.println("Essa palavra não está no arquivo");
                    }   
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ler.close();

    }

}

*/