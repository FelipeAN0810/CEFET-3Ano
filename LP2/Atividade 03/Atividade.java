import java.util.Scanner;

class Aluno{
    int Senha, Grupo, SubTurma;
    String Nome, Matricula;

    public Aluno(int NewSenha, int NewGrupo, int NewSubTurma, String NewNome, String NewMatricula){
        Senha = NewSenha;
        Nome = NewNome;
        Matricula = NewMatricula;
        Grupo = NewGrupo;
        SubTurma = NewSubTurma;
    }

    public String MostraTudo(){
        return "Aluno: " + Nome + ", Matricula: " + Matricula + ", Grupo: " + Grupo + ", Subturma: " + SubTurma; 

        for(int i = 0; i < 9; i++)
        {
            System.out.print("*");
        }
    }

    public void Setagem(int SetSenha, int SetGrupo, int SetSubTurma, String SetNome, String SetMatricula){

        Nome = SetNome;
        Matricula = SetMatricula;
        Grupo = SetGrupo;
        SubTurma = SetSubTurma;
        Senha = SetSenha;

        System.out.print("Aluno Cadastrado!");
    }
}

public class Atividade{
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        
        Aluno MoldeAluno = new Aluno(1, 1, 1, "Ana Beatriz", "123321");

        String Nome1, Matricula1;
        int Senha1, Grupo1, SubTurma1;

        System.out.print("\nQual o seu nome? R: ");
        Nome1 = ler.nextLine();
        System.out.print("\nQual a sua matricula? R: ");
        Matricula1 = ler.nextLine();
        System.out.print("\nQual o seu grupo? R: ");
        Grupo1 = ler.nextInt();
        System.out.print("\nQual a sua SubTurma? R: ");
        SubTurma1 = ler.nextInt();
        System.out.print("\nDefina uma senha de inteiros? R: ");
        Senha1 = ler.nextInt();

        MoldeAluno.Setagem(Senha1, Grupo1, SubTurma1, Nome1, Matricula1);
    }

    
}




