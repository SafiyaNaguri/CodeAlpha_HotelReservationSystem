public class Room {
    private int roomNumber;
    private String category; // Standard, Deluxe, Suite
    private double pricePerNight;
    private boolean isBooked;

    public Room(int roomNumber, String category, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.pricePerNight = pricePerNight;
        this.isBooked = false;
    }

    public int getRoomNumber() { return roomNumber; }
    public String getCategory() { return category; }
    public double getPricePerNight() { return pricePerNight; }
    public boolean isBooked() { return isBooked; }

    public void setBooked(boolean status) { isBooked = status; }

    @Override
    public String toString() {
        return "Room " + roomNumber + " [" + category + "] - Rs." + pricePerNight
                + "/night - " + (isBooked ? "Booked" : "Available");
    }
}