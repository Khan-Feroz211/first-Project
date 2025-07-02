import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.time.format.DateTimeFormatter;

public class Home extends JFrame {
    private static final long serialVersionUID = 1L;

    private final JTextArea movieInfoArea;

    public Home() {
        setTitle("Movie Info Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        add(panel);

        movieInfoArea = new JTextArea();
        movieInfoArea.setEditable(false);
        movieInfoArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        panel.add(new JScrollPane(movieInfoArea), BorderLayout.CENTER);

        JButton loadMovieBtn = new JButton("Load Movies From Database");
        panel.add(loadMovieBtn, BorderLayout.SOUTH);

        loadMovieBtn.addActionListener(e -> loadMoviesFromDB());

        setVisible(true);
    }

    private void loadMoviesFromDB() {
        MovieDAO dao = new MovieDAO();
        ArrayList<Movie> movies = dao.getAllMovies();

        if (movies.isEmpty()) {
            movieInfoArea.setText("No movies found in database.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        for (Movie movie : movies) {
            sb.append("ID: ").append(movie.getID()).append("\n");
            sb.append("Name: ").append(movie.getName()).append("\n");
            sb.append("Language: ").append(movie.getLanguage()).append("\n");
            sb.append("Genre: ").append(movie.getGenre()).append("\n");
            sb.append("Duration: ").append(movie.getDuration()).append(" mins\n");
            sb.append("Starring: ").append(movie.getStarring()).append("\n");
            sb.append("Rating: ").append(movie.getRating()).append("\n");
            sb.append("Shows:\n");

            for (Show show : movie.getShows()) {
                sb.append("  - ").append(show.getDate())
                  .append(" ").append(show.getTime())
                  .append(", Place: ").append(show.getPlace())
                  .append(", Capacity: ").append(show.getCapacity())
                  .append(", Available Seats: ").append(show.getAvailableseats())
                  .append("\n");
            }
            sb.append("\n------------------------\n\n");
        }

        movieInfoArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Home::new);
    }
}
