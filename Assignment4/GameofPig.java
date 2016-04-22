/*
 * Assignment 4 
 * GameofPig.java
 * Write a program named GameofPig to implement the game of “Pig”.
 * input: Scanner,random
 * output: user won or computer won
 */  

import java.util.*;

public class GameofPig{
	
	public static void main(String [] args){
		Scanner yourTyping = new Scanner(System.in);
		Random r = new Random();

		//first time I wrote (6), it's not correct
		//because (6) means from 0 to 5
		//but dice have 6 saides from 1 to 6
		//so plus 1
		int randomRoll = r.nextInt(6) + 1;
		int yourPoint;
		int computerPoint;

		//define elements in while loop
		int count = 1;
		int yourTotal = 0;
		int computerTotal = 0;	

		//while loop contains the whole procedure structure
		//build a one-to-one mapping
		//then call the interface
		while(yourTotal < 100 && computerTotal < 100){
			System.out.println("It is the " + count + " round.");
			count++;

			//call start(you)
			yourPoint = you(r, yourTyping);
			//call end(you)

			yourTotal = yourTotal + yourPoint;
			System.out.println("Your total this round is " + yourPoint + ".");
			System.out.println("Your total so far is " + yourTotal);

			//call start(PC)
			computerPoint = computer(r);
			//call end(PC)

			computerTotal = computerTotal + computerPoint;
			System.out.println("The Computer this round is " + computerPoint + ".");
			System.out.println("The Computer's total so far is " + computerTotal);

			//when satisfy if
			//then break for loop and the while loop above
			//else then excute the following command
			if(yourTotal >= 100 || computerTotal >= 100) { 
				break;
			}else{
				System.out.println("Do you want to roll again? (y or n)");
				String response;
				response = yourTyping.next();

				//get response from (y or n) = the typing next
				//determin whether continue
				//if not continue then break
				while(!response.equals("n") && !response.equals("y")) {
					System.out.println("Invalid value. Please enter y or n.");
					response = yourTyping.next();
				}	
				if(response.equals("n")) 
				break;
			}
		}
		//another condition
		if(yourTotal > computerTotal){
			System.out.println("Computer total is " + computerTotal);
			System.out.println("Your total is " + yourTotal);
			System.out.println();
			System.out.println("Congratulations! You won.");

		}else{
			System.out.println("Computer won.");
		}
	}

	//one-to-one mapping
	public static int you(Random r, Scanner yourTyping){
		boolean cont = true;
		int turnPoint = 0;
		int point = 0;
		while(cont){
			point = r.nextInt(6) + 1;
			System.out.println("You rolled " + point);
			if(point ==1){
				System.out.println("Your turn is over and you loose all your points from this round.");
				return 0;
			}else{
				System.out.println("Do you want to roll again? (y or n)");
				String response;
				response = yourTyping.next();
				if(response.equals("y")){
					cont = true;
					turnPoint = turnPoint + point;
				}else{
					cont = false;
					turnPoint = turnPoint + point;
					return turnPoint;
				}
			}
		}
		return turnPoint;
	}

	public static int computer(Random r){
		int point = 0;
		int turnPoint = 0;
		for(int i = 0; i < 4; i++){
			point = r.nextInt(6) + 1;
			if(point == 1){
				System.out.println("The Computer rolled 1. The Computer's turn is over and looses all its points from this round.");
				return 0;
			}else{
				turnPoint = turnPoint + point;
			}
		}
		return turnPoint;
	}

}
