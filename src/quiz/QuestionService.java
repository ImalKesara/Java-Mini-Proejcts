package quiz;

import java.util.Scanner;

public class QuestionService {
    Questions[] questions = new Questions[5];
    String selections[] = new String[5];



    public QuestionService(){
        questions[0] = new Questions(1,"which is not a operating system ?","Windows","Mac os","Linux","Facebook","Facebook");
        questions[1] = new Questions(2,"What is the capital of France ?","Berlin","Madrid","Paris","Rome","Paris");
        questions[2] = new Questions(3,"Which planet is known as the Red Planet?","Earth","Mars","Jupiter","Venus","Mars");
        questions[3] = new Questions(4,"Which element has the chemical symbol 'O' ?","Oxygen","Gold","Silver","Osmium","Oxygen");
        questions[4] = new Questions(5,"What is the largest ocean on Earth ?","Atlantic Ocean","Indian Ocean","Arctic Ocean","Pacific Ocean","Pacific Ocean");
    }

    public void displayQuestion(){
//        for(int i =0 ; i < questions.length ; i++){
//            System.out.println(questions[i].getQuestion());
//            System.out.println("A) "+questions[i].getOpt1());
//            System.out.println("B) "+questions[i].getOpt2());
//            System.out.println("C) "+questions[i].getOpt3());
//            System.out.println("D) "+questions[i].getOpt4());
//            System.out.println("select ur answer :-");
//            String answer = input.nextLine();
//            if(answer.equals(questions[i].getAns())){
//                System.out.println("ur answer is correct");
//                score += 1;
//            }else{
//                System.out.println("wrong");
//            }
//
//        }
//        System.out.println("Your score is "+ score + "/5");
        int i = 0;
        for(Questions q : questions){

            System.out.println("Question no "+q.getId());
            System.out.println(q.getQuestion());
            System.out.println(q.getOpt1());
            System.out.println(q.getOpt2());
            System.out.println(q.getOpt3());
            System.out.println(q.getOpt4());
            Scanner scanner = new Scanner(System.in);
            selections[i++] = scanner.nextLine();

        }

    }

    public void printScore(){
        int score = 0;
        for(int i=0 ; i < questions.length ; i++){
            Questions que = questions[i];
            String trueAnswer = que.getAns();
            String userAnswer = selections[i];
            if(trueAnswer.equals(userAnswer)){
                score++;
            }
        }
        System.out.println("Your score is " + score);

    }


}
