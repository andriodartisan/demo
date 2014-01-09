package com.example.zenyan;

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
			holder.setting_blacklist_item_image = (ImageView) convertView.findViewById(R.id.item_sendbc_gv_img);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		if(position == (photoPath.size() - 1)){
			holder.setting_blacklist_item_image.setTag(IMAGE_UNSPECIFIED);
			holder.setting_blacklist_item_image.setImageResource(R.drawable.selector_setting_blacklist_add);
		}else{
			holder.setting_blacklist_item_image.setTag(photoPath.get( position + 1).toString());
			loadLocalBitmap(holder.setting_blacklist_item_image);
		}
		
		return convertView;
	}
	
	private void loadLocalBitmap(ImageView imageView){
		 // ͼƬ���Ӧ��url,���ֵ�ڼ���ͼƬ����кܿ��ܻᱻ�ı�  
        String path = (String) imageView.getTag();
        Bitmap bitmap = getLoacalBitmap(path); //�ӱ���ȡͼƬ(��cdcard�л�ȡ)
        if(bitmap != null){
        	imageView.setImageBitmap(bitmap); //����Bitmap
        }
	}
	
	/**
    * ���ر���ͼƬ
    * @param url
    * @return
    */
    public static Bitmap getLoacalBitmap(String url) {
         try {
              FileInputStream fis = new FileInputStream(url);
              return BitmapFactory.decodeStream(fis);  ///����ת��ΪBitmapͼƬ        
           } catch (FileNotFoundException e) {
              e.printStackTrace();
              return null;
         }
    }
    
	/**
	 * ���ú���gridView���ݸ�����
	 */
	class ViewHolder {
		private ImageView setting_blacklist_item_image;
	}
}