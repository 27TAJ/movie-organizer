import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        MovieCollection collection = new MovieCollection();

        boolean exit = false;
        while (!exit)
        {
            System.out.println("Movie Collection Organizer");
            System.out.println("1. Display Movies");
            System.out.println("2. Add a movie");
            System.out.println("3. Remove a movie");
            System.out.println("4. Sort movies (alphabetically)");
            System.out.println("5. Sort movies (Year released)");
            System.out.println("6. Exit program");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1)
                {
                    collection.displayMovies();
                }
            else if (choice == 2)
                {
                    System.out.println("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter director: ");
                    String director = scanner.nextLine();
                    System.out.println("Enter year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    collection.addMovie(title, director, year);
                }
            else if (choice == 3)
                {
                    System.out.println("Enter title to remove:");
                    String titleToRemove = scanner.nextLine();
                    collection.removeMovie(titleToRemove);
                }
            else if (choice == 4)
                {
                    collection.sortMoviesByTitle();
                }
            else if (choice == 5)
                {
                    collection.sortMoviesByYear();
                }
            else if (choice == 6)
                {
                    System.exit(0);
                }
            else
            {
                System.out.println("Invalid choice, try again.");
            }
        }
        System.out.println("Exiting the program...");
        scanner.close();
    }

}

class MovieCollection
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

    public void removeMovie(String titleToRemove)
    {
        for (int i = 0 ; i < movies.size() ; i++)
        {
            if (movies.get(i).getTitle().equals(titleToRemove))
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

}

class Movie
{
    private String title;
    private String director;
    private int year;

    public Movie (String title, String director, int year)
        {
            this.title = title;
            this.director = director;
            this.year = year;

        }
    public String getTitle()
    {
        return title;
    }
    
        public String toString() 
        {
            return title + " directed by " + director + "(" + year +")";
        }

        public static Comparator<Movie> TitleComparator = new Comparator<Movie>() 
        {
            public int compare(Movie m1, Movie m2) 
            {
                return m1.title.compareTo(m2.title);
            }
        };
    
        public static Comparator<Movie> YearComparator = new Comparator<Movie>() 
        {
            public int compare(Movie m1, Movie m2) 
            {
                return Integer.compare(m1.year, m2.year);
            }
        };
}