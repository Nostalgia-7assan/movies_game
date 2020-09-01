import java.io.File ;
import java.util.ArrayList;
import java.util.Scanner ;

public class Game {
    public static void main(String args[]) throws Exception {

        // Scan the file
        File f = new File("movies.txt") ;
        Scanner s = new Scanner(f) ;

        // Add to moveies list and select a random one
        ArrayList<String> moveies = new ArrayList<String>() ;
        while(s.hasNextLine()) {
            moveies.add(s.nextLine()) ;
        }
        int r = (int) (Math.random()* moveies.size());
        String word = (String) moveies.get(r);

        // Build the "__ __"
        int len = 0;
        StringBuilder out = new StringBuilder("") ;
        for (int i = 0 ; i < word.length() ; i++) {
            if ( word.charAt(i)==' ') {
                out.append(" ");
            } else {
                out.append("_");
                len++ ;
            }
        }

        // Enter the game
        System.out.println("Simple Game To play");
        System.out.println("Guess a movie of "+len+" letters");
        System.out.println("You have 10 trials");
        boolean flag = false ;

        for (int i = 0 ; i < 10 ;) {
            // Scan The first Char
            System.out.println("\nYou are Guessing: " + out);
            System.out.print("Guess a letter: ");
            Scanner sg = new Scanner(System.in);
            char c = sg.next().charAt(0) ;
            int index = word.indexOf(c) ;
            if (index >= 0) {
                // Do all the replacements
                System.out.println("Right Guess") ;
                while (index >= 0) {
                    out.setCharAt(index, c);
                    index = word.indexOf(c, index + 1);
                }
                // Check if winner
                if (out.indexOf("_") == -1) {
                    flag = true;
                    break;
                }
            } else {
                System.out.println("Wrong Guess");
                i++ ;
            }
            System.out.println("You have Guessed ("+i+") wrong letter: ");
        }

        // Ending the game
        if(flag) {
            System.out.println("\nCongratulations You Won");
            System.out.println("You have guessed \""+word+ "\" correct");
        } else {
            System.out.println("\nYou are rune out of trials");
            System.out.println("Hard luck");
        }


    } // End Main
}
