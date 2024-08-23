package entregavel;

public class Pedido {
    private Fatura fatura;

    public Pedido() {
        this.fatura = FaturaFactory.criarFatura(this); // Pedido usa a fábrica para criar Fatura
    }

    public Fatura getInvoice() {
        return fatura;
    }
}

class Fatura {
    private Pedido pedido;

    public Fatura(Pedido pedido) {
        this.pedido = pedido;
    }
    public Pedido getPedido() {
        return this.pedido;
    }
    // Métodos adicionais
}
// Fábrica para criar Fatura
class FaturaFactory {
    public static Fatura criarFatura(Pedido pedido) {
        return new Fatura(pedido);
    }
}


// Aqui temos o Creator, o Low Coupling
/* Creator: 
Padrão Creator
O padrão Creator é um princípio GRASP que sugere que uma classe deve ser responsável por criar instâncias de outras classes se:

    Tem a maior parte das informações necessárias para criar a instância.
    Usa o objeto resultante.
    É uma classe que agrega instâncias do objeto a ser criado.

Low Coupling: A classe Pedido não precisa saber detalhes sobre a implementação de Fatura.
      O acoplamento é reduzido porque Pedido não está diretamente criando a instância de Fatura, 
      mas delega essa responsabilidade à fábrica.
*/