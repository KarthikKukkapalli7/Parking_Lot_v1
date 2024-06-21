package com.exit;


import java.util.Calendar;
import java.util.Date;

import com.DB.DataBase;




public class Exit {

	public double exitCost(int billId) {
		
		
		Date endTime = Calendar.getInstance().getTime();
		Date startTime = DataBase.Bill.get(billId).getTime();
		System.out.println(endTime.toString()+" "+startTime.toString());
		
		long difference = endTime.getTime() - startTime.getTime();
		System.out.println(difference+" "+endTime+" "+startTime);
		double differenceHours = (double)difference / (60 * 60 * 1000);
		
		return DataBase.cost.get(DataBase.Bill.get(billId).getType())*differenceHours; 
		
	}
	
}