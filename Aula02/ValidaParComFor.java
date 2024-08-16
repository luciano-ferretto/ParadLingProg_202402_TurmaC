import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidaParComFor {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(0, 1, 2, 3,4,5, 6, 7, 8, 10);
        //Crio uma nova lista que irá receber somente os valores PAR 
        // da lista original
        List<Integer> listaPar = new ArrayList<>();
        //Interajo com a lista original através do For-each
        // adiciionando na nova lista somente os valores Pares
        for (Integer numero : lista) {
            if (numero % 2 == 0) listaPar.add(numero);
        }
        //Imprimo a nova lista
        System.out.println(listaPar);
    }
}


