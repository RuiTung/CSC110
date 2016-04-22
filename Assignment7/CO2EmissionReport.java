/*
 * Assignment 7 / V00800795/ Rui Ma
 * CO2EmissionReport.java
 * Write a program named CO2EmissionReport.java
 * and let it reads in a data file that contains information 
 * on carbon dioxide emissions per country.
 * input: Scanner,Point, PrintStream, IO
 * output: CarbonReport.txt
 * 
 */ 

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

// Scan user's input file name, and evaluate whether the input is correct
// Print the result into a file of CarbonReport.txt
public class CO2EmissionReport {
	
	public static void main(String[] args) {
		Scanner userReader = new Scanner(System.in);
		Scanner file = null;
		System.out.println("Please enter name of input file:");
		
		// use 'while' to evaluate input
		while(file == null) {
			String filename = userReader.next();
			try {
				file = new Scanner(new File(filename));
			} catch (FileNotFoundException e) {
				System.out.println("Invalid value, please retype:");
			}
		}
		
		// assign file's data to CO2DataArray
		CO2Data[] CO2DataArray = readData(file);
		
		// call sortByTotalEmissions method
		sortByTotalEmissions(CO2DataArray);
		
		// scan Canada's rank in the CO2DataArray
		int c = 0;
		for(int i = 0; i < CO2DataArray.length; i++) {
			if(CO2DataArray[i].getCountry().equals("Canada")) {
				c = i + 1;
			}
		}
		
		// print result into output file
		PrintStream output = null;
		try {
			output = new PrintStream(new File("CarbonReport.txt"));
		} catch (java.io.FileNotFoundException e) {
			System.out.println("Error: File cannot be found.");
			System.exit(-1);
		}
		
		// the result consists countries with lowest, highest total emissions, and Canada's ranking
		output.println("The country with the lowest total emissions is " + CO2DataArray[0].getCountry());
		output.println("The country with the highest total emissions is " + CO2DataArray[CO2DataArray.length - 1].getCountry());
		output.println("Canada is ranked " + c + " out of " + CO2DataArray.length + " lowest for total emissions");
		
		// there is a blank line between the two blocks of output!!
		output.println();
		
		// call sortByCO2PerPerson method
		sortByCO2PerPerson(CO2DataArray);
		
		// scan Canada's rank in the CO2DataArray
		for(int i = 0; i < CO2DataArray.length; i++) {
			if(CO2DataArray[i].getCountry().equals("Canada")) {
				c = i + 1;
			}
		}
		
		// the result consists countries with lowest, highest per person emissions, and Canada's ranking
		output.println("The country with the lowest per person road emissions is " + CO2DataArray[0].getCountry());
		output.println("The country with the highest per person road emissions is " + CO2DataArray[CO2DataArray.length - 1].getCountry());
		output.println("Canada is ranked " + c + " out of " + CO2DataArray.length + " lowest for per person road emissions");
	}

	// read CO2Data file
	public static CO2Data[] readData(Scanner s) {
		String content = s.nextLine();
		int dataSize = s.nextInt();

		// create CO2DataArray
		CO2Data[] dataArray = new CO2Data[dataSize];
		for(int i = 0; i < dataArray.length; i++) {
			dataArray[i] = new CO2Data();
			
			String countries = s.next();
			dataArray[i].setCountry(countries);
			
			double totalCO2 = s.nextDouble();
			dataArray[i].setTotalCO2(totalCO2);
			
			double road = s.nextDouble();
			dataArray[i].setRoadCO2(road);
			
			double CO2Person = s.nextDouble();
			dataArray[i].setCO2PerPerson(CO2Person);
			
			int carPerson = s.nextInt();
			dataArray[i].setCarsPerPerson(carPerson);
		}
		return dataArray;
	}

	// use bubble sort to compare value of total emissions then swap
	public static void sortByTotalEmissions(CO2Data[] arr) {
		boolean swapped;
		do {
			swapped = false;
			for(int i = 0; i < arr.length - 1; i++) {
				if(arr[i].getTotalCO2() > arr[i+1].getTotalCO2()) {
					CO2Data temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					swapped = true;
				}
			}
		} while(swapped);
	}

	// use bubble sort to compare value of perperson emissions then swap
	public static void sortByCO2PerPerson(CO2Data[] arr) {	
		boolean swapped;
		do {
			swapped = false;
			for(int i = 0; i < arr.length - 1; i++) {
				if(arr[i].getCO2PerPerson() > arr[i+1].getCO2PerPerson()){
					CO2Data temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					swapped = true;
				}
			}
		} while(swapped);
	}
}
