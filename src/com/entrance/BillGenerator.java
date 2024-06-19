package com.entrance;



import com.DB.DataBase;
import com.utilities.Avaliability;
import com.utilities.Vehicle;

public class BillGenerator {

	
	
	public int billGenerator(int billId,String type,Vehicle vehicle) {
		
		if(Avaliability.Avail.get(type)>0) {
			
			DataBase.Bill.put(billId,vehicle);
			
			
	                                       }
		
		return billId;
	}

}
