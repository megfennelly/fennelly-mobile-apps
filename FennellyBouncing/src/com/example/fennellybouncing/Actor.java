package com.example.fennellybouncing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;

public class Actor {
	//Fields for aCtor
	private Point p; //for location
	private int c; //color
	private int s;//size
	private int dx; //change in x speed
	private int dy; //change in y speed
	private Paint paint; //paint object
	
	//ints for width and height
	private int w;
	private int h;
	
	//boolean visible to check if draw
	private boolean isVisable = true;
	
	// Context
	private Context aContext;
	private int costume;
	private BitmapDrawable graphic;
	
	//Constructor
	public Actor(Context context, int x, int y, int col, int size) {
		// Initialize values
		p = new Point(x, y);
		c = col; 
		s = size; //assign size
		w = s;//set width
		h = s; //set height
		paint = new Paint(); //creates paint object
		paint.setColor(c);//sets paint color
		dx = 0;
		dy = 0; //sets speed to zero
		
		//set the context
		aContext = context;
		
}// end constructor 
	
	// Acessors and Modifiers 
	
	public boolean getVisable() {
		return isVisable;
	}
	
	public int getX() {
		return p.x;
	}

	
	public int getY() {
		return p.y;
	}
	
	public Paint getPaint() {
		return paint;
	}
	
	public int getSize() {
		return s;
	}
	
	// Modifiers - change data in actor
	public void setColor(int col){
		c = col;
		paint.setColor(c);
		

		}
	
	public void goTo(int x, int y) {
		p.x = x;
		p.y = y;
		}
	
	public void setDX(int speed) {
		dx = speed;
	}
	
	public void setVisable(boolean v) {
		isVisable = v;
	}
	public void setDY(int speed) {
		dy = speed;
}
	public void changeDX(float a) {
		dx += a;
	}
	
	public void changeDY(float a) {
		dy += a;
	}
	
	public void move() {
		p.x += dx;
		p.y += dy;
	}
	
	public void bounce(Canvas c) {
		if (p.x > c.getWidth() || p.x < 0) {
			dx = dx * -1;
		}
		if (p.y > c.getHeight() || p.y < 0) {
			dy = dy * -1;
		}

	}
	
	//Returns h and w 
	public int getHeight() {
		return h;
	}
	
	public int getWidth() {
		return w;
	}
	
	public void bounceActor(Actor a) {
		
		}
	
	//last actor functions
	public void drawCircle(Canvas c) {
		c.drawCircle(p.x,  p.y, s, paint);
	}
	
	public void drawSquare(Canvas c) {
		c.drawRect(p.x,  p.y, p.x+s, p.y+s, paint);
	}
	
	public void setCostume(int cost) {
		costume = cost;
		graphic = (BitmapDrawable)aContext.getResources().getDrawable(costume);
		//set width and height based on graphic
		w = graphic.getBitmap().getWidth();
		h = graphic.getBitmap().getHeight();
	}
	
	
	public Bitmap getBitmap() {
		return graphic.getBitmap();
	}
	
	public void draw(Canvas c) {
		c.drawBitmap(getBitmap(), p.x, p.y, paint);
	}
	
	//Function to return true or false if touching another ACtor
	public boolean isTouching(Actor a) {
		boolean result = false;
		
		if ((p.x+w > a.getX() && p.x < a.getX() + a.getWidth()) && (p.y +h >a.getY()&& p.y+h < a.getY() +a.getHeight())) {
	result = true;
		}
	return result;
}
 //Bounce off Function
	public void bounceOff() {
		dx = dx * -1;
		dy = dy * -1;
	}
	
	public void bounceUp() {
		dy = dy * -1;
	}
//modifiers for width and height
	public void setWidth(int width) {
		w = width;
	}
	
	public void setHeight(int height) {
		h = height;
	}
	
	//Function to draw a Rectangle
	public void drawRect(Canvas c) {
		if (isVisable) {
		c.drawRect(p.x, p.y, p.x+w, p.y+h, paint);
	}
		
	
	}
}

