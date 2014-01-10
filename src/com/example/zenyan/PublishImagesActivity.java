package com.example.zenyan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import com.example.zenyan.adapter.MultipleImageGVAdapter;
import com.example.zenyan.util.Common;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class PublishImagesActivity extends Activity {
	private ImageButton i8_title_back_button;
	private ImageView i8_title_right_img;
	private TextView i8_title_text_tv;
	
	GridView near_menu_bc_send_gv;
	private MultipleImageGVAdapter multipleImageGVAdapter = null; 
	private ArrayList<String> photoPath = null;
	private String filePath = null;
	
	private AlertDialog alert; // ��������
	
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			System.out.println(filePath);
			switch (msg.what) {
			case Common.getNewversionOK:
				multipleImageGVAdapter.addPhoto(filePath);
				photoPath.add(filePath);
				break;
			default:
				break;
			}
		}
	};
	

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
		near_menu_bc_send_gv = (GridView)findViewById(R.id.near_menu_bc_send_gv);
		
		i8_title_back_button.setVisibility(View.VISIBLE);
		i8_title_right_img.setVisibility(View.VISIBLE);
		i8_title_text_tv.setText(getResources().getString(R.string.publish_images));
		i8_title_right_img.setImageResource(R.drawable.me_info_finish_btn);
		
		photoPath = new ArrayList<String>();
		multipleImageGVAdapter = new MultipleImageGVAdapter(this);
		near_menu_bc_send_gv.setAdapter(multipleImageGVAdapter);
		
		near_menu_bc_send_gv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				if(arg2 == (photoPath.size())){
					
					final CharSequence[] items = { getString(R.string.setting_getbyxiangce),
							getString(R.string.setting_getbycamera),getString(R.string.cancel) };
					AlertDialog.Builder builder = new AlertDialog.Builder(PublishImagesActivity.this);
					builder.setTitle(getString(R.string.setting_title_upload));
					builder.setItems(items, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int item) {
							switch(item) {
								case 0:
									// �������ѡ��
									getByAlbum();
									break;
								case 1:
									// ����
									getByCamera();
									break;
								case 2:
									break;
							}
							alert.dismiss();
						}
					});
					alert = builder.create();
					alert.show();
				}else {
					
				}
			}
		});
		
		i8_title_back_button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
	}

	/**
	 *  �������ѡ��ͼƬ
	 */
	private void getByAlbum(){
		Intent intent = new Intent(Intent.ACTION_PICK, null);
		intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,Common.IMAGE_UNSPECIFIED);
		startActivityForResult(intent, Common.IMAGE_RESULT_CODE_XIANGCe);
	}
	
	/**
	 * ����
	 */
	private void getByCamera(){
		filePath = getImageFilePath();
		
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(filePath)));
		startActivityForResult(intent, Common.IMAGE_RESULT_CODE_CAMERA);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case Common.IMAGE_RESULT_CODE_XIANGCe:
			filePath = data.getData().toString();
			handler.post(compressedImgXiangCe);
			break;
		case Common.IMAGE_RESULT_CODE_CAMERA:
			if(filePath == null || "".equals(filePath)){
				return;
			}
			File file = new File(filePath);
			if(file.exists()){
				handler.post(compressedImgCamera);
			}else{
			}
			break;
		default:
			break;
		}
	}
	/**
	 * 压缩图片
	 */
	Runnable compressedImgCamera = new Runnable() {
		@Override
		public void run() {
			Bitmap bmp = getNativeImageForAppointSize(filePath);
			saveCompressBitmapToSD(filePath, bmp);
			
			Message msg = new Message();
			msg.what = Common.getNewversionOK;
			msg.obj = filePath;
			handler.sendMessage(msg);
			if(bmp != null){
				bmp.recycle();
			}
		}
	};
	/**
	 * ѹ��ͼƬ
	 */
	Runnable compressedImgXiangCe = new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			if(filePath == null || "".equals(filePath)){
				return;
			}
			ContentResolver resolver = getContentResolver();
			Uri originalUri = Uri.parse(filePath); //���ͼƬ��uri
			try {
				Bitmap bm = MediaStore.Images.Media.getBitmap(resolver, originalUri);
				filePath = getImageFilePath();
				saveCompressBitmapToSD(filePath, bm);
				Message msg = new Message();
				msg.what = Common.getNewversionOK;
				msg.obj = filePath;
				handler.sendMessage(msg);
				if(bm != null){
					bm.recycle();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	};
	
	/**
	 * 获取本地图片并指定高度和宽度（最大宽度：600；最大高度：1000）
	 * 
	 * @param imagePath
	 *            图片路径
	 * @return
	 */
	public static Bitmap getNativeImageForAppointSize(String imagePath) {

		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		// 获取这个图片的宽和高
		Bitmap myBitmap = BitmapFactory.decodeFile(imagePath, options); // 此时返回myBitmap为空

		// 计算缩放比
		int be = 1;
		int wScale = (int) (options.outWidth / (float) 600 + 0.5);
		int hScale = (int) (options.outWidth / (float) 1000 + 0.5);
		if (wScale > 1 || hScale > 1) {
			if (wScale > hScale) {
				be = wScale;
			} else {
				be = hScale;
			}
		}
		options.inSampleSize = be;

		// 重新读入图片，注意这次要把options.inJustDecodeBounds 设为 false
		options.inJustDecodeBounds = false;
		myBitmap = BitmapFactory.decodeFile(imagePath, options);
		return myBitmap;
	}
	
	public static void saveCompressBitmapToSD(String filePathName,
			Bitmap compressBitmap) {

		File sendPicturefile = new File(filePathName);

		try {
			FileOutputStream fos = new FileOutputStream(sendPicturefile);
			compressBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ͼƬ����·��
	 * @return
	 */
	private String getImageFilePath(){
		String filepath = Environment.getExternalStorageDirectory().getAbsolutePath()
				+ File.separator + "zeyan"
				+ File.separator + "zeyanImages" + File.separator ;
		System.out.println(filepath);
		File file =  new File(filepath);
		if (!file.exists()) {  
            file.mkdirs();  
        }  
		return filepath  + UUID.randomUUID().toString() +  ".jpeg";
	}
}
