
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Booking {
	int passengerCount;
	String passergerName;
	int Busno;
	static int id =1;
	int passengerId =1;
	char berth;
	Scanner sc = new Scanner(System.in);
	Booking(){
		System.out.println("Enter the Your name:");
		passergerName = sc.next();
		
		System.out.println("1.For Express 2.For Delux" );
		int n = sc.nextInt();
		switch(n) {
		case 1:{
			CusDetails();
			break;
		}
		case 2:{
			CusDetails();
			System.out.println("Enter Your prefered Berth..");
			berth = sc.next().charAt(0);
			
			break;
		}
			
		}
	}
	
	public static void BookingDetails(ArrayList<Booking>bookings) {
		System.out.println("Bookings Details...");
		for(Booking p : bookings) {
			System.out.println(p.passergerName +"  " +p.passengerId + "  " +p.Busno + " "+ p.passengerCount+"\n");
		}
	}
	
	
	
	public void CusDetails() {
		System.out.println("Enter the How many persons:");
		boolean noProb = true;
		do {
		try {
			passengerCount = Integer.parseInt(sc.next());
			noProb = false;
		}
		catch (Exception e) {
			System.out.println(e + "\nso enter the valid input");
		}
		}while(noProb);
		
		
		System.out.println("Enter the Bus Number:");
		noProb = true;
		do {
		try {
			Busno = Integer.parseInt(sc.next());
			if(Busno > 4) {
				System.out.println("Please Enter Valid Busno -> 1,2,3");
				noProb = true;
				continue;
			}
				 
			noProb = false;
		}
		catch (Exception e) {
			System.out.println(e + "\nso enter the valid input");
		}
		}while(noProb);
		
		
		passengerId = id++;
	}


	public boolean DeluxIsAvail(ArrayList<DeluxBus> dbuses, ArrayList<Booking> bookings, Booking p1) {
		for(DeluxBus b : dbuses) {
			if(b.Busno == p1.Busno) {
				if(p1.berth=='l') {
					if(b.Lcap >= p1.passengerCount) {
						b.Lcap -=p1.passengerCount;
						int price = b.price* p1.passengerCount;
						System.out.println(p1.passergerName + "  You Booking is Confirmed\n");
						System.out.println("Total amount is " + price);
						return true;
					}
				}
				if(p1.berth=='u') {
					if(b.Ucap >= p1.passengerCount) {
						b.Ucap -=p1.passengerCount;
						int price = b.price* p1.passengerCount;
						System.out.println(p1.passergerName + "  You Booking is Confirmed\n");
						System.out.println("Total amount is " + price);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean isAvail(ArrayList<Bus> buses, ArrayList<Booking> bookings, Booking p1) {
		int capacity =0;
		for(Bus b : buses) {
			if(b.Busno == p1.Busno) {
				capacity = b.cap;
				if(capacity >= p1.passengerCount) {
						b.cap -= p1.passengerCount;
						int price = b.price* p1.passengerCount;
						System.out.println("______________________________________");
						System.out.println(p1.passergerName + "  You Booking is Confirmed\n");
						System.out.println("Total amount is " + price);
						System.out.println();
						return true;
				}
			}
		}
		return false;
	}
	

}