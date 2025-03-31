import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Mailbox mailbox = new Mailbox();
        mailbox.addemail(new Email("Juan", "juan saluda", "2023-12-03", 2));
        mailbox.addemail(new Email("Carlos", "pepe saluda", "2023-11-02", 1));
        SortingStrategy dateSortingStrategy = new DateSortingStrategy();
        SortingStrategy fromSortingStrategy = new FromSortingStrategy();
        SortingStrategy prioritySortingStrategy = new PrioritySortingStrategy();
        SortingStrategy subjectSortingStrategy = new SubjectSortingStrategy();

        // Configurar la estrategia de ordenación actual
        mailbox.setSortingStrategy(dateSortingStrategy);
        // Mostrar correos electrónicos ordenados por fecha
        mailbox.show();

        // Cambiar la estrategia de ordenación
        mailbox.setSortingStrategy(fromSortingStrategy);
        // Mostrar correos electrónicos ordenados por remitente
        mailbox.show();

        // Cambiar la estrategia de ordenación
        mailbox.setSortingStrategy(prioritySortingStrategy);
        // Mostrar correos electrónicos ordenados por prioridad
        mailbox.show();

        // Cambiar la estrategia de ordenación
        mailbox.setSortingStrategy(subjectSortingStrategy);
        // Mostrar correos electrónicos ordenados por asunto
        mailbox.show();

    }
}