package com.example.zenyan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity implements  OnClickListener {
	private ImageButton publish_image_button,publish_content_button,publish_link_button;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initDate();
	}
	
	private void initDate(){
		publish_image_button = (ImageButton)findViewById(R.id.publish_image_button);
		publish_content_button = (ImageButton)findViewById(R.id.publish_content_button);
		publish_link_button = (ImageButton)findViewById(R.id.publish_link_button);

		publish_image_button.setOnClickListener(this);
		publish_content_button.setOnClickListener(this);
		publish_link_button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.publish_image_button:
			Intent isi = new Intent().setClass(MainActivity.this,PublishImagesActivity.class);
			startActivity(isi);
			break;
		case R.id.publish_content_button:
			Intent cti = new Intent().setClass(MainActivity.this, PublishContentActivity.class);
			startActivity(cti);
			break;
		case R.id.publish_link_button:
			Intent lki = new Intent().setClass(MainActivity.this, PublishContentActivity.class);
			lki.putExtra("type", "link");
			startActivity(lki);
			break;
		default:
			break;
		}
	}
	
}
