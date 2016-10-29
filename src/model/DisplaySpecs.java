package model;

public class DisplaySpecs {

	private double myBackgroundIndex;
	private double myPenColorIndex;
	private double myPenSizeIndex;
	private double myShapeIndex;
	private double myPaletteIndex;
	private double DEFAULT=0.0;
	
	public DisplaySpecs(){
		myBackgroundIndex=DEFAULT;
		myPenColorIndex=DEFAULT;
		myPenSizeIndex=DEFAULT;
		myShapeIndex=DEFAULT;
		myPaletteIndex=DEFAULT;
	}

	public double getBackgroundIndex() {
		return myBackgroundIndex;
	}

	public double getPenColorIndex() {
		return myPenColorIndex;
	}

	public double getPenSizeIndex() {
		return myPenSizeIndex;
	}

	public double getShapeIndex() {
		return myShapeIndex;
	}

	public double getPaletteIndex() {
		return myPaletteIndex;
	}

	public void setBackgroundIndex(double myBackgroundIndex) {
		this.myBackgroundIndex = myBackgroundIndex;
	}

	public void setPenColorIndex(double myPenColorIndex) {
		this.myPenColorIndex = myPenColorIndex;
	}

	public void setPenSizeIndex(double myPenSizeIndex) {
		this.myPenSizeIndex = myPenSizeIndex;
	}

	public void setShapeIndex(double myShapeIndex) {
		this.myShapeIndex = myShapeIndex;
	}

	public void setPaletteIndex(double myPaletteIndex) {
		this.myPaletteIndex = myPaletteIndex;
	}
	
}
