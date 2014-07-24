package com.maracujas.whatsappbestclassicrockwallpapers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Wallpaper extends Activity implements OnClickListener{
	ImageView display;
	int toPhone;
	Uri uri;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_wallpaper);
		
		toPhone = R.drawable.back_acdc_1;
		
		display  = (ImageView) findViewById(R.id.IVDisplay);
		uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_acdc_1");
		ImageView image1 = (ImageView) findViewById(R.id.IVimage1);
		ImageView image2 = (ImageView) findViewById(R.id.IVimage2);
		ImageView image3 = (ImageView) findViewById(R.id.IVimage3);
		ImageView image4 = (ImageView) findViewById(R.id.IVimage4);
		ImageView image5 = (ImageView) findViewById(R.id.IVimage5);
		ImageView image6 = (ImageView) findViewById(R.id.IVimage6);
		ImageView image7 = (ImageView) findViewById(R.id.IVimage7);
		Button setWall = (Button) findViewById(R.id.BsetWallpaper);
		ImageButton ibshare = (ImageButton) findViewById(R.id.IBSave);
		ImageButton ibsave = (ImageButton) findViewById(R.id.IBShare);
		
		image1.setOnClickListener(this);
		image2.setOnClickListener(this);
		image3.setOnClickListener(this);
		image4.setOnClickListener(this);
		image5.setOnClickListener(this);
		image6.setOnClickListener(this);
		image7.setOnClickListener(this);
		setWall.setOnClickListener(this);
		ibshare.setOnClickListener(this);
		ibsave.setOnClickListener(this);
		
	}
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.IVimage1:
			display.setImageResource(R.drawable.back_acdc_1);
			toPhone = R.drawable.back_acdc_1;
	        uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_acdc_1");
			break;
		case R.id.IVimage2:
			display.setImageResource(R.drawable.back_acdc_2);
			toPhone = R.drawable.back_acdc_2;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_acdc_2");
			break;
		case R.id.IVimage3:
			display.setImageResource(R.drawable.back_beatles_1);
			toPhone = R.drawable.back_beatles_1;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_beatles_1");
			break;
		case R.id.IVimage4:
			display.setImageResource(R.drawable.back_bonjovi_1);
			toPhone = R.drawable.back_bonjovi_1;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_bonjovi_1");
			break;
		case R.id.IVimage5:
			display.setImageResource(R.drawable.back_gunsnroses_1);
			toPhone = R.drawable.back_gunsnroses_1;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_gunsnroses_1");
			break;
		case R.id.IVimage6:
			display.setImageResource(R.drawable.back_kiss_1);
			toPhone = R.drawable.back_kiss_1;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_kiss_1");
			break;
		case R.id.IVimage7:
			display.setImageResource(R.drawable.back_lad_zepplin_2);
			toPhone = R.drawable.back_lad_zepplin_2;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_lad_zepplin_2");
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
		case R.id.IBSave:
			saveImage();
			break;			
		case R.id.IBShare:
			shareImage();
			break;
		}
	}
	public void shareImage() {
		
		//uri = Uri.parse("file://sdcard/Asapato.jpg");
	
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/jpg");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Best Classic Rock Wallpapers");
        shareIntent.putExtra(Intent.EXTRA_TITLE, "SHARE");
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(Intent.createChooser(shareIntent, "Share image using"));
	}
	
	public void saveImage(){
		String commonPath = Environment.getExternalStorageDirectory().toString() + "/ClassicRock"; 
        File direct = new File(commonPath);

        if(!direct.exists())
        {
            if(direct.mkdir()) 
              {
                Log.d("tag","directory created");
               //directory is created;
              }

        }

        Bitmap bm = BitmapFactory.decodeResource( getResources(), R.drawable.back_acdc_1);
        OutputStream outStream = null;
           File savingFile = new File(commonPath, "back_acdc_1.jpeg");
           if(!savingFile.exists())
           {
               Log.d("tag","file is created");

           try {
                savingFile.createNewFile();
                outStream = new FileOutputStream(savingFile);
                bm.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
                outStream.flush();
                outStream.close();

                Log.d("tag","Saved");
				Toast.makeText(getApplicationContext(), "Image Saved Succesfully!", Toast.LENGTH_LONG).show();

               } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

               } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

               }

            }
	}
}

