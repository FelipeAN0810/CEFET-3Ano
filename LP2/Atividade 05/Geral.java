import java.io.*;
import java.util.*;

public class Geral{

    public static void main(String[] args){

        boolean continuar = false;

        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

        Scanner ler = new Scanner (System.in);

        System.out.println("Você deseja ver o arquivo? \n 1 - Sim \n 2 - Não");
        int escolha = ler.nextInt();
        if (escolha == 1){
            try{
                String FileName = "pessoal.csv";
                funcionarios = ReadCSVFile.readCSV(FileName, funcionarios);

                System.out.println("Arquivo lido com pelo programa com sucesso!");
            } catch(IOException e){
                System.out.println("Erro ao ler o arquivo");
            }
        }
        
        System.out.println("Deseja cadastrar funcionario? \n 1 - Sim \n 2 - Não");
        int escolha2 = ler.nextInt();

        if(escolha2 == 1){
            do{
                System.out.println("Insira os dados do funcionário:");
                System.out.println("Id:");
                ler.nextLine();
                String id = ler.nextLine();

                System.out.println("Nome:");
                String nome = ler.nextLine();

                System.out.println("Email:");
                String email = ler.nextLine();

                System.out.println("Senha:");
                String senha = ler.nextLine();

                System.out.println("Cargo:");
                System.out.println("1 - Geral");
                System.out.println("2 - Docente");
                System.out.println("3 - Discente");
                int lercargo = ler.nextInt();

                if(lercargo == 1){
                    Funcionario funcionario = new Funcionario(id, nome, email, senha, "Geral");
                    funcionarios.add(funcionario);

                }else if(lercargo == 2){

                    System.out.println("Insira o Setor: ");
                    String setor = ler.nextLine();

                    String cargo = "Docente";
                    Setor func = new Setor(id, nome, email, senha, cargo, setor);
                    funcionarios.add(func);
                }

                System.out.println("Deseja cadastrar outro funcionario? \n 1 - Sim \n 2 - Não");
                int lercontinua = ler.nextInt();
                if(lercontinua == 1){
                    continuar = true;
                }else{
                    continuar = false;
                }
            }while(continuar);
        }

        System.out.println("Funcionários: ");
        
        for(Funcionario funcionario : funcionarios){
            System.out.println(funcionario.ToString());
        }
        ler.close();
    }
}

