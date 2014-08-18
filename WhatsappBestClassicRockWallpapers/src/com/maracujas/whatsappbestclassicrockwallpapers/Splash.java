package com.maracujas.whatsappbestclassicrockwallpapers;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.ImageView;

public class Splash extends Activity {
	
	FasterAnimationsContainer mFasterAnimationsContainer;
	private static final int[] IMAGE_RESOURCES = { R.drawable.splash_wallpaper_00000, R.drawable.splash_wallpaper_00001, R.drawable.splash_wallpaper_00002, R.drawable.splash_wallpaper_00003,
			R.drawable.splash_wallpaper_00004, R.drawable.splash_wallpaper_00005, R.drawable.splash_wallpaper_00006, R.drawable.splash_wallpaper_00007
			, R.drawable.splash_wallpaper_00008, R.drawable.splash_wallpaper_00009, R.drawable.splash_wallpaper_00010, R.drawable.splash_wallpaper_00011,
			R.drawable.splash_wallpaper_00012, R.drawable.splash_wallpaper_00013, R.drawable.splash_wallpaper_00014, R.drawable.splash_wallpaper_00015, R.drawable.splash_wallpaper_00016,
			R.drawable.splash_wallpaper_00017, R.drawable.splash_wallpaper_00018, R.drawable.splash_wallpaper_00019, R.drawable.splash_wallpaper_00020, R.drawable.splash_wallpaper_00021, R.drawable.splash_wallpaper_00022, R.drawable.splash_wallpaper_00023, R.drawable.splash_wallpaper_00024, R.drawable.splash_wallpaper_00025, R.drawable.splash_wallpaper_00026, R.drawable.splash_wallpaper_00027, R.drawable.splash_wallpaper_00028, R.drawable.splash_wallpaper_00029, R.drawable.splash_wallpaper_00030, R.drawable.splash_wallpaper_00031, R.drawable.splash_wallpaper_00032, R.drawable.splash_wallpaper_00033, R.drawable.splash_wallpaper_00034, R.drawable.splash_wallpaper_00035, R.drawable.splash_wallpaper_00036, R.drawable.splash_wallpaper_00037, R.drawable.splash_wallpaper_00038, R.drawable.splash_wallpaper_00039, R.drawable.splash_wallpaper_00040, R.drawable.splash_wallpaper_00041, R.drawable.splash_wallpaper_00042, R.drawable.splash_wallpaper_00043, R.drawable.splash_wallpaper_00044, R.drawable.splash_wallpaper_00045, R.drawable.splash_wallpaper_00046, R.drawable.splash_wallpaper_00047, R.drawable.splash_wallpaper_00048, R.drawable.splash_wallpaper_00049, R.drawable.splash_wallpaper_00050, R.drawable.splash_wallpaper_00051, R.drawable.splash_wallpaper_00052, R.drawable.splash_wallpaper_00053, R.drawable.splash_wallpaper_00054, R.drawable.splash_wallpaper_00055, R.drawable.splash_wallpaper_00056, R.drawable.splash_wallpaper_00057, R.drawable.splash_wallpaper_00058, R.drawable.splash_wallpaper_00059};
	private static final int ANIMATION_INTERVAL = 50;// 200ms
	
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        // show the screen (our splash image)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        
        
        ImageView img = (ImageView)findViewById(R.id.splash_anim);

        mFasterAnimationsContainer = FasterAnimationsContainer
				.getInstance(img);
		mFasterAnimationsContainer.addAllFrames(IMAGE_RESOURCES,
				ANIMATION_INTERVAL);
		mFasterAnimationsContainer.start();
		 Handler x = new Handler();
	        x.postDelayed(new splashhandler(), 2000);
    }

    class splashhandler implements Runnable {

        public void run() {

            // start new activity
            startActivity(new Intent(getApplication(), Main.class));
            // close out this activity
            finish();

        }
    }
    
    @Override
	protected void onDestroy() {
		super.onDestroy();
		mFasterAnimationsContainer.stop();
	}
    

}
