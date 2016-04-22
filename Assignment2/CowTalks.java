/*
 * Assignment 2
 * CowTalks.java
 * Print a Cow and let it talks
 */  
import java.util.Scanner;

public class CowTalks {
	public static void main(String[] args) {
		printMessage();
		printCow();
	}
	public static void printMessage() {
		Scanner userReader = new Scanner(System.in);
		System.out.println("What should the cow say?");
		String theName = userReader.nextLine();
		int nameSize = theName.length() + 4;
		
		for (int i = 1; i <= nameSize; i++) {
			System.out.print ("*");
		}

		System.out.println("\n| " + theName + "|");

		for (int i = 1; i <= nameSize; i++) {
			System.out.print("*");
		}
	}

	public static void printCow() {
		System.out.println();
		System.out.println("        \\    ^__^");
		System.out.println("         \\   (oo)\\_______");
		System.out.println("             (__)\\       )\\/\\");
		System.out.println("                    ||----w |");
		System.out.println("                    ||     ||");
	}
}