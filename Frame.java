package balls;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Frame extends JFrame implements Runnable{
	private Ball balls[];
	private Panel pan;
	private JLabel lblClickMe;
	private int ballCount;
	public Frame(Ball balls[]) {
		this.balls = balls;
		ballCount = 0;
		this.setTitle("Ballz");
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		
		this.pan = new Panel();
		this.setContentPane(pan);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblClickMe= new JLabel("Click Me");
		lblClickMe.setHorizontalTextPosition(SwingConstants.CENTER);
		lblClickMe.setForeground(Color.RED);
		lblClickMe.setFont(new Font("Yu Gothic", Font.PLAIN, 32));
		lblClickMe.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblClickMe, BorderLayout.SOUTH);
	}
	
	class Panel extends JPanel{
		public void paintComponent(Graphics g) {
			for(int i=0; i<ballCount; i++) {
				g.setColor(balls[i].getColor());
				g.fillOval(balls[i].getPosition().x, balls[i].getPosition().y, balls[i].getRadius()*2, balls[i].getRadius()*2);
			}
			
		}
	}

	@Override
	public void run() {
		Random r = new Random();
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if (ballCount == 0)
					lblClickMe.setVisible(false);
				ballCount++;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			
		});
		
		while(true) {
			try {
				for(int i=0; i<ballCount; i++) {
					int x = balls[i].getPosition().x;
					int y = balls[i].getPosition().y;
					
					if (x<0 || x>595 - balls[i].getRadius()*2) {
						balls[i].xVelocity *= -1; 
						balls[i].setColor(new Color(r.nextFloat(),r.nextFloat(),r.nextFloat()));
					}
					if (y<0 || y>570 - balls[i].getRadius()*2) {
						balls[i].yVelocity *= -1; 
						balls[i].setColor(new Color(r.nextFloat(),r.nextFloat(),r.nextFloat()));
					}
					Point p = new Point(balls[i].getPosition().x + balls[i].xVelocity, balls[i].getPosition().y + balls[i].yVelocity);
					balls[i].setPosition(p);
				}
				Thread.sleep(10);
			}catch(Exception e) {}
			
			this.repaint();
			this.revalidate();
		}
		
	}
}
