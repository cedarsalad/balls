package balls;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class Ball {
	private int radius;
	private Point position;
	private Color color;
	public int xVelocity;
	public int yVelocity;
	
	public Ball(int radius, Point position, Color color) {
		this.radius = radius;
		this.position = position;
		this.color = color;
		Random r = new Random();
		if (r.nextFloat() < 0.5) 
			xVelocity = r.nextInt(3)+1;
		else
			xVelocity = -(r.nextInt(3)+1);
		Random r2 = new Random();
		if (r.nextFloat() < 0.5) 
			yVelocity = r.nextInt(3)+1;
		else
			yVelocity = -(r.nextInt(3)+1);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
