import java.io.Serializable;
import java.util.List;

public class Answer implements Serializable {

    private static final long serialVersionUID = 1336L;

    private List<Object> answer;

    public Answer(List<Object> answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer=" + answer +
                '}';
    }
}
