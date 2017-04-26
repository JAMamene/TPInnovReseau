import java.io.Serializable;

/**
 * A request to execute by the server. Contains the necessary objects.
 */
public class Request implements Serializable {

    private static final long serialVersionUID = 1337L;

    private RequestType requestType;
    private Object param;

    /**
     * Creates a request to add a new idea.
     * @param idea - the idea to add
     */
    public Request(Idea idea) {
        this.requestType = RequestType.ADD;
        this.param = idea;
    }

    /**
     * Creates a request to be added to one of the idea participants.
     * @param participation - the participation to add
     */
    public Request(Participation participation) {
        this.requestType = RequestType.PARTICIPATE;
        this.param = participation;
    }

    /**
     * Creates a request to get all the emails of the people interested by one idea.
     * @param id - the id of the idea
     */
    public Request (Integer id) {
        this.requestType = RequestType.LIST_INTEREST;
        this.param = id;
    }

    /**
     * Creates a request to list all ideas.
     */
    public Request() {
        this.requestType = RequestType.LIST_IDEA;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    /**
     * Returns the object associated with the request :
     *  - an Idea if adding a new idea,
     *  - a Participation if adding a participant to an idea,
     *  - an Integer to get all the emails of the people interested by one idea,
     *  - null if requesting the list of all ideas
     * @return the parameter of the request
     */
    public Object getParam() {
        return param;
    }

}
