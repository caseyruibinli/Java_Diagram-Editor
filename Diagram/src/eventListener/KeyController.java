package eventListener;

import java.util.ArrayList;

import core.Processing;
import ecs100.UI;
import module.*;
import ui.UI_Output;

public class KeyController {
	
	private ArrayList<Diagram> diagrams;
	private Diagram diagram;
	private boolean isKeyActivated = true;

	public void keyAction() {
		
		 UI.setKeyListener(this::key);
	}
	
	public void key(String key) {	
		
		if (!isKeyActivated) {
			return;
		}
		
		if (key.equals("w")|| key.equals("d")) {
	        new UI_Output().improveOverlapping(diagrams, diagram); // 位置关键
			new UI_Output().drawBorder(diagram, false);
			 if (key.equals("w")) { // make the diagram taller 
		          new Processing().setSize(diagram, diagram.getW(), diagram.getH() + 5);
			 }
		
			 if (key.equals("d")) {// make the diagram shorter
			      new Processing().setSize(diagram, diagram.getW() + 5, diagram.getH());
			 }
			 
		          new UI_Output().draw(diagram);
		          new UI_Output().drawBorder(diagram, true);		
		     	  new UI_Output().drawAlarmText(diagrams, diagram ,true); 
		}
		else if (key.equals("s") || key.equals("a")) {
			
			 new UI_Output().drawBorder(diagram, false);
			 new UI_Output().drawWithColor(diagram, "white");// for better rendering
			 if (key.equals("s")) {// make the diagram shorter
			      new Processing().setSize(diagram, diagram.getW(), diagram.getH() - 5);
			 }
	          
	          if (key.equals("a")) {// make the diagram shorter
			      new Processing().setSize(diagram, diagram.getW() - 5 , diagram.getH());
			 }	
	          new UI_Output().improveOverlapping(diagrams, diagram);// 位置关键
	          new UI_Output().draw(diagram);
	          new UI_Output().drawBorder(diagram, true);	
	     	  new UI_Output().drawAlarmText(diagrams, diagram ,true); 
		}     
	          
	}
		
	public Diagram getDiagram() {
		return diagram;
	}

	public void setDiagram(Diagram diagram) {
		this.diagram = diagram;
	}
	
	public ArrayList<Diagram> getDiagrams() {
		return diagrams;
	}

	public void setDiagrams(ArrayList<Diagram> diagrams) {
		this.diagrams = diagrams;
	}
	
	public boolean getIsKeyActivated() {
		return isKeyActivated;
	}

	public void setIsKeyActivated(boolean isKeyActivated) {
		this.isKeyActivated = isKeyActivated;
	}
		
}