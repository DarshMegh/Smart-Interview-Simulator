import java.util.*;

class QuestionBank {

    public static List<Question> getQuestions() {
        List<Question> list = new ArrayList<>();

        list.add(new Question("What is JVM?", "java virtual machine", "easy", "java"));
        list.add(new Question("What is OOP?", "object oriented programming", "easy", "java"));
        list.add(new Question("What is HashMap?", "key value", "medium", "dsa"));
        list.add(new Question("Binary search complexity?", "log n", "medium", "dsa"));
        list.add(new Question("What is Dijkstra?", "shortest path", "hard", "dsa"));
        return list;
    }
}