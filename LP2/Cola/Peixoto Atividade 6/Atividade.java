import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.IOException;
import java.util.Scanner;

public class Atividade {
    public static void main(String[] args) throws FileNotFoundException {
        for (String i : args) {
            System.out.println(i);

        }
        Scanner leitura = new Scanner(System.in);
        String palavra;
        System.out.print("Digite a palavra que você deseja procurar: ");
        palavra = leitura.nextLine();

        try {
            FileReader file = new FileReader(args[0]);
            Scanner ler = new Scanner(file);
            String linha;
            int contador = 0;
            int contadorlinha = 0;
            System.out.print("A palavra " + palavra + " aparece nas linhas ");
            while (ler.hasNextLine()) {
                contador = 0;
                contadorlinha++;
                linha = ler.nextLine();
                String[] palavras = linha.split(" ");

                for (int i = 0; i < palavras.length; i++) {
                    if (palavras[i].toUpperCase().equals(palavra.toUpperCase())) {
                        contador++;
                    }
                }
                if (contador > 0) {
                    System.out.print(" " + contadorlinha);
                }

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}