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

		if((super.getCenterX() >= 0 && super.getCenterX() <= width) && super.getCenterY() >= 0 && super.getCenterY() <= height) {
			double newCenterX = this.xVelocity + super.getCenterX();
			double newCenterY = this.yVelocity + super.getCenterY();
			if(newCenterX < 0 || newCenterX > width || newCenterY < 0 || newCenterY > height ) {
				if(newCenterX > width && newCenterY > height) {
					this.xVelocity = this.xVelocity * -1;
					this.yVelocity = this.yVelocity * -1;
				} else if(newCenterX < 0 && newCenterY < 0) {
					this.xVelocity = this.xVelocity * -1;
					this.yVelocity = this.yVelocity * -1;
				} else if(newCenterX > width && newCenterY < 0) {
					this.xVelocity = this.xVelocity * -1;
					this.yVelocity = this.yVelocity * -1;
				} else if(newCenterX < 0 && newCenterY > height) {
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

			if(c.getCenterX() > super.getCenterX()) {
				this.xVelocity = this.xVelocity * -1;
			}
			if(c.getCenterY() < super.getCenterY()) {
				this.yVelocity = this.yVelocity * -1;
			}
			if(c.getCenterX() < super.getCenterX()) {
				this.xVelocity = this.xVelocity * -1;
			}
			if(c.getCenterY() > super.getCenterY()) {
				this.yVelocity = this.yVelocity * -1;
			}
		}
		
		return super.overlaps(c);
	}
}
