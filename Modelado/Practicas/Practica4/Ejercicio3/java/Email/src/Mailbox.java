import java.util.ArrayList;
import java.util.List;

public class Mailbox {
    private List<Email> emails;

    private SortingStrategy sortingStrategy;

    public Mailbox() {
        emails = new ArrayList<Email>();
    }

    public void addemail(Email email) {
        emails.add(email);
    }
    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void show() {
        sortingStrategy.sort(emails);
        for (Email email : emails) {
            System.out.println(email.toString());
        }
    }
}
