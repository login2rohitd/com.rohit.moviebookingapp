
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieBookingAppApplication {

    public static void main(String[] args) {

        int option = 0;
        Util util = new Util();

        ArrayList<Show> shows = new ArrayList<Show>();
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        Scanner select = new Scanner(System.in);
        Scanner choice = new Scanner(System.in);

        shows.add(new Show("RRR - Film", "23.08.2021", "Screen 2", new BigDecimal(120.727), 10, 7));
        shows.add(new Show("Black Panther - Film", "23.08.2021", "Screen 5", new BigDecimal(100), 5, 5));

        do {
            System.out.println("------------------------------------");
            System.out.println(":Cinema Booking System by Rohit:");
            System.out.println("------------------------------------\n");
            //ToDo: System.out.println("Please Enter 0 to Add Show");
            System.out.println("Please Enter 1 to Display Shows");
            System.out.println("Please Enter 2 to Make Booking");
            System.out.println("Please Enter 3 to Cancel Booking");
            System.out.println("Please Enter 4 to Exit\n");

            System.out.print("Enter Option: ");
            option = select.nextInt();

            if (option == 1) {
                System.out.println("DISPLAY SHOWS Selected");
                util.detailsOfShow(shows);
                System.out.println("End of Show List.\n");
            }

            if (option == 2) {
                System.out.println("MAKE BOOKING Selected");
                util.detailsOfShow(shows);
                System.out.println("-------------------------");
                System.out.print("Enter the show number: ");
                int showNumber = choice.nextInt();
                if (showNumber>shows.size()) {
                    System.out.println("Wrong Show Number is entered\n");
                    continue;
                }
                int repeat = 0;
                System.out.println();
                do {
                    util.printSeatPlan(shows.get(showNumber - 1));
                    System.out.print("Enter the row: ");
                    int selectedRow = choice.nextInt();
                    System.out.print("Enter the seat: ");
                    int selectedSeat = choice.nextInt();
                    if (!util.validateSelectedSeat(shows.get(showNumber - 1), selectedRow-1, selectedSeat-1)) {
                        System.out.println("Wrong row or seat is selected\n");
                        break;
                    }
                    System.out.println();
                    Booking booking = new Booking(shows.get(showNumber - 1));
                    if (util.bookSeat(booking, selectedRow - 1, selectedSeat - 1)) {
                        bookings.add(booking);
                        System.out.println("Booked Successfully. The seat is now reserved for you.");
                    } else {
                        System.out.println("Sorry the seat is already reserved.");
                    }
                    System.out.println();
                    System.out.print("Enter 1 to reserve another seat or 2 to check out: ");
                    repeat = choice.nextInt();
                } while (repeat == 1);
                System.out.println();
                System.out.println("Your Bill");
                System.out.println("-------------------------");
                BigDecimal totalCost = new BigDecimal(0.0);
                for (Booking booking : bookings) {
                    totalCost = totalCost.add(booking.getShow().getCost());
                }
                System.out.println("Total costs: " + totalCost.setScale(2, BigDecimal.ROUND_UP) + " Rupees");
                System.out.println();
            }

            if (option == 3) {
                System.out.println("CANCEL BOOKING Selected");
                System.out.println("-------------------------\n");
                for (Booking booking : bookings) {
                    util.unBookSeat(booking);      //cancelling booking
                }
                bookings.clear();
                System.out.println("Your reservation has been canceled!");
                System.out.println();
            }

            if (option == 4) {
                System.exit(0);
            }

        } while (true);
    }

}
