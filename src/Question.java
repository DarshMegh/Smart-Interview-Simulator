public class Question {
    String question;
    String answer;
    String difficulty;
    String topic;

    public Question(String question, String answer, String difficulty, String topic) {
        this.question = question;
        this.answer = answer.toLowerCase();
        this.difficulty = difficulty.toLowerCase();
        this.topic = topic.toLowerCase();
    }

    // Priority for sorting
    public int getPriority() {
        if (difficulty.equals("easy")) return 1;
        if (difficulty.equals("medium")) return 2;
        return 3; // hard
    }
}

