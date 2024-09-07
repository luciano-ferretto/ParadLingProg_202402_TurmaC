import java.util.Arrays;
import java.util.List;

public class Lista {
    public static void main(String[] args) {
        List<String> listaABC = List.of("A", "B", "C");
        List<Integer> lista123 = Arrays.asList(1, 2, 3);
        
        //listaABC.set(0, "a");

        lista123.remove(1);
    }
}
