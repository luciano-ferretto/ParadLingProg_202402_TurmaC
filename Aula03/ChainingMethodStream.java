import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ChainingMethodStream {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // Criação do stream
        Stream<String> nameStream = names.stream();

        // Filtragem dos nomes
        Stream<String> filtStream = nameStream.filter(name -> name.length() > 3);

        // Mapeamento para maiúsculas
        Stream<String> filtAndMapStream = filtStream.map(name -> name.toUpperCase());

        // Ordenação dos nomes
        Stream<String> filtAndMapAndSortedStream = filtAndMapStream.sorted();

        // Coleta em uma lista
        List<String> newListNames = filtAndMapAndSortedStream.toList();
        //List<String> newListNames = filtAndMapAndSortedStream.collect(Collectors.toList());
        
        System.out.println(newListNames);

        List<String> newListNames2 = names.stream()
            .filter(name -> name.length() > 3)
            .map(name -> name.toUpperCase())
            .sorted()
            .toList();

        System.out.println(newListNames2);
    }
    
}