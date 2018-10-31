package ie.gmit.sw;

import java.io.Serializable;

public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public Customer() {
		
	}
	
	public Customer(String n) {
		this.name = n;
	}

	public String getName() {
	    return name;
	}
	
	public void setName(String name) {
	    this.name = name;
	}

} 