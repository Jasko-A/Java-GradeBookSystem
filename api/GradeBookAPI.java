package api;

import model.*;	//import necessary packages
import Util.*;

public abstract class GradeBookAPI { 	//create an abstract class because the GradeBookBrdge will use all functions in this object
	private static Student stu[];
	private static Statistics statLab7;

	public void LoadAndCompute(String fName) {
		
		Student stu[] = new Student[40];	//declare a Student Object
		stu = Util.readFile(fName, stu);	//file will be read in and the student object will be instantiated 
		statLab7 = new Statistics();
		statLab7.findlow(stu); // call function for low, high, and average
		statLab7.findhigh(stu);
		statLab7.findavg(stu);
		setStu(stu);
	}

	public static void setStu(Student a[]) {	//set the student object to its private static variable so it will never be lost
		stu = a;
	}

	public void printAll() {	//takes care of necessary printing
		printer();
		statLab7.print1();
	}

	public void printStats(int SID) {	//print stats for the particular student ID
		for (int i = 0; i < stu.length; i++) {
			if (SID == 0)
				break;
			if (stu[i] == null)
				break;
			if (SID == stu[i].getSID()) {
				System.out.printf("Student ID: %d\n", SID);
				for (int j = 0; j < 5; j++) {
					System.out.printf("Q%d: %d  ", (j + 1), stu[i].getScore(j));
				}
			}
		}
	}

	public void printer() // printer function
	{
		System.out.printf("StuID  Qu1 Qu2 Qu3 Qu4 Qu5\n");
		for (int i = 0; i < stu.length; i++) {
			if (stu[i] == null) // fixes null pointer exception
				break;
			stu[i].printStats();
			System.out.printf("\n");
		}
	}
}
