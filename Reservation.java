public class Reservation {
    private int reservationId;
    private Room room;
    private Guest guest;
    private int nights;
    private double totalBill;
    private boolean paymentDone;

    public Reservation(int reservationId, Room room, Guest guest, int nights) {
        this.reservationId = reservationId;
        this.room = room;
        this.guest = guest;
        this.nights = nights;
        this.totalBill = room.getPricePerNight() * nights;
        this.paymentDone = false;
    }

    public int getReservationId() { return reservationId; }
    public Room getRoom() { return room; }
    public Guest getGuest() { return guest; }
    public double getTotalBill() { return totalBill; }
    public boolean isPaymentDone() { return paymentDone; }
    public void markPaid() { paymentDone = true; }

    public void printInvoice() {
        System.out.println("\n----- Booking Invoice -----");
        System.out.println("Reservation ID : " + reservationId);
        System.out.println("Guest Name     : " + guest.getName());
        System.out.println("Room           : " + room.getRoomNumber() + " (" + room.getCategory() + ")");
        System.out.println("Nights Stayed  : " + nights);
        System.out.println("Total Bill     : Rs." + totalBill);
        System.out.println("Payment Status : " + (paymentDone ? "PAID" : "PENDING"));
        System.out.println("----------------------------");
    }
}