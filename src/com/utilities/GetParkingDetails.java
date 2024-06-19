package com.utilities;

import java.util.Map;

import com.DB.DataBase;

public class GetParkingDetails {
	
	public void getAllDetails() {
		
		Map<Integer,Vehicle> bill = DataBase.Bill;
		for(int billId : bill.keySet()) {
			System.out.print(billId);	
		}
		
	}

}
