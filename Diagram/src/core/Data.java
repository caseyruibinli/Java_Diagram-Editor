package core;
import module.*;

import java.util.ArrayList;


public class Data {
	
	
	ArrayList<Diagram> diagrams = new ArrayList<>();
	Diagram ramdnoDiagram;
	
	
	public ArrayList<Diagram>  addData() {
		diagrams.add(new Box (300, 300, 300, 300, "red"));
		diagrams.add(new Box (250, 450, 100, 100, "green"));
		diagrams.add(new Oval (550, 500, 70, 120, "blue"));
		diagrams.add(new Oval (400, 140, 150, 150, "yellow"));
		diagrams.add(new Line (-100, 700, 4000, 20, "black")); // horizontal line
		diagrams.add(new Line (700, -100, 10, 4000, "gray")); // vertical line
	
		return diagrams;
	}
	
	


	
	

}