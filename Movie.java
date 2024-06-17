import java.util.Comparator;


public class Movie
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
    
    public String getDirector()
    {
        return director;
    }

    public int getYear()
    {
        return year;
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
