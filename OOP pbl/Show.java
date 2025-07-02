import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Show {
    private int ID;
    private LocalDateTime showTime;
    private int Capacity;
    private int availableseats;
    private String place;

    public Show() {}

    // Getters and setters
    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }
    public LocalDateTime getShowTime() { return showTime; }
    public void setShowTime(LocalDateTime showTime) { this.showTime = showTime; }
    public int getCapacity() { return Capacity; }
    public void setCapacity(int capacity) { Capacity = capacity; }
    public int getAvailableseats() { return availableseats; }
    public void setAvailableseats(int availableseats) { this.availableseats = availableseats; }
    public String getPlace() { return place; }
    public void setPlace(String place) { this.place = place; }

    public String getDate() {
        DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return showTime.format(dateformatter);
    }

    public String getTime() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return showTime.format(timeFormatter);
    }
}
