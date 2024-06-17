import javax.swing.SwingUtilities;


public class Main
{
    public static void main(String[] args) 
    {
       final MovieCollection collection = MovieCollection.loadMovieCollection();

        if (collection == null)
        {
        final MovieCollection newCollection = new MovieCollection();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI(newCollection);
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                newCollection.saveMovieCollection();
                System.out.println("Movie collection saved on application exit.");
            }
        }));
        }
        else
        {
    
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new GUI(collection);
            }
        });
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            collection.saveMovieCollection();
            System.out.println("Movie Collection saved on exit.");
        }));
        }
    }
}
