public class Funcionario{
    protected String id, nome, email, senha, cargo;

    public Funcionario(String id, String nome, String email, String senha, String cargo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
    }

    public String ImprimeSenha(String senha){
        String escondesenha = "";
        for (int i = 0; i < senha.length(); i++) {
            escondesenha += "*";
        }
        return escondesenha;
    }


    public String ToString(){
        return String.format("Dados: %s\nNome: %s\nEmail: %s\nSenha: %s\nCargo: %s\n", id, nome, email, ImprimeSenha(senha), cargo);
    }
}


/*
    public void CSV(){
        String Id, Nome, Email, Cargo, Turma, Setor;

        String [] cabecalho = {Id, Nome, Email, Cargo, Turma, Setor};
        
        List<String[]> linhas = new ArrayList<>();
        linhas.add(new String[]{Id, Nome, Email, Cargo, Turma, Setor});

        Writer writer = Files.newBufferWriter(Paths.get("pessoal.csv"));
        csvWriter csvWriter = new CSVWriter(writer);

        csvWriter.writeNext(cabecalho);
        csvWriter.writeAll(linhas);

        csvWriter.flush();
        writer.close();
        

        https://dicasdejava.com.br/como-escrever-arquivos-csv-em-java/
    }
*/