import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A list of ideas stored on the server.
 */
public interface RemoteListInterface{

    /**
     * Lists all ideas.
     *
     * @return an answer containing all of the ideas
     */

    Answer list();

    /**
     * Adds a new idea to the list.
     *
     * @param idea - the idea to add
     * @return an empty answer
     */
    Answer add(Idea idea);

    /**
     * Adds a new participation to an idea.
     *
     * @param p - the participation to add to the idea
     * @return an empty answer
     */
    Answer participate(Participation p);

    /**
     * See the emails of everyone interested in one idea.
     *
     * @param id - the id of the idea
     * @return an answer containing the emails of the people interested in the idea
     */
    Answer seeInterested(Integer id);

}
