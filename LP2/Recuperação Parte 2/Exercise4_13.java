public class Exercise4_13 {
    class Fibo{
        public int Fibonacci(int i) {
            if(i<=2){
                return 1;
            } else {
                return Fibonacci(i-1) + Fibonacci(i-2);
            }
        }
    }
}

//A segunda resposta é porque ele não consegue aproveitar os calculos anteriores, e sim recalcular os valores, os abrindo exponencialmente.

/*3

public static int Fibo(int i) {
    return (i <= 2) ? 1 : Fibonacci(i-1) + Fibonacci(i-2);
}
*/