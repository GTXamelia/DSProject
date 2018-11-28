package ie.gmit.sw.bookings;

import java.io.Serializable;

public class Bookings implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String dateStart;
	private String dateEnd;
	private int carID;
	private int customerID;
	
	public Bookings() {
		
	}

	public Bookings(int id, String dateStart, String dateEnd, int carID, int customerID) {
		super();
		this.id = id;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.carID = carID;
		this.customerID = customerID;
	}

	public int getId() {
		return id;
	}

	public String getDateStart() {
		return dateStart;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public int getCarID() {
		return carID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
} 