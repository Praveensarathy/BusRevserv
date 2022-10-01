
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Bus> buses = new ArrayList<Bus>();
		ArrayList<Booking> bookings = new ArrayList<Booking>();        
		ArrayList<DeluxBus> dbuses = new ArrayList<DeluxBus>();
		buses.add(new Bus(1));
		buses.add(new Bus(3));
		buses.add(new Bus(2));
		
		dbuses.add(new DeluxBus(1));
		dbuses.add(new DeluxBus(2));
		dbuses.add(new DeluxBus(3));
		for(Bus b : buses) {
			b.display();
		}
		System.out.println("\n\n");
		for(DeluxBus db : dbuses) {
			db.display();
		}
		do {
			System.out.println("1.For new Booking");
			System.out.println("2.Existing Booked Tickets");
			System.out.println("3.For Delux Buses Available Tickets and Price");
			System.out.println("4.For Express Buses Available Tickets and Price");
			System.out.println("5.Cancellation");
			System.out.println("6. Exit...");
			int n = sc.nextInt();
		
			if(n==1) {
				int sum =0;
				for(Bus b : buses) {
					sum += b.cap;
				}
				if(sum==0) {
					System.out.println("Sorry All buses are booked please try another login..!");
				}
				Booking p1 = new Booking();
				System.out.println("Booking Details");
				System.out.println( "\nPname   " + p1.passergerName +"\nid      "+p1.passengerId+"\nBusNo.  "+ p1.Busno + "\nPCount  "+ p1.passengerCount);
				if(p1.berth == 'l' || p1.berth == 'u') {
					if(p1.DeluxIsAvail(dbuses,bookings,p1)) {					
						bookings.add(p1);
					}
					else
						System.out.println("--------------sorry Bus Number " + p1.Busno +" bus tickets are already booked ... please try another bus\n");
				}
				else {
				if(p1.isAvail(buses,bookings,p1)) {					
					bookings.add(p1);
				}
				else
					System.out.println("--------------sorry Bus Number " + p1.Busno +" bus tickets are already booked ... please try another bus\n");
				}
			}
			
			if(n==2) 
				Booking.BookingDetails(bookings);
			if(n==3) {
				for(DeluxBus db : dbuses) 
					db.display();
				System.out.println();
			}
			if(n==4) {
				for(Bus b : buses)
					b.display();
				System.out.println();
			}
			if(n==5) {
				System.out.println("Enter your BookingId");
				int id = sc.nextInt();
				Main.cancellation(id,bookings,buses);
			}
				
			if(n==6) {
				return;
			}
		}while(true);
	}
	public static void cancellation(int id,ArrayList<Booking>bookings,ArrayList<Bus>buses) {
		for(Booking p : bookings) {
			if(id==p.passengerId) {
				String name = p.passergerName;
				for(Bus b:buses) {
					if(p.Busno==b.Busno) {
						b.cap +=p.passengerCount;
						break;
					}
				}
				bookings.remove(p);
				System.out.println(name +" Your tickets are successfully Cancelled ...");
				break;
			}
			else
				System.out.println("your id is Not found");
		}
		
	}

}
