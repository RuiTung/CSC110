/*
 * Assignment 1
 * PositionCalculator.java
 * Calculate Fomula
 */    
public class PositionCalculator {
	
	public static void main(String[] args) {
		
		double s0 = 5.0;
		double v0 = 2.0;
		double t = 10.0;
		double a = 1.5;
		double s = s0 + v0 * t + (a*t*t) / 2;
		
		System.out.println("The new position is " + s);
		
	}
}
		
