import java.awt.Color;

public class ColorfulBouncingCircle extends Circle{
	private double xVelocity;
	private double yVelocity;
	private static double width;
	private static double height;
	
	public ColorfulBouncingCircle(double radius, double centerX, double centerY, Color color, double xVeloctiy, double yVelocity) {
		super(radius, centerX, centerY);
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
	}
	
	public static void setPlayingFieldSize(double newWidth, double newHeight) {
		
	}
	
	public void tick() {
		if() {
			
		} else if() {
			
		}
	}
	
	public boolean overlaps(Circle c) {
		
		Circle.overlaps();
	}
	

}
