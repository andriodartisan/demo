package com.example.zenyan.adapter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.zenyan.R;

public class MultipleImageGVAdapter extends BaseAdapter{
	private final static String IMAGE_UNSPECIFIED ="image/*";
	private LayoutInflater inflater;
	private ArrayList<String> photoPath = null;
	
	public void addPhoto(String photoPath){
		this.photoPath.add(photoPath);
		notifyDataSetChanged();
	}
	
	public MultipleImageGVAdapter(Context context) {
		inflater = LayoutInflater.from(context);
		this.photoPath = new ArrayList<String>();
		photoPath.add(IMAGE_UNSPECIFIED);
	}
	
	@Override
	public int getCount() {
		return photoPath.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item_near_sendbc_list_grid, null);
			holder = new ViewHolder();
			holder.imageView = (ImageView) convertView.findViewById(R.id.item_sendbc_gv_img);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		if(position == (photoPath.size() - 1)){
			holder.imageView.setTag(IMAGE_UNSPECIFIED);
			holder.imageView.setImageResource(R.drawable.selector_setting_blacklist_add);
		}else{
			holder.imageView.setTag(photoPath.get( position + 1).toString());
			loadLocalBitmap(holder.imageView);
		}
		
		return convertView;
	}
	
	private void loadLocalBitmap(ImageView imageView){
        String path = (String) imageView.getTag();
        Bitmap bitmap = getLoacalBitmap(path); 
        if(bitmap != null){
        	imageView.setImageBitmap(bitmap);
        }
	}
	
    public static Bitmap getLoacalBitmap(String url) {
         try {
              FileInputStream fis = new FileInputStream(url);
              return BitmapFactory.decodeStream(fis);    
           } catch (FileNotFoundException e) {
              e.printStackTrace();
              return null;
         }
    }
    
	class ViewHolder {
		private ImageView imageView;
	}
}