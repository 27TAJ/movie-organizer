import javax.swing.SwingUtilities;


public class Main
{
    public static void main(String[] args) 
    {
        MovieCollection collection = new MovieCollection();

        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new GUI(collection);
            }
        });
    }
}
