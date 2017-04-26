import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Idee implements Serializable {

    private static final long serialVersionUID = 1339L;

    private String intiator;
    private String email;
    private String name;
    private String description;
    private List<String> technologies;
    private List<String> interested;

    public Idee(String intiator, String email, String name, String description, List<String> technologies) {
        this.intiator = intiator;
        this.email = email;
        this.interested = new ArrayList<>();
        this.name = name;
        this.description = description;
        this.technologies = technologies;
    }

    public void addInterested (String email) {
        interested.add(email);
    }

    @Override
    public String toString() {
        return "Idee{" +
                "intiator='" + intiator + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", technologies=" + technologies +
                ", interested=" + interested +
                '}';
    }
}
