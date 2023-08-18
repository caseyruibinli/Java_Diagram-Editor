package core;

import java.util.*;

import ecs100.UI;
import eventListener.*;
import module.*;
import ui.*;


public class Engine {

	ArrayList<Diagram> diagrams = new ArrayList<>();
	ArrayList<Image> images  = new Processing().processImage();;
    MouseController mouse;
    
    public void renderDiagram(Diagram diagram) { 	
		if(mouse != null) {		 // Last Diagram 
		     	diagrams = mouse.getDiagrams();	

		}	
       new UI_Output().draw(diagram);
       mouse =  new MouseController(); 
       diagrams.add(diagram);
       mouse.setDiagrams(diagrams);
       mouse.setMouseListener();

    }
    
	public void addBox() {
		Box box = new UI_Input().boxInput(); // Create a Box object
		renderDiagram(box);  
	}
	
	public void addOval() {
		Oval oval = new UI_Input().ovalInput(); 
		renderDiagram(oval);
	}
	
	public void addLine() {
		Line line = new UI_Input().lineInput(); 
		renderDiagram(line);
	}

	public void loadImage() {
		if (!images.isEmpty()) {
	    Image image = images.remove(0);
	    renderDiagram(image);
		}
		else {
			UI.println("Loaded all photos.");
		}
	   
	}

	public void chooseImage() {
        Image image = new Processing().chooseImageFile();
		if (image!= null) {
			renderDiagram(image);
		}
    }
	
	public void loadRandom() {
		this.renderDiagram(new Processing().processRandomData());
	}
	
    public void loadData() {	
    	ArrayList<Diagram> presetDiagrams = new Data().addData();
    	for (Diagram diagram : presetDiagrams) {
         	this.renderDiagram(diagram);
    	}
    }
	
	public void clearPanes() {
		new Engine();
		UI.clearPanes();
	}
	
	public void opening () {
		 new UI_Output().instruction();
		 new UI_Output().openingAnimation();
	}

	public Engine() {
		UI.initialise();
		UI.addButton("Add auto random shapes (Recommended)", this::loadRandom);
		UI.addButton("Add image (Recommended)", this::loadImage);
		UI.addButton("Choose image", this::chooseImage);
		UI.addButton("Add box", this::addBox);
		UI.addButton("Add oval", this::addOval);
		UI.addButton("Add longline", this::addLine);
		UI.addButton("Load Data", this::loadData );
		UI.addButton("Clear ALL", this::clearPanes);
		this.opening();
	}

	public static void main(String[] args) {
		new Engine();
	}

}
