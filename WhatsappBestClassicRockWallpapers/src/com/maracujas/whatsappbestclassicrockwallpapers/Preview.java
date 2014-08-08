package com.maracujas.whatsappbestclassicrockwallpapers;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
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
	    finish();
	}
	@Override
	protected void onPause() {
	    super.onPause();
	    unbindDrawables(getWindow().getDecorView().findViewById(android.R.id.content));
	    System.gc();
	}
	
	private void Cleanup()
	{    
		unbindDrawables(getWindow().getDecorView().findViewById(android.R.id.content));
		System.gc();
	    Runtime.getRuntime().gc();  
	}
	
	private void unbindDrawables(View view)
    {
            if (view.getBackground() != null)
            {
                    view.getBackground().setCallback(null);
            }
            if (view instanceof ViewGroup && !(view instanceof AdapterView))
            {
                    for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++)
                    {
                            unbindDrawables(((ViewGroup) view).getChildAt(i));
                    }
                    ((ViewGroup) view).removeAllViews();
            }
    }
	
}
