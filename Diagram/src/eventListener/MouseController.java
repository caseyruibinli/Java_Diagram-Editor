package eventListener;

import java.util.ArrayList;

import core.*;
import ecs100.UI;
import module.*;
import ui.*;

public class MouseController{
	
	private ArrayList<Diagram> diagrams;
	private Diagram selectedDiagram ; // for clicked part
    private KeyController key;
	
	public  void setMouseListener() {
		  diagrams = this.getDiagrams();   
		  selectedDiagram = null;
		
		UI.setMouseMotionListener(this::doMouse);
	}
	
	public void doMouse(String action, double x, double y) {

	if(selectedDiagram == null) { // Can be implemented when there is no selectedDiagram (by click) at the moment 
		if (action.equals("pressed")) {			
		  for(Diagram diagram: diagrams) {
			  
			 if (new Processing().isWithinRange(x, y, diagram)) { 
				  diagram.setDraggable(true);
				  double[] xylast = {x,y};
				  diagram.setXYlast(xylast);   
			 }
			 else {
				  diagram.setDraggable(false);
			 }   
		  }
		}
	}

		if (action.equals("dragged")) {			
		  for(Diagram diagram: diagrams) {
			if (diagram.getIsDraggable()) {
				 new UI_Output().drawWithColor(diagram, "white"); // for better rendering  
		         new UI_Output().drawWithXYandColor(diagram, diagram.getXYlast()[0], diagram.getXYlast()[1],"white");	         
		         new UI_Output().drawWithXY(diagram, x + diagram.getXc() - diagram.getXYlast()[0], y + diagram.getYc() - diagram.getXYlast()[1]);         
		         new UI_Output().improveOverlapping(diagrams, diagram);
		         
		         diagram = new Processing().setCoordinates(diagram, x + diagram.getXc() - diagram.getXYlast()[0],  y + diagram.getYc() - diagram.getXYlast()[1]);
		         double[] xylast = {x,y};
				 diagram.setXYlast(xylast);			
			} 
		  }
		}
			
		if (action.equals("released")) {		
		  for(Diagram diagram: diagrams) {	  
		    if (diagram.getIsDraggable()) {
		         new UI_Output().drawWithColor(diagram, "white");
		         new UI_Output().drawWithXY(diagram,  x + diagram.getXc() - diagram.getXYlast()[0], y + diagram.getYc() - diagram.getXYlast()[1]); 
		         diagram = new Processing().setCoordinates(diagram, x + diagram.getXc() - diagram.getXYlast()[0], y + diagram.getYc() - diagram.getXYlast()[1]);
		     }
	      }  
		}
		

		if (action.equals("clicked")) {

			if (selectedDiagram != null) {   // PART B: This part would be invoked only a diagram has been selected by 'clicked', when selectedDiagram won't be null.
				 key.setIsKeyActivated(false);// When Clicking (anywhere) after key-listener is running in a selected mode, stop the key-listener
				
				 new UI_Output().drawAlarmText(diagrams, selectedDiagram ,false); 
			  if (!new Processing().isWithinRange(x, y, selectedDiagram) ) { // In this case, the un-select action will only be 
				  selectedDiagram.setFirstClickedInvoked(false); // invoked by clicking (not other actions) area outside of the selected diagram
				  new UI_Output().drawBorder(selectedDiagram, false);
				  new UI_Output().improveOverlapping(diagrams, selectedDiagram);                                     
				  selectedDiagram = null; // after the un-select action, un-select action must be pointed to null
			  }
			  else { //  clicking (not other actions) area inside of the selected diagram
				    selectedDiagram.setSecondClickedInvoked(true);   // For tagging used later         
					new UI_Output().drawWithColor(selectedDiagram, "white");	// Correct the rendering before actually deleting the diagram
					new UI_Output().drawBorder(selectedDiagram, false);	
					new UI_Output().improveOverlapping(diagrams, selectedDiagram);      
					selectedDiagram = null;
			  }
			}
			
			int fixed = diagrams.size() - 1;    // PART B: delete the tagged diagram
			  for(int i = fixed ; i>= 0 ; i--) {
				  if(diagrams.get(i).getIsSecondClickedInvoked()) { 
						  diagrams.remove(i);  
						  break;
				  }
		    }

			for(Diagram diagram: diagrams) { // PART A (in order of normal execution; Note that this writing order cannot be modified )
			    if (diagram.getIsDraggable()) { // This selects the empty space could not be edited by 'clicked'
					if (!diagram.getIsFirstClickedInvoked()) { // This controls if the diagram has been selected by 'clicked'
						 diagram.setFirstClickedInvoked(true);
						 new UI_Output().drawBorder(diagram, true); 
						 new UI_Output().drawAlarmText(diagrams, diagram ,true); 
						 selectedDiagram = diagram; // let this variable points to the selected diagram
						 
						 key = new KeyController();
						 key.setDiagrams(diagrams);
						 key.setDiagram(diagram);
						 key.keyAction();			 
						 break;// only select one item if you click multiple items at the same time; In this system, if overlapping, the engine will choose one randomly.
					}	
			     }
		     }
			if(selectedDiagram != null) { // PART A
				   for(Diagram diagram: diagrams) { // After a diagram is selected, all area could not be dragged
			    	     diagram.setDraggable(false);// There could only be 'clicking'
			        }  
			}

		}
	}
	
	public ArrayList<Diagram> getDiagrams() {
		return diagrams;
	}

	public void setDiagrams(ArrayList<Diagram> diagrams) {
		this.diagrams = diagrams;
	}
	
}