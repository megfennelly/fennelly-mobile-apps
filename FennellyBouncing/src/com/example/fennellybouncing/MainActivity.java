package com.example.fennellybouncing;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {
	
	//Fields for animation view
	private AnimationView animationView;
	
	//Sensor Manager for Accelerometer 
	private SensorManager sensorManager;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //Initialize animation view
    	animationView = (AnimationView)findViewById(R.id.animationView);
    	
    	//Enable the listener
    	enableAccelerometerListening();
    	
    	//initialize the sensor manager
    	sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    	sensorManager.registerListener(sensorEventListener, 
    			sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 
    			SensorManager.SENSOR_DELAY_NORMAL);
    	
    }//end onCreate
    
    //Define the sensorEventListener
    private SensorEventListener sensorEventListener = 
    		new SensorEventListener() {
    	
    	@Override
    	public void onAccuracyChanged(Sensor arg0, int arg1) {
    		//TODO Auto- generated method stub
    		//not used
    	}
    	@Override
    	public void onSensorChanged(SensorEvent event) {
    		//TODO auto- generated method stub
    		float x = event.values[0];
    		float y = event.values[1];
    		float z = event.values[2];
    		
    		//pass the values to the Animation View
    		animationView.setAX(x);
    		animationView.setAY(y);
    		animationView.setAZ(z);
    	}
   
    };//end sensorEventListener


    private void enableAccelerometerListening() {
		// TODO Auto-generated method stub
		
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
