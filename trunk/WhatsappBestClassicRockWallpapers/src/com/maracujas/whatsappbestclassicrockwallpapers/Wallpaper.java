package com.maracujas.whatsappbestclassicrockwallpapers;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Wallpaper extends Activity implements OnClickListener{
	ImageView display;
	int toPhone;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wallpaper);
		
		toPhone = R.drawable.back_acdc_1;
		
		display  = (ImageView) findViewById(R.id.IVDisplay);
		ImageView image1 = (ImageView) findViewById(R.id.IVimage1);
		ImageView image2 = (ImageView) findViewById(R.id.IVimage2);
		ImageView image3 = (ImageView) findViewById(R.id.IVimage3);
		ImageView image4 = (ImageView) findViewById(R.id.IVimage4);
		ImageView image5 = (ImageView) findViewById(R.id.IVimage5);
		ImageView image6 = (ImageView) findViewById(R.id.IVimage6);
		ImageView image7 = (ImageView) findViewById(R.id.IVimage7);
		Button setWall = (Button) findViewById(R.id.BsetWallpaper);
		
		image1.setOnClickListener(this);
		image2.setOnClickListener(this);
		image3.setOnClickListener(this);
		image4.setOnClickListener(this);
		image5.setOnClickListener(this);
		image6.setOnClickListener(this);
		image7.setOnClickListener(this);
		setWall.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.IVimage1:
			display.setImageResource(R.drawable.back_acdc_1);
			toPhone = R.drawable.back_acdc_1;
			break;
		case R.id.IVimage2:
			display.setImageResource(R.drawable.back_acdc_2);
			toPhone = R.drawable.back_acdc_2;
			break;
		case R.id.IVimage3:
			display.setImageResource(R.drawable.back_beatles_1);
			toPhone = R.drawable.back_beatles_1;
			break;
		case R.id.IVimage4:
			display.setImageResource(R.drawable.back_bonjovi_1);
			toPhone = R.drawable.back_bonjovi_1;
			break;
		case R.id.IVimage5:
			display.setImageResource(R.drawable.back_gunsnroses_1);
			toPhone = R.drawable.back_gunsnroses_1;
			break;
		case R.id.IVimage6:
			display.setImageResource(R.drawable.back_kiss_1);
			toPhone = R.drawable.back_kiss_1;
			break;
		case R.id.IVimage7:
			display.setImageResource(R.drawable.back_lad_zepplin_2);
			toPhone = R.drawable.back_lad_zepplin_2;
			break;
			
		case R.id.BsetWallpaper:
			InputStream is = getResources().openRawResource(toPhone);
			Bitmap bm = BitmapFactory.decodeStream(is);
			try{
				getApplicationContext().setWallpaper(bm);
				Toast.makeText(getApplicationContext(), "Image Saved Succesfully!", Toast.LENGTH_LONG).show();
			}catch(IOException e){
				e.printStackTrace();
			}
			break;
		}
	}
}
