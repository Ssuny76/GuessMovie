public class MoviesManager {
    Movie [] movies;
    int moviesCount;

    MoviesManager(){
        moviesCount = 0;
        movies = new Movie[50];
    }

    void addMovie(Movie movie){
        movies[moviesCount] = movie;
        moviesCount++;
    }

    Movie searchMovie(String movieName){
        for(int i=0; i<moviesCount; i++){
            if(movies[i].name.equals(movieName)){
                return movies[i];
            }
        }
        return null;
    }

}
