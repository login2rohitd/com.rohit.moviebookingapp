
import java.util.ArrayList;

public class Row {

	private int rowNumber;
	private int seatCount;

	private ArrayList<Seat> seats;

	public Row(int rowNumber, int seatCount) {
		this.rowNumber = rowNumber;
		this.seatCount = seatCount;

		//Initialised the seats arrayList. And added specified number of seats instances in row.
		seats = new ArrayList<Seat>();
		createSeats(this.seatCount);
	}

	public int getRowNumber()
	{
		return rowNumber;
	}

	//To create specified number of seats instances in row.
	public void createSeats(int seatCount) {
		for (int i = 1; i <= seatCount; i++)
		{
			seats.add(new Seat(false, i));
		}
	}

	public ArrayList<Seat> getSeats() {
		return seats;
	}
}
