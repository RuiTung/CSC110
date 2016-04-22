/*
 * Assignment 5
 * Slugs.java
 * Write a program named Slugs to implement all points.
 * input: Scanner,Point, PrintStream
 * output: all points
 */  

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.awt.*;

public class Slugs {
		public static void main(String[] args) {
			Scanner fileScanner = setupScanner();
			String fileName = fileScanner.next();
			PrintStream filePrinter = setupPrintStream(fileName);
			int imageSize = fileScanner.nextInt();
			
			//int d = fileScanner.nextInt();
			PrintStream output = setupPrintStream(fileName);
			output.println(imageSize + " " + imageSize);
			//Point[] slugs=setupSlugs(imageSize);
			int d = 10;
			
			Point[] slugs = new Point[4];
			
			slugs[0]=new Point(0,0);
			slugs[1]=new Point(0,imageSize);
			slugs[2]=new Point(imageSize,imageSize);
			slugs[3]=new Point(imageSize,0);

			int i = 0;
			while(distance1 (slugs[i],slugs[(i + 1) % 4]) > d) {
				int dis=distance1 (slugs[i],slugs[(i + 1) % 4]);
				slugs[i]=position (d,slugs[i],slugs[(i + 1) % 4],output);
				i = (i + 1) % 4;
			}
		}

		//calculate the moving distance
		public static int distance1(Point p1,Point p2){
			int x = p1.x - p2.x;
			int y = p1.y - p2.y;
			int distance = (int)Math.sqrt(x * x + y * y);
			return distance;
		}
		
		//get points
		public static Point position(int distance1,Point p1,Point p2, PrintStream output){		
			output.print(p1.x + " ");
			output.print(p1.y + " ");
			int distance2 = distance1(p1,p2);
			int x1 = p2.x - p1.x;
			int y1 = p2.y - p1.y;
			double ratio = (double) distance1 / distance2;
			int newx = (int) (ratio * x1);
			int newy = (int) (ratio * y1);
			int nextx = newx + p1.x;
			int nexty = newy + p1.y;
			Point s = new Point(nextx, nexty);
			output.println(nextx + " " + nexty);
			return s;
		}

		//read data from file
		public static Scanner setupScanner() {
			Scanner s = null; 
			File f = new File("slug_details.txt");
			try {
				s = new Scanner(f);
				System.out.println("successfully scanning slug_details.txt");
			} catch(IOException e) {
				System.out.println("Can't scan the file");
				System.exit(-1);
			}
			return s;
		}		
		
		//put data into file
		public static PrintStream setupPrintStream(String fileName) {
			PrintStream p = null;
			File f = new File(fileName);
			try {
				p = new PrintStream(f);
				System.out.println("Successfully linked printstream");
			} catch (IOException e){
				System.out.println("Unable to set up the printstream");
				System.exit(-1);	
			}
			return p;
		}		
}