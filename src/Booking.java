public class Booking {

	private String userName;
	private Show show;
	private int rowNumber;
	private int seatNumber;

	Util util = new Util();

	//Constructor.
	public Booking(String userName, Show show) {
		this.userName = userName;
		this.show = show;
	}

	// Getters and Setters
	public String getUserName() {
		return userName;
	}
	public Show getShow() {
		return show;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public int getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}
	public void setSeatNumber(int seatNumber)
	{
		this.seatNumber = seatNumber;
	}
}
