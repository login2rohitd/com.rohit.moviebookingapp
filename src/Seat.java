
public class Seat {

	private int seatNumber;
	private boolean isReserved;

	//Constructor.
	public Seat(boolean isReserved, int seatNumber) {
		this.isReserved = isReserved;
		this.seatNumber = seatNumber;
	}


	//Getters and setters.
	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public boolean isReserved() {
		return isReserved;
	}

	public void setReserved(boolean reserved) {
		isReserved = reserved;
	}
}
