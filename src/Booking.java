
public class Booking {

	Show show;
	int rowNumber;
	int seatNumber;

	Util util = new Util();

	//Constructor.
	public Booking(Show show) {
		this.show = show;
	}

	// Getters and Setters
	public Show getShow() {
		return show;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}
	public void setSeatNumber(int seatNumber)
	{
		this.seatNumber = seatNumber;
	}
}
