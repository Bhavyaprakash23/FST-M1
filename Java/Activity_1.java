package Activitiy1;

public class Activity_1 {
	public static void main(String[] args)
	{
		Car Toyota = new Car();
		Toyota.make = 2026;
		Toyota.color = "Blue";
		Toyota.transmission = "Automatic";
		Toyota.displayCharacterstics();
		Toyota.accelerate();
		Toyota.brake();
	}
}
