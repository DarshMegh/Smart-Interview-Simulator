import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Topic:");
        System.out.println("1. Java");
        System.out.println("2. DSA");
        System.out.println("3. All");

        int choice = sc.nextInt();
        sc.nextLine();

        List<Question> questions = QuestionBank.getQuestions();
        List<Question> filtered = new ArrayList<>();

        for (Question q : questions) {
            if (choice == 1 && q.topic.equals("java")) {
                filtered.add(q);
            } else if (choice == 2 && q.topic.equals("dsa")) {
                filtered.add(q);
            } else if (choice == 3) {
                filtered.add(q);
            }
        }

        System.out.println("Total Questions: " + filtered.size());

        InterviewEngine engine = new InterviewEngine(filtered);
        engine.startInterview();
    }
}
