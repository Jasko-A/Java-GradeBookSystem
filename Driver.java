import api.*;
import interfaces.*;   //import necessary packages and interfaces
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
			//this is an array of text files that a read into the program
		String texts[] = { "C:\\Users\\Jasmin\\Documents\\Java\\Assignment 7\\src\\studentQuizes.txt",
				"C:\\Users\\Jasmin\\Documents\\Java\\Assignment 7\\src\\studentQuizes1.txt",
				"C:\\Users\\Jasmin\\Documents\\Java\\Assignment 7\\src\\studentQuizes2.txt" };
		AllScores a1[] = new GradeBookBridge[3];
		StudentStats s1[] = new GradeBookBridge[3];	//declare necessary objects
		Scanner input = new Scanner(System.in);	//open scanner object
		
		for (int i = 0; i < texts.length; i++) {
			int x = 1;
			a1[i] = new GradeBookBridge();
			a1[i].LoadAndCompute(texts[i]);		//initialize appropriate interface objects to be used to complete the program
			a1[i].printAll();
			s1[i] = new GradeBookBridge();
			do {
				if (s1[i] == null)
					break;
				System.out.printf("\nEnter an ID number(enter 0 to exit): ");
				x = input.nextInt();
				input.nextLine();	//deals with the nextInt buffer
				s1[i].printStats(x);
			} while (x != 0);
		}
		input.close();		//close the scanner
	}
}
