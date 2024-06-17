import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;


public class MovieCollection implements Serializable
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

    public static MovieCollection loadMovieCollection()
    {
        return deserializeCollection("movieCollection.ser");
    }

    public void saveMovieCollection()
    {
        serializeCollection("movieCollection.ser");
    }

    public void serializeCollection(String filename)
    {
        try (FileOutputStream fileOut = new FileOutputStream(filename); 
        ObjectOutputStream out = new ObjectOutputStream(fileOut);)
        {
            out.writeObject(this);
            System.out.println("Movie Collection serialized into " + filename);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static MovieCollection deserializeCollection(String filename)
    {
        File file = new File(filename);
        if (!file.exists()) 
        {
            System.out.println("File " + filename + " does not exist. Making a new collection!");
            return new MovieCollection();
        }
    
        MovieCollection collection = null;
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) 
        {
            collection = (MovieCollection) in.readObject();
            System.out.println("Movie collection deserialized from " + filename);
        } catch (IOException | ClassNotFoundException e) 
        {
            e.printStackTrace();
        }
        return collection;
    }


}
