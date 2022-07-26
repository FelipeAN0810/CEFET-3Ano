public class Setor extends Funcionario{
    
    private String setor;
    public Setor(String id, String nome, String email, String senha, String cargo, String values) {
        super(id, nome, email, senha, cargo);
        this.setor = setor;
    }

    public String ToString(){
        return String.format("Dados: %s\nNome: %s\nEmail: %s\nSenha: %s\nCargo: %s\n", id, nome, email, ImprimeSenha(senha), cargo);
    }
}