package com.example.zenyan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class PublishImagesActivity extends Activity {
	private ImageButton i8_title_back_button;
	private ImageView i8_title_right_img;
	private TextView i8_title_text_tv;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_publish_images);
		initDate();
	}
	
	private void initDate(){
		i8_title_back_button = (ImageButton)findViewById(R.id.i8_title_back_button);
		i8_title_right_img = (ImageView)findViewById(R.id.i8_title_right_img);
		i8_title_text_tv = (TextView)findViewById(R.id.i8_title_text_tv);
		i8_title_back_button.setVisibility(View.VISIBLE);
		i8_title_right_img.setVisibility(View.VISIBLE);
		i8_title_text_tv.setText(getResources().getString(R.string.publish_images));
		i8_title_right_img.setImageResource(R.drawable.me_info_finish_btn);
	}
	
	/*public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}*/

}
