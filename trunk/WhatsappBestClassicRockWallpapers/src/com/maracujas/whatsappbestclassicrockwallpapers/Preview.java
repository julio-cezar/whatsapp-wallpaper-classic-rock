package com.maracujas.whatsappbestclassicrockwallpapers;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
		image1.setImageBitmap(decodeSampledBitmapFromResource(getResources(), imageId, 380, 600));

		
		
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
	
	public static int calculateInSampleSize(
		    BitmapFactory.Options options, int reqWidth, 
		    int reqHeight) {
		  // Altura e largura da imagem
		  final int height = options.outHeight;
		  final int width = options.outWidth;
		  int inSampleSize = 1;

		  if (height > reqHeight || width > reqWidth) {

		    // Calcula as propor��es de altura e largura 
		    // com a altura e largura solicitada
		    final int heightRatio = 
		      Math.round((float) height / (float) reqHeight);

		    final int widthRatio = 
		      Math.round((float) width / (float) reqWidth);

		    // Escolhe qual a melhor propor��o para inSampleSize 
		    inSampleSize = 
		        heightRatio < widthRatio ? heightRatio : widthRatio;
		  }

		  return inSampleSize;
		}
	
	public static Bitmap decodeSampledBitmapFromResource(
			  Resources res, int resId, int reqWidth, 
			  int reqHeight) {

			  // Primeiro faz a decodifica��o com 
			  // inJustDecodeBounds = true para verificar as dimens�es
			  final BitmapFactory.Options options = 
			      new BitmapFactory.Options();

			  options.inJustDecodeBounds = true;
			  BitmapFactory.decodeResource(res, resId, options);

			  // Calcula o inSampleSize
			  options.inSampleSize = 
			      calculateInSampleSize(options, reqWidth, reqHeight);

			  // Decodifica o bitmap com o inSampleSize configurado
			  options.inJustDecodeBounds = false;
			  return BitmapFactory.decodeResource(res, resId, options);
			}
	
}

