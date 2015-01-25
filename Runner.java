package frames;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Runner extends JPanel implements Runnable, ActionListener, MouseListener{
	private static final long serialVersionUID = 1L;
	
	JFrame mainFrame = new JFrame("Catch the ball!");
	Thread thread = new Thread(this, "Main Thread");
	
	int x = (int)(Math.random()*300);
	int y =	(int)(Math.random()*300);
	int mx = -100;
	int my = -100;
	int time = 1000;
	int speed = 10;
	int diff;
	
	JButton b = new JButton("STOP MOVING");

	
	JPanel leftPane = new JPanel();
	
	JLabel label = new JLabel("Catch the ball before the time runs out! Time: " + time);
	

	
	boolean shouldRun = true;
	boolean buttonMode = true;
	boolean toTheEnd = false;
	boolean mainRun = true;
	
	public void moveBall(){
		double decide = Math.random()*100;
		if(decide <= 25){
			if(x < 301 && y < 301){
				x += 10;
				y += 10;
			}
			else{
				x -= 10;
				y -= 10;
			}
		}
		else if(decide <= 50){
			if(x > 0 && y > 0){
				x -= 10;
				y -= 10;
			}
			else{
				x += 10;
				y += 10;
			}
		}
		else if(decide <= 75){
			if(x < 301 && y > 0){
				x += 1;
				y -= 1;
			}
			else{
				x -= 1;
				y += 1;
			}
		}
		else{
			if(x > 0 && y < 301){
				x -= 1;
				y += 1;
			}
			else{
				x += 1;
				y -= 1;
			}
		}
	}


	@Override
	public void run(){
		while(shouldRun){
			if(mainRun){
				if(mx >= x - 15 && mx <= x + 15 && my >= y - 15 && my <= y + 15){
					label.setText("YOU WIN! Time left: " + (int)time/speed);
					shouldRun = false;
					FrameTest ft = new FrameTest();
					close();
				}
				else if(time <= 0){
					label.setText("YOU LOSE! Time: 0");
					shouldRun = false;
				}
				else{
					time--;
					try {
						moveBall();
						Thread.sleep(speed);
					} 
					catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
					}
					label.setText("Catch the ball before the time runs out! Time: " + (int)time/speed);
					repaint();
				}
			}
		}
	}
	public Runner(int diff){
		this.diff = diff;
		
		if(diff == 0){
			time = 1000;
			speed = 10;
		}
		if(diff == 1){
			time = 1000;
			speed = 6;
		}
		if(diff == 2){
			time = 1000;
			speed = 1;
		}

		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(new Dimension(600, 600));
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setVisible(true);
		
		addMouseListener(this);
		setPreferredSize(new Dimension(300,300));
		mainFrame.add(this, BorderLayout.CENTER);
		
		leftPane.setSize(new Dimension(200,600));
		leftPane.setBackground(new Color(210, 210, 50));
		leftPane.setLayout(new FlowLayout());
		mainFrame.add(leftPane, BorderLayout.LINE_END);
		
		b.addActionListener(this);
		mainFrame.add(b, BorderLayout.PAGE_START);
		
		mainFrame.add(label, BorderLayout.PAGE_END);
		thread.start();
	}


	@Override
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.fillOval(x, y, 30, 30);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == b){
			if(buttonMode){
				b.setText("START MOVING");
				mainRun = false;
				buttonMode = false;
			}
			else{
				b.setText("STOP MOVING");
				mainRun = true;
				buttonMode = true;
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}	

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		mx = arg0.getX();
		my = arg0.getY();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		mx = -100;
		my = -100;
	}
	
	public void setDiff(int d){
		diff = d;
		
		if(diff == 0){
			time = 1000;
			speed = 10;
		}
		if(diff == 1){
			time = 650;
			speed = 10;
		}
		if(diff == 2){
			time = 600;
			speed = 5;
		}
	}
	
	public void close(){
		mainFrame.dispose();
	}
	
}
