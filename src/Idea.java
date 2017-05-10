import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * An idea submitted from one of the users.
 */
public class Idea implements Serializable {

    private static final long serialVersionUID = 1339L;

    private int id;
    private String initiator;
    private String email;
    private String name;
    private String description;
    private List<String> technologies;
    private List<String> interested;

    /**
     * Creates a new idea.
     *
     * @param initiator    - the name of the initiator of the idea
     * @param email        - the email of the initiator
     * @param name         - the name of the idea
     * @param description  - the description of the idea
     * @param technologies - a list of all the technologies that might be involved
     */
    public Idea(String initiator, String email, String name, String description, List<String> technologies) {
        this.initiator = initiator;
        this.email = email;
        this.interested = new ArrayList<>();
        this.name = name;
        this.description = description;
        this.technologies = technologies;
    }

    /**
     * Copy constructor
     *
     * @param idea the idea to copy
     */
    public Idea(Idea idea) {
        id = idea.getId();
        initiator = idea.getInitiator();
        email = idea.getEmail();
        interested = new ArrayList<>(idea.getInterested());
        name = idea.getName();
        description = idea.getDescription();
        technologies = new ArrayList<>(idea.getTechnologies());
    }

    /**
     * Adds a new email to the list of people interested in this idea.
     *
     * @param email - the mail to add
     */
    public void addInterested(String email) {
        interested.add(email);
    }

    public String getInitiator() {
        return initiator;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getTechnologies() {
        return technologies;
    }

    public List<String> getInterested() {
        return interested;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Idee n°" + id +
                ":\n intiateur : " + initiator +
                "\n email : " + email +
                "\n name : " + name +
                "\n description : " + description +
                "\n technologies : " + technologies +
                "\n interested : " + interested +
                "\n\n";
    }
}
