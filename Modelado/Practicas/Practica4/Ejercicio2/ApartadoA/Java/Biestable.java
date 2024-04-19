
package Java;

public class Biestable{
    Estado estado;
    public Biestable(){
        this.estado = new Rojo();
    }
    public void abrir(){
        this.estado.abrir(this);
    }
    public void cerrar(){
        this.estado.cerrar(this);
    }
    public void estado(){
        System.out.println(estado);
    }
}