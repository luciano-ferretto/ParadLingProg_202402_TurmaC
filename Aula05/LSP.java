public class LSP {
    public static void main(String[] args) {
        Cubo cubo = new Cubo(2);
        imprimeArea(cubo);
        imprimeVolume(cubo);
        Quadrado ret = new Quadrado(3);
        imprimeArea(ret);
        imprimeVolume(ret);

    }
    static void imprimeArea(FormaGeometrica forma) {
        System.out.println(forma.calculaArea());
    }
    static void imprimeVolume(FormaGeometrica forma) {
        System.out.println(forma.calculaVolume());
    }
}

abstract class FormaGeometrica {
    double lado;
    abstract double calculaArea();
    abstract double calculaVolume();
}

class Cubo extends FormaGeometrica {
    Cubo(double lado) {
        this.lado = lado;
    }
    @Override
    double calculaArea() {
        return 6 * (lado * lado);
    }
    @Override
    double calculaVolume() {
        return 3 * lado;
    }
}

class Quadrado extends FormaGeometrica {
    Quadrado(double lado) {
        this.lado = lado;
    }
    @Override
    double calculaArea() {
        return lado * lado;
    }
    @Override
    double calculaVolume() {
        //return 0;
        throw new UnsupportedOperationException(
            "Unsupported method 'calculaVolume'");
    }
}
