import java.io.Serializable;

public class Participation implements Serializable{

    private static final long serialVersionUID = 1338L;

    private int id;
    private String email;

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
