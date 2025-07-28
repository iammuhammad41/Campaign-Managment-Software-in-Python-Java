public class Campaign {
    private String name;
    private String description;
    private String status;

    public Campaign(String name, String description, String status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return "Campaign Name: " + name + "\nDescription: " + description + "\nStatus: " + status;
    }
}
