
class Vehicle {
	int passengers; //number of passengers
	int fuelcap; //fuel capacity in gallons
	int mpg; //fuel consumption in miles per gallon
	
	Vehicle(int p, int f, int m){
		passengers = p;
		fuelcap = f;
		mpg = m;
	}
	
	int range(){
		return fuelcap * mpg;
	}
	
	double fuelneeded(int miles){
		return (double) miles / mpg;
	}
}

//This class declares an object of type Vehicle
class VehicleDemo{
	public static void main(String[] args) {
		Vehicle minivan = new Vehicle(1, 2, 3);
		
		//assign values to fields in minivan
		minivan.passengers = 7;
		minivan.fuelcap = 16;
		minivan.mpg = 21;
		
		//compute the range assuming a full tank of gas
		System.out.print("Minivan can carry " + minivan.passengers +  " with a range of " + minivan.range());
	}
}
