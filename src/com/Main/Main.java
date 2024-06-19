package com.Main;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import com.utilities.Avaliability;
import com.utilities.Vehicle;
import com.DB.DataBase;
import com.entrance.BillGenerator;
import com.exit.Exit;
import com.utilities.GetParkingDetails;
import com.utilities.Payment;


public class Main {
	
	
	public static int billId=0;	

	public static void main(String[] args) {
		System.out.println("welcome to parking lot application");
		System.out.println("some settings need to be done before using application");
		System.out.println("Please enter 1 for setup");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int val1 = sc.nextInt();
		boolean run=false;
		if(val1==1) {
			System.out.println("Please enter no of types of vehicles does this parking lot should contain");
			int noOfTypes=sc.nextInt();
			for(int i =1;i<=noOfTypes;i++) {
				System.out.println("Please enter type");
				String type=sc.next();
				System.out.println("Please enter no of that vehicles capacity");
				int no=sc.nextInt();
				
				Avaliability.Avail.put(type,no);
				System.out.println("Please enter cost for 1 hour");
				int costForHour = sc.nextInt();
				DataBase.cost.put(type,costForHour);
                System.out.println("Congracts, Initial setup was done"); 
                run=true;
			}
		
		    System.out.println("Please enter 1 to run application");
		    int val2=sc.nextInt();
		    while(run && (val2==1)) {
		    	
		    	System.out.println("Please enter 1 for to park");
		    	System.out.println("please enter 2 for exit ");
		    	System.out.println("Please enter 3 for print all parking vehicle details");
		    	int val3=sc.nextInt();
		    	if(val3==1) {
		    		System.out.println("Please enter type of vehicle to park");
		    		String type=sc.next();
		    		if(Avaliability.Avail.containsKey(type) && Avaliability.Avail.get(type)>0) {
		    			Date startTime = Calendar.getInstance().getTime();
		    			
		    			Vehicle vehicle = new Vehicle(type,startTime);
		    			vehicle.setLocation(Avaliability.Avail.get(type));
		    			BillGenerator bill = new BillGenerator();
		    			System.out.println("Please collect your bill"+bill.billGenerator(billId,type,vehicle));
		    			billId= billId+1;      
		    			Avaliability.Avail.put(type,Avaliability.Avail.get(type)-1);
		    		}
		    	}
		    	else if(val3==2){
		    		
		    		Exit exit = new Exit();
		    		System.out.println("Please enter billId");
		    		GetParkingDetails parkdetails = new GetParkingDetails();
		    		parkdetails.getAllDetails();
		    		int Id = sc.nextInt();
		    		long exitcost= exit.exitCost(Id);
		    		System.out.println("The cost was "+exitcost);
		    		Payment pay = new Payment();
		    		
		    		pay.payment(Id);
		    		
		    		parkdetails.getAllDetails();
		    		
		    	
		    		
		    	}
		    	
		    	
		    	
		    	
		    	
		    }
		    	
		    }
		
	}
	

}
