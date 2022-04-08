/*
 * Yanlin Huang
 * 7/26/2021
 * 
 */

import java.awt.*;

public class Animation {

	public static void main(String[] args) {
		DrawingPanel p = new DrawingPanel(400, 290);
		Graphics g = p.getGraphics();
		p.setBackground(Color.BLACK);
		
		//draw CLUB with a white pen
		drawClub(g,p);
		//draw a blue frame after drawing Club to make it cooler
		g.setColor(Color.blue);
		g.fillRect(0, 220, 390, 15);
		g.fillRect(0, 35, 390, 15);
		p.sleep(1000);
		//moving black circle erase club
		eraseClub(g,p);
		//draw a robot's head
		drawRobot(g,p);
		//show the text "We are Emotion AI Club!"
		g.setColor(new Color(11, 122, 63));
		g.setFont(new Font("Serif", Font.PLAIN, 25));
		g.drawString("We are Emotion AI Club!", 76, 180);
		p.sleep(2000);
		
		//cut the robot into halves
		cutRobot(g,p);
		
		//show the green text "?" and "RUN!"		
		g.setColor(new Color(11, 122, 63));
		g.drawString("?", 282, 180);
		p.sleep(1000);	
		g.drawString("RUN!",20, 265);
		p.sleep(500);
		
		//robot chases the "Emotion AI'
		chasing(g, p);
		//robot eats the "Emotion AI"
		eating(g, p);		
		//"RUN" got more ! and turns blue
		blueRUN(g, p);
		//robot back to origin
		goingBack(g, p);
		//"RUN" run
		runing(g, p);
	}
	public static void drawClub(Graphics g, DrawingPanel p) {
		letterC(g, p);
		letterL(g, p);
		letterU(g, p);
		letterB(g, p);
		p.sleep(400);
	}
	
	public static void eraseClub(Graphics g, DrawingPanel p) {
		int x = 350;
		//eraser moves up and down
		for(int i = 1; i <= 8; i++) {
			eraser(x, 200, x, 20, g, p, 1);
			x -= 50;
			eraser(x+50, 20, x, 200, g, p, 1);			
		}
		p.sleep(500);
	}
	
	public static void drawRobot(Graphics g, DrawingPanel p) {
		//two eyes
		drawEyes(g,p);
		p.sleep(1300);
		//face
		g.setColor(new Color(51, 88, 158));
		g.fillRect(165, 90, 65, 50);
		drawEyes(g,p);
		p.sleep(600);
		//ears
		g.setColor(new Color(153, 103, 41));
		g.fillRect(150, 105, 15, 22);
		g.fillRect(230, 105, 15, 22);
		p.sleep(400);
		//radio hat
		drawHat(g,p);
		p.sleep(400);
		//use pen to draw mouth
		smallWhitePen(175, 115, 197, 130, g, p, 10);
		smallWhitePen(197, 130, 217, 113, g, p, 10);
		p.sleep(500);
	}
	
	public static void cutRobot(Graphics g, DrawingPanel p) {
		for(int i = 1; i <= 14; i++) {
			p.clear();			
			//objects that remain the same
			g.setColor(new Color(11, 122, 63));
			g.drawString("Emotion AI", 154, 180);
			drawHat(g, p);
			
			//the left half robot moving to left with speed = 3
			leftRobot(3 * i, 0, g, p);	
			
			//the right half robot moving to right with speed = 5
			rightRobot(5 * i, 0, g, p);		
			
			p.sleep(50);
		}
		p.sleep(1000);
	}
	
	public static void chasing(Graphics g, DrawingPanel p) {		
		for(int i = 1; i <= 10; i++) {
			p.clear();
			//still objects
			g.setColor(new Color(11, 122, 63));
			g.drawString("RUN!",20, 265);
			g.drawString("Emotion AI ?", 154 + 2*i, 180 + i);
			drawHat(g, p);
			
			//left head move down
			leftRobot(3*14, 6*i, g, p);
			//right head move to lower right
			rightRobot(5*14 + 6*i, 6*i, g, p);
			p.sleep(50);
		}
		p.sleep(600);
	}
	
	public static void eating(Graphics g, DrawingPanel p) {
		for(int i = 1; i <= 17; i++) {
			p.clear();
			//unchanged objects
			g.setColor(new Color(11, 122, 63));
			g.drawString("RUN!",20, 265);
			g.drawString("Emotion AI ?", 154 + 2*10, 180 + 10);
			drawHat(g, p);
			
			//the left head move to right
			eraser(123, 150, 110 + 5*i, 150, g, p, 0);
			leftRobot(42 - 5*i, 60, g, p);
			//the right head move to left
			eraser(325, 150, 325 - 5*i, 150, g, p, 0);
			rightRobot(130 - 5*i, 60, g, p);
			p.sleep(200);
		}
	}
	
	public static void blueRUN(Graphics g, DrawingPanel p) {
		p.clear();
		//robot cannot completely close the month in the last eating method
		//to make it more smooth, I call the scene with "run!" first
		drawHat(g, p);
		leftRobot(-45, 60, g, p);
		rightRobot(45, 60, g, p);
		g.setColor(new Color(11, 122, 63));
		g.drawString("RUN?",20, 265);
		p.sleep(1000);
		
		//RUN got two more !
		g.setColor(new Color(11, 122, 63));
		g.drawString("RUN???",20, 265);
		p.sleep(1000);
	
		//RUN turns blue
		g.setColor(new Color(51, 88, 159));
		g.drawString("RUN???",20, 265);
	    p.sleep(1000);
	}
	
