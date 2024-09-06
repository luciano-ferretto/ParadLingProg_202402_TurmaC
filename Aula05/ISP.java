public class ISP {
    
}

interface Ave {
    void comer();
    void voar();
}
class Canarinho implements Ave {
    @Override
    public void comer() {
        System.out.println("Canarinho comendo");
    }
    @Override
    public void voar() {
        System.out.println("Canarinho voando");
    }
}
class Pinguim implements Ave {
    @Override
    public void comer() {
        System.out.println("Pinguim comendo");
    }
    @Override
    public void voar() {
        throw new UnsupportedOperationException("Pinguim não voa");
    }
}




