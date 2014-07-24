package com.maracujas.whatsappbestclassicrockwallpapers;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class Splash extends Activity {
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        // show the screen (our splash image)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        // setup handler to close the splash screen
        Handler x = new Handler();
        x.postDelayed(new splashhandler(), 3000);
    }

    class splashhandler implements Runnable {

        public void run() {

            // start new activity
            startActivity(new Intent(getApplication(), Main.class));
            // close out this activity
            finish();

        }
    }
}
