package com.maracujas.whatsappbestclassicrockwallpapers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Wallpaper extends Activity implements OnClickListener{
	ImageView display;
	int toPhone;
	Uri uri;
	Bundle extras;
	String banda;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_wallpaper);
		
		
		
	    extras = getIntent().getExtras(); 
	    banda="no";

		if (extras != null) {
			banda = extras.getString("banda");
		}
				
		
		display  = (ImageView) findViewById(R.id.IVDisplay);
		toPhone = R.drawable.ic_launcher;
		uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/ic_launcher");
		ImageView image1 = (ImageView) findViewById(R.id.IVimage1);
		ImageView image2 = (ImageView) findViewById(R.id.IVimage2);
		ImageView image3 = (ImageView) findViewById(R.id.IVimage3);
		ImageView image4 = (ImageView) findViewById(R.id.IVimage4);
		ImageView image5 = (ImageView) findViewById(R.id.IVimage5);
		Button setWall = (Button) findViewById(R.id.BsetWallpaper);
		Button bPreview = (Button) findViewById(R.id.BPreview);
		ImageButton ibshare = (ImageButton) findViewById(R.id.IBSave);
		ImageButton ibsave = (ImageButton) findViewById(R.id.IBShare);
		ImageButton ibsound = (ImageButton) findViewById(R.id.IBSound);
		TextView tvBanda = (TextView) findViewById(R.id.tvBanda);

		//Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		//image1.setImageBitmap(bMap);
		
		switch(banda){
		case "beatles":
			tvBanda.setText("Beatles");
			image1.setImageResource(R.drawable.icon_back_beatles_1);
			image2.setImageResource(R.drawable.icon_back_beatles_2);
			image3.setImageResource(R.drawable.icon_back_beatles_3);
			image4.setImageResource(R.drawable.icon_back_beatles_4);
			image5.setImageResource(R.drawable.icon_back_beatles_5);
		break ;
		case "acdc":
			tvBanda.setText("AC/DC");
			image1.setImageResource(R.drawable.icon_back_acdc_1);
			image2.setImageResource(R.drawable.icon_back_acdc_2);
			image3.setImageResource(R.drawable.icon_back_acdc_3);
			image4.setImageResource(R.drawable.icon_back_acdc_4);
			image5.setImageResource(R.drawable.icon_back_acdc_5);
		break ;
		case "rolling":
			tvBanda.setText("Rolling Stones");
			image1.setImageResource(R.drawable.icon_back_rolling_1);
			image2.setImageResource(R.drawable.icon_back_rolling_2);
			image3.setImageResource(R.drawable.icon_back_rolling_3);
			image4.setImageResource(R.drawable.icon_back_rolling_4);
			image5.setImageResource(R.drawable.icon_back_rolling_5);
		break ;
		case "eagles":
			tvBanda.setText("Eagles");
			image1.setImageResource(R.drawable.icon_back_eagle_1);
			image2.setImageResource(R.drawable.icon_back_eagle_2);
			image3.setImageResource(R.drawable.icon_back_eagle_3);
			image4.setImageResource(R.drawable.icon_back_eagle_4);
			image5.setImageResource(R.drawable.icon_back_eagle_5);
			break;
		case "ledzeppelin":
			tvBanda.setText("Ledzeppelin");
			image1.setImageResource(R.drawable.icon_back_led_zeppelin_1);
			image2.setImageResource(R.drawable.icon_back_led_zeppelin_2);
			image3.setImageResource(R.drawable.icon_back_led_zeppelin_3);
			image4.setImageResource(R.drawable.icon_back_led_zeppelin_4);
			image5.setImageResource(R.drawable.icon_back_led_zeppelin_5);
			break;
		case "who":
			tvBanda.setText("The Who");
			image1.setImageResource(R.drawable.icon_back_the_who_1);
			image2.setImageResource(R.drawable.icon_back_the_who_2);
			image3.setImageResource(R.drawable.icon_back_the_who_3);
			image4.setImageResource(R.drawable.icon_back_the_who_4);
			image5.setImageResource(R.drawable.icon_back_the_who_5);
			break;
			
		case "no":
	     	   Toast.makeText(getApplicationContext(), "no Image!", Toast.LENGTH_LONG).show();
			break;
		}
				
		image1.setOnClickListener(this);
		image2.setOnClickListener(this);
		image3.setOnClickListener(this);
		image4.setOnClickListener(this);
		image5.setOnClickListener(this);
		setWall.setOnClickListener(this);
		bPreview.setOnClickListener(this);
		ibshare.setOnClickListener(this);
		ibsave.setOnClickListener(this);
		ibsound.setOnClickListener(this);
		
	}
	
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
	switch(banda){
	case "beatles":
		switch(v.getId()){
		case R.id.IVimage1:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_beatles_1);
			toPhone = R.drawable.back_beatles_1;
	        uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_beatles_1");
			break;
		case R.id.IVimage2:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_beatles_2);
	    	toPhone = R.drawable.back_beatles_2;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_beatles_2");
			break;
		case R.id.IVimage3:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_beatles_3);
			toPhone = R.drawable.back_beatles_3;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_beatles_3");
			break;
		case R.id.IVimage4:
				display.setImageDrawable(null);
				display.setImageResource(R.drawable.icon_back_beatles_4);
				toPhone = R.drawable.back_beatles_4;
				uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_beatles_4");
			break;
		case R.id.IVimage5:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_beatles_5);
			toPhone = R.drawable.back_beatles_5;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_beatles_5");
			break;		
		}
	break;
	
	case "rolling":
		
		switch(v.getId()){
		case R.id.IVimage1:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_rolling_1);
			toPhone = R.drawable.back_rolling_1;
	        uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_rolling_1");
			break;
		case R.id.IVimage2:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_rolling_2);
	    	toPhone = R.drawable.back_rolling_2;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_rolling_2");
			break;
		case R.id.IVimage3:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_rolling_3);
			toPhone = R.drawable.back_rolling_3;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_rolling_3");
			break;
		case R.id.IVimage4:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_rolling_4);
			toPhone = R.drawable.back_rolling_4;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_rolling_4");
			break;
		case R.id.IVimage5:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_rolling_5);
			toPhone = R.drawable.back_rolling_5;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_rolling_5");
			break;		
		}
	break;
	
	case "acdc":
		switch(v.getId()){
		case R.id.IVimage1:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_acdc_1);
			toPhone = R.drawable.back_acdc_1;
	        uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_acdc_1");
			break;
		case R.id.IVimage2:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_acdc_2);
	    	toPhone = R.drawable.back_acdc_2;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_acdc_2");
			break;
		case R.id.IVimage3:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_acdc_3);
			toPhone = R.drawable.back_acdc_3;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_acdc_3");
			break;
		case R.id.IVimage4:
				display.setImageDrawable(null);
				display.setImageResource(R.drawable.icon_back_acdc_4);
				toPhone = R.drawable.back_acdc_4;
				uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_acdc_4");
			break;
		case R.id.IVimage5:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_acdc_5);
			toPhone = R.drawable.back_acdc_5;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_acdc_5");
			break;		
		}
	break;
	
	case "ledzeppelin":
		switch(v.getId()){
		case R.id.IVimage1:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_led_zeppelin_1);
			toPhone = R.drawable.back_led_zeppelin_1;
	        uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_led_zeppelin_1");
			break;
		case R.id.IVimage2:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_led_zeppelin_2);
	    	toPhone = R.drawable.back_led_zeppelin_2;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_led_zeppelin_2");
			break;
		case R.id.IVimage3:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_led_zeppelin_3);
			toPhone = R.drawable.back_led_zeppelin_3;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_led_zeppelin_3");
			break;
		case R.id.IVimage4:
				display.setImageDrawable(null);
				display.setImageResource(R.drawable.icon_back_led_zeppelin_4);
				toPhone = R.drawable.back_led_zeppelin_4;
				uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_led_zeppelin_4");
			break;
		case R.id.IVimage5:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_led_zeppelin_5);
			toPhone = R.drawable.back_led_zeppelin_5;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_led_zeppelin_5");
			break;		
		}
	break;
	
	case "eagles":
		switch(v.getId()){
		case R.id.IVimage1:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_eagle_1);
			toPhone = R.drawable.back_eagle_1;
	        uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_eagle_1");
			break;
		case R.id.IVimage2:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_eagle_2);
	    	toPhone = R.drawable.back_eagle_2;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_eagle_2");
			break;
		case R.id.IVimage3:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_eagle_3);
			toPhone = R.drawable.back_eagle_3;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_eagle_3");
			break;
		case R.id.IVimage4:
				display.setImageDrawable(null);
				display.setImageResource(R.drawable.icon_back_eagle_4);
				toPhone = R.drawable.back_eagle_4;
				uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_eagle_4");
			break;
		case R.id.IVimage5:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_eagle_5);
			toPhone = R.drawable.back_eagle_5;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_eagle_5");
			break;		
		}
	break;
	
	case "who":
		switch(v.getId()){
		case R.id.IVimage1:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_the_who_1);
			toPhone = R.drawable.back_the_who_1;
	        uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_the_who_1");
			break;
		case R.id.IVimage2:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_the_who_2);
	    	toPhone = R.drawable.back_the_who_2;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_the_who_2");
			break;
		case R.id.IVimage3:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_the_who_3);
			toPhone = R.drawable.back_the_who_3;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_the_who_3");
			break;
		case R.id.IVimage4:
				display.setImageDrawable(null);
				display.setImageResource(R.drawable.icon_back_the_who_4);
				toPhone = R.drawable.back_the_who_4;
				uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_the_who_4");
			break;
		case R.id.IVimage5:
			display.setImageDrawable(null);
			display.setImageResource(R.drawable.icon_back_the_who_5);
			toPhone = R.drawable.back_the_who_5;
			uri = Uri.parse("android.resource://com.maracujas.whatsappbestclassicrockwallpapers/drawable/back_the_who_5");
			break;		
		}
	break;
	
	}
	
  switch(v.getId()){
		case R.id.BsetWallpaper:
			setWallpaper();
			sound();
			break;
		case R.id.IBSave:
			saveImage();
			sound();
			break;			
		case R.id.IBShare:
			shareImage();
			sound();
			break;	
		case R.id.IBSound:
			//setNotification();
			sound();
			break;
		
		case R.id.BPreview:
			 Intent intentPreview = new Intent(Wallpaper.this, Preview.class);
			 intentPreview.putExtra("image", toPhone);
			 startActivity(intentPreview);
		//	 moveTaskToBack(true);
			break;
	}
	}
	
	public void setWallpaper(){
		InputStream is = getResources().openRawResource(toPhone);
		Bitmap bm = BitmapFactory.decodeStream(is);
		try{
			getApplicationContext().setWallpaper(bm);
			Toast.makeText(getApplicationContext(), "Image was set as Wallpaper Succesfully!", Toast.LENGTH_LONG).show();
			Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
			 // Vibrate for 500 milliseconds
			 v.vibrate(500);
		}catch(IOException e){
			e.printStackTrace();
		}		 
	}
	public void shareImage() {
		
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/jpeg");
      //shareIntent.setType( "text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Best Classic Rock Wallpapers!");
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
        Bitmap bm = BitmapFactory.decodeResource( getResources(), toPhone);
        String strtoPhone = ""+toPhone;
        String nameFile = strtoPhone+".jpeg";
        OutputStream outStream = null;

           File savingFile = new File(commonPath, nameFile);
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
				Toast.makeText(getApplicationContext(),"Image Saved Succesfully!", Toast.LENGTH_LONG).show();
				
               } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

               } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

               }

            }
           else {
        	   Toast.makeText(getApplicationContext(), "Image already Saved!", Toast.LENGTH_LONG).show();

           }
	}
	public void sound(){
		final MediaPlayer mp = new MediaPlayer();
		if(mp.isPlaying())
        {  
            mp.stop();
            mp.reset();
        } 
        try {

            AssetFileDescriptor afd;
            afd = getAssets().openFd("raw_back_in_black_2.mp3");
            mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
            mp.prepare();
            mp.start();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	

	
	public  void setNotification(){
		/*String filepath ="/sdcard/media/ringtone";
        File ringtoneFile = new File(filepath,"Circle Game.mp3");
        ContentResolver mCr = getContentResolver();
        

           
           
        ContentValues values = new ContentValues();
        values.put(MediaStore.MediaColumns.DATA, ringtoneFile.getAbsolutePath());
        values.put(MediaStore.MediaColumns.TITLE, "Circle Game");
        values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/mp3");
        values.put(MediaStore.Audio.Media.ARTIST, "ano Hana");
        values.put(MediaStore.MediaColumns.SIZE, 215454);
        values.put(MediaStore.Audio.Media.DURATION, 230);
        values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
        values.put(MediaStore.Audio.Media.IS_NOTIFICATION, false);
        values.put(MediaStore.Audio.Media.IS_ALARM, false);
        values.put(MediaStore.Audio.Media.IS_MUSIC, true);

        Uri uri = MediaStore.Audio.Media.getContentUriForPath(ringtoneFile.getAbsolutePath());
        getContentResolver().delete(uri,MediaStore.MediaColumns.DATA + "=\""+ ringtoneFile .getAbsolutePath() + "\"", null);
        Uri newUri = getContentResolver().insert(uri, values);

       
        
        Uri ringtoneUri = Uri.parse("sdCard/media/audio/notifications/anydo_pop.mp3");
        RingtoneManager.setActualDefaultRingtoneUri( Wallpaper.this, RingtoneManager.TYPE_RINGTONE, newUri);
        Ringtone rt = RingtoneManager.getRingtone( Wallpaper.this,ringtoneUri);
        rt.play();
 	   Toast.makeText(getApplicationContext(), "sound set as ringtone!", Toast.LENGTH_LONG).show();*/
		
		
		File newSoundFile = new File("/sdcard/media/Ringtone", "myringtone.oog");
		Uri mUri = Uri.parse("android.resource://com.maracujas.whasappbestclassicrockwallpapers/R.raw.raw_back_in_black");
		ContentResolver mCr = getContentResolver();
		AssetFileDescriptor soundFile;
		try {
		       soundFile= mCr.openAssetFileDescriptor(mUri, "r");
		   } catch (FileNotFoundException e) {
		       soundFile=null;   
		   }

		   try {
		      byte[] readData = new byte[1024];
		      FileInputStream fis = soundFile.createInputStream();
		      FileOutputStream fos = new FileOutputStream(newSoundFile);
		      int i = fis.read(readData);

		      while (i != -1) {
		        fos.write(readData, 0, i);
		        i = fis.read(readData);
		      }

		      fos.close();
		   } catch (IOException io) {
		   }
		   Log.i("notification", "file created");
		   
		   ContentValues values = new ContentValues();
		   values.put(MediaStore.MediaColumns.DATA, newSoundFile.getAbsolutePath());
		   values.put(MediaStore.MediaColumns.TITLE, "1my ringtone");
		   values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/oog");
		   values.put(MediaStore.MediaColumns.SIZE, newSoundFile.length());
		   values.put(MediaStore.Audio.Media.ARTIST, R.string.app_name);
		   values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
		   values.put(MediaStore.Audio.Media.IS_NOTIFICATION, true);
		   values.put(MediaStore.Audio.Media.IS_ALARM, true);
		   values.put(MediaStore.Audio.Media.IS_MUSIC, true);

		   Uri uri = MediaStore.Audio.Media.getContentUriForPath(newSoundFile.getAbsolutePath());
		   Uri newUri = mCr.insert(uri, values);


		   try {
		       RingtoneManager.setActualDefaultRingtoneUri(this, RingtoneManager.TYPE_RINGTONE, newUri);
		 	   Toast.makeText(getApplicationContext(), "sound set as ringtone!", Toast.LENGTH_LONG).show();
		   } catch (Throwable t) {
		       Log.d("notification", "catch exception");
		   }


	}
	public void onBackPressed() {

		 Intent start = new Intent(Wallpaper.this, Main.class);
		    startActivity(start);
		    finish();
		 }
	
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
	
	/*private Bitmap getBitmap(String path) {
		ContentResolver  mContentResolver = getContentResolver();
		Uri uri = new Uri.parse(path);
		InputStream in = null;
		try {
		    final int IMAGE_MAX_SIZE = 1200000; // 1.2MP
		    in = mContentResolver.openInputStream(uri);

		    // Decode image size
		    BitmapFactory.Options o = new BitmapFactory.Options();
		    o.inJustDecodeBounds = true;
		    BitmapFactory.decodeStream(in, null, o);
		    in.close();



		    int scale = 1;
		    while ((o.outWidth * o.outHeight) * (1 / Math.pow(scale, 2)) > 
		          IMAGE_MAX_SIZE) {
		       scale++;
		    }
		    Log.d("GETBITMAP", "scale = " + scale + ", orig-width: " + o.outWidth + ",orig-height: " + o.outHeight);

		    Bitmap b = null;
		    in = mContentResolver.openInputStream(uri);
		    if (scale > 1) {
		        scale--;
		        // scale to max possible inSampleSize that still yields an image
		        // larger than target
		        o = new BitmapFactory.Options();
		        o.inSampleSize = scale;
		        b = BitmapFactory.decodeStream(in, null, o);

		        // resize to desired dimensions
		        int height = b.getHeight();
		        int width = b.getWidth();
		        Log.d("GETBITMAP", "1th scale operation dimenions - width: " + width + ",height: " + height);

		        double y = Math.sqrt(IMAGE_MAX_SIZE
		                / (((double) width) / height));
		        double x = (y / height) * width;

		        Bitmap scaledBitmap = Bitmap.createScaledBitmap(b, (int) x, 
		           (int) y, true);
		        b.recycle();
		        b = scaledBitmap;

		        System.gc();
		    } else {
		        b = BitmapFactory.decodeStream(in);
		    }
		    in.close();

		    Log.d("GETBITMAP", "bitmap size - width: " +b.getWidth() + ", height: " +b.getHeight());
		    return b;
		} catch (IOException e) {
		    Log.e("GETBITMAP", e.getMessage(),e);
		    return null;
		}
	}*/


	
}

