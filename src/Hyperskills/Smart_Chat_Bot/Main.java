package Hyperskills.Smart_Chat_Bot;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    final static Scanner scanner = new Scanner(System.in);
    final static ArrayList<Questions> questions = new ArrayList<>();

    public static void main(String[] args) {
        greetings("MGK", 1990);
        askForName();
        guessAge();
        count();
        test();
        end();
    }

    static void greetings(String name, int birthYear) {
        System.out.println("Hello! My name is " + name + ".");
        System.out.println("I was created in " + birthYear + ".");
        System.out.println("Please, remind me your name.");
    }

    static void askForName() {
        String name = scanner.nextLine();
        System.out.println("What a great name you have, " + name + "!");
    }

    static void guessAge() {
        System.out.println("Let me guess your age");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7. ");
        int remainderThree = scanner.nextInt();
        int remainderFive = scanner.nextInt();
        int remainderSeven = scanner.nextInt();
        int yourAge = (remainderThree * 70 + remainderFive * 21 + remainderSeven * 15) % 105;
        System.out.println("Your age is " + yourAge + " that's a good time to start programming! ");
    }

    static void count() {
        System.out.println("Now I will prove to you that I can count to any number you want.");
        int num = scanner.nextInt();
        for (int i = 0; i <= num; i++) {
            System.out.printf("%d!\n", i);
        }
    }

    static void test() {
        int score = 0;
        System.out.println("Let's test your programming knowledge.");
        Map<Integer, String> options = Map.of(
                1, "4",
                2, "20",
                3, "100",
                4, "-1"
        );

        Map<Integer, String> options1 = Map.of(
                1, "Paris",
                2, "London",
                3, "Berlin",
                4, "Rome"
        );

        Map<Integer, String> options2 = Map.of(
                1, "Mars",
                2, "Earth",
                3, "Venus",
                4, "Jupiter"
        );
        questions.add(new Questions(1, "What is 2 + 2 ? ", 1, options));
        questions.add(new Questions(2, "What is the capital of France?", 1, options1));
        questions.add(new Questions(3, "Which planet do humans live on?", 2, options2));


        for (Questions question : questions) {
            question.displayQuestion();
            System.out.println("Your answer");
            int answer = scanner.nextInt();
            question.setUserAnswer(answer);
            int correctAns = question.getCorrectAnswer();
            System.out.println("Correct answer is " + correctAns);
        }

        for (Questions question : questions) {
            if (question.isCorrectAnswer()) {
                score++;
            }
        }

        System.out.println("Your score: " + score + "/" + questions.size());
    }

    static void end() {
        System.out.println("Congratulations, have a nice day!");
    }

}
