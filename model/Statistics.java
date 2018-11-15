package model;

public class Statistics {
	
	int[] lowscores = new int[5];	//declare and initialize array required for assigment
	int[] highscores = new int[5];
	float[] avgscores = new float[5];

	public Statistics() {	//default constructor
	}

	public int[] getLowscores() {	//return lowscores array
		return lowscores;
	}

	public void setLowscores(int[] lowscores) {	//set an array
		this.lowscores = lowscores;
	}

	public int[] getHighscores() {	//return highscores array
		return highscores;
	}

	public void setHighscores(int[] highscores) {	//set highscores array
		this.highscores = highscores;
	}

	public float[] getAvgscores() {	//return averageScores array
		return avgscores;
	}

	public void setAvgscores(float[] avgscores) {	//set averageScores array
		this.avgscores = avgscores;
	}

	public int getHighScore(int i) {	//get a high score from the highscore's array
		return highscores[i];
	}

	public int getLowScore(int i) {	//get a low score form the lowscore array
		return lowscores[i];
	}

	public float getAverageScore(int i) {	//get average score from averagescores array
		return avgscores[i];
	}

	public void findlow(Student[] a) {
		/*
		 * This method will find the lowest score and store it in an array names
		 * lowscores.
		 */
		for (int j = 0; j < a[0].getNumQuizzes(); j++) {	//number of quizzes
			int temp = 101;
			for (int i = 0; i < a.length; i++) {	//loops through number of students
				if(a[i]!= null)		//handles null pointer exception
				{
					if (a[i].getScore(j) < temp) {
						temp = a[i].getScore(j);
					}
				}
				if(a[i] == null)
					break;
				
			}
			lowscores[j] = temp;	//insert the temp as the low score for that quiz from all students
		}
	}

	public void findhigh(Student[] a) {
		/*
		 * This method will find the highest score and store it in an array
		 * names highscores.
		 */
		for (int j = 0; j < a[0].getNumQuizzes(); j++) {
			int temp = 0;
			for (int i = 0; i < a.length; i++) {
				if(a[i] != null)		//handles null pointer acception
				{
					if (a[i].getScore(j) > temp) {
						temp = a[i].getScore(j);
					}
				
				}
				if(a[i] == null)	//handles null pointe exception
					break;	//break out of loop
				
			}
			highscores[j] = temp;	//populates the highscores array
		}
	}

	public void findavg(Student[] a) {
		/*
		 * This method will find avg score for each quiz and store it in an
		 * array names avgscores.
		 */
		int totalNumStudents = 0;
	
		for (int j = 0; j < a[0].getNumQuizzes(); j++) {
			//int[] scores = a[j].getScoresArray();
			float quizTotal = 0;
			for (int i = 0; i < a.length; i++) {
				if(a[i] != null)
				{
					quizTotal += a[i].getScore(j);
				}
				if(a[i] == null)	//handles null pointer exception
				{
					totalNumStudents = (i);
					break;	//break out of loop
				}
					
			}
			avgscores[j] = (quizTotal / totalNumStudents);	//insert average score for the quiz in the averagescore array
		}
	}

	public void print1() {			//prints all instance variable
		System.out.printf("High Scores: \n");
		for (int i = 0; i < 5; i++) {
			System.out.printf("Quiz #%d: %d", (i + 1), getHighScore(i));
			System.out.printf("\n");
		}
		System.out.printf("Low Scores: \n");
		for (int i = 0; i < 5; i++) {
			System.out.printf("Quiz #%d: %d", (i + 1), getLowScore(i));
			System.out.printf("\n");
		}
		System.out.printf("Average Scores: \n");
		for (int i = 0; i < 5; i++) {
			System.out.printf("Quiz #%d: %.1f", (i + 1), getAverageScore(i));
			System.out.printf("\n");
		}
		System.out.printf("\n");

	}
	
	 
}
