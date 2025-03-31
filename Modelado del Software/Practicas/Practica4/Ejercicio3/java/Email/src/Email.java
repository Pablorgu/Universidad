public class Email {
        private String from;
        private String subject;
        private String date;
        private int priority;


    public Email(String from, String subject, String date, int priority) {
        this.from = from;
        this.subject = subject;
        this.date = date;
        this.priority = priority;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    @Override
    public String toString(){
        return "From: "+from+"\nSubject: "+subject+"\nDate: "+date+"\nPriority: "+priority+"\n";
    }
}
