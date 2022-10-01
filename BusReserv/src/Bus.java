

import java.util.ArrayList;

public class Bus {
	int Busno;
	int cap=10;
	int price=100;
	public Bus(int BusNo) {
		Busno = BusNo;
	}
	public void display() {
		System.out.println("busNo -> " + Busno + " Capacity: " + cap + " price ->" + price);
	}
}