import java.util.*;

public class InterviewEngine {

    private PriorityQueue<Question> questionQueue;
    private Map<String, Integer> performance;
    private int totalScore;

    public InterviewEngine(List<Question> questions) {
        questionQueue = new PriorityQueue<>(
                (a, b) -> a.getPriority() - b.getPriority()
        );

        questionQueue.addAll(questions);
        performance = new HashMap<>();
        totalScore = 0;
    }

    public void startInterview() {
        Scanner sc = new Scanner(System.in);

        while (!questionQueue.isEmpty()) {
            Question q = questionQueue.poll();

            System.out.println("\nQuestion: " + q.question);
            System.out.println("⏳ You have 10 seconds to answer!");

            long startTime = System.currentTimeMillis();

            System.out.print("Your Answer: ");
            String userAnswer = sc.nextLine().toLowerCase();

            long endTime = System.currentTimeMillis();
            long timeTaken = (endTime - startTime) / 1000;

            if (timeTaken > 10) {
                System.out.println("⏰ Time Up! You took " + timeTaken + " seconds.");
                System.out.println("❌ Wrong! Correct answer: " + q.answer);
                continue;
            }

            if (userAnswer.contains(q.answer)) {
                System.out.println("✅ Correct!");

                int score = getScore(q.difficulty);
                totalScore += score;

                performance.put(q.topic,
                        performance.getOrDefault(q.topic, 0) + score);

                System.out.println("Score: +" + score);

            } else {
                System.out.println("❌ Wrong! Correct answer: " + q.answer);
            }
        }

        showResult();
    }

    private int getScore(String difficulty) {
        if (difficulty.equals("easy")) return 1;
        if (difficulty.equals("medium")) return 2;
        return 3;
    }

    private void showResult() {
        System.out.println("\n🏆 Total Score: " + totalScore);

        System.out.println("\n📊 Performance:");
        for (String topic : performance.keySet()) {
            System.out.println(topic + " -> " + performance.get(topic));
        }
    }
}