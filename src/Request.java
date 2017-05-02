import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * A request to execute by the server. Contains the necessary objects.
 */
public class Request implements Serializable {

    private static final long serialVersionUID = 1337L;

    private String method_name;
    private Object param;

    /**
     * Creates a request to add a new idea.
     *
     * @param idea - the idea to add
     */
    public Request(Idea idea) {
        method_name = "add";
        param = idea;
    }

    /**
     * Creates a request to be added to one of the idea participants.
     *
     * @param participation - the participation to add
     */
    public Request(Participation participation) {
        method_name = "participate";
        param = participation;
    }

    /**
     * Creates a request to get all the emails of the people interested by one idea.
     *
     * @param id - the id of the idea
     */
    public Request(Integer id) {
        method_name = "seeInterested";
        param = id;
    }

    /**
     * Creates a request to list all ideas.
     */
    public Request() {
        method_name = "list";
        param = null;
    }

    public Answer invoke(Stuff stuff) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException {
        if (param==null) {
            return (Answer) (Class.forName("Stuff").getMethod(method_name)).invoke(stuff);
        }
        else {
            return (Answer) (Class.forName("Stuff").getMethod(method_name, param.getClass()).invoke(stuff,param));
        }
    }

}
