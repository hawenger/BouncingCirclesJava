import java.awt.Color;
//Hannah Wenger

public class ColorfulBouncingCircle extends ColorfulCircle {
	private double xVelocity, yVelocity;
	private static double width;
	private static double height;
	
	public ColorfulBouncingCircle(double radius, double centerX, double centerY, Color color, double xVelocity, double yVelocity) {
		super(radius, centerX, centerY, color);
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
	}
	
	//Set height of playing field
	public static void setPlayingFieldSize(double newWidth, double newHeight) {
		height = newHeight;
		width = newWidth;
	}
	
	//Responsible for movement of circles
	public void tick() {
		//Determining if inside playing field
		if((this.getCenterX() >= 0 && this.getCenterX() <= width) && this.getCenterY() >= 0 && this.getCenterY() <= height) {
			double newCenterX = this.xVelocity + this.getCenterX();
			double newCenterY = this.yVelocity + this.getCenterY();
			//Determining if move would cause object to move beyond field
			if(newCenterX < 0 || newCenterX > width || newCenterY < 0 || newCenterY > height ) {
				//Determining if Bouncing from corner
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
					//Determining if Bouncing from Side Only
				} else if(newCenterX < 0 || newCenterX > width) {
					this.xVelocity = this.xVelocity * -1;
					//Determined Bounce is from Top/Bottom only
				} else {
					this.yVelocity = this.yVelocity * -1;
				}
			//Determined move would cause object to stay inside of bounds
			} else {
				this.setCenterCoordinates(newCenterX, newCenterY);
			}
		}
		
		}
	
	//Overide Overlaps method from circles to determine if circles overlap
	@Override
	public boolean overlaps(Circle c) {
		if(super.overlaps(c)) {
			super.getRadius();
			this.getRadius();
			if(c.getCenterX() > this.getCenterX() || c.getCenterX() < this.getCenterX()) {
				this.xVelocity = this.xVelocity * -1;
			}
			if(c.getCenterY() < this.getCenterY() || c.getCenterY() > this.getCenterY()) {
				this.yVelocity = this.yVelocity * -1;
			}

		}
		
		return super.overlaps(c);
	}
}
