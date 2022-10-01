

public class DeluxBus extends Bus{
	
	int Lcap = 5;
	int Ucap = 5;
	int price = 200;
	Boolean Ac = true;
	
	public DeluxBus(int BusNo) {
		super(BusNo);
	}
	public void display() {
		System.out.println("busNo -> " + Busno + "  LowerBerth -> " +Lcap +"  UpperBerth-> "+ Ucap + " price ->" + price);
	}
	

}
