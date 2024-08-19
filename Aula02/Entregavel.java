import java.util.List;

public class Entregavel {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(24,3,6,5,7,89,10);
        System.out.println(numbers);

        List<Integer> pares = numbers.stream().filter(n -> n % 2 == 0).toList();
        System.out.println(pares);

        List<Integer> dobro = numbers.stream().map(n -> n *2).toList();
        System.out.println(dobro);

        List<Integer> ordem = numbers.stream().sorted().toList();
        System.out.println(ordem);

        numbers.forEach(n -> System.out.println(n));

    }
}
