import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemoteList {

    private final List<Idea> ideas;

    public RemoteList() {
        this.ideas = Collections.synchronizedList(new ArrayList<>());
    }

    public Answer list() {
        List<Object> objects = new ArrayList<>();
        synchronized (ideas) {
            objects.addAll(ideas);
        }
        return new Answer(Answer.NORMAL_STATUS, objects);
    }

    public Answer add(Idea idea) {
        ideas.add(idea);
        return new Answer(Answer.NORMAL_STATUS, null);
    }

    public Answer participate(Participation p) {
        try {
            synchronized (ideas) {
                ideas.stream().filter(idea -> (idea.getId() == p.getId())).findFirst().orElseThrow(RuntimeException::new).addInterested(p.getEmail());
            }
        }
        catch (RuntimeException e) {
            return new Answer(Answer.BAD_STATUS, null);
        }
        return new Answer(Answer.NORMAL_STATUS, null);
    }

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
