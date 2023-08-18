package ui;
import ecs100.UI;
import module.*;

import java.awt.Color;
import java.util.ArrayList;

import core.Processing;

public class UI_Output {
	
    private float[][] dataPGM;
	
	public void draw(Diagram diagram) {
		
		if (diagram instanceof Image) {
			
			drawImage(diagram, diagram.getXc(), diagram.getYc());
		}
		else {
			drawCore(diagram, diagram.getXc(), diagram.getYc(), diagram.getColorStr());
		} 
	    
	}

	public void drawWithXY(Diagram diagram, double x, double y) {
		
        if (diagram instanceof Image) {
			
			drawImage(diagram, x, y);
		}
        else {
        	drawCore(diagram, x, y, diagram.getColorStr());
        }
	}

	public void drawWithColor(Diagram diagram, String color) {

    	   drawCore(diagram, diagram.getXc(), diagram.getYc(), color);
	}
	
	public void drawWithXYandColor(Diagram diagram, double x, double y, String color) {
		 
        	drawCore(diagram, x, y, color);
	}
	
	private void drawCore(Diagram diagram, double x, double y, String color) {
	    diagram.setandgetColor(color, true);
	    if (diagram instanceof Box || diagram instanceof Line || diagram instanceof Image) {
	        UI.fillRect(x - diagram.getW() / 2, y - diagram.getH() / 2, diagram.getW(), diagram.getH());
	    } else if (diagram instanceof Oval) {
	        UI.fillOval(x - diagram.getW() / 2, y - diagram.getH() / 2, diagram.getW(), diagram.getH());
	    }
	}
	
	public void drawImage(Diagram diagram, double x, double y) {
		Image image = (Image) diagram;
		UI.drawImage(image.getAddress(), x - image.getW() / 2, y - image.getH() / 2, image.getW() , image.getH() ) ; //显示层这里图片一定要小才可以
	}
	
	public void drawBorder (Diagram diagram, boolean isBorder) {
		if (isBorder) {
		   UI.setColor(Color.red);
		}
		else {
			 UI.setColor(Color.white);
		}
		   if (diagram instanceof Box) {
			   UI.setLineWidth(4);
			   UI.drawRect(diagram.getXc() - diagram.getW() / 2, diagram.getYc() - diagram.getH() / 2, diagram.getW(), diagram.getH());
		   }
		   
		   if (diagram instanceof Line || diagram instanceof Image) {
			   UI.setLineWidth(2);
			   UI.drawRect(diagram.getXc() - diagram.getW() / 2, diagram.getYc() - diagram.getH() / 2, diagram.getW(), diagram.getH());
		   }
		   
		   if (diagram instanceof Oval) {
			   UI.setLineWidth(4);
			   UI.drawOval(diagram.getXc() - diagram.getW() / 2, diagram.getYc() - diagram.getH() / 2, diagram.getW(), diagram.getH());
		   }
	 }
	
	
     public void improveOverlapping( ArrayList<Diagram> diagrams, Diagram diagramTargeted) {
    	   for(Diagram otherdiagram: diagrams) {
            	 if(diagramTargeted.equals(otherdiagram)) { // Skip the target diagram
          		     continue;
          	     }
          	       new UI_Output().draw(otherdiagram);
		   }     
    	 
	 }
     
     public void drawAlarmText(ArrayList<Diagram> diagrams, Diagram diagram, boolean isShown) {
    	 
    	 UI.setFontSize(35);
    	 if (isShown) {
    	 	 UI.setColor(Color.red);
    		 UI.drawString("SELECTED", 340, 50); 
    		 UI.setFontSize(25);
    	 	 UI.setColor(Color.black);
    		 UI.drawString("Delete --- Click item itself", 470, 90);
    		 UI.drawString("Change Size --- Press key 'wsad' lowercase", 470, 120);
    		 UI.drawString("Unselect --- Click outside of the item",470, 150);
    		 
    	 }
    	 else {
    		 UI.eraseString("SELECTED", 340, 50);
    		 UI.setFontSize(25);
    		 UI.eraseString("Delete --- Click item itself", 470, 90);
    		 UI.eraseString("Change Size --- Press key 'wsad' lowercase", 470, 120);
    		 UI.eraseString("Unselect --- Click outside of the item",470, 150);
    		 this.improveOverlapping(diagrams, diagram);
    		 new UI_Output().draw(diagram);
    	 }
   
     }
     
     public void openingAnimation() {
    	 
    	String[] numStr = {"3","2","1"};
      	String[] colorStr = {"yellow","green","blue"};
    	
    	 for (int i = 0 ; i <= 2 ; i++) {
    	 UI.clearGraphics();
    	 UI.setFontSize(100);
    	 new Diagram().setandgetColor(colorStr[i], false);
    	 UI.drawString(numStr[i], 300, 300);
    	 
    	 UI.setFontSize(45);
    	 UI.setColor(Color.black);
       	 UI.drawString("WAIT", 270, 200);
    	 UI.sleep(500);
    	 }
     	 UI.clearGraphics();
     	 UI.setFontSize(80);
     	 UI.setColor(Color.red);
    	 UI.drawString("START", 200, 300);
    	 UI.sleep(800);
    	 UI.clearGraphics();
     }
     
     public void instruction() {
    	 UI.println("----Diagram Editor Instruction----");
    	 UI.println("(Items include shapes and images.)");
    	 UI.println("1. Move item: User can press and  \n drag any items on a canvas with multiple diagrams");
    	 UI.println("(can drag multiple items at the same time)");
    	 UI.println("2. Select item: User can click one item to select it.");
    	 UI.println("The selected item can be implemented actions like:");
    	 UI.println("(1) Delete the item by clicking item itself;");
      	 UI.println("(2) Changing size the item by pressing 'wsad';");
      	 UI.println("(3) Unselect the item by clicking anywhere outside of the item");
     }
     
	
    public float[][] getDataPGM() {
		return dataPGM;
	}

	public void setDataPGM(float[][] dataPGM) {
		this.dataPGM = dataPGM;
	}


}