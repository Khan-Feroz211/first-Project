import java.util.ArrayList;

public class Movie {
    private int ID;
    private String name;
    private String language;
    private String genre;
    private int duration;
    private String starring;
    private String rating;
    private ArrayList<Show> shows;

    public Movie() {
        this.shows = new ArrayList<>();
    }

    // Getters and setters
    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
    public String getStarring() { return starring; }
    public void setStarring(String starring) { this.starring = starring; }
    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }
    public ArrayList<Show> getShows() { return shows; }
    public void setShows(ArrayList<Show> shows) { this.shows = shows; }
}
