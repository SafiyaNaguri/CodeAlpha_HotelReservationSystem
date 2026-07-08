import java.util.*;

public class Main {
    public static void main(String[] args) {
        HotelManager manager = new HotelManager();
        Scanner sc = new Scanner(System.in);
        int guestCounter = 1;

        while (true) {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View All Bookings");
            System.out.println("5. Make Payment");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Enter a number (1-6):");
                sc.next();
            }
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    manager.showAvailableRooms();
                    break;

                case 2:
                    manager.showAvailableRooms();
                    System.out.print("Enter Room Number to book: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Invalid input. Enter a numeric room number:");
                        sc.next();
                    }
                    int roomNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter phone number: ");
                    String phone = sc.nextLine();

                    System.out.print("Number of nights: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Invalid input. Enter a numeric value:");
                        sc.next();
                    }
                    int nights = sc.nextInt();

                    Guest guest = new Guest(guestCounter++, name, phone);
                    manager.bookRoom(roomNo, guest, nights);
                    System.out.println("Booking successful!");
                    break;

                case 3:
                    System.out.print("Enter Reservation ID to cancel: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Invalid input. Enter a numeric ID:");
                        sc.next();
                    }
                    int cancelId = sc.nextInt();
                    manager.cancelReservation(cancelId);
                    break;

                case 4:
                    manager.viewAllBookings();
                    break;

                case 5:
                    System.out.print("Enter Reservation ID to pay for: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Invalid input. Enter a numeric ID:");
                        sc.next();
                    }
                    int payId = sc.nextInt();
                    manager.makePayment(payId);
                    break;

                case 6:
                    System.out.println("Thank you for using our system!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }
}