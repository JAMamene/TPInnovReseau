import java.io.Serializable;

/**
 * A participation used to add a new person to the list of the people interested in an idea.
 */
public class Participation implements Serializable {

    private static final long serialVersionUID = 1338L;

    private int id;
    private String email;

    /**
     * Creates a new participation.
     *
     * @param id    - the id of the idea the person is interested in
     * @param email - the mail of the interested person
     */
    public Participation(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
