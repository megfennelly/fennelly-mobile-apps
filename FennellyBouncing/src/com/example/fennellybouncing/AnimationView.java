package com.example.fennellybouncing;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.SensorManager;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class AnimationView extends View {
	
	//Field for animation view
	private AnimationView animationView;
	
	private int lives= 0;
	
	//Sensor manager for accelerometer
	private SensorManager sensorManager;
	
	//creating actors
	private Actor michael;
	private Actor thomas;
	private Actor nate;
	private Actor serena;
	private Actor dan;
	private Actor blair;
	//private Actor vogue;
	
	//paint object
	private Paint textPainter;
	
	//breakout actors
	private Actor paddle;
	private Actor ball;
	
	//Array list for bricks
	private List <Actor> bricks;
	
	//values to hold accel data
	private float ax= 0;
	private float ay= 0;
	private float az= 0;
	
	//private Actor vogue;
	
	//create handler for animation
	private Handler h;
	private int RATE = 30;

	public AnimationView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		//breakout actors
		ball=new Actor(context, 200, 200, Color.MAGENTA, 30);
		paddle=new Actor(context, 300, 300, Color.CYAN, 40);
		
		paddle.setWidth(150);
		paddle.setHeight(40);
		
		ball.setDX(10);
		ball.setDY(10);
		
		//textPainter
		textPainter=new Paint();
		textPainter.setColor(Color.RED);
		textPainter.setTextSize(40);
		
		//Initialize the brick list
		bricks = new ArrayList <Actor> (0); //creates a list of 6
		
		//For loop to initialize bricks as Actors
		for (int i=0; i< 6; i++) {
			bricks.add(new Actor(context, i*80, 100, Color.GREEN, 40));
		}
		
		for (int i=0; i < bricks.size(); i++) {
			bricks.get(i).setWidth(75);
		}
		
		//initialize
		michael = new Actor(context, 100, 100, Color.RED, 12);
		thomas = new Actor(context, 200, 200, Color.BLUE, 18);
		serena = new Actor(context, 200, 100, Color.MAGENTA, 30);
		dan = new Actor(context, 100, 150, Color.GREEN, 22);
		nate = new Actor(context, 200, 100, Color.GREEN,20);
		blair = new Actor(context, 500, 300, Color.CYAN, 30);
		//vogue = new Actor(context, 200, 300, Color.RED, 18);
		
		//vogue.setCostume(R.drawable.oreo);
		
		
		
		michael.setDX(7);
		michael.setDY(7);
		
		serena.setDX(9);
		serena.setDY(7);
		
		dan.setDX(8);
		dan.setDY(7);
	
		nate.setDX(7);
		nate.setDY(6);
		
		blair.setDX(11);
		blair.setDY(11);
		
		thomas.setDX(8);
		thomas.setDY(9);
		
		
		//initialize handler
		h = new Handler();}
		
		//on draw method
		public void onDraw(Canvas c) {
			
		//Bricks Draw REctangles
			for (int i=0; i < bricks.size(); i++) {
				bricks.get(i).setWidth(75);
				//set brick width for screen
				bricks.get(i).setWidth((c.getWidth()/6)-3);
				//set the x position for the bricks
				int xPos = i * (c.getWidth()/6);
				
			//goto and draw the bricks
			bricks.get(i).goTo(xPos, 100);
			bricks.get(i).drawRect(c);
			
			paddle.goTo(paddle.getX(), c.getHeight()-250);
			
			c.drawText(String.valueOf(lives), 100, 150, textPainter);
			
			
			
			//check for collisions
			if (ball.isTouching(bricks.get(i))) {
				if (bricks.get(i).getVisable()== true) {
					ball.bounceUp();
					bricks.get(i).setVisable(false);
					
				}//end if
			}//end if
		}//end forloop
			//Actors for Breakout
			paddle.drawRect(c);
			ball.drawCircle(c);
			
			ball.move();
			ball.bounce(c);
			if (ball.isTouching(paddle)) {
				ball.bounceUp();
				lives++;
				
			if (ball.isTouching(serena)) {
				ball.bounceOff();
			}
			
			if (ball.isTouching(michael)){
				ball.bounceOff();
			}
			
			//Bounce off the vogue blair actor
			if (serena.isTouching(michael)) {
				serena.bounceOff();
				}
			if (serena.isTouching(thomas)) {
				serena.bounceOff();
			}
			if (serena.isTouching(blair)) {
				serena.bounceOff();
			}
			
			if (serena.isTouching(dan)) {
				serena.bounceOff();
			}
			
			if (serena.isTouching(nate)) {
				serena.bounceOff();
			}
			
		//	if (serena.isTouching(vogue)) {
			//	serena.bounceOff();
			//}
			
			
		//michael
			if (michael.isTouching(serena)) {
				michael.bounceOff();
				}
			if (michael.isTouching(thomas)) {
				michael.bounceOff();
			}
			if (michael.isTouching(blair)) {
				michael.bounceOff();
			}
			
			if (michael.isTouching(dan)) {
				michael.bounceOff();
			}
			
			if (michael.isTouching(nate)) {
				michael.bounceOff();
			}
			
			//if (michael.isTouching(vogue)) {
				//michael.bounceOff();
			//}
			
			//thomas
			if (thomas.isTouching(serena)) {
				thomas.bounceOff();
				}
			if (thomas.isTouching(michael)) {
				thomas.bounceOff();
			}
			if (thomas.isTouching(blair)) {
				thomas.bounceOff();
			}
			
			if (thomas.isTouching(dan)) {
				thomas.bounceOff();
			}
			
			if (thomas.isTouching(nate)) {
				thomas.bounceOff();
			}
			
			//if (thomas.isTouching(vogue)) {
				//thomas.bounceOff();
			//}
			
			//dan
			if (dan.isTouching(michael)) {
				dan.bounceOff();
				}
			if (dan.isTouching(thomas)) {
				dan.bounceOff();
			}
			if (dan.isTouching(blair)) {
				dan.bounceOff();
			}
			
			if (dan.isTouching(serena)) {
				dan.bounceOff();
			}
			
			if (dan.isTouching(nate)) {
				dan.bounceOff();
			}
			
			//if (dan.isTouching(vogue)) {
				//dan.bounceOff();
			//}
			
			//nate
			if (nate.isTouching(michael)) {
				nate.bounceOff();
				}
			if (nate.isTouching(thomas)) {
				nate.bounceOff();
			}
			if (nate.isTouching(blair)) {
				nate.bounceOff();
			}
			
			if (nate.isTouching(dan)) {
				nate.bounceOff();
			}
			
			if (nate.isTouching(serena)) {
				nate.bounceOff();
			}
			
			//if (nate.isTouching(vogue)) {
//				nate.bounceOff();
//			}
			
			michael.drawCircle(c);
			thomas.drawSquare(c);
			serena.drawSquare(c);
			blair.drawCircle(c);
			dan.drawSquare(c);
			nate.drawCircle(c);
			//vogue.draw(c);
			
//			//Read accel data and move oreo
//			vogue.changeDX(ax * -1);//read the x acceleration
//			vogue.changeDY(ay); //read the y accel
//			vogue.move(); //move
//			vogue.bounce(c);//bounce
			
			
			
			
			//move
			michael.move();
			thomas.move();
			michael.bounce(c);
			thomas.bounce(c);
			
			serena.move();
			//blair.move();
			serena.bounce(c);
			//blair.bounce(c);
			
			dan.move();
			nate.move();
			dan.bounce(c);
			nate.bounce(c);}
			
			
			//call the Runnable
			h.postDelayed(r, RATE);
			}
		
		private Runnable r = new Runnable() {
			
			@Override
			public void run() {
			// TODO Auto-generated constructor stub
				invalidate();
			}
			

	};//end constructor
	
	//function to grab touch event data
	public boolean onTouchEvent(MotionEvent event) {
		//fetch data from touch event
		int action=event.getActionMasked();//get type of action
		int actionIdex=event.getActionIndex();//get index of action
		
		//set Position of paddle to touch data
		paddle.goTo((int)event.getX(), 750);
		
		//set position of lair to touch data
		blair.goTo((int)event.getX(), (int)event.getY());
		
		
		return true;
	}//end on touch event
	
	//modifier fields for acceleration data
	public void setAX(float x) {
		ax = x;
	}
	
	public void setAY(float y) {
		ay = y;
	}
	
	public void setAZ(float z) {
		az = z;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}// end class animationView
