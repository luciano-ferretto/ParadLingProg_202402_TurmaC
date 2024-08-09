import java.util.Arrays;
import java.util.List;

public class SomaComReduce {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Soma dos números é " + 
            numeros.stream().reduce(0, (a, b) -> a + b));
    }
}


