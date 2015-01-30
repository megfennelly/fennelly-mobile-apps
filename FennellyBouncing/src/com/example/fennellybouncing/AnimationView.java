package com.example.fennellybouncing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.hardware.SensorManager;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class AnimationView extends View {
	
	//Field for animation view
	private AnimationView animationView;
	
	//Sensor manager for accelerometer
	private SensorManager sensorManager;
	
	//creating actors
	private Actor michael;
	private Actor thomas;
	private Actor nate;
	private Actor serena;
	private Actor dan;
	private Actor blair;
	private Actor vogue;
	
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
		
		//initialize
		michael = new Actor(context, 100, 100, Color.RED, 10);
		thomas = new Actor(context, 200, 200, Color.BLUE, 9);
		serena = new Actor(context, 200, 100, Color.MAGENTA, 9);
		dan = new Actor(context, 100, 150, Color.GREEN, 8);
		nate = new Actor(context, 200, 100, Color.DKGRAY, 9);
		blair = new Actor(context, 500, 300, Color.CYAN, 10);
		vogue = new Actor(context, 200, 300, Color.RED, 10);
		
		vogue.setCostume(R.drawable.oreo);
		
		
		
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
			michael.drawCircle(c);
			thomas.drawSquare(c);
			serena.drawSquare(c);
			blair.drawCircle(c);
			dan.drawSquare(c);
			nate.drawCircle(c);
			vogue.draw(c);
			
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
			nate.bounce(c);
			
			//call runnable
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
