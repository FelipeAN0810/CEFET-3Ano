import java.io.*;
import java.util.*;

public class Movel{
    protected static int numeroRodas;
    protected static String fabricantes;
    protected static int anoFabricacao;
    private static int velocidade;
    public static int velocidadeNova;


    public static void main(String[] args) {
        //Ainda não sei o que colocar no Main
        recebeMain();
    }


    /*public Movel(int rodas, int fabri, int anoFa, int veloc, int cilin, int numPa, int volum, int pesoM) {
    }*/

    public static void recebeMain(){
        Scanner ler = new Scanner (System.in);

        System.out.println("Quantas rodas possuem o veiculo? ");
        numeroRodas = ler.nextInt();
        ler.nextLine();
        System.out.println("Qual o fabricante? ");
        fabricantes = ler.nextLine();
        System.out.println("Qual o ano de fabricação? ");
        anoFabricacao = ler.nextInt();
        System.out.println("Qual a velocidade do veiculo? ");
        velocidadeNova = ler.nextInt();
        
        ler.close();
    }

    public int getVelocidade(){
        return velocidade;
    }

    public void setVelocidade(int velocidadeNova){
        this.velocidade = velocidadeNova;
    }
    
    
    /* Tentativa de fazer a questão 3
    class OpenTXTFile {

        public ArrayList<Movel> LerTXT(String file) {
        Scanner scanner;
        File txt = new File(file);
        ArrayList<Movel> vetorDeitens = new ArrayList<>();
    
        try {
            scanner = new Scanner(txt);
            scanner.nextLine();
    
            while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split("[;]");
              //pass values of line to integer
                int rodas = Integer.parseInt(line[0]);
                int fabri = Integer.parseInt(line[1]);
                int anoFa = Integer.parseInt(line[2]);
                int veloc = Integer.parseInt(line[3]);
                int cilin = Integer.parseInt(line[4]);
                int numPa = Integer.parseInt(line[5]);
                int volum = Integer.parseInt(line[6]);
                int pesoM = Integer.parseInt(line[7]);
            
            Movel itens = new Movel(rodas, fabri, anoFa, veloc, cilin, numPa, volum, pesoM);

            vetorDeitens.add(itens);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return vetorDeitens;
        }
    }

    public String ToString(){
        return String.format("NumRodas: %s;Fabricante: %s;Ano Fabricação: %s;Velocidade: %s\n",numeroRodas, fabricantes, anoFabricacao, velocidadeNova);
    }
    */
}