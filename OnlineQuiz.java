import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineQuiz {
    private List<Question> questions;
    private Scanner scanner;

    public OnlineQuiz() {
        questions = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void startQuiz() {
        System.out.println("Welcome to the Online Quiz Application!");
        int score = 0;
        for (Question question : questions) {
            System.out.println(question.getQuestion());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            int answerIndex = -1;
            while (true) {
                try {
                    System.out.print("Your answer: ");
                    answerIndex = Integer.parseInt(scanner.nextLine()) - 1;

                    // Validate the user's input
                    if (answerIndex < 0 || answerIndex >= options.size()) {
                        System.out.println("Please enter a valid option number.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

            if (question.isCorrect(answerIndex)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + question.getCorrectAnswer());
            }
        }
        System.out.println("Your final score is " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        OnlineQuiz quiz = new OnlineQuiz();
        quiz.addQuestion(new Question("Which animal is known as the 'King of the Jungle'?", "Lion", List.of("Tiger", "Elephant", "Lion", "Gorilla")));
        quiz.addQuestion(new Question("What is the chemical symbol for water?", "H2O", List.of("O2", "H2", "H2O", "HO2")));
        quiz.addQuestion(new Question("Who invented the telephone?", "Alexander Graham Bell", List.of("Thomas Edison", "Alexander Graham Bell", "Nikola Tesla", "Guglielmo Marconi")));
        quiz.addQuestion(new Question("Which planet is closest to the Sun?", "Mercury", List.of("Venus", "Earth", "Mercury", "Mars")));
        quiz.addQuestion(new Question("What is the capital of Australia?", "Canberra", List.of("Sydney", "Melbourne", "Canberra", "Brisbane")));
        quiz.addQuestion(new Question("What is the largest mammal in the world?", "Blue Whale", List.of("Elephant", "Blue Whale", "Great White Shark", "Giraffe")));
        quiz.addQuestion(new Question("Who discovered penicillin?", "Alexander Fleming", List.of("Marie Curie", "Alexander Fleming", "Isaac Newton", "Louis Pasteur")));
        quiz.addQuestion(new Question("Which country is home to the kangaroo?", "Australia", List.of("India", "Australia", "South Africa", "Brazil")));
        quiz.addQuestion(new Question("What is the square root of 144?", "12", List.of("10", "12", "14", "16")));
        quiz.addQuestion(new Question("Who wrote 'Pride and Prejudice'?", "Jane Austen", List.of("Charlotte Brontë", "Jane Austen", "Emily Dickinson", "George Eliot")));
        quiz.addQuestion(new Question("Which is the smallest ocean in the world?", "Arctic Ocean", List.of("Indian Ocean", "Pacific Ocean", "Atlantic Ocean", "Arctic Ocean")));
        quiz.addQuestion(new Question("What is the boiling point of water in Celsius?", "100°C", List.of("50°C", "90°C", "100°C", "120°C")));
        quiz.addQuestion(new Question("Which language has the most native speakers?", "Mandarin Chinese", List.of("Spanish", "English", "Mandarin Chinese", "Hindi")));
        quiz.addQuestion(new Question("Who painted the ceiling of the Sistine Chapel?", "Michelangelo", List.of("Leonardo da Vinci", "Raphael", "Michelangelo", "Donatello")));
        quiz.addQuestion(new Question("Which continent has the most countries?", "Africa", List.of("Asia", "Europe", "Africa", "South America")));
        quiz.addQuestion(new Question("What is the main component of the sun?", "Hydrogen", List.of("Oxygen", "Helium", "Hydrogen", "Carbon")));
        quiz.addQuestion(new Question("What is the largest desert in the world?", "Sahara Desert", List.of("Gobi Desert", "Arabian Desert", "Sahara Desert", "Kalahari Desert")));
        quiz.addQuestion(new Question("Which instrument has 88 keys?", "Piano", List.of("Guitar", "Piano", "Violin", "Flute")));

        quiz.startQuiz();
    }
}

class Question {
    private String question;
    private String correctAnswer;
    private List<String> options;

    public Question(String question, String correctAnswer, List<String> options) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isCorrect(int index) {
        return options.get(index).equalsIgnoreCase(correctAnswer);
    }
}