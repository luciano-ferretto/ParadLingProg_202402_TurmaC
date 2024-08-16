import java.util.function.*;

public class LambdaFunction {
    public static void main(String[] args) {
        // Sem parâmetros
        Runnable greet = () -> System.out.println("Olá, Mundo!");
        greet.run(); // Saída: Olá, Mundo!

        // Com um parâmetro
        Function<Integer, Integer> raiz = x -> x * x;
        System.out.println("O quadrado de 5 é: " + raiz.apply(5));

        // Com múltiplos parâmetros
        BiFunction<Integer, Integer, Integer> soma = (a, b) -> a + b;
        System.out.println("A soma de 10 e 20 é: " + soma.apply(10, 10)); // Saída: A soma de 10 e 20 é: 30

        // Com Bloco de código
        BiFunction<Integer, Integer, String> divisibilityCheck = (a, b) -> {
            if (b == 0) {
                return "Divisão por zero não é permitida!";
            }
            return a % b == 0 ? a + " é divisível por " + b : a + " não é divisível por " + b;
        };
        System.out.println(divisibilityCheck.apply(10, 2)); // Saída: 10 é divisível por 2
        System.out.println(divisibilityCheck.apply(10, 3)); // Saída: 10 não é divisível por 3


        // EXEMPLOS DAS PRINCIPAIS INTERFACES FUNCIONAIS
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println(stringLength.apply("Hello")); // Saída: 5
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(2, 3)); // Saída: 5

        Consumer<String> print = s -> System.out.println(s);
        print.accept("Hello World"); // Saída: Hello World
        BiConsumer<String, Integer> printStringAndLength = (s, len) -> System.out.println(s + " tem comprimento " + len);
        printStringAndLength.accept("Hello", 5); // Saída: Hello tem comprimento 5

        Supplier<Double> randomValue = () -> Math.random();
        System.out.println(randomValue.get()); // Saída: um número aleatório entre 0.0 e 1.0

        Predicate<Integer> isPositive = n -> n > 0;
        System.out.println(isPositive.test(5)); // Saída: true
        System.out.println(isPositive.test(-5)); // Saída: false
        BiPredicate<String, Integer> isStringLengthEqual = (s, len) -> s.length() == len;
        System.out.println(isStringLengthEqual.test("Hello", 5)); // Saída: true
        
        UnaryOperator<Integer> square = n -> n * n;
        System.out.println(square.apply(4)); // Saída: 16
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        System.out.println(multiply.apply(3, 5)); // Saída: 15

    }
}
