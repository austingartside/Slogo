package model;

public class DisplaySpecs {

	private double myBackgroundIndex;
	private double myPenColorIndex;
	private double myPenSizeIndex;
	private double myShapeIndex;
	private double myPaletteIndex;
	private double myR;
	private double myG;
	private double myB;
	private double DEFAULT=0.0;
	private Controller myController;
	
	public DisplaySpecs(Controller control){
		myBackgroundIndex=1.0;
		myPenColorIndex=DEFAULT;
		myPenSizeIndex=DEFAULT;
		myShapeIndex=DEFAULT;
		myPaletteIndex=DEFAULT;
		myController= control;
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

	public double setBackgroundIndex(double myBackgroundIndex) {
		this.myBackgroundIndex = myBackgroundIndex;
		myController.UpdateView();
		return myBackgroundIndex;
	}

	public double setPenColorIndex(double myPenColorIndex) {
		this.myPenColorIndex = myPenColorIndex;
		myController.UpdateView();
		return myPenColorIndex;
	}

	public double setPenSizeIndex(double myPenSizeIndex) {
		this.myPenSizeIndex = myPenSizeIndex;
		myController.UpdateView();
		return myPenSizeIndex;
	}

	public double setShapeIndex(double myShapeIndex) {
		this.myShapeIndex = myShapeIndex;
		myController.UpdateView();
		return myShapeIndex;
	}

	public double setPaletteIndex(double myPaletteIndex, double r,double g, double b) {
		this.myPaletteIndex = myPaletteIndex;
		this.myR=r;
		this.myG=g;
		this.myB=b;
		return myPaletteIndex;
	}
	
}
