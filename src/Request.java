import java.io.Serializable;

/**
 * A request to execute by the server. Contains the necessary objects.
 */
public class Request implements Serializable {

    private static final long serialVersionUID = 1337L;

    private String methodName;
    private Object param;

    /**
     * Creates a request to add a new idea.
     *
     * @param idea - the idea to add
     */
    public Request(Idea idea) {
        methodName = "add";
        param = idea;
    }

    /**
     * Creates a request to be added to one of the idea participants.
     *
     * @param participation - the participation to add
     */
    public Request(Participation participation) {
        methodName = "participate";
        param = participation;
    }

    /**
     * Creates a request to get all the emails of the people interested by one idea.
     *
     * @param id - the id of the idea
     */
    public Request(Integer id) {
        methodName = "seeInterested";
        param = id;
    }

    /**
     * Creates a request to list all ideas.
     */
    public Request() {
        methodName = "list";
        param = null;
    }

    public String getMethod() {
        return methodName;
    }

    public Object getParam() {
        return param;
    }

    @Override
    public String toString() {
        return "Request{" +
                "methodName='" + methodName + '\'' +
                ", param=" + param +
                '}';
    }
}
