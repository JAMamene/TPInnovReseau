import java.io.Serializable;
import java.util.List;

/**
 * An answer from the server to one of the client requests.
 * Contains the requested list of ideas or emails.
 */
public class Answer implements Serializable {

    public static final String NORMAL_STATUS = "OK";
    private static final long serialVersionUID = 1336L;
    private List<Object> answer;
    private String status;

    /**
     * Creates a new answer.
     * @param status - the status of the answer
     * @param answer - the list of objects sent with the answer
     */
    public Answer(String status, List<Object> answer) {
        this.status = status;
        this.answer = answer;
    }

    public String getStatus() {
        return status;
    }

    public List<Object> getAnswer() {
        return answer;
    }

}
