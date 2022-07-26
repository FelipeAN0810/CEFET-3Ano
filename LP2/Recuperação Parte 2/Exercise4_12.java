public class Exercise4_12 {
    class conta{
        public double saldo;
        public String titular;
        public String numero;
        public String agencia;
        public String dataAbertura;

        void sacar(double valor){
            this.saldo -= valor;
        }

        void depositar(double valor){
            this.saldo += valor;
        }

        double rendimento(){
            return this.saldo * 0.1;
        }

        String recuperarDadosParaImpressao(){
            String dados = "Titular: " + this.titular + "\n";
            dados += "Número: " + this.numero + "\n";
            dados += "Agência: " + this.agencia + "\n";
            dados += "Data de abertura: " + this.dataAbertura + "\n";
            dados += "Saldo: " + this.saldo + "\n";
            return dados;
        }
    }

    public static void main(String[] args) {
        //Professor, não consegui resolver esse erro, o senhor sabe o que está errado?
        conta c1 = new conta();
        c1.titular = "João";
        c1.numero = "1235";
        c1.agencia = "567890";
        c1.dataAbertura = "01012019";
        c1.saldo = 100;
        c1.sacar(50);
        c1.depositar(50);
        System.out.println("saldo atual:" + c1.saldo);
        System.out.println("rendimento  mensal:" + c1.rendimento());


        conta c2 = new conta();
        c2.titular = "João";
        c2.numero = "1235";
        c2.agencia = "567890";
        c2.dataAbertura = "01012019";
        c2.saldo = 100;
        c2.sacar(50);
        c2.depositar(50);
        System.out.println("saldo atual:" + c2.saldo);
        System.out.println("rendimento  mensal:" + c2.rendimento());

        if (c1 == c2){
            System.out.println("as contas são iguais");
        }else{
            System.out.println("as contas são diferentes");
        }

        
    }
}
