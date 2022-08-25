
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class MovieBookingAppApplication {

    public static void main(String[] args) {

        int option = 0;
        Util util = new Util();
        String loggeduserName = "";

        ArrayList<Show> shows = new ArrayList<Show>();
        ArrayList<Booking> sessionsBookings = new ArrayList<Booking>();
        HashMap<String, ArrayList<Booking>> allBookingsDataWithCustomerId = new HashMap<>();

        Scanner select = new Scanner(System.in);
        Scanner choice = new Scanner(System.in);

        //Shows , for now added manually.
        shows.add(new Show("RRR - Film", "23.08.2021", "Screen 2", new BigDecimal(120.727), 10, 7));
        shows.add(new Show("Black Panther - Film", "23.08.2021", "Screen 5", new BigDecimal(100), 5, 5));

        do {
            if (loggeduserName.equals("")) {
                System.out.print("Type what you want to do (login / logout): ");
                String action = select.next();

                if (action.equals("login")) {
                    System.out.print("If You Are Already User Then Enter your unique UserName: ");
                    loggeduserName = select.next();
                    //ToDo: Validate userName.
                } else {
                    System.out.println("Bye. logging out...");
                    System.out.println("Thank You...");
                    sessionsBookings.clear();
                    loggeduserName = "";
                    continue;
                }
            }

            Util.optionsToUser();
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
                    util.printSeatPlan(shows.get(showNumber - 1));                  //Print theater
                    System.out.print("Enter the row: ");
                    int selectedRow = choice.nextInt();
                    System.out.print("Enter the seat: ");
                    int selectedSeat = choice.nextInt();
                    if (!util.validateSelectedSeat(shows.get(showNumber - 1), selectedRow-1, selectedSeat-1)) {
                        System.out.println("Wrong row or seat is selected\n");
                        break;
                    }
                    System.out.println();
                    Booking booking = new Booking(loggeduserName, shows.get(showNumber - 1));
                    if (util.bookSeat(booking, selectedRow - 1, selectedSeat - 1)) {
                        sessionsBookings.add(booking);
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
                for (Booking booking : sessionsBookings) {
                    totalCost = totalCost.add(booking.getShow().getCost());
                }
                System.out.println("Total costs: " + totalCost.setScale(2, BigDecimal.ROUND_UP) + " Rupees");
                String selection;
                System.out.println("Want to Continue? (y/n)");
                selection = choice.next();
                util.bookingConfirmtion(selection, sessionsBookings, allBookingsDataWithCustomerId, totalCost);
                System.out.println();
            }

            if (option == 3) {
                System.out.println("CANCEL BOOKING Selected");
                System.out.println("-------------------------\n");
                System.out.println("Enter Booking ID:");
                String selection = choice.next();
                ArrayList<Booking> bookingByIDForCancellation = allBookingsDataWithCustomerId.get(selection);
                if(null == bookingByIDForCancellation) {
                    System.out.println("Invalid Booking ID");
                    continue;
                }
                for (Booking booking : bookingByIDForCancellation) {
                    util.unBookSeat(booking);      //cancelling booking
                }
                allBookingsDataWithCustomerId.remove(selection);
                System.out.println("Your booking has been canceled!. Payment will be refunded with in 2-3 days.");
                System.out.println();
            }

            if (option == 4) {
                util.UsersBookings(loggeduserName, allBookingsDataWithCustomerId);
            }

            if (option == 5) {
                System.out.println("Bye. logging out...");
                System.out.println("Thank You...");
                sessionsBookings.clear();
                loggeduserName = "";
                //System.exit(0);
            }
        } while (true);
    }

}
