import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Get questions from QuestionBank
        List<Question> questions = QuestionBank.getQuestions();

        // Print total questions (test)
        System.out.println("Total Questions: " + questions.size());

        // Start Interview
        InterviewEngine engine = new InterviewEngine(questions);
        engine.startInterview();
    }
}