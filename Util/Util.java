package Util;
import java.io.*;
import java.util.StringTokenizer;

import model.*;



public class Util {
	//private boolean DEBUG = true;
	Util(){}
	
	public static Student [] readFile(String filename, Student [] stu) {
		//Reads the file and builds student array.
		//Open the file using FileReader Object.
		//In a loop read a line using readLine method.
		//Tokenize each line using StringTokenizer Object
		//Each token is converted from String to Integer using parseInt method
		//Value is then saved in the right property of Student Object.

		int counter = 0;
		try {
			FileReader file = new FileReader(filename);	//initialize FileReader with fname
			BufferedReader buff = new BufferedReader(file);	//initialize BufferedReader
			boolean eof = false;
			while (!eof) {
				String line = buff.readLine(); //read in a line
				counter++;
				if (line == null)	//check if it is end of file
					eof = true;
				else {
					if (counter == 1) {	//skip line 1 of the file because we don't need it
						;	
					}
					if(stu.length == counter)
						break;
					if (counter > 1) {	//when the first line is skipped build A Student
						buildStudent(stu, (counter - 2), line);
					}
				}
			}
			buff.close();
		} catch (Exception e) {	//if an exception is thrown proceed here
			System.out.println("Error -- " + e.toString());	//this is printed
		}
		return stu;
	}
	
	public static void buildStudent(Student [] a1, int counter, String temp)	//creates a new student and inserts all quiz
	{																			//information for that particular student
		a1[counter] = new Student();
		String s1 = "";
		int num = 0;
		
		StringTokenizer st = new StringTokenizer(temp);		//create a stringToeknizer
		s1 = st.nextToken();								//reads in one segmented part at a time
		num = Integer.parseInt(s1);							//converts String to Integer
		a1[counter].setSID(num);							//set the first integer to the ID number because that is the first thing for all students
		while(st.hasMoreTokens())	
		{
			for(int quiz = 0; quiz < 5; quiz++)				//populate the scores array for the student
			{
				s1 = st.nextToken();
				num = Integer.parseInt(s1);
				a1[counter].setScores(quiz, num);
			}
		}
	}
}
