package module;

public class Image extends Diagram {
	
	
	private double width;
	private double height;
	private double xcenter;
	private double ycenter;
	private String color; // just for matching 
	private String address;
	

	public Image( double xcenter, double ycenter, double width, double height, String color) {
		this.width = width;
		this.height = height;
		this.xcenter = xcenter;
		this.ycenter = ycenter;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	
}