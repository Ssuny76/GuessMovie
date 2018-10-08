import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class GuessMovie {
    public static void main(String [] args) throws FileNotFoundException {
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);

        MoviesManager myMoviesManager = new MoviesManager();
        int count = 0;
        while(scanner.hasNext()){
            count += 1;
            String name = scanner.nextLine();
            int space = name.split(" ").length - 1;
            int length = name.split("").length;
            Movie newMovie = new Movie();
            newMovie.name = name;
            newMovie.length = length;
            myMoviesManager.addMovie(newMovie);
        }

        System.out.println("Guess the name of the Movie!");
        Scanner scanner1 = new Scanner(System.in);
        int randomNumber = (int) (Math.random() * count);

        String movieName = myMoviesManager.movies[randomNumber].name;
        int movieLength = myMoviesManager.movies[randomNumber].length;
        boolean hasWon = false;
        int wrong = 0;
        String search = movieName;
        for(int j = 0; j < search.length(); j++){

            if(search.charAt(j) != ' '){
                search = search.substring(0, j) + '_' + search.substring(j + 1);
            }
        }

        while(wrong < 10){
            System.out.println("Your guessing: "+search);
            System.out.println("You have guessed (" + wrong +") letters. Enter character you want to check: ");

            char guess = scanner1.next().charAt(0);

            if(movieName.indexOf(guess) != -1){
                for(int r = 0; r < movieLength; r++){
                    if(movieName.charAt(r) == guess){
                        search = search.substring(0, r) + guess + search.substring(r + 1);
                    }
                }

            }
            else {
                System.out.println("there is no "+ guess +" in the movie name.");
                wrong = wrong + 1;
            }

            if(search.indexOf('_') == -1) {
                hasWon = true;
                break;
            }


        }
    if(hasWon){
        System.out.println("You Win!");
    }
    else{
        System.out.println("You lose!");
    }
    }
}
