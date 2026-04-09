import java.util.*;

public class InterviewEngine {

    private Queue<Question> questionQueue;
    private Map<String, Integer> performance;

    // Constructor
    public InterviewEngine(List<Question> questions) {
        questionQueue = new LinkedList<>(questions);
        performance = new HashMap<>();
    }

    // Start Interview
    public void startInterview() {
        Scanner sc = new Scanner(System.in);

        while (!questionQueue.isEmpty()) {
            Question q = questionQueue.poll();

            System.out.println("\nQuestion: " + q.question);
            String userAnswer = sc.nextLine().toLowerCase();

            if (userAnswer.contains(q.answer)) {
                System.out.println("✅ Correct!");
                performance.put(q.topic, performance.getOrDefault(q.topic, 0) + 1);
            } else {
                System.out.println("❌ Wrong! Correct answer: " + q.answer);
            }
        }

        showResult();
    }

    // Show Result
    private void showResult() {
        System.out.println("\n📊 Performance:");

        for (String topic : performance.keySet()) {
            System.out.println(topic + " -> " + performance.get(topic));
        }
    }
}