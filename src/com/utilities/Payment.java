package com.utilities;

import com.DB.DataBase;


public class Payment {

	public boolean payment(int billId) {
		
			String type = DataBase.Bill.get(billId).getType();
			int noOfVel=Avaliability.Avail.get(type);
			Avaliability.Avail.put(type, noOfVel+1);
			DataBase.Bill.remove(billId);
		    return true;
	}
	
}
