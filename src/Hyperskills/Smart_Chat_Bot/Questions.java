package Hyperskills.Smart_Chat_Bot;

import java.util.Map;

public class Questions {
    String question;
    int correctAnswer;
    Map<Integer, String> options;
    int userAnswer;
    int id;

    public Questions(int id, String question, int correctAnswer, Map<Integer, String> options) {
        this.id = id;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.options = options;
    }

    public void displayQuestion(){
        System.out.println(question);
        for(Map.Entry<Integer,String> entry : options.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public void setUserAnswer(int userAnswer){
        this.userAnswer = userAnswer;
    }

    public boolean isCorrectAnswer(){
        return correctAnswer == userAnswer;
    }

    public int getCorrectAnswer(){
        return correctAnswer;
    }
}
