package balls;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class Main42 {

	public static void main(String[] args) {
		Ball balls[] = new Ball[99];
		Random rand = new Random();
		for (int i=0; i<balls.length; i++) {
			int radius = (int)((rand.nextInt(3)+1)*10);
			
			int x = (int)((rand.nextInt(21)+3)*10);
			int y = (int)((rand.nextInt(21)+1)*10);
			
			float r = rand.nextFloat();
			float g = rand.nextFloat();
			float b = rand.nextFloat();
			Color randomColor = new Color(r, g, b);

			balls[i] = new Ball(radius, new Point(x, y), randomColor);
		}
		
		Frame f = new Frame(balls);
		Thread t = new Thread(f);
		
		t.start();
	}

}
