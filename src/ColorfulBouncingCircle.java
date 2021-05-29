import java.awt.Color;

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
		//new Circle c1 = (super(getRadius(), getCenterX(), getCenterY(), Color co))
		double newCenterX = this.xVelocity + this.getCenterX();
		double newCenterY = this.yVelocity + this.getCenterY();
		if((this.getCenterX() >= 0 && this.getCenterX() <= width) && this.getCenterY() >= 0 && this.getCenterY() <= height) {
			newCenterX = this.xVelocity + this.getCenterX();
			newCenterY = this.yVelocity + this.getCenterY();
			if(newCenterX < 0 || newCenterX > width || newCenterY < 0 || newCenterY > height ) {
				if(newCenterX > width && newCenterY > height) {
					this.xVelocity = this.xVelocity * -1;
					this.yVelocity = this.yVelocity * -1;
				} else if(newCenterX < 0 && newCenterY < 0) {
					this.xVelocity = this.xVelocity * -1;
					this.yVelocity = this.yVelocity * -1;
				} else if(newCenterX > width && newCenterY > height) {
					this.xVelocity = this.xVelocity * -1;
					this.yVelocity = this.yVelocity * -1;
				} else if(newCenterX < 0 || newCenterX > width) {
					this.xVelocity = this.xVelocity * -1;
				} else {
					this.yVelocity = this.yVelocity * -1;
				}
			} else {
				this.setCenterCoordinates(newCenterX, newCenterY);
			}
		}
		
		}
	
	@Override
	public boolean overlaps(Circle c) {
		if(super.overlaps(c)) {
			double centerX = this.getCenterX();
			double centerY = this.getCenterY();
			if(c.getCenterX() > centerX ) {
				this.xVelocity = this.xVelocity * -1;
			}
			if(c.getCenterY() < centerY) {
				this.yVelocity = this.yVelocity * -1;
			}
			if(c.getCenterX()< centerX) {
				this.xVelocity = this.xVelocity * -1;
			}
			if(c.getCenterY() < centerY) {
				this.yVelocity = this.yVelocity * -1;
			}
		}
		
		return super.overlaps(c);
	}
}
