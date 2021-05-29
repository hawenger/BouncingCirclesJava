import java.awt.Color;
import java.awt.Graphics;

public class ColorfulBouncingCircle extends ColorfulCircle {
	private double xVelocity, yVelocity;
	private static double width;
	private static double height;
	
	public ColorfulBouncingCircle(double radius, double centerX, double centerY, Color color, double xVelocity, double yVelocity) {
		super(radius, centerX, centerY, color);
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
	}
	
	
	public static void setPlayingFieldSize(double newWidth, double newHeight) {
		height = newHeight;
		width = newWidth;
	}
	
	public void tick() {
		double centerX = super.getCenterX();
		double centerY = super.getCenterY();
		double newCenterX = this.xVelocity + centerX;
		double newCenterY = this.yVelocity + centerY;
		if((centerX >= 0 && centerX <= width) && centerY >= 0 && centerY <= height) {
			super.setCenterCoordinates(newCenterX, newCenterY);
			newCenterX = this.xVelocity + super.getCenterX();
			newCenterY = this.yVelocity + super.getCenterY();
		}
		if(newCenterX < 0 || newCenterX > width || newCenterY < 0 || newCenterY > height ) {
				if(newCenterX > width && newCenterY > height) {
					this.xVelocity = xVelocity * -1;
					this.yVelocity = yVelocity * -1;
				} else if(newCenterX < 0 && newCenterY < 0) {
					this.xVelocity = xVelocity * -1;
					this.yVelocity = yVelocity * -1;
				} else if(newCenterX > width && newCenterY > height) {
					this.xVelocity = xVelocity * -1;
					this.yVelocity = yVelocity * -1;
				} else if(newCenterX < 0 || newCenterX > width) {
					this.xVelocity = xVelocity * -1;
				} else {
					this.yVelocity = yVelocity * -1;
				}
			}
		}
	
	@Override
	public boolean overlaps(Circle c) {
		
		if(this.overlaps(c)) {
			//alter velocity
		}
		
	}
	

}
