public class Turma extends Funcionario{
    
    private String turma;
    
    Turma(String id, String nome, String email, String senha, String cargo, String setor){
        super(id, nome, email, senha, cargo);
        this.turma = turma;
    }

    public String ToString(){
        return String.format("Dados: %s\nNome: %s\nEmail: %s\nSenha: %s\nCargo: %s\n", id, nome, email, ImprimeSenha(senha), cargo);
    }
}
