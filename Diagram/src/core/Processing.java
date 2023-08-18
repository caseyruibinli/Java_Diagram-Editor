package core;
import java.util.ArrayList;
import java.util.Arrays;

import ecs100.UI;
import module.*;
import module.Box;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Processing {

	public ArrayList<Double> boxToArrayList(Box box) {

		ArrayList<Double> arr = new ArrayList<>(Arrays.asList(box.getXc(), box.getYc(), box.getW(), box.getH()));
		return arr;
	}

	public boolean isWithinRange(double x, double y, Diagram diagram) {
		if (diagram instanceof Box || diagram instanceof Line || diagram instanceof Image) {
			return (x > diagram.getXc() - diagram.getW() / 2 && x < diagram.getXc() + diagram.getW() / 2 &&
					y > diagram.getYc() - diagram.getH() / 2 && y < diagram.getYc() + diagram.getH() / 2);
		}

		if (diagram instanceof Oval) {
			return (((x - diagram.getXc()) / (diagram.getW() / 2.0)) * ((x - diagram.getXc()) / (diagram.getW() / 2.0)) +
					((y - diagram.getYc()) / (diagram.getH() / 2.0)) * ((y - diagram.getYc()) / (diagram.getH() / 2.0)) <= 1.0);
		}

		return false;
	}

	public Diagram setCoordinates(Diagram diagram, double xcenter, double ycenter) {

		diagram.setXc(xcenter);
		diagram.setYc(ycenter);
		return diagram;
	}

	public Diagram setSize(Diagram diagram, double width, double height) {

		diagram.setW(width);
		diagram.setH(height);

		return diagram;
	}

	public Diagram processRandomData() {

		Diagram diagram = null;
		double probability = Math.random();
		double randomX = 50 + Math.random() * 600;
		double randomY = 50 + Math.random() * 600;
		double randomW = 30 + Math.random() * 300;
		double randomH = 30 + Math.random() * 300;
		double randomThickness = 5 + Math.random() * 10;
		String randomColor = "ramdon";

		if (probability < 0.45) {
			diagram = new Box(randomX, randomY, randomW, randomH, randomColor);
		} else if (probability >= 0.45 && probability < 0.7) {
			diagram = new Oval(randomX, randomY, randomW, randomH, randomColor);
		} else if (probability >= 0.7 && probability < 0.85) {
			diagram = new Line(-100, randomY, 4000, randomThickness, randomColor);  // Horizontal Lines
		} else if (probability >= 0.85 && probability < 1) {
			diagram = new Line(randomX, -100, randomThickness, 4000, randomColor);  // Vertical Lines
		}

		return diagram;
	}

	public ArrayList<Image> processImage() {
		ArrayList<Image> images = new ArrayList<>();
		double x = 0;
		for (int i = 1; i <= 5; i++) {
			String photopath = "D:/Software/Eclipse Workspace/Diagram/image/image_0" + i + ".jpg";
			Image image = new Image(x + 100, 200, 100, 100, "nocolor");
			image.setAddress(photopath);
			images.add(image);
			x = x + 100;
		}
		return images;
	}

	public Image chooseImageFile() {

		try {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"JPG & GIF Images", "jpg", "gif");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(null);

			if (returnVal == JFileChooser.APPROVE_OPTION) { // returnVal == 0
				String imageAddress = chooser.getSelectedFile().getAbsolutePath();

				Image image = new Image(100, 200, 100, 100, "nocolor");
				image.setAddress(imageAddress);

				return image;
			} else { //  returnVal == 1
				UI.println(returnVal);
				System.out.println("File selection was cancelled.");
				return null;
			}

		} catch (Exception e) {
			System.out.println("An error occurred while selecting the image: " + e.getMessage());
			return null;
		}

	}
}