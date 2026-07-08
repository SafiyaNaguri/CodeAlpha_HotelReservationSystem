import java.util.ArrayList;
import java.io.*;

public class HotelManager {
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();
    private int nextReservationId = 1;
    private final String DATA_FILE = "bookings.txt";

    public HotelManager() {
        setupRooms();
    }

    private void setupRooms() {
        rooms.add(new Room(101, "Standard", 1500));
        rooms.add(new Room(102, "Standard", 1500));
        rooms.add(new Room(201, "Deluxe", 2800));
        rooms.add(new Room(202, "Deluxe", 2800));
        rooms.add(new Room(301, "Suite", 5000));
    }

    public void showAvailableRooms() {
        System.out.println("\n--- Available Rooms ---");
        boolean anyAvailable = false;
        for (Room r : rooms) {
            if (!r.isBooked()) {
                System.out.println(r);
                anyAvailable = true;
            }
        }
        if (!anyAvailable) System.out.println("Sorry, no rooms available right now.");
    }

    public Reservation bookRoom(int roomNumber, Guest guest, int nights) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber && !r.isBooked()) {
                r.setBooked(true);
                Reservation res = new Reservation(nextReservationId++, r, guest, nights);
                reservations.add(res);
                saveBookingToFile(res);
                return res;
            }
        }
        System.out.println("Room not available or doesn't exist.");
        return null;
    }

    public boolean cancelReservation(int reservationId) {
        for (Reservation res : reservations) {
            if (res.getReservationId() == reservationId) {
                res.getRoom().setBooked(false);
                reservations.remove(res);
                System.out.println("Reservation " + reservationId + " cancelled. Room is free again.");
                return true;
            }
        }
        System.out.println("Reservation ID not found.");
        return false;
    }

    public void viewAllBookings() {
        if (reservations.isEmpty()) {
            System.out.println("No active bookings.");
            return;
        }
        for (Reservation res : reservations) {
            res.printInvoice();
        }
    }

    public void makePayment(int reservationId) {
        for (Reservation res : reservations) {
            if (res.getReservationId() == reservationId) {
                res.markPaid();
                System.out.println("Payment of Rs." + res.getTotalBill() + " received. Thank you!");
                return;
            }
        }
        System.out.println("Reservation not found.");
    }

    private void saveBookingToFile(Reservation res) {
        try (FileWriter fw = new FileWriter(DATA_FILE, true)) {
            fw.write("ResID:" + res.getReservationId()
                    + " | Guest:" + res.getGuest().getName()
                    + " | Room:" + res.getRoom().getRoomNumber()
                    + " | Total:" + res.getTotalBill() + "\n");
        } catch (IOException e) {
            System.out.println("Could not save booking to file: " + e.getMessage());
        }
    }
}