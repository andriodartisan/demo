package com.example.zenyan;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zenyan.util.Common;
import com.example.zenyan.util.WSHelper;

public class PublishContentActivity extends Activity implements OnClickListener {
	private ImageButton i8_title_back_button;
	private ImageView i8_title_right_img;
	private TextView i8_title_text_tv;
	private EditText title,content;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_publish_content);
		initDate();
	}
	
	private void initDate(){
		title = (EditText)findViewById(R.id.title);
		content = (EditText)findViewById(R.id.content);
		
		Intent lki = getIntent();
		String type = lki.getStringExtra("type");
		if(type !=null && "link".equals(type)){
			title.setHint(R.string.publish_link_title_hint);
		}
		
		i8_title_back_button = (ImageButton)findViewById(R.id.i8_title_back_button);
		i8_title_right_img = (ImageView)findViewById(R.id.i8_title_right_img);
		i8_title_text_tv = (TextView)findViewById(R.id.i8_title_text_tv);
		i8_title_back_button.setVisibility(View.VISIBLE);
		i8_title_right_img.setVisibility(View.VISIBLE);
		i8_title_text_tv.setText(getResources().getString(R.string.publish_images));
		i8_title_right_img.setImageResource(R.drawable.me_info_finish_btn);
		
		i8_title_back_button.setOnClickListener(this);
		i8_title_right_img.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.i8_title_back_button:
			finish();
			break;
		case R.id.i8_title_right_img:
			publishMsg();
			break;
		default:
			break;
		}
	}
	
	private void publishMsg(){
		String strTitle =  title.getText().toString();
		String strContent = content.getText().toString();
		if(Common.strIsEmpty(strTitle)){
			Toast.makeText(this, "title is not null!", Toast.LENGTH_LONG).show();
			title.setFocusableInTouchMode(true);
			return;
		}
		if(Common.strIsEmpty(strContent)){
			Toast.makeText(this, "content is not null!", Toast.LENGTH_LONG).show();
			content.setFocusableInTouchMode(true);
			return;
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("accesstoken", "123456");
		map.put("data", strTitle+"lll"+strContent);
		map.put("circleid", "");
		map.put("circlename", "");
		map.put("latitude", "33");
		map.put("longitude", "33");
		map.put("locname", "深圳");
		map.put("isphoto", "1");  
		map.put("devicetype", "android");
		map.put("userid","1");
		map.put("username","admin");
		boolean result = false;
		try {
			result = WSHelper.submitDataByDoGet(map, "post");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result){
			Toast.makeText(this, "pubish success!", Toast.LENGTH_LONG).show();
		}else{
			Toast.makeText(this, "pubish failed!", Toast.LENGTH_LONG).show();
		}
	}
}
