package com.utilities;

import java.util.Date;

public class Vehicle {
	
	private int Location;
	private String type;
	Date time;


	public Vehicle(String type,Date time) {
		this.type = type;
		this.time=time;
	}

	
	public Date getTime() {
		return time;
	}

	public int getLocation() {
		return Location;
	}


	public void setLocation(int location) {
		Location = location;
	}


	public String getType() {
		return type;
	}

	
	
}
