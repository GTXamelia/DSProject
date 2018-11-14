package ie.gmit.sw;

import java.io.Serializable;

public class Car implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int reg;
	private String Year;
	private String Make;
	private Double cost;
	
	public Car(){
		
	}

	public Car(int id, int reg, String year, String make, Double cost) {
		this.id = id;
		this.reg = reg;
		this.Year = year;
		this.Make = make;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public int getReg() {
		return reg;
	}

	public String getYear() {
		return Year;
	}

	public String getMake() {
		return Make;
	}

	public Double getCost() {
		return cost;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setReg(int reg) {
		this.reg = reg;
	}

	public void setYear(String year) {
		Year = year;
	}

	public void setMake(String make) {
		Make = make;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

} 