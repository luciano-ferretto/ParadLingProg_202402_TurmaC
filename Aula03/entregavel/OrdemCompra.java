package entregavel;

import java.util.List;

public class OrdemCompra {
    private List<Item> itens;

    public void addItem(Item item) {
        itens.add(item);
    }

    public void imprimirRelatorio() {
        // Imprime um relatório da ordem de compra
    }
}

class Item {
    double getPreco() {
        return 2;
    }
}

class Calculadora {
    public double calculaTotalOrdemCompra(List<Item> itens) {
        double total = 0;
        for (Item item : itens) {
            total += item.getPreco();
        }
        return total;
    }
}