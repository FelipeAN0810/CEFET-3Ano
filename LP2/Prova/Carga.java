import java.io.*;
import java.util.*;

class Carga extends Movel{
    /*public Carga(int rodas, int fabri, int anoFa, int veloc, int cilin, int numPa, int volum, int pesoM) {
        super(rodas, fabri, anoFa, veloc, cilin, numPa, volum, pesoM);
        
    }*/

    private int volumeMaximo;
    private int pesoMaximo;
    public int volume;
    public int peso;

    public void recebe1(){
        Scanner ler1 = new Scanner (System.in);

        System.out.println("Qual o volume suportado? ");
        volume = ler1.nextInt();

        System.out.println("Quantos Kg? ");
        peso = ler1.nextInt();

        ler1.close();

        super.toString();
    }

    public int getDados1(){
        return volumeMaximo;
    }
    public int getDados2(){
        return pesoMaximo;
    }

    public void Dados(int cilindros, int passageiros){
        this.volumeMaximo = volume;
        this.pesoMaximo = peso;
    }


}
