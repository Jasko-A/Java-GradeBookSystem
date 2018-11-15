package api;

import interfaces.AllScores;	//import all interfaces into the bridge
import interfaces.MyConstant;
import interfaces.StudentStats;

public class GradeBookBridge extends GradeBookAPI implements MyConstant,AllScores,StudentStats{
		public GradeBookBridge(){};		//default constructor
}
