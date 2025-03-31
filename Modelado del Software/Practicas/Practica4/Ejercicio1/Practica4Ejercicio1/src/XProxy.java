public class XProxy implements X{

    Object obj;
    XService xService;

    public XProxy(Object obj, XService xService) {
        this.obj = obj;
        this.xService = xService;
    }

    @Override
    public void rutina1() {
        System.out.println("Acceso a rutina 1 concedido ");
        xService.rutina1();
    }

    @Override
    public void rutina2() {

        if( obj instanceof ClientA ||  obj instanceof ClientB){
            System.out.println("Acceso a rutina 2 concedido ");
            xService.rutina2();
        }else{
            System.out.println("Acceso a rutina 2 denegado ");
        }

    }

    @Override
    public void rutina3() {

        if( obj instanceof ClientA ||  obj instanceof ClientC){
            System.out.println("Acceso a rutina 3 concedido ");
            xService.rutina3();
        }else{
            System.out.println("Acceso a rutina 3 denegado ");
        }
    }

    @Override
    public void rutina4() {
        if( obj instanceof X){
            System.out.println("Acceso a rutina 4 concedido ");
            xService.rutina4();
        }else{
            System.out.println("Acceso a rutina 4 denegado ");
        }

    }
}
