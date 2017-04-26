import java.io.Serializable;

public class Request implements Serializable {

    private static final long serialVersionUID = 1337L;

    private RequestType requestType;
    private Object param;

    public Request(Idee idee) {
        this.requestType = RequestType.ADD;
        this.param = idee;
    }

    public Request(Participation participation) {
        this.requestType = RequestType.PARTICIPATE;
        this.param = participation;
    }

    public Request (Integer id) {
        this.requestType = RequestType.LIST_INTEREST;
        this.param = id;
    }

    public Request() {
        this.requestType = RequestType.LIST_IDEA;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public Object getParam() {
        return param;
    }
}
