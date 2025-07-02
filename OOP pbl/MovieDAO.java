import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MovieDAO {

    public ArrayList<Movie> getAllMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        String movieQuery = "SELECT * FROM movie_details";
        String showQuery = "SELECT * FROM show_schedule WHERE movie_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement movieStmt = conn.prepareStatement(movieQuery);
             ResultSet movieRs = movieStmt.executeQuery()) {

            while (movieRs.next()) {
                Movie movie = new Movie();
                movie.setID(movieRs.getInt("id"));
                movie.setName(movieRs.getString("name"));
                movie.setLanguage(movieRs.getString("language"));
                movie.setGenre(movieRs.getString("genre"));
                movie.setDuration(movieRs.getInt("duration"));
                movie.setStarring(movieRs.getString("starring"));
                movie.setRating(movieRs.getString("rating"));

                // Get shows for this movie
                try (PreparedStatement showStmt = conn.prepareStatement(showQuery)) {
                    showStmt.setInt(1, movie.getID());
                    try (ResultSet showRs = showStmt.executeQuery()) {
                        ArrayList<Show> shows = new ArrayList<>();
                        while (showRs.next()) {
                            Show show = new Show();
                            show.setID(showRs.getInt("id"));
                            // Parse show_time string into LocalDateTime
                            String showTimeStr = showRs.getString("show_time");
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            LocalDateTime showTime = LocalDateTime.parse(showTimeStr, formatter);
                            show.setShowTime(showTime);

                            show.setCapacity(showRs.getInt("capacity"));
                            show.setAvailableseats(showRs.getInt("available_seats"));
                            show.setPlace(showRs.getString("place"));
                            shows.add(show);
                        }
                        movie.setShows(shows);
                    }
                }
                movies.add(movie);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
