import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.function.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
       /* if (b == 0){
            System.out.println("b не может быть равно 0");
            return;
        }*/
        try {
            int c = calc.devide.apply(a, b);
            calc.println.accept(c);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException" + e.getMessage());
        }
    }
}

class Calculator {
    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> x / y;

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;
}
