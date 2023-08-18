package module;

import java.awt.Color;
import java.util.ArrayList;

import ecs100.UI;

 public class Diagram {
	
	private double width;
	private double height;
	private double xcenter;
	private double ycenter;
	private double[] xylast;
	private String color;
	private boolean isDraggable;
	private Color diagramRGB;
	private boolean firstClickedInvoked = false;
	private boolean secondtClickedInvoked = false;
	
	public void setandgetColor(String color, boolean isRandom) { // Shared method
	
			switch( color ) {
			  case "black":
					UI.setColor(Color.black);
			        break;
			  case "white":
					UI.setColor(Color.white);
				    break;
			  case "gray":
					UI.setColor(Color.gray);
				    break;
			  case "red":
					UI.setColor(Color.red);
			        break;
			  case "blue":
					UI.setColor(Color.blue);
				    break;
			  case "green":
					UI.setColor(Color.green);
				    break;
			  case "yellow":
					UI.setColor(Color.yellow);
				    break;
		      default :    
		         ArrayList<Integer> RGB = new ArrayList<Integer>();
		    	
		         
		         
		         if(this.getDiagramRGB() != null) {
		        	  UI.setColor(this.getDiagramRGB());	 
		         }
		         else {
		               if (!isRandom) {			        
				        	 for (int i = 0 ; i <= 2 ; i++ ) {
					        	   RGB.add(UI.askInt("Enter the RGB info in order."));
					            }   	
		               }
      
		               else {
		            	   for (int i = 0 ; i <= 2 ; i++ ) {
		            		      RGB.add((int)(Math.random()*256));
				            }   	            	   
		               }
				       Color actualCarColor = new Color(RGB.get(0), RGB.get(1), RGB.get(2));
				       this.setDiagramRGB(actualCarColor); // If there is a ramdon RGB, set it to the field of the diagram object
					   UI.setColor(actualCarColor);
				 } 
		    }         
		        
	}
		
	
	public Color getDiagramRGB() {
		return diagramRGB;
	}

	public void setDiagramRGB(Color RGB) {
		this.diagramRGB = RGB;
	}
	
	public double getW() {
		return width;
	}


	public void setW(double width) {
		this.width = width;
	}


	public double getH() {
		return height;
	}


	public void setH(double height) {
		this.height = height;
	}


	public double getXc() {
		return xcenter;
	}


	public void setXc(double xcenter) {
		this.xcenter = xcenter;
	}


	public double getYc() {
		return ycenter;
	}


	public void setYc(double ycenter) {
		this.ycenter = ycenter;
	}
	
	
	public String getColorStr() {
		return color;
	}

	public void setColorStr(String color) {
		this.color = color;
	}

	public boolean getIsDraggable() {
		return isDraggable;
	}

	public void setDraggable(boolean isDraggable) {
		this.isDraggable = isDraggable;
	}
	
	public double[] getXYlast() {
		return xylast;
	}

	public void setXYlast(double[] xylast) {
		this.xylast = xylast;
	}
	
	public boolean getIsFirstClickedInvoked() {
		return firstClickedInvoked;
	}


	public void setFirstClickedInvoked(boolean firstClickedInvoked) {
		this.firstClickedInvoked = firstClickedInvoked;
	}


	public boolean getIsSecondClickedInvoked() {
		return secondtClickedInvoked;
	}


	public void setSecondClickedInvoked(boolean secondtClickedInvoked) {
		this.secondtClickedInvoked = secondtClickedInvoked;
	}

	public boolean isEmpty() {
		return xcenter == 0.0 ; // default value in the declaration of a class (field)	
	}
	
}