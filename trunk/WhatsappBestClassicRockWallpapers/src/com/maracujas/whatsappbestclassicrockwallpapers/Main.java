package com.maracujas.whatsappbestclassicrockwallpapers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Main extends Activity implements OnClickListener{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_main);
		Button btBeatles = (Button) findViewById(R.id.bt_the_beatles);
		Button btEagles = (Button) findViewById(R.id.bt_eagles);
		Button btRolling = (Button) findViewById(R.id.bt_rolling_stone);
		Button btACDC = (Button) findViewById(R.id.bt_acdc);
		Button btLedZeppelin = (Button) findViewById(R.id.bt_the_led_zeppelin);
		Button btWho = (Button) findViewById(R.id.bt_the_who);
		Button btKiss = (Button) findViewById(R.id.bt_kiss);
		Button btAeroSmith = (Button) findViewById(R.id.bt_aerosmith);
		Button btDoors = (Button) findViewById(R.id.bt_the_doors);
		Button btVanHaren = (Button) findViewById(R.id.bt_van_halen);
		
		btBeatles.setOnClickListener(this);
		btEagles.setOnClickListener(this);
		btRolling.setOnClickListener(this);
		btACDC.setOnClickListener(this);
		btLedZeppelin.setOnClickListener(this);
		btWho.setOnClickListener(this);
		btKiss.setOnClickListener(this);
		btAeroSmith.setOnClickListener(this);
		btDoors.setOnClickListener(this);
		btVanHaren.setOnClickListener(this);
		
		/*btBeatles.setBackgroundResource(R.drawable.seletor_the_beatles);
		btEagles.setBackgroundResource(R.drawable.seletor_bt_eagles);
		btRolling.setBackgroundResource(R.drawable.seletor_bt_rolling_stone);
		btACDC.setBackgroundResource(R.drawable.seletor_bt_acdc);
		btLedZeppelin.setBackgroundResource(R.drawable.seletor_bt_led_zeppelin);
		btWho.setBackgroundResource(R.drawable.seletor_bt_the_who);*/


	}
	
	@Override
	public void onClick(View v) {
		Intent i=new Intent(this, Wallpaper.class);
		switch(v.getId()){
		case R.id.bt_rolling_stone:
			i.putExtra("banda", "rolling");
			this.startActivity(i);
			finish();	
			break;
		case R.id.bt_eagles:
			i.putExtra("banda", "eagles");
			this.startActivity(i);
			finish();
			break;
		case R.id.bt_the_beatles:	
			i.putExtra("banda", "beatles");
			this.startActivity(i);
			finish();
			break;
		case R.id.bt_acdc:
			i.putExtra("banda", "acdc");
			this.startActivity(i);
			finish();
			break;
		case R.id.bt_the_led_zeppelin:
			i.putExtra("banda", "ledzeppelin");
			this.startActivity(i);
			break;
		case R.id.bt_the_who:
			i.putExtra("banda", "who");
			this.startActivity(i);
			finish();
			break;	
		
		case R.id.bt_kiss:
			i.putExtra("banda", "kiss");
			this.startActivity(i);
			finish();
			break;	
		
		case R.id.bt_aerosmith:
			i.putExtra("banda", "aerosmith");
			this.startActivity(i);
			finish();
			break;	
			
		case R.id.bt_the_doors:
			i.putExtra("banda", "doors");
			this.startActivity(i);
			finish();
			break;	
			
		case R.id.bt_van_halen:
			i.putExtra("banda", "vanhalen");
			this.startActivity(i);
			finish();
			break;	
	}
}
		

	private Bitmap decodeFile(File f){
	    try {
	        //Decode image size
	        BitmapFactory.Options o = new BitmapFactory.Options();
	        o.inJustDecodeBounds = true;
	        BitmapFactory.decodeStream(new FileInputStream(f),null,o);

	        //The new size we want to scale to
	        final int REQUIRED_SIZE=70;

	        //Find the correct scale value. It should be the power of 2.
	        int scale=1;
	        while(o.outWidth/scale/2>=REQUIRED_SIZE && o.outHeight/scale/2>=REQUIRED_SIZE)
	            scale*=2;

	        //Decode with inSampleSize
	        BitmapFactory.Options o2 = new BitmapFactory.Options();
	        o2.inSampleSize=scale;
	        return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
	    } catch (FileNotFoundException e) {}
	    return null;
	}
}
