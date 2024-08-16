import java.util.Arrays;
import java.util.List;

public class ValidaParComFilter {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(0, 1, 2, 3,4,5, 6, 7, 8, 10);
        //Aqui estou usando vários conceitos de programação Funcional
        // Funções Lambda: numero -> numero % 2 == 0
        // Funções de Ordem Superior: filter()
        // Imutabilidade: A lista original não é alterada
        // Programação Declarativa: 
        //      Descrevo O QUE desejo fazer com os dados (filtrar pares)
        //      sem me preocupar com o COMO os dados são iterados ou armazenados.
        List<Integer> listaPar = lista.stream().filter(numero -> numero % 2 == 0).toList();
        System.out.println(listaPar);
    }
}


