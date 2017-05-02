import java.util.ArrayList;
import java.util.List;

public class Stuff {

    public List<Idea> ideas;

    public Stuff () {
        this.ideas = new ArrayList<>();
    }

    public Answer list() {
        List<Object> objects = new ArrayList<>();
        objects.addAll(ideas);
        return new Answer(Answer.NORMAL_STATUS, objects);
    }

    public Answer add(Idea idea) {
        ideas.add(idea);
        return new Answer(Answer.NORMAL_STATUS, null);
    }

    public Answer participate(Participation p) {
        Idea i = ideas.stream().filter(idea -> (idea.getId() == p.getId())).findFirst().orElse(null);
        if (i == null) {
            return new Answer(Answer.BAD_STATUS, null);
        }
        i.addInterested(p.getEmail());
        return new Answer(Answer.NORMAL_STATUS, null);
    }

    public Answer seeInterested(Integer id) {
        Idea i = ideas.stream().filter(idea -> (idea.getId() == id)).findFirst().orElse(null);
        if (i == null) {
            return new Answer(Answer.BAD_STATUS, null);
        }
        List<Object> objects = new ArrayList<>();
        objects.addAll(i.getInterested());
        return new Answer(Answer.NORMAL_STATUS, objects);
    }

}
