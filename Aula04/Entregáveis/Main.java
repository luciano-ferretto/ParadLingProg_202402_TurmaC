import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Lista imutável usando List.of()
        List<String> listaImutavel = List.of("A", "B", "C");

        // Lista de tamanho fixo usando Arrays.asList()
        List<String> listaTamanhoFixo = Arrays.asList("X", "Y", "Z");

        // Testando operações de adição e remoção
        listaImutavel.add("D"); // O que acontece aqui?
        listaTamanhoFixo.remove("X"); // E aqui?
    }
}


