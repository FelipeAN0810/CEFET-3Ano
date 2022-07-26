import java.util.Scanner;

public class Questao4 {

    public static void main(String[] args){
		Scanner recebe = new Scanner(System.in);
		
		float imc = 0, peso = 0, altura = 0;
		
		System.out.printf("Informe seu peso em Kg: ");
		peso = recebe.nextInt();
		
		System.out.printf("\nInforme sua altura em metros: ");
		altura = recebe.nextInt();
		
		imc = (peso)/(altura * altura);
		
		if (imc < 18.5)
			System.out.printf("MAGREZA: %f", imc);
		else if(imc > 18.5 && imc < 24.9)
			System.out.printf("Normal: %f", imc);
		else if(imc > 25.0 && imc < 29.9)
			System.out.printf("Sobrepeso: %f", imc);
		else
			System.out.printf("Obesidade: %f", imc);
	}
}