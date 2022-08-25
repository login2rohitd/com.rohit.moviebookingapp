
import java.math.BigDecimal;
import java.util.ArrayList;

public class Util {

    //To print the details of all show.
    public void detailsOfShow(ArrayList<Show> shows) {
        System.out.println("-------------------------\n");
        for (int i = 0; i < shows.size(); i++) {
            System.out.println(String.format("Show Number: %02d", i + 1));
            System.out.println("Show Name: " + shows.get(i).getShowName());
            System.out.println("Show Date: " + shows.get(i).getShowDate());
            System.out.println("Screen Number: " + shows.get(i).getScreenNo());
            System.out.println("Show Price: " + shows.get(i).getCost().setScale(2, BigDecimal.ROUND_UP) + " Rupees");
            System.out.println("\n");
        }
    }

    //To Print the all seat structure for selected show.
    public void printSeatPlan(Show show) {
        System.out.println();
        int maxSeatsInRow = 0;
        for (Row row : show.getRows())
        {
            if (row.getSeats().size() > maxSeatsInRow)
            {
                maxSeatsInRow = row.getSeats().size();
            }
        }
        System.out.print("   |");
        for (int i=1; i <= maxSeatsInRow; i++) {
            System.out.print(" " + i);
        }
        System.out.print("\n");
        System.out.print("----");
        for (int i=1; i <= maxSeatsInRow; i++) {
            if (i>9) {
                System.out.print("---");       //3 dashes because it will be 3 digits.
            }
            else {
                System.out.print("--");
            }
        }
        System.out.print("\n");
        for (Row row : show.getRows())
        {
            if (row.getRowNumber()>9) {
                System.out.print(row.getRowNumber() + " | ");
            }
            else {
                System.out.print(row.getRowNumber() + "  | ");
            }
            for (Seat seat : row.getSeats())
            {

                if (seat.isReserved()) {
                    System.out.print("X ");
                }
                else {
                    System.out.print(seat.getSeatNumber() + " ");
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    //Final Booking with checkout.
    public boolean bookSeat(Booking booking, int selectedRow, int selectedSeat) {
        Seat seat = booking.getShow().getRows().get(selectedRow).getSeats().get(selectedSeat);
        if (seat.isReserved()) {
            return false;
        }
        else {
            reserveSeat(seat);
            booking.setRowNumber(selectedRow);
            booking.setSeatNumber(selectedSeat);
            return true;
        }
    }

    //To Reserve Seat.
    public void reserveSeat(Seat seat) {
        seat.setReserved(true);
    }

    //Validate selected seat
    public boolean validateSelectedSeat(Show show, int selectedRow, int selectedSeat) {
        if (selectedRow>show.getRows().size()-1){
            return false;
        }

        if (selectedSeat>show.getRows().get(selectedRow).getSeats().size()-1){
            return false;
        }

        return true;
    }

    //TODO: To cancel Booking.
    public boolean unBookSeat(Booking booking) {
        Seat seat = booking.getShow().getRows().get(booking.rowNumber).getSeats().get(booking.seatNumber);
        unReserveSeat(seat);
        return true;
    }

    //To Un-Reserve Seat.
    public void unReserveSeat(Seat seat)
    {
        seat.setReserved(false);
    }


}
