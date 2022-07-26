import java.io.*;
import java.util.*;


class Esportivo extends Movel{
    /*public Esportivo(int rodas, int fabri, int anoFa, int veloc, int cilin, int numPa, int volum, int pesoM) {
        super(rodas, fabri, anoFa, veloc, cilin, numPa, volum, pesoM);

    }*/

    private int cilindradas;
    private int numPassageiros;
    public int cilindros;
    public int novoNumPassageiros;

    public void recebe(){
        Scanner ler1 = new Scanner (System.in);

        System.out.println("Quantas cilindradas o veiculo possui? ");
        cilindros = ler1.nextInt();

        System.out.println("Quantos passageiros? ");
        novoNumPassageiros = ler1.nextInt();

        ler1.close();
        
        super.toString();
    }

    public int getDados1(){
        return cilindradas;
    }
    public int getDados2(){
        return numPassageiros;
    }

    public void Dados(int cilindros, int passageiros){
        this.cilindradas = cilindros;
    }

    public void setNumPassageiros(int novoNumPassageiros){

        //Meu compilador tá bugado e só aceitou assim
        if(novoNumPassageiros > 0){
            if(novoNumPassageiros < 5){
                this.numPassageiros = novoNumPassageiros;
            }
            
        }
    }
}
