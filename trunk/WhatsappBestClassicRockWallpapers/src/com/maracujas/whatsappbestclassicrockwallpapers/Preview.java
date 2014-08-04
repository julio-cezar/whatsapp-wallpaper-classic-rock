package com.maracujas.whatsappbestclassicrockwallpapers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class Preview extends Activity {
	
	Bundle extras;
	int imageId;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
			
		setContentView(R.layout.activity_preview);
		
		ImageView image1 = (ImageView) findViewById(R.id.imageViewPreview);
		
		
		extras = getIntent().getExtras(); 
		//imageId=1;

		if (extras != null) {
			//String auximage = extras.getString("image");
			imageId = extras.getInt("image");
		}
		image1.setImageResource(imageId);
	}
	
	/*public void onBackPressed() {

		 Intent start = new Intent(Preview.this, Wallpaper.class);
		    startActivity(start);
		    //finish();
		 }*/
	
	@Override
	public void onDestroy()
	{   
	    Cleanup();
	    super.onDestroy();
	}

	private void Cleanup()
	{    
	   System.gc();
	    Runtime.getRuntime().gc();  
	}
}
