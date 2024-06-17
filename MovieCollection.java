import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MovieCollection
{
    private List<Movie> movies;

    public MovieCollection()
    {
        movies = new ArrayList<>();
    }

    public void addMovie(String title, String director, int year)
    {
        Movie movie = new Movie(title, director, year);
        movies.add(movie);
        System.out.println("You have added " + title + " to your movie collection.");

    }

    public void removeMovie(String titleToRemove, String directorToRemove, int yearToRemove)
    {
        for (int i = 0 ; i < movies.size() ; i++)
        {
            if (movies.get(i).getTitle().equals(titleToRemove) && movies.get(i).getDirector().equals(directorToRemove) && movies.get(i).getYear() == yearToRemove)
                {
                    movies.remove(i);
                    System.out.println(titleToRemove + " has been removed from the collection.");
                    return;
                }

        }
        System.out.println(titleToRemove + " was not found in the collection");
    }

    public void sortMoviesByTitle() {
        Collections.sort(movies, Movie.TitleComparator);
    }

    public void sortMoviesByYear() {
        Collections.sort(movies, Movie.YearComparator);
    }

    public void displayMovies()
    {
        System.out.println("\t Movie Colletion: ");
        for (Movie movie : movies)
            {
                System.out.println(movie);
            }

    }

    public List<Movie> getMovies()
    {
        return movies;
    }

}
