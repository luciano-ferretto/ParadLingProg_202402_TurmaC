public class FatorialExamples {
    public static long fatorialIterativo(int n) {
        long resultado = n;
        for (long i = n - 1; i > 1; i--) {
            resultado *= i;
        }
        return resultado;
    }

    public static long fatorialRecursivo(int n) {
        if (n == 0 || n == 1) return 1;
        return n * fatorialRecursivo(n - 1);
    }
    
    public static void main(String[] args) {
        int n = 50; // Você pode ajustar esse valor para testar com diferentes entradas
        
        // Teste do método recursivo
        long startTimeRecursivo = System.nanoTime();
        long resultadoRecursivo = fatorialRecursivo(n);
        long endTimeRecursivo = System.nanoTime();
        
        long durationRecursivo = endTimeRecursivo - startTimeRecursivo;
        System.out.println("Resultado Recursivo: " + resultadoRecursivo);
        System.out.println("Tempo de Execução Recursivo: " + durationRecursivo + " nanosegundos");
        
        // Teste do método iterativo
        long startTimeIterativo = System.nanoTime();
        long resultadoIterativo = fatorialIterativo(n);
        long endTimeIterativo = System.nanoTime();
        
        long durationIterativo = endTimeIterativo - startTimeIterativo;
        System.out.println("Resultado Iterativo: " + resultadoIterativo);
        System.out.println("Tempo de Execução Iterativo: " + durationIterativo + " nanosegundos");
    }
}
