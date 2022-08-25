
import java.math.BigDecimal;
import java.util.ArrayList;

public class Show {

	private String showName;
	private String showDate;
	private String screenNo;
	private BigDecimal cost;
	private ArrayList<Row> rows;

	//Constructor
	public Show(String showName, String showDate, String screenNo, BigDecimal cost, int rowsForShow, int seatsForEachRowsForShow) {
		this.showName = showName;
		this.showDate = showDate;
		this.screenNo = screenNo;
		this.cost = cost;

		//Initialised the rows arrayList. And added specified number of rows instances for show.
		this.rows = new ArrayList<>();
		createRows(rowsForShow, seatsForEachRowsForShow);
	}

	//Created specified number of rows instances for show.
	public void createRows(int rowsForShow, int seatsForEachRowsForShow) {
		for (int i = 1; i <= rowsForShow; i++)
		{
			rows.add(new Row(i, seatsForEachRowsForShow));
		}
	}

	//Getters and Setter.
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}
	public String getShowName() {
		return showName;
	}
	public String getShowDate() {
		return showDate;
	}
	public String getScreenNo() {
		return screenNo;
	}
	public ArrayList<Row> getRows() {
		return rows;
	}
	public BigDecimal getCost() {
		return cost;
	}
}
