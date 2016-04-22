/*
 * Assignment 3 
 * CarbonCal.java
 * Write a program named CarbonCal.java to calculate a user's carbon footprint over 1 year.
 * input: Scanner
 * output: transportation;electricity;food;total
 */  

import java.util.*;

	public class CarbonCalc {
			public static void main(String[] args) {
				Scanner console = new Scanner(System.in);
				double transportation = determineTransportationEmission(console);
				double electricity = determineElectricityEmission(console);
				double food = determineFoodEmission(console);
				double total = calculateTotalEmission(transportation, electricity, food);
				printReport(transportation,electricity,food,total);
			}
					
			public static double determineTransportationEmission(Scanner input) {
				
				//1. The number of kilometers / day
				//2. The fuel efficiency
				
				System.out.println("How many kilometers do you drive perday?");
				double kilometersPerDay = input.nextDouble();
				System.out.println("What is the fuel efficiency of your car?");
				double fuelEfficiency = input.nextDouble();
				
				//kgCO2 = 2.3 x litresUsedPerYear
				//litresUsedPerYear = 365 x (kmPerDay ¡Â fuelEfficiency)
				
				double litersUsedPerYear = 365 * (kilometersPerDay/fuelEfficiency);
				double transpotation = 2.3 * litersUsedPerYear;
				return transpotation;
				
			}
			
			public static double determineElectricityEmission(Scanner input) {
				
				//1. The monthly kilowatt usage.
				//2. The number of people in the home.
				
				System.out.println("What is the monthly kilowatt usage?");
				double kWhPerMonth = input.nextDouble();
				System.out.println("How many people in the home?");
				double numPeopleInHome= input.nextDouble();
				
				//kgCO2 = (kWhPerMonth * 12 * 0.257) ¡Â numPeopleInHome
				
				double electricity = (kWhPerMonth * 12 * 0.257)/numPeopleInHome;
				return electricity;
				
			}
			public static double determineFoodEmission(Scanner input) {
				
				//1. The percentage of meat & fish.
				//2. The percentage of dairy.
				//3. The percentage of fruits & vegetables.
				//4. The percentage of carbohydrates.
				
				System.out.println("What percentage of meat and fish in your diet?");
				double percentageMeatAndFish = input.nextDouble();
				System.out.println("What percentage of diary in your diet?");
				double percentageDiary = input.nextDouble();
				System.out.println("What percentage of fruits and vegetables in your diet?");
				double percentageFruitsAndVegetables = input.nextDouble();
				System.out.println("What percentage of carbohydrates?");
				double percentageCarbohydrates = input.nextDouble();
				
				//Yearly kgC02 for meat = (% meat and fish eaten) x 53.1
				//Yearly kgCO2 for dairy = (% dairy eaten) x 13.8
				//Yearly kgC02 for fruit&veg = (% fruit and veg eaten) x 7.6
				//Yearly kgCO2 for Carbs = (% carbs eaten) x 3.1
				// total yearly kgCO2 for food is the sum of the above 4
				
				double yearlyMeatAndFish = percentageMeatAndFish * 53.1;
				double yearlyDiary = percentageDiary * 13.8;
				double yearlyFruitsAndVegetables = percentageFruitsAndVegetables * 7.6;
				double yearlyCarbohydrates = percentageCarbohydrates * 3.1;
				
				double food = yearlyMeatAndFish + yearlyDiary + yearlyFruitsAndVegetables + yearlyCarbohydrates;
				return food;
				
			}
			
			public static double calculateTotalEmission(double transportation, double electricity, double food) {
				double total = (transportation + electricity + food) / 1000;
				return total;
				
			}
			
			public static void printReport(double transportation, double electricity, double food, double total) {
				
				//You produce an annual total of 7.14432 metric tons of CO2 per year.
				//The breakdown is as follows:
				//       Car          32.90166%
				//       Electricity  0.43167156%	
				//       Food         66.66667%		
				
				System.out.println("You produce an anuual total of " + total + " metric tons of CO2 per year.");
				System.out.println("The breakdown is as follows:");
				System.out.println("\tCar:\t\t" + transportation / 1000 / total * 100 + "%");
				System.out.println("\tElectricity:\t" + electricity / 1000 / total * 100 + "%");
				System.out.println("\tFood:\t\t" + food / 1000 / total * 100 + "%");
				
				//It is the first code that I wrote over 100 lines.
				//Dover is really a smart guy~~~
			}
			
	}