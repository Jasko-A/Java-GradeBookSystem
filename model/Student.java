package model;

public class Student {
	 /**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private int SID;
	protected int scores[] = new int[5];	//delcare and intialze an array of integers
	  //write public get and set methods for
	  //SID and scores
	  //add methods to print values of instance variables.
	 public Student(){}
	 
	 public void setSID(int SID)	//set ID
	 {
		 this.SID = SID;
	 }
	 public int getSID()	//get ID
	 {
		 return SID;
	 }
	 public void setScores(int x, int score)	//set score in scores array
	 {
		 scores[x] = score;
	 }
	 public int [] getScoresArray()	//return the entire array
	 {
		 return scores;
	 }
	 public int getScore(int i)	//get a single score from the array
	 {
		 return scores[i];
	 }
	 public int getNumQuizzes()	//get # of quizes by returning the size of the scores array
	 {
		 return scores.length;
	 }
	 public void printStats()	//print stats for everything
	 {
		 System.out.printf("%-6d", SID);
		 for(int i = 0; i < scores.length; i++)
		 {
			 System.out.printf(" %03d", scores[i]);
		 }
		 System.out.printf("\n");
	 }
	 
	
	
	 

}
