public class ClientB implements Client{

    private X x;

    public ClientB() {
        FactoryX factoryX = new FactoryX();
        x = factoryX.create(this);
    }

    @Override
    public void rutina1() {
        x.rutina1();
    }

    @Override
    public void rutina2() {
        x.rutina2();
    }

    @Override
    public void rutina3() {
        x.rutina3();
    }

    @Override
    public void rutina4() {
        x.rutina4();
    }
}
