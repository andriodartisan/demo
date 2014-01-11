package com.example.zenyan.util;

import java.io.File;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;


public class WSHelper {
	final static String WSUrl="http://192.168.0.90/api";
	private static String namespace = "http://192.168.0.90/oceanx2-0/api/message/";
	/**
	 * 使用get请求以普通方式提交数据
	 * @param map 传递进来的数据，以map的形式进行了封装
	 * @param path 要求服务器servlet的地址
	 * @return 返回的boolean类型的参数
	 * @throws Exception
	 */
	public static Boolean submitDataByDoGet(Map<String, String> map, String path) throws Exception {
		// 拼凑出请求地址
		StringBuilder sb = new StringBuilder(namespace + path);
		sb.append("?");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			sb.append(entry.getKey()).append("=").append(entry.getValue());
			sb.append("&");
		}
		sb.deleteCharAt(sb.length() - 1);
		String str = sb.toString();
		System.out.println(str);
		URL Url = new URL(str);
		HttpURLConnection HttpConn = (HttpURLConnection) Url.openConnection();
		HttpConn.setRequestMethod("GET");
		HttpConn.setReadTimeout(5000);
		// GET方式的请求不用设置什么DoOutPut()之类的吗？
		if (HttpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
			return true;
		}
		return false;
	}

	/**
	 * 普通方式的DoPost请求提交数据
	 * @param map 传递进来的数据，以map的形式进行了封装
	 * @param path 要求服务器servlet的地址
	 * @return 返回的boolean类型的参数
	 * @throws Exception
	 */
	public static Boolean submitDataByDoPost(Map<String, String> map, String path) throws Exception {
		// 注意Post地址中是不带参数的，所以newURL的时候要注意不能加上后面的参数
		URL Url = new URL(namespace + path);
		// Post方式提交的时候参数和URL是分开提交的，参数形式是这样子的：name=y&age=6
		StringBuilder sb = new StringBuilder();
		// sb.append("?");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			sb.append(entry.getKey()).append("=").append(entry.getValue());
			sb.append("&");
		}
		sb.deleteCharAt(sb.length() - 1);
		String str = sb.toString();

		HttpURLConnection HttpConn = (HttpURLConnection) Url.openConnection();
		HttpConn.setRequestMethod("POST");
		HttpConn.setReadTimeout(5000);
		HttpConn.setDoOutput(true);
		HttpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		HttpConn.setRequestProperty("Content-Length", String.valueOf(str.getBytes().length));
		OutputStream os = HttpConn.getOutputStream();
		os.write(str.getBytes());
		if (HttpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
			return true;
		}
		return false;
	}

	/**
	 * 以HttpClient的DoGet方式向服务器发送请数据
	 * @param map 传递进来的数据，以map的形式进行了封装
	 * @param path 要求服务器servlet的地址
	 * @return 返回的boolean类型的参数
	 * @throws Exception
	 */
	public static JSONObject submitDataByHttpClientDoGet(Map<String, String> map, String path) throws Exception {
		HttpClient hc = new DefaultHttpClient();
		// 请求路径
		StringBuilder sb = new StringBuilder(namespace + path);
		sb.append("?");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			sb.append(entry.getKey()).append("=").append(URLEncoder.encode(URLEncoder.encode(entry.getValue(),"UTF-8"),"UTF-8"));
			sb.append("&");
		}
		sb.deleteCharAt(sb.length() - 1);
		String str = sb.toString();
		System.out.println(str);
		HttpGet request = new HttpGet(str);
		HttpResponse response = hc.execute(request);
		String responseData = null;
		if (response.getStatusLine().getStatusCode() == HttpURLConnection.HTTP_OK) {
			HttpEntity responseEntity = response.getEntity();
			System.out.println("responseEntity === " + responseEntity);
	        if (responseEntity != null) {
	        	responseData = EntityUtils.toString(responseEntity);
	        	System.out.println("responseData === " + responseData);
	        } 
	        JSONObject jsonObject = new JSONObject(responseData);
			return jsonObject;
		}
		return null;
	}
	
	/**
	 * 以HttpClient的DoPost方式提交数据到服务器
	 * @param map 传递进来的数据，以map的形式进行了封装
	 * @param path 要求服务器servlet的地址
	 * @return 返回的boolean类型的参数
	 * @throws Exception
	 */
	public static Boolean submintDataByHttpClientDoPost(Map<String, String> map, String path) throws Exception {
		// 1. 获得一个相当于浏览器对象HttpClient，使用这个接口的实现类来创建对象，DefaultHttpClient
		HttpClient hc = new DefaultHttpClient();
		// DoPost方式请求的时候设置请求，关键是路径
		HttpPost request = new HttpPost(namespace + path);
		System.out.println(namespace + path);
		// 2. 为请求设置请求参数，也即是将要上传到web服务器上的参数
		//List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		MultipartEntity  multipartEntity = new MultipartEntity();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if(entry.getKey().equals("picture")){
				FileBody file = new FileBody(new File(entry.getValue()));
				multipartEntity.addPart(entry.getKey(), file);
			}else{
				multipartEntity.addPart(entry.getKey(), new StringBody(entry.getValue()));
			}
		}
		// 请求实体HttpEntity也是一个接口，我们用它的实现类UrlEncodedFormEntity来创建对象，注意后面一个String类型的参数是用来指定编码的
		//HttpEntity entity = new UrlEncodedFormEntity(parameters, "UTF-8");
		request.setEntity(multipartEntity);
		// 3. 执行请求
		HttpResponse response = hc.execute(request);
		String responseData = null;
		// 4. 通过返回码来判断请求成功与否
		if (response.getStatusLine().getStatusCode() == HttpURLConnection.HTTP_OK) {
			HttpEntity responseEntity = response.getEntity();
			System.out.println("responseEntity === " + responseEntity);
	        if (responseEntity != null) {
	        	responseData = EntityUtils.toString(responseEntity);
	        	System.out.println("responseData === " + responseData);
	        } 
			return true;
		}
		return false;
	}

}