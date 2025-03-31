public class Main {
    public static void main(String[] args) {
        Biestable biestable = new Biestable();
        biestable.estado();
        biestable.abrir();
        biestable.estado();
        biestable.cerrar();
        biestable.estado();
        System.out.println("------------------------------------------");
        Triestable triestable = new Triestable();
        triestable.estado();
        triestable.abrir();
        triestable.estado();
        triestable.abrir();
        triestable.estado();
        triestable.cerrar();
        triestable.estado();
        triestable.abrir();
        triestable.estado();
        triestable.cerrar();
        triestable.estado();
        triestable.cerrar();
        triestable.estado();

    }
}
