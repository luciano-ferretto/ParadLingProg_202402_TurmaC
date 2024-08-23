package entregavel;

// Classe para calcular áreas e volumes
public class CalculadoraMedidas {
    public double calculaArea(FormaGeometrica formaGeometrica) {
        return formaGeometrica.calculaArea();
    }

    public double calculaVolume(FormaGeometrica formaGeometrica) {
        return formaGeometrica.calculaVolume();
    }

    public static void main(String[] args) {
        FormaGeometrica circle = new Circulo(5);
        FormaGeometrica cube = new Cubo(3);

        CalculadoraMedidas calculator = new CalculadoraMedidas();
        System.out.println("Área do círculo: " + calculator.calculaArea(circle));
        System.out.println("Área do cubo: " + calculator.calculaArea(cube));
        System.out.println("Volume do cubo: " + calculator.calculaVolume(cube));
    }
}

// Classe abstrata FormaGeometrica
abstract class FormaGeometrica {
    public abstract double calculaArea();
    public abstract double calculaVolume();
}

// Implementações de Formas Geométricas
class Circulo extends FormaGeometrica {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double calculaArea() {
        return Math.PI * raio * raio;
    }

    @Override
    public double calculaVolume() {
        throw new UnsupportedOperationException("Círculos não possuem Volume");
    }
}

class Cubo extends FormaGeometrica {
    private double lado;

    public Cubo(double lado) {
        this.lado = lado;
    }

    @Override
    public double calculaArea() {
        return 6 * lado * lado;
    }

    @Override
    public double calculaVolume() {
        return lado * lado * lado;
    }
}


