
public class TwoVehicles {

	public static void main(String[] args) {
		Vehicle minivan = new Vehicle(7, 16, 21);
		Vehicle sportscar = new Vehicle(2, 14, 12);
		double gallons;
		int dist = 252;
		int range1, range2;
		
		gallons = minivan.fuelneeded(dist);
		
//		System.out.println("Minivan can carry " + minivan.passengers + " with a range of " + minivan.range());
		System.out.println("To go " + dist + " miles minivan needs " + gallons + " gallons of fuel.");
		
		gallons = sportscar.fuelneeded(dist);
		
//		System.out.println("Sportscar can carry " + sportscar.passengers + " with a range of " + sportscar.range());
		System.out.println("To go " + dist + " miles sportscar needs " + gallons + " gallons of fuel.");

	}

}
