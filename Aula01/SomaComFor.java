import java.util.Arrays;
import java.util.List;

public class SomaComFor {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        int soma = 0;
        for (Integer numero : numeros) {
            soma += numero;
        }

        System.out.println("Soma dos números é " + soma);
    }
}