	public static void goingBack(Graphics g, DrawingPanel p) {
		for(int i = 1; i <= 15; i++) {
			p.clear();
			//still objects and RUN get back to one !
			g.setColor(new Color(51, 88, 159));
			g.drawString("RUN?",20, 265);
			drawHat(g, p);
			
			//robot move back
			leftRobot(-45 + 3*i, 60 - 4*i, g, p);
			rightRobot(45 - 3*i, 60 - 4*i, g, p);
			p.sleep(50);
		}
		p.sleep(2000);
	}
	
	public static void runing(Graphics g, DrawingPanel p) {
		for(int i = 1; i <= 10; i++) {
			p.clear();
			//RUN move to lower left
			g.setColor(new Color(51, 88, 159));
			g.drawString("RUN?",20 - 5*i, 265 + 5*i);
			
			//unchanged Objects
			drawHat(g, p);
			leftRobot(0, 0, g, p);
			rightRobot(0, 0, g, p);
			p.sleep(100);			
		}
	}
	
	//left half of robot except for hat
	//dx, dy describe the distant from origin
	public static void leftRobot(int dx, int dy, Graphics g, DrawingPanel p) {
		g.setColor(new Color(51, 88, 158));
		g.fillRect(165 - dx, 90 + dy, 33, 50);
		g.setColor(Color.white);
		g.fillOval(175 - dx, 100 + dy, 5, 5);
		g.setColor(new Color(153, 103, 41));
		g.fillRect(150 - dx, 105 + dy, 15, 22);
		smallWhitePen(175 - dx, 115 + dy, 197 - dx, 130 + dy, g, p, 0);
	}
	//right half of robot except for hat
	public static void rightRobot(int dx, int dy, Graphics g, DrawingPanel p) {
		g.setColor(new Color(51, 88, 158));
		g.fillRect(198 + dx, 90 + dy, 32, 50);
		g.setColor(Color.white);
		g.fillOval(215 + dx, 100 + dy, 5, 5);
		g.setColor(new Color(153, 103, 41));
		g.fillRect(230 + dx, 105 + dy, 15, 22);
		smallWhitePen(197 + dx, 130 + dy, 217 + dx, 113 +dy, g, p, 0);
	}
	
	public static void letterC(Graphics g, DrawingPanel p) {
		//ball from (75,50) to (0,125) and cut to half to make more curve
		whitePen(75, 50, 30, 75, g, p);
		whitePen(30, 75, 0, 125, g, p);
		//ball from (0, 125) to (75,200) 
		whitePen(0, 125, 32, 170, g, p);
		whitePen(32, 170, 75, 200, g, p);
	}
	
	public static void letterL(Graphics g, DrawingPanel p) {
		//ball from (100, 50) to (100, 200) and back to (175, 200)
		whitePen(100, 50, 100, 200, g, p);
		whitePen(100, 200, 175, 200, g, p);
	}
	
	public static void letterU(Graphics g, DrawingPanel p) {
		whitePen(200, 50, 200, 150, g, p);
		whitePen(200, 150, 238, 200, g, p);
		//(238,200) is the lowest point of U letter
		whitePen(238, 200, 275, 150, g, p);
		whitePen(275, 150, 275, 45, g, p);
	}
	
	public static void letterB(Graphics g, DrawingPanel p) {
		whitePen(300, 50, 300, 200, g, p);
		//first semicircle of B
		whitePen(300, 50, 375, 87, g, p);
		whitePen(375, 87, 300, 125, g, p);
		//second semicircle of B
		whitePen(300, 125, 375, 163, g, p);
		whitePen(375, 163, 300, 200, g, p);
	}
	
	//set up general pen for white pen and black eraser
	//will move form (x1, y1) to (y2, y2) at the same speed
	public static void pen(int x1, int y1,int x2, int y2, Graphics g, DrawingPanel p, int sleepTime, Color color, int size) {
		int lengthX = x2 - x1;
		int lengthY = y2 - y1;
		int loopTimes = (int)Math.sqrt(lengthX * lengthX + lengthY * lengthY); //move 1 in total per loop
		
		//use double to get a more exact number on x and y component speeds
		double dx = (double)lengthX/loopTimes;
		double dy = (double)lengthY/loopTimes;
		
		for(int i = 0; i < loopTimes; i++) {
			g.setColor(color);
			//fillOval method only allow int type, trun double back to int
			g.fillOval(x1 + (int)(dx * i), y1 + (int)(dy * i), size, size);			
			p.sleep(sleepTime);
		}
	}
	
	//set up a white pen to draw on black panel
	public static void whitePen(int x1, int y1,int x2, int y2, Graphics g, DrawingPanel p) {
		pen(x1, y1, x2, y2, g, p, 2, Color.white, 20);
	}
	
	//set up a black eraser by general pen
	public static void eraser(int x1, int y1,int x2, int y2, Graphics g, DrawingPanel p, int sleepTime) {
		pen(x1, y1, x2, y2, g, p, sleepTime, Color.black, 50);
	}
	
	//set up smaller white pen for drawing month
	public static void smallWhitePen(int x1, int y1,int x2, int y2, Graphics g, DrawingPanel p, int sleepTime) {
		pen(x1, y1, x2, y2, g, p, sleepTime, Color.white, 3);
	}
	
	public static void drawEyes(Graphics g, DrawingPanel p) {
		g.setColor(Color.white);
		g.fillOval(175, 100, 5, 5);
		g.fillOval(215, 100, 5, 5);
		
	}
	
	public static void drawHat(Graphics g, DrawingPanel p) {
		Color red1 = new Color(143, 51, 30);
		g.setColor(red1);
		g.fillRect(193, 70, 8, 20);
		g.fillOval(185, 60, 25, 20);
	}

}