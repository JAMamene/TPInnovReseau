import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A list of ideas stored on the server.
 */
public class RemoteList {

    private final List<Idea> ideas;

    /**
     * Creates a new remoteList.
     */
    public RemoteList() {
        this.ideas = Collections.synchronizedList(new ArrayList<>());
    }

    /**
     * Lists all ideas.
     *
     * @return an answer containing all of the ideas
     */
    public Answer list() {
        List<Object> objects = new ArrayList<>();
        synchronized (ideas) {
            objects.addAll(ideas);
        }
        return new Answer(Answer.NORMAL_STATUS, objects);
    }

    /**
     * Adds a new idea to the list.
     *
     * @param idea - the idea to add
     * @return an empty answer
     */
    public Answer add(Idea idea) {
        ideas.add(idea);
        return new Answer(Answer.NORMAL_STATUS, null);
    }

    /**
     * Adds a new participation to an idea.
     *
     * @param p - the participation to add to the idea
     * @return an empty answer
     */
    public Answer participate(Participation p) {
        try {
            synchronized (ideas) {
                ideas.stream().filter(idea -> (idea.getId() == p.getId())).findFirst().orElseThrow(RuntimeException::new).addInterested(p.getEmail());
            }
        } catch (RuntimeException e) {
            return new Answer(Answer.BAD_STATUS, null);
        }
        return new Answer(Answer.NORMAL_STATUS, null);
    }

    /**
     * See the emails of everyone interested in one idea.
     *
     * @param id - the id of the idea
     * @return an answer containing the emails of the people interested in the idea
     */
    public Answer seeInterested(Integer id) {
        synchronized (ideas) {
            Idea i = ideas.stream().filter(idea -> (idea.getId() == id)).findFirst().orElse(null);
            if (i == null) {
                return new Answer(Answer.BAD_STATUS, null);
            }
            List<Object> objects = new ArrayList<>();
            objects.addAll(i.getInterested());
            return new Answer(Answer.NORMAL_STATUS, objects);
        }
    }

}
