/* Tentativa 1: Deu MUITO ERRADO
import java.util.Scanner;

public class Questao1 {
	public static void main(String args[]){
	
    // Declarando variaveis
    int numero = 0, individual[], i = 0;

    individual = new int[4];

    //Para receber um valor.
    Scanner recebe = new Scanner(System.in);

    //Acoplando a uma variável
    System.out.println("Informe 5 numeros:");

    for( i = 0; i <= 5; i++){
        individual[i] = recebe.nextInt();
    }

    for(i = 0; i <= 5; i++){
        System.out.println(individual[i]);
    }
	}
}*/


//Depois de uma pesquisa
import java.util.LinkedList;
import java.util.Scanner;

public class Questao1 {

    public static void main(String[] args){
        int numero = 0;
		Scanner Recebe = new Scanner(System.in);

		System.out.println("Digite um número de 5 casas");
		numero = Recebe.nextInt();

        LinkedList<Integer> stack = new LinkedList<Integer>();
        while(numero > 0){
            stack.push(numero % 10);
            numero = numero / 10;
        }
        while ((!stack.isEmpty())){
            System.out.println(stack.pop());
        }
    }
}
