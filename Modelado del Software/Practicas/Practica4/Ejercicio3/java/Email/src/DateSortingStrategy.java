import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DateSortingStrategy implements SortingStrategy {
    public void sort(List<Email> email) {
        for (int i = 1; i < email.size(); i++ ){
            for (int j = email.size()-1; j >= i; j--){
                if (before(email.get(j), email.get(j - 1))) {
                    // intercambiar los mensajes j y j-1
                    Email temp = email.get(j);
                    email.set(j, email.get(j - 1));
                    email.set(j - 1, temp);
                }
            }
        }
    }

    private boolean before(Email email1, Email email2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date1 = sdf.parse(email1.getDate());
            Date date2 = sdf.parse(email2.getDate());

            return date1.before(date2);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
