public class ChainingMethodWithPersons {
    public static void main(String[] args) {
        // Invocando um método Estático
        // Este método retorna uma nova instância da classe Person (novo objeto)
        Person pessoa = Person.build();
        // Invocando um método de Instância
        // Deve ser usado uma variável que referencia um objeto na memória
        pessoa.toString();

        // Criação (Instanciação) de um objeto do tipo "Person"
        Person pessoa01 = new Person(); // Através do "new"
        pessoa01 = Person.build(); // Ou Através do método estático para build
        // Invocar métodos para alterar atributos (uma linha para cada atributo)
        pessoa01.setName("Silvio Santos");
        pessoa01.setAge(93);
        // Imprime na tela os dados desse objeto:
        System.out.println(pessoa01.toString());

        // Tentativa de usar o Method Chaining em uma Classe não preparada
        // Pois o método "setName()" NÃO retorna nada (VOID)
        // sendo assim "nada (void)" não pode invocar nenhum método
        /* -------- CÓDIGO COM ERRO
        Person pessoa02 = Person.build().setName("Senor Abravanel").setAge(93);
        System.out.println(pessoa02.toString());
         -----------*/

        // Exemplo de Chaining Method possível
        // Primeiro é invocado o método "Static" "build()" a partir da Classe
        // Esse método retorna um novo Objeto do tipo "PersonExampleChainingMethod"
        // A partir desse objeto é invocado o método "setName()"
        // Esse método retorna o próprio Objeto "PersonExampleChainingMethod"
        // A partir desse retorno invocamos o método "setAge()"
        // Esse método retorna o próprio Objeto "PersonExampleChainingMethod"
        // Por fim o Objeto "PersonExampleChainingMethod" criado é referenciado pela
        // variável "pessoa03"
        PersonWithChainingMethod pessoa03 = PersonWithChainingMethod.build().setName("Raul Seixas").setAge(44);
        System.out.println(pessoa03); // Imprime na tela os dados da Pessoa - implicitamente invoca o método
                                      // "toString()"

        // Se não precisamos manter esse objeto em memória,
        // podemos fazer todo o processo e jogar o resultado diretamente para o método
        // "println()"
        System.out.println(PersonWithChainingMethod.build().setName("Carrie Fisher").setAge(60));

        System.out.println(
                PersonWithChainingMethod
                        .build()
                        .setName("Carrie Fisher")
                        .setAge(60)
                        .toString());

    }
}
