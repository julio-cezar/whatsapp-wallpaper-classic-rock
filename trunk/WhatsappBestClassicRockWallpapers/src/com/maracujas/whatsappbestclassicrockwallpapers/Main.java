package com.maracujas.whatsappbestclassicrockwallpapers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

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


		btBeatles.setOnClickListener(this);
		btEagles.setOnClickListener(this);
		btRolling.setOnClickListener(this);
		btACDC.setOnClickListener(this);
		btLedZeppelin.setOnClickListener(this);
		btWho.setOnClickListener(this);

	}
	
	@Override
	public void onClick(View v) {
		Intent i=new Intent(this, Wallpaper.class);
		switch(v.getId()){
		case R.id.bt_the_beatles:	
			i.putExtra("banda", "beatles");
			this.startActivity(i);
			break;
		case R.id.bt_eagles:
			i.putExtra("banda", "eagles");
			this.startActivity(i);
			finish();
			break;
		case R.id.bt_rolling_stone:
			i.putExtra("banda", "rolling");
			this.startActivity(i);
			finish();
			break;
		case R.id.bt_acdc:
			//i.putExtra("banda", "acdc");
			this.startActivity(i);
			break;
		case R.id.bt_the_led_zeppelin:
			//i.putExtra("banda", "ledzeppelin");
			this.startActivity(i);
			break;
		case R.id.bt_the_who:
			i.putExtra("banda", "who");
			this.startActivity(i);
			break;
	
	}
	}
}
