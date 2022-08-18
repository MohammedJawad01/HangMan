import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{

        System.out.println("welcome to hangman !\n test your english");

        File dictionary =new File("/Users/mohammedjawad/Desktop/hangMan/hangMan/src/dictionary.txt");

        Scanner textScanner =new Scanner(dictionary);
        Scanner input =new Scanner(System.in);

        ArrayList<String> words =new ArrayList<>();
        while (textScanner.hasNextLine()){
            words.add(textScanner.nextLine());
        }
        String hidden_text=words.get((int)(Math.random()*words.size()));

        char[] textArray =hidden_text.toCharArray();
        char[] myAnswers =new char[textArray.length];
        
        for (int i=0;i<textArray.length;i++){
            myAnswers[i]='?';
        }
        System.out.println("hint the first letter is "+textArray[0]);

        boolean finished =false;
        int lives=6;

        while (finished ==false){
            System.out.println("****************************");

            String letter=input.next();

            // checks for valid input
            while (letter.length()!=1 ||Character.isDigit(letter.charAt(0))){
                System.out.println("Error input try again !");
                letter=input.next();
            }
            //checks if the letter is in the word
            boolean found =false;
            for (int i=0;i<textArray.length;i++){
                if (letter.charAt(0)==textArray[i]){
                    myAnswers[i]=textArray[i];
                    found= true;
                }
            }

            if (!found){
            lives--;
               System.out.println("wrong letter");
            }

            boolean done = true;
            for (int i=0;i<myAnswers.length;i++){
                if (myAnswers[i]=='?'){
                    System.out.print(" _");
                    done=false;
                }
                else {
                    System.out.print(" "+myAnswers[i]);
                }
            }
            System.out.println("\n" +"lives left: "+lives);
            drawHangman(lives);

            //checks if the game ends
            if (done){
                System.out.println("congrats you find the word");
                finished=true;
            }
            if (lives<=0){
                System.out.println("you are dead! try hard next time");
                finished=true;
            }

        }
        System.out.println(hidden_text);

    }
    public static void drawHangman(int l) {
        if(l == 6) {
            System.out.println("|----------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 5) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 4) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 3) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 2) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 1) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else{
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
    }
}
