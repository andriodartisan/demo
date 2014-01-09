package com.example.zenyan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	private Button publish_content_button,publish_link_button,publish_images_button;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initDate();
	}
	
	private void initDate(){
		publish_content_button = (Button)findViewById(R.id.publish_content_button);
		publish_link_button = (Button)findViewById(R.id.publish_link_button);
		publish_images_button = (Button)findViewById(R.id.publish_images_button);
		
		publish_content_button.setOnClickListener(this);
		publish_link_button.setOnClickListener(this);
		publish_images_button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.publish_content_button:
			Log.i("content...", "this is publish_content_button");
			Intent cti = new Intent().setClass(MainActivity.this, PublishContentActivity.class);
			startActivity(cti);
			break;
		case R.id.publish_link_button:
			Log.i("link...", "this is publish_link_button");
			Intent lki = new Intent().setClass(MainActivity.this, PublishContentActivity.class);
			lki.putExtra("type", "link");
			startActivity(lki);
			break;
		case R.id.publish_images_button:
			Log.i("images...", "this is publish_images_button");
			Intent isi = new Intent().setClass(MainActivity.this,PublishImagesActivity.class);
			startActivity(isi);
			break;
		default:
			break;
		}
	}
	
}
