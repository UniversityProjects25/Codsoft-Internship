import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Task_4_Quiz_Application_with_Timer{
    private static final int TIME_LIMIT_PER_QUESTION = 20; // Time limit per question in seconds
    private static final int TOTAL_QUESTIONS = 5; // Total number of questions in the quiz
    private static int currentQuestion = 0; // Track the current question number
    private static int score = 0; // Track the user's score

    private static String[] questions = {
            "What is the capital of France?",
            "What is the largest planet in our solar system?",
            "Who wrote 'To Kill a Mockingbird'?",
            "What is the chemical symbol for water?",
            "Which year did World War II end?"
    };

    private static String[][] options = {
            {"A. London", "B. Paris", "C. Rome", "D. Madrid"},
            {"A. Mars", "B. Jupiter", "C. Earth", "D. Saturn"},
            {"A. Harper Lee", "B. J.K. Rowling", "C. Stephen King", "D. Charles Dickens"},
            {"A. H2O", "B. CO2", "C. O2", "D. NaCl"},
            {"A. 1945", "B. 1939", "C. 1950", "D. 1960"}
    };

    private static char[] answers = {'B', 'B', 'A', 'A', 'A'}; // Correct answers

    public static void main(String[] args) {
        startQuiz();
    }

    private static void startQuiz() {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up for question " + (currentQuestion + 1));
                nextQuestion();
            }
        };

        timer.schedule(task, TIME_LIMIT_PER_QUESTION * 1000);

        displayQuestion();

        Scanner scanner = new Scanner(System.in);
        char userAnswer = scanner.next().toUpperCase().charAt(0);

        timer.cancel(); // Cancel the timer since the user has provided an answer

        if (userAnswer == answers[currentQuestion]) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect!");
        }

        nextQuestion();
    }

    private static void displayQuestion() {
        System.out.println("Question " + (currentQuestion + 1) + ": " + questions[currentQuestion]);
        for (String option : options[currentQuestion]) {
            System.out.println(option);
        }
        System.out.print("Your answer: ");
    }

    private static void nextQuestion() {
        currentQuestion++;

        if (currentQuestion < TOTAL_QUESTIONS) {
            startQuiz();
        } else {
            endQuiz();
        }
    }

    private static void endQuiz() {
        System.out.println("Quiz ended!");
        System.out.println("Your score: " + score + "/" + TOTAL_QUESTIONS);
    }
}


