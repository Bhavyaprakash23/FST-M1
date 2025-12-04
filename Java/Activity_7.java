package Activitiy1;

public class Activity_7 {

	public static void main(String[] args) {
		 MountainBike mb = new MountainBike(3, 0, 25);
	        System.out.println(mb.bicycleDesc());
	        
	        mb.speedUp(20);
	        System.out.println(" current speed after speeding up : " + mb.currentSpeed);
	        
	       
	        mb.applyBrake(5);
	        System.out.println(" current speed after applying brakes : " + mb.currentSpeed);
	        
	    }
	}