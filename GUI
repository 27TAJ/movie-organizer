import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;



public class GUI implements ActionListener
{
    private JFrame frame;
    private JPanel panel;
    private CardLayout cardLayout;
    private JPanel cards;
    private JPanel displayMoviesPanel;
    private JPanel addMoviePanel;
    private JPanel removeMoviePanel;
    private MovieCollection movieCollection;
    private JTextField addTitleField;
    private JTextField addDirectorField;
    private JTextField addYearField;
    private JTextField removeTitleField;
    private JTextField removeDirectorField;
    private JTextField removeYearField;
    private JTable table;
    private String[] columnNames = {"Title", "Director","Year"};
    private Object[][] data;
    

    public GUI(MovieCollection movieCollection)
    {
        this.movieCollection = movieCollection;
        frame = new JFrame();
        frame.setTitle("Movie Collection Organizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        frame.getContentPane().add(cards);
        panel = new JPanel();
        cards.add(panel, "MENU_PANEL");

        addButtonsToMenu(panel);
        initPanels();
        
        frame.pack();
        frame.setVisible(true);
        
    }


    private void initPanels()
    {
        displayMoviesPanel = new JPanel();
        initDisplayMoviesPanel(displayMoviesPanel);        


        addMoviePanel = new JPanel();
        initAddMoviePanel(addMoviePanel);
        

        removeMoviePanel = new JPanel();
        initRemoveMoviePanel(removeMoviePanel);

        cards.add(displayMoviesPanel, "DISPLAY_MOVIES");
        cards.add(addMoviePanel, "ADD_MOVIE");
        cards.add(removeMoviePanel, "REMOVE_MOVIE");
    }

    private void initAddMoviePanel(JPanel panel)

    {
        panel.setLayout(new GridLayout(1, 6));

        addTitleField = new JTextField();
        addDirectorField = new JTextField();
        addYearField = new JTextField();
        
        panel.add(new JLabel("Title: "));
        panel.add(addTitleField);
        panel.add(new JLabel("Director: "));
        panel.add(addDirectorField);
        panel.add(new JLabel("Year: "));
        panel.add(addYearField);
        addButton("Submit", "ADD_MOVIE_BUTTON", panel);
        addButton("Back","BACK_BUTTON", panel);
    }

    private void initRemoveMoviePanel(JPanel panel)
    {
        panel.setLayout(new GridLayout(1,6));

        removeTitleField = new JTextField();
        removeDirectorField = new JTextField();
        removeYearField = new JTextField();

        panel.add(new JLabel("Title: "));
        panel.add(removeTitleField);
        panel.add(new JLabel("Director: "));
        panel.add(removeDirectorField);
        panel.add(new JLabel("Year: "));
        panel.add(removeYearField);
        addButton("Remove","REMOVE_MOVIE_BUTTON", panel);
        addButton("Back","BACK_BUTTON", panel);


    }

    public void initDisplayMoviesPanel(JPanel panel)
    {
        Object[][] data = new Object[movieCollection.getMovies().size()][3];

        for (int i = 0 ; i < movieCollection.getMovies().size() ; i++)
        {
            Movie movie = movieCollection.getMovies().get(i);
            data[i][0] = movie.getTitle();
            data[i][1] = movie.getDirector();
            data[i][2] = movie.getYear();
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        table.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        addButton("Back", "BACK_BUTTON", panel);

    }

    public void updateDisplayMoviesPanel()
    {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        Object[][] data = new Object[movieCollection.getMovies().size()][3];

        for (int i = 0 ; i <movieCollection.getMovies().size() ; i++)
        {
            Movie movie = movieCollection.getMovies().get(i);
            data[i][0] = movie.getTitle();
            data[i][1] = movie.getDirector();
            data[i][2] = movie.getYear();

        }

        DefaultTableModel newModel = new DefaultTableModel(data, columnNames);
        table.setModel(newModel);

    }


    private void addButtonsToMenu(JPanel menu)
    {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        addButton("Display Movies","DISPLAY_MOVIES", buttonPanel);
        addButton("Add a Movie","ADD_MOVIE", buttonPanel);
        addButton("Remove a Movie","REMOVE_MOVIE", buttonPanel);
        addButton("Sort Alphabetically","SORT_ALPHA", buttonPanel);
        addButton("Sort by Release Date","SORT_YEAR", buttonPanel);
        addButton("Exit","EXIT", buttonPanel);

        menu.add(buttonPanel);
    }
    
    private void addButton(String text, String actionCommand, Container container)
    {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        int maxWidth = (int) (Toolkit.getDefaultToolkit().getScreenSize().width * 0.5);
        button.setMaximumSize(new Dimension(maxWidth, button.getPreferredSize().height));
        button.setActionCommand(actionCommand);
        button.addActionListener(this);
        container.add(button);
    }

    private void clearFields(JTextField text1, JTextField text2, JTextField text3)
    {
        text1.setText("");
        text2.setText("");
        text3.setText("");
    }

   public void actionPerformed(ActionEvent e)
   {
        String command = e.getActionCommand();
        switch (command)
        {
            case "DISPLAY_MOVIES":
                cardLayout.show(cards, "DISPLAY_MOVIES");
                break;
            case "ADD_MOVIE":
                cardLayout.show(cards, "ADD_MOVIE");
                break;
            case "REMOVE_MOVIE":
                cardLayout.show(cards, "REMOVE_MOVIE");
                break;
            case "SORT_ALPHA":
                movieCollection.sortMoviesByTitle();
                break;
            case "SORT_YEAR":
                movieCollection.sortMoviesByYear();
                break;
            case "EXIT":
                System.exit(0);
                break;
            case "ADD_MOVIE_BUTTON":
                movieCollection.addMovie(addTitleField.getText(), addDirectorField.getText(), Integer.parseInt(addYearField.getText()));
                updateDisplayMoviesPanel();
                clearFields(addTitleField, addDirectorField, addYearField);
                break;
            case "REMOVE_MOVIE_BUTTON":
                movieCollection.removeMovie(removeTitleField.getText(), removeDirectorField.getText(), Integer.parseInt(removeYearField.getText()));
                updateDisplayMoviesPanel();
                clearFields(removeTitleField, removeDirectorField, removeYearField);
                break;
            case "BACK_BUTTON":
                cardLayout.show(cards, "MENU_PANEL");
                break;
            default:
                break;


        }



   }



}
