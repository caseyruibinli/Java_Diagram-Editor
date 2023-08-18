package module;

public class Line extends Diagram {
	
	private double width;
	private double height;
	private double xcenter;
	private double ycenter;
	private String color;
	private boolean isHorizontal;



	public Line(double xcenter, double ycenter, double width, double height, String color) {
		this.width = width;
		this.height = height;
		this.xcenter = xcenter;
		this.ycenter = ycenter;
		this.color = color;
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

	public boolean isHorizontal() {
		return isHorizontal;
	}

	public void setHorizontal(boolean isHorizontal) {
		this.isHorizontal = isHorizontal;
	}

	
	
}