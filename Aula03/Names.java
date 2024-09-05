import java.util.List;
import java.util.stream.Stream;

public class Names {
    public static void main(String[] args) {
        List<String> names = List.of("Bob", "Eve", "Alice", "David", "Charlie");
        Stream<String> namesStream = names.stream();
        Stream<String> namesFiltered = namesStream.filter(name -> name.length() > 3);
        Stream<String> namesFilteredMapped = namesFiltered.map(name -> name.toUpperCase());
        Stream<String> namesFilteredMappedSorted = namesFilteredMapped.sorted();
        List<String> newNames = namesFilteredMappedSorted.toList();
        System.out.println(newNames);
        System.out.println(names
            .stream()
            .filter(name -> name.length() > 3)
            .map(name -> name.toUpperCase())
            .sorted()
            .toList()
        );
    }
}
