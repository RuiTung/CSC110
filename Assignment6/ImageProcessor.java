/*
 * Assignment 6
 * ImageProcessor.java
 * Write a program named ImageProcessor.java to perform an image transformation
 * reflect vertical axis and horizontal axis, tile image and brighten/darken image
 * input: color, buffer, Io, imageIo
 * output: text file
 */  

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class ImageProcessor {

    public static int[][] readGrayscaleImage(String filename) {
    	//create the array
    	int [][] result = null; 
        try {
        	//create the file
            File imageFile = new File(filename);    
            BufferedImage image = ImageIO.read(imageFile);
            int height = image.getHeight();
            int width  = image.getWidth();
            //read each pixel value
            result = new int[height][width];       
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int rgb = image.getRGB(x, y);
                    result[y][x] = rgb & 0xff;
                }
            }
        }
        catch (IOException ioe) {
            System.err.println("Problems reading file named " + filename);
            System.exit(-1);
        }
        
        //once we're done filling it, return the new array
        return result;
    }


    public static void writeGrayscaleImage(String filename, int[][] array) {
        int width = array[0].length;
        int height = array.length;

        try {
        	//create the image
            BufferedImage image = new BufferedImage(width, height,
            BufferedImage.TYPE_INT_RGB);  
            
            //set all its pixel values based on values in the input array
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int rgb = array[y][x];
                    rgb |= rgb << 8;
                    rgb |= rgb << 16;
                    image.setRGB(x, y, rgb);
                }
            }
            
            //write the image to a file
            File imageFile = new File(filename);
            ImageIO.write(image, "jpg", imageFile);
        }
        catch (IOException ioe) {
            System.err.println("Problems writing file named " + filename);
            System.exit(-1);
        }
    }
    
    // print 2D array
    public static void print2dArray(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%3d ", arr[i][j]);
            }
            System.out.println();
        }
    }
    
    // convert image into an ASCII image and print to a text file
    public static void ascii(String arr1, String arr2) {
    	int[][] imagefile = readGrayscaleImage(arr1);
    	int height = imagefile.length;
        int width = imagefile[0].length; 
        String[][] output = new String[height][width];
        PrintStream newTextFile = null;
        
    	for(int row = 0; row < height; row++){
        	for(int i = 0; i < width; i++){
                
        		//0 to 25: M, 26 to 50: $, 51 to 76: o, 77 to 102: |, 103 to 127: *
        		//128 to 152: :, 153 to 178: =, 179 to 204: \, 205 to 230: ., 231 to 255: space
        		//use if, else if to judge all situations
        		if(imagefile[row][i] >=0 && imagefile[row][i] <= 25){
                	output[row][i]="M";
                }
                else if(imagefile[row][i] >= 26 && imagefile[row][i] <= 50){
                	output[row][i]="$";
                    }else if(imagefile[row][i] >= 51 && imagefile[row][i] <= 76){
                    	output[row][i]="o";
                    }else if(imagefile[row][i] >= 77 && imagefile[row][i] <= 102){
                    	output[row][i]="|";
                    }else if(imagefile[row][i] >= 103 && imagefile[row][i] <= 127){
                    	output[row][i]="*";
                    }else if(imagefile[row][i] >= 128 && imagefile[row][i] <= 152){
                    	output[row][i]=":";
                    }else if(imagefile[row][i] >= 154 && imagefile[row][i] <= 178){
                    	output[row][i]="=";
                    }else if(imagefile[row][i] >= 179 && imagefile[row][i] <= 204){
                    	output[row][i]="\'";
                    }else if(imagefile[row][i] >= 205 && imagefile[row][i] <= 230){
                    	output[row][i]=".";
                    }else if(imagefile[row][i] >= 231 && imagefile[row][i] <= 255){
                    	output[row][i]=" ";
                    }
        	}
    	}

    	try {
    		newTextFile = new PrintStream(new File(arr2));
    		System.out.println("Successfully write data.");
    	} catch(IOException e) {
            System.err.println("Problems writing on file named");
            System.exit(-1);
    	}
    	for(int m = 0; m < height; m++) {
    		for( int n = 0; n < width; n++) {
    			newTextFile.print(output[m][n]);
    		}
    		newTextFile.println();
    	}
    }
    
    // reflect contents of the image across the vertical axis
    public static int[][] reflectV(int[][] arr) {
        int height = arr.length;
        int width = arr[0].length;      
        int[][] flippedArray = new int[height][width];
        
        for (int row = 0; row < arr.length; row++) {
            for (int i = 0; i < arr[row].length; i++) {
                flippedArray[row][i] = arr[row][arr[row].length-1-i];
            }
        }        
        return flippedArray;
    }

    // reflect contents of the image across the horizontal axis
    public static int[][] reflectH(int[][] arr) {
    	int height = arr.length;
    	int width = arr[0].length;
    	int[][] flippedArray = new int[height][width];

    		for (int column = 0; column < arr[column].length; column++) {
    			for(int j = 0; j < arr.length; j++) {
    				flippedArray[column][j] = arr[arr.length - 1 -column][j];
    			}
    		}	
    	return flippedArray;
    }
    
    // repeat image according to number of items
    public static int[][] tile(int[][] arr, int i1, int i2) {
    	int height = arr.length * i2;
    	int width = arr[0].length * i1;
    	int[][] flippedArray = new int[height][width];
    	for(int i = 0; i < i2; i++) {
    		for(int j = 0; j < i1; j++) {
    			for (int row = 0; row < arr.length; row++) {
    				for (int m = 0; m < arr[row].length; m++) {
    					flippedArray[row+arr.length*i] [m + arr[row].length * j] = arr[row][m];
    				}
    			}
    		}
    	}
    	return flippedArray;
    }
    
    // brighten or darken the image
    public static int[][] adjustBrightness(int[][] arr, int x) {
    	int height = arr.length;
    	int width = arr[0]. length;
    	int[][] flippedArray = new int[height] [width];
    	
    	for(int row = 0; row < arr.length; row++) {
    		for(int i = 0; i < arr[row].length; i++) {
    			flippedArray[row][i] = arr[row][i] + x;
    			
    			// two error checking conditions, when the value is out of range
    			if (flippedArray[row][i] > 255) {
    				flippedArray[row][i] = 255;
    			}
    			if (flippedArray[row][i] < 0) {
    				flippedArray[row][i] = 0;
    			}
    		}
    	}
    	return flippedArray;
    }
    
    // main method concludes all methods 
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Error: Arguments are not enough.");
            System.exit(-1);
        }
        
        // create function
        String function = args[0];

        if (function.equals("-ascii")) {
        	ascii(args[1], args[2]);
        } else if (function.equals("-reflectH")) { 
            String inputFileName = args[1];
            System.out.println("reading in file " + inputFileName);
            String outputFileName = args[2];
            int[][] arr = readGrayscaleImage(inputFileName);
            int[][] flippedArray = reflectV(arr);
            writeGrayscaleImage(outputFileName, flippedArray);
        } else if (function.equals("-reflectV")) {
            String inputFileName = args[1];
            System.out.println("reading in file " + inputFileName);
            String outputFileName = args[2];
            int[][] arr = readGrayscaleImage(inputFileName);
            int[][] flippedArray = reflectV(arr);
            writeGrayscaleImage(outputFileName, flippedArray);
        } else if(function.equals("-tile")) {
        	int x = Integer.parseInt(args[1]);
        	int y = Integer.parseInt(args [2]);
        	int [][] a = readGrayscaleImage(args[3]);
        	int [][] b = tile(a, y, x);
        	writeGrayscaleImage(args[4], b);
        } else if(function.equals("adjustBrightness")) {
        	int amount = Integer.parseInt(args [1]);
        	int [][] a = readGrayscaleImage(args [2]);
        	int [][] b = adjustBrightness(a, amount);
        	writeGrayscaleImage(args[3], b);
        } else {
        	System.out.println("Wrong Arguments");
        }
        
    }
}
