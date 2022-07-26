import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;

public class TrabPratico {

    public static void main(String[] args) throws FileNotFoundException {

        Algoritimos algoritimos = new Algoritimos();
        LerArquivo novoleitor = new LerArquivo();
        ArrayList<String> nomes = new ArrayList<String>();
        EscreveArquivo escrevearquvio = new  EscreveArquivo();

        //ENTRADAS DO METODO INSERTIONSORT
        //100 ALE

        
        nomes = novoleitor.lerarquivo("entrada-100-ale.txt");
        long tempoInicial = System.currentTimeMillis();
        algoritimos.insertionSort(nomes);
        long tempoFinal = System.currentTimeMillis();
        long tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"insertionSort-100-ale");
        System.out.println("o metodo insertionSort executou em " + (tempo) + " milesegundos no arquivo de 100 entradas aleatorias");
        
        //100 CRE
        nomes = novoleitor.lerarquivo("entrada-100-cre.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.insertionSort(nomes);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"insertionSort-100-cre");
        System.out.println("o metodo insertionSort executou em " + (tempo) + " milesegundos no arquivo de 100 entradas crescente");

        // 100 DEC
        nomes = novoleitor.lerarquivo("entrada-100-dec.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.insertionSort(nomes);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"insertionSort-100-dec");
        System.out.println("o metodo insertionSort executou em " + (tempo) + " milesegundos no arquivo de 100 entradas decrescente");

        // 1000 ALE
        nomes = novoleitor.lerarquivo("entrada-1000-ale.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.insertionSort(nomes);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"insertionSort-1000-ale");
        System.out.println("o metodo insertionSort executou em " + (tempo) + " milesegundos no arquivo de 1000 entradas aleatorias");

        // 100 CRE
        nomes = novoleitor.lerarquivo("entrada-1000-cre.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.insertionSort(nomes);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"insertionSort-1000-cre");
        System.out.println("o metodo insertionSort executou em " + (tempo) + " milesegundos no arquivo de 1000 entradas crescentes");

        // 1000 DEC
        nomes = novoleitor.lerarquivo("entrada-1000-dec.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.insertionSort(nomes);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"insertionSort-1000-dec");
        System.out.println("o metodo insertionSort executou em " + (tempo) + " milesegundos no arquivo de 1000 entradas decrescentes");

        // 10000 ALE
        nomes = novoleitor.lerarquivo("entrada-10000-ale.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.insertionSort(nomes);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"insertionSort-10000-ale");
        System.out.println("o metodo insertionSort executou em " + (tempo) + " milesegundos no arquivo de 10000 entradas aleatorias");

        // 10000 CRE
        nomes = novoleitor.lerarquivo("entrada-10000-cre.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.insertionSort(nomes);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"insertionSort-10000-cre");
        System.out.println("o metodo insertionSort executou em " + (tempo) + " milesegundos no arquivo de 10000 entradas crescentes");

        // 10000 DEC
        nomes = novoleitor.lerarquivo("entrada-10000-dec.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.insertionSort(nomes);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"insertionSort-10000-dec");
        System.out.println("o metodo insertionSort executou em " + (tempo) + " milesegundos no arquivo de 1000 entradas decrescentes");

        //ENTRADAS DO METODO SHELL_SORT
        // 100 ALE
        nomes = novoleitor.lerarquivo("entrada-100-ale.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.shellSort(nomes);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"shellSort-100-ale");
        System.out.println("o metodo Shell_Sort executou em " + (tempo) + " milesegundos no arquivo de 100 entradas aleatorias");

        //100 CRE
        nomes = novoleitor.lerarquivo("entrada-100-cre.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.shellSort(nomes);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"shellSort-100-cre");
        System.out.println("o metodo Shell_Sort executou em " + (tempo) + " milesegundos no arquivo de 100 entradas crescentes");

        // 100 DEC
        nomes = novoleitor.lerarquivo("entrada-100-dec.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.shellSort(nomes);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"shellSort-100-dec");
        System.out.println("o metodo Shell_Sort executou em " + (tempo) + " milesegundos no arquivo de 100 entradas decrescente");

        // 1000 ALE
        nomes = novoleitor.lerarquivo("entrada-1000-ale.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.shellSort(nomes);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"shellSort-1000-ale");
        System.out.println("o metodo Shell_Sort executou em " + (tempo) + " milesegundos no arquivo de 1000 entradas aleatorias");

        // 1000 CRE
        nomes = novoleitor.lerarquivo("entrada-1000-cre.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.shellSort(nomes);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"shellSort-1000-cre");
        System.out.println("o metodo Shell_Sort executou em " + (tempo) + " milesegundos no arquivo de 1000 entradas crescente");

        // 1000 DEC
        nomes = novoleitor.lerarquivo("entrada-1000-dec.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.shellSort(nomes);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"shellSort-1000-dec");
        System.out.println("o metodo Shell_Sort executou em " + (tempo) + " milesegundos no arquivo de 1000 entradas decrescente");

        // 10000 ALE
        nomes = novoleitor.lerarquivo("entrada-10000-ale.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.shellSort(nomes);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"shellSort-10000-ale");
        System.out.println("o metodo Shell_Sort executou em " + (tempo) + " milesegundos no arquivo de 10000 entradas aleatorias");

        // 10000 CRE
        nomes = novoleitor.lerarquivo("entrada-10000-cre.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.shellSort(nomes);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"shellSort-10000-cre");
        System.out.println("o metodo Shell_Sort executou em " + (tempo) + " milesegundos no arquivo de 10000 entradas crescente");

        // 10000 DEC
        nomes = novoleitor.lerarquivo("entrada-10000-dec.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.shellSort(nomes);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"shellSort-10000-dec");
        System.out.println("o metodo Shell_Sort executou em " + (tempo) + " milesegundos no arquivo de 10000 entradas decrescente");


        //ENTRADAS DO METODO MERGESORT
        // 100 ALE
        nomes = novoleitor.lerarquivo("entrada-100-ale.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.mergeSort(nomes, 0, nomes.size()-1);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"mergeSort-100-ale");
        System.out.println("o metodo mergeSort executou em " + (tempo) + " milesegundos no arquivo de 100 entradas aleatorias");


        //100 CRE  
        nomes = novoleitor.lerarquivo("entrada-100-cre.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.mergeSort(nomes, 0, nomes.size()-1);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"mergeSort-100-cre");
        System.out.println("o metodo mergeSort executou em " + (tempo) + " milesegundos no arquivo de 100 entradas crescentes");

        
        // 100 DEC
        nomes = novoleitor.lerarquivo("entrada-100-dec.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.mergeSort(nomes, 0, nomes.size()-1);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"mergeSort-100-dec");
        System.out.println("o metodo mergeSort executou em " + (tempo) + " milesegundos no arquivo de 100 entradas decrescentes");

        
        // 1000 ALE
        nomes = novoleitor.lerarquivo("entrada-1000-ale.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.mergeSort(nomes, 0, nomes.size()-1);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"mergeSort-1000-ale");
        System.out.println("o metodo mergeSort executou em " + (tempo) + " milesegundos no arquivo de 1000 entradas aleatorias");

        
        // 1000 CRE
        nomes = novoleitor.lerarquivo("entrada-1000-cre.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.mergeSort(nomes, 0, nomes.size()-1);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"mergeSort-1000-cre");
        System.out.println("o metodo mergeSort executou em " + (tempo) + " milesegundos no arquivo de 1000 entradas crescente");

        
        // 1000 DEC
        nomes = novoleitor.lerarquivo("entrada-1000-dec.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.mergeSort(nomes, 0, nomes.size()-1);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"mergeSort-1000-dec");
        System.out.println("o metodo mergeSort executou em " + (tempo) + " milesegundos no arquivo de 1000 entradas decrescente");

        
        // 10000 ALE
        nomes = novoleitor.lerarquivo("entrada-10000-ale.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.mergeSort(nomes, 0, nomes.size()-1);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"mergeSort-10000-ale");
        System.out.println("o metodo mergeSort executou em " + (tempo) + " milesegundos no arquivo de 10000 entradas aleatorias");

        
        // 10000 CRE
        nomes = novoleitor.lerarquivo("entrada-10000-cre.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.mergeSort(nomes, 0, nomes.size()-1);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"mergeSort-10000-cre");
        System.out.println("o metodo mergeSort executou em " + (tempo) + " milesegundos no arquivo de 10000 entradas crescentes");

        
        // 10000 DEC
        nomes = novoleitor.lerarquivo("entrada-10000-dec.txt");
        tempoInicial = System.currentTimeMillis();
        algoritimos.mergeSort(nomes, 0, nomes.size()-1);
        tempoFinal = System.currentTimeMillis();
        tempo = tempoFinal - tempoInicial;
        escrevearquvio.Escrevendo(nomes,"mergeSort-10000-dec");
        System.out.println("o metodo mergeSort executou em " + (tempo) + " milesegundos no arquivo de 10000 entradas decrescentes");
    }

}

class Algoritimos {

    public void insertionSort(ArrayList<String> valores) {
        

        for (int i = 1; i < valores.size(); i++) {
            int j = i;

            while (j > 0 && valores.get(j).compareTo(valores.get(j - 1)) < 0) {
                String aux = valores.get(j);
                // valores.add(j) = valores.get(j - 1);
                valores.set(j, valores.get(j - 1));
                // valores.add(j - 1) = aux;
                valores.set((j - 1), aux);
                j -= 1;
            }

        }
        
    }

    public void shellSort(ArrayList<String> valores) {
        

        int h = 1;
        int tam = valores.size();

        while (h < tam) {
            h = h * 3 + 1;
        }
        // arredonda h para baixo, fazendo assim seu valor ser de 4
        h = (int) Math.floor(h / 3);

        int cont;
        String elemento;
        while (h > 0) {
            for (int i = h; i < tam; i++) {
                elemento = valores.get(i);
                cont = i;
                while (cont >= h && valores.get(cont - h).compareTo(elemento) > 0) {
                    // valores[cont] = valores[cont - h];
                    valores.set(cont, valores.get(cont - h));
                    cont = cont - h;
                }
                // valores[cont] = elemento;
                valores.set(cont, elemento);

            }
            h = h / 2;
        }
        
    }

    void merge(ArrayList<String> arr, int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;

        String L[] = new String[n1];
        String M[] = new String[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr.get(p + i);
        for (int j = 0; j < n2; j++)
            M[j] = arr.get(q + 1 + j);

        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        while (i < n1 && j < n2) {
            if (L[i].compareTo(M[j]) <= 0) {
                arr.set(k, L[i]);
                i++;
            } else {
                arr.set(k, M[j]);
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr.set(k, L[i]);
            i++;
            k++;
        }

        while (j < n2) {
            arr.set(k, M[j]);
            j++;
            k++;
        }

    }

    public void mergeSort(ArrayList<String> arr, int l, int r) {
        if (l < r) {

            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }
}

class LerArquivo {

    public ArrayList<String> lerarquivo(String caminho) throws FileNotFoundException {
        FileReader arquivo = new FileReader(caminho);
        Scanner ler = new Scanner(arquivo);

        ArrayList<String> linhas = new ArrayList<String>();

        ler.nextLine();
        while (ler.hasNext()) {
            linhas.add(ler.nextLine());
        }

        ler.close();

        return linhas;
    }

}

class EscreveArquivo{

    public void Escrevendo(ArrayList<String> nomes, String NomeArquivo) throws FileNotFoundException{
        File arquivo = new File(NomeArquivo + ".csv");
        PrintWriter pw =  new PrintWriter(arquivo);

        for(int i = 0; i < nomes.size(); i ++){
            pw.println(nomes.get(i));
        }

        pw.close();
    }
}
