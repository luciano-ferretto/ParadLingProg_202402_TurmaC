public class ISP {
    
}

interface AveVoadora {
    void voar();
}
interface AveComedora {
    void comer();
}
class Canarinho implements AveVoadora, AveComedora {
    @Override
    public void comer() {
        System.out.println("Canarinho comendo");
    }
    @Override
    public void voar() {
        System.out.println("Canarinho voando");
    }
}
class Pinguim implements AveComedora {
    @Override
    public void comer() {
        System.out.println("Pinguim comendo");
    }
}




