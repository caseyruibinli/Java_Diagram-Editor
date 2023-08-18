package ui;

import ecs100.UI;
import module.*;


public class UI_Input {
	
    public Box boxInput () {
		double width = UI.askDouble("What is the width? ");
		double height = UI.askDouble("What is the height? ");
		double xcenter = UI.askDouble("What is the xcenter? ");
		double ycenter = UI.askDouble("What is the ycenter? ");
		String color = UI.askString("What is the color? ");
	    Box box =new Box (xcenter, ycenter, width, height, color);
		return box;
	}
    
    public Oval ovalInput () {
		double width = UI.askDouble("What is the width? ");
		double height = UI.askDouble("What is the height? ");
		double xcenter = UI.askDouble("What is the xcenter? ");
		double ycenter = UI.askDouble("What is the ycenter? ");
		String color = UI.askString("What is the color? ");
	    Oval oval =new Oval (xcenter, ycenter, width, height, color);
		return oval;
	}
    
    public Line lineInput () {
    	
        double x;
        double y;
        double height;
        double width;
        boolean isHorizontal = UI.askBoolean("Is it horizontal?");

        if(isHorizontal) {
    	   y = UI.askDouble("What is the position on Y-Axis? ");
    	   x = -100;
           height = UI.askDouble("What is the thickness? (5-20 would be best!) ");
           width = 4000;
        }
        else {
           x = UI.askDouble("What is the position on x-Axis? ");
    	   y = -100;
           width = UI.askDouble("What is the thickness? (5-20 would be best!) ");
           height = 4000;
        }
		       
		Line line =new Line (x, y, width, height, "black");
		line.setHorizontal(isHorizontal);
		return line;
	}
    
   
    

}