package com.example.zenyan;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Log;

/**
 * 名称：Common 
 * 作者：吴光平 
 * 时间：2013-07-17 
 * 描述：应用公用操作类
 * 版本号：V1.0.0
 * ========================历史版本================================= 
 * 序号      版本号           日期                                姓名         描述
 * 1   V1.0.0 2013-07-17  吴光平     建立
 * 
 * ========================历史版本=================================
 * 说明：请在有更改程序的时候修改以上注释
 */
public class Common {
	
	public static final String PREFS_NAME = "OceanxPreference";//Preference
	public static final int IsTimeShow = 1;//Preference
	/**
	 *  第一次启动
	 */
	public static final String COMMON_USER_FIRST_START = "COMMON_USER_FRIST_START"; 

	/**
	 * app推广页
	 */
	public static final String I8Chat_APP_Promotion_Page = "http://app.i8i8i8.com/index.html";
	
	/**
	 * app推广页
	 */
	public static final String I8Chat_APP_Promotion_Message = "一起使用爱吧！" + "  " + Common.I8Chat_APP_Promotion_Page;
	
	/**
	 * app推广页
	 */
	public static final String I8Chat_APP_Promotion_Email = "我刚刚安装了一款新的社交应用 爱吧 ，它好玩极了！\n如果你没有安装，下载它试试看。 这里是下载应用的链接：\n\n" + Common.I8Chat_APP_Promotion_Page + "\n\n安装完后，你应该能在通讯录中看到我，如果没看到我，请吧你的用户名发我，我会加你：）     " + "\n\n" + "发自我的android";
	
//	public static final String OpenFireAddressIP = "59.188.0.23";//192.168.0.43
	//测试服务器
	public static final String OpenFireAddress = "xmpp.i8i8i8.com";//192.168.0.43
	public static final String SERVER_API_URL = "http://club.i8i8i8.com/api";//服务器接口地址http://xmpp.i8i8i8.com
	public static final String PUSH_API_URL = "http://push.i8i8i8.com/push";//推送接口地址
	public static final String SERVER_API_AUTH_CODE = "i8chatauth0000000001";
	
	public static final String XmppDomain="xmpp.xxx.com";//xmpp地址
	
	public static final String ChatAccountKey = "ChatAccountKey";//自己帐号(废止)
	public static final String ChatAccountPassWord = "ChatAccountPassWord";//自己密码（废止）
	
	public static final String RememberTheUserName = "RememberTheUserName";//Preference
	
	
	/**
	 * 播报照片传值 键
	 */
	public static final String Photos = "PHOTOS";
	/**
	 * 播报照片传值 键
	 */
	public static final String WaterFall = "WaterFall";
	/**
	 * 是否是瀑布流
	 */
	public static final boolean isWaterFall = true;

	/**
	 * 个人资料展示传值 键
	 */
	public static final String Contacts = "CONTACTS";
	
	/**
	 * 通知栏显示图标
	 */
	public static final String setting_privacy_box_notifiaction = "setting_privacy_box_notifiaction";
	
	/**
	 *  唯一设备id
	 */
	public static final String COMMON_USER_IMEI = "commonUserImei";
	/**
	 *  用户id
	 */
	public static final String COMMON_USER_ID = "commonUserId"; 
	/**
	 *  用户名
	 */
	public static final String COMMON_USER_NAME = "commonUserName"; 
	/**
	 *  用户手机号
	 */
	public static final String COMMON_USER_PHONE = "commonUserPhone";
	/**
	 *  用户密码
	 */
	public static final String COMMON_USER_PASSWORD = "commonUserPassword";
	/**
	 *  用户Show
	 */
	public static final String COMMON_USER_SHOW = "commonUserShow"; 
	/**
	 *  用户头像地址
	 */
	public static final String COMMON_USER_PORTRAIT = "commonUserPortrait";
	/**
	 *  用户性别（0：男；1：女）
	 */
	public static final String COMMON_USER_SEX = "commonUserSex"; 
	/**
	 *  用户背景
	 */
	public static final String COMMON_USER_BACKGROUND = "commonUserBackground";
	/**
	 *  用户聊天背景
	 */
	public static final String COMMON_USER_CHATBACKGROUND = "commonUserChatBackground";
	/**
	 *  用户经度
	 */
	public static final String COMMON_USER_LONGITUDE = "commonUserLongitude";
	/**
	 *  用户纬度
	 */
	public static final String COMMON_USER_LATITUDE = "commonUserLatitude"; 
	/**
	 *  用户地理位置 城市
	 */
	public static final String COMMON_USER_LOCATION = "commonUserLocation";
	/**
	 *  用户地理位置 详细地址
	 */
	public static final String COMMON_USER_ADDRESS = "commonUserAddress";
	/**
	 *  用户地理位置 街道
	 */
	public static final String COMMON_USER_STREET = "commonUserStreet";
	/**
	 *  服务器接口验证值
	 */
	public static final String COMMON_API_AUTH_TOKEN = "commonApiAuthToken"; 
	public static final String ChatFriendUserListKey = "ChatFriendUserListKey";//好友数据列表
	
	public static String NEWHOME_ACTION = "oceanx.chat.newhome";//广场-新动态
	public static String NEWINVITE_ACTION = "oceanx.chat.newinvite";//邀请动态
	public static String NEWMESSAGE_ACTION = "oceanx.chat.newmessage";//当前聊天人的新消息
	/**
	 * 发送播报成功广播
	 */
	public static String NEW_NEAR_BROADCAST_SEND_ACTION = "NEW_NEAR_BROADCAST_SEND_ACTION";
	
	/**
	 * 当前聊天人在线
	 */
	public static String NEWONLINE_ACTION = "oceanx.chat.newonline";
	/**
	 * 当前聊天人离线
	 */
	public static String NEWOFFLINE_ACTION = "oceanx.chat.newoffline";
	
	public static String i8LOGINORREGISTERSUCCESS = "i8LOGINORREGISTERSUCCESS";//登录或者注册成功
	
	/**
	 * 不正常的情况导致断线
	 */
	public static String OPENFIRE_CONNECTION_ONERROR = "OPENFIRE_CONNECTION_ONERROR";
	/**
	 * 被挤掉线的情况导致断线
	 */
	public static String OPENFIRE_CONNECTION_ONERROR_STREAM_ERROR = "OPENFIRE_CONNECTION_ONERROR_STREAM_ERROR";
	/**
	 * 网络不正常
	 */
	public static String NETWORK_CONNECTION_ONERROR = "NETWORK_CONNECTION_ONERROR";
	/**
	 * 已经登录OpenFire了
	 */
	public static String OPENFIRE_CONNECTION_EXPECTION = "Already logged in to server";
	/**
	 * 登录OpenFire无响应
	 */

	public static String OPENFIRE_CONNECTION_NO_RESPONSE = "No response from the server";

	/**
	 * 没有连接登录OpenFire无响应
	 */
	public static String OPENFIRE_CONNECTION_NOT_CONNECTION = "Not connected to server";

	
	/**
	 * openfire断线开始重连
	 */
	public static String OPENFIRE_CONNECTION_START = "OPENFIRE_CONNECTION_START";
	/**
	 * openfire断线重连成功
	 */
	public static String OPENFIRE_CONNECTION_YES = "OPENFIRE_CONNECTION_YES";
	/**
	 * openfire断线重连失败
	 */
	public static String OPENFIRE_CONNECTION_ERROR = "OPENFIRE_CONNECTION_ERROR";
	
	
	public static String com_i8i8i8_i8chat_language = "com.i8i8i8.i8chat.language";
	public static String com_i8i8i8_i8chat_font = "com.i8i8i8.i8chat.font";

	public static String com_i8i8i8_i8chat_setting_clear_sql = "com_i8i8i8_i8chat_setting_clear_sql";
	
	/**
	 * 应用已过期
	 */
	public static String com_i8i8i8_i8chat_frame_app_overdue = "com_i8i8i8_i8chat_frame_app_overdue";
	
	public static final String getSmsCode = SERVER_API_URL + "/sendsms";//获取验证码
	public static final String newUserRegister = SERVER_API_URL + "/register";//注册
	public static final String userLogin = SERVER_API_URL + "/login";//用户登录
	public static final String resetPassword = SERVER_API_URL + "/resetpassword"; // 重置密码
	public static final String externalLogin = SERVER_API_URL + "/externallogin"; // 第三方登陆
	public static final String updateUserLocation = SERVER_API_URL + "/user/location"; // 上传用户经纬度
	public static final String updateUserInfo = SERVER_API_URL + "/user/update"; // 修改用户信息
	public static final String updateUserPortrait = SERVER_API_URL + "/user/avatar/upload"; // 修改用户头像
	public static final String updateUserBackground = SERVER_API_URL + "/user/background/upload"; // 修改用户主页背景
	
	public static final String getFriendListByName = SERVER_API_URL + "/user/search";//模糊查询用户列表
	public static final String getFriendInfoItem = SERVER_API_URL + "/user/get";//获取单个用户信息
	public static final String getFriendOfTuijian = SERVER_API_URL + "/user/recommand";//获取推荐好友列表
	public static final String getFriendOfNear = SERVER_API_URL + "/user/near";//获取附近用户列表
	public static final String uplodeVideoUrl = SERVER_API_URL + "/voice/upload";//上传录音
	public static final String getPersonPublicInfo = SERVER_API_URL + "/message/my"; // 获取指定用户发布的消息
	public static final String getNearPublicInfo = SERVER_API_URL + "/message/near"; // 获取周围用户发布的消息
	public static final String putLikeNearPublicInfo = SERVER_API_URL + "/message/like/post"; // 赞消息
	public static final String nearSendBroadcast = SERVER_API_URL + "/message/post"; // 发送消息
	public static final String nearSendBroadcastUploadPhoto = SERVER_API_URL + "/message/photo/upload"; // 上传照片
	public static final String nearSendBroadcastUploadPhotoTest = SERVER_API_URL + "/message/photo/uptest"; // 上传照片
	/**
	 *  获取图钉照片
	 */
	public static final String getNearPhoto = SERVER_API_URL + "/message/photo/near"; 
	
	public static final String putUserFeedback = SERVER_API_URL + "/user/feedback"; // 意见反馈
	
	public static final String getNewversion = SERVER_API_URL + "/version";//新版本Newversion
	
	public static final String barCodeScanning = SERVER_API_URL + "/book/get";//条形码扫描
	
	public static final int getNewversionOK = 30000;//新版本Newversion有
	public static final int getNewversionN = 30001;//新版本Newversion没有
	public static final int getNewversionF = 30002;//新版本Newversion失败
	public static final int getNewversionS = 30003;//新版本Newversion失败
	public static final int getNewversionM = 30004;//更多
	
	
	public static final int MessageShowCountNum = 30;//每页显示消息个数
	public static final int HandlerMessageShowCountNum = 4000000;//线程更新分页消息
	
	/**
	 * 过滤图片
	 */
	public static final String IMAGE_UNSPECIFIED = "image/*";
	/**
	 * 上传几张图片
	 */
	public static final int IMAGE_UNSPECIFIEDNUM = 3;
	/**
	 * 相册过滤图片返回码
	 */
	public static final int IMAGE_RESULT_CODE_XIANGCe = 10000;
	/**
	 * 相机过滤图片返回码
	 */
	public static final int IMAGE_RESULT_CODE_CAMERA = 10001;
	/**
	 * 裁剪图片返回码
	 */
	public static final int IMAGE_RESULT_CODE_PHOTOZOOM = 10005;
	/**
	 * 裁剪大小-x-头像
	 */
	public static final int IMAGE_RESULT_CODE_PHOTOZOOM_X = 200;
	/**
	 * 裁剪大小-y-头像
	 */
	public static final int IMAGE_RESULT_CODE_PHOTOZOOM_Y = 200;
	/**
	 * 裁剪大小-x-bg
	 */
	public static final int IMAGE_RESULT_CODE_BGZOOM_X = 400;
	/**
	 * 裁剪大小-y-bg
	 */
	public static final int IMAGE_RESULT_CODE_BGZOOM_Y = 400;
	/**
	 * 裁剪大小-x-chatbg
	 */
	public static final int IMAGE_RESULT_CODE_CHATBGZOOM_X = 600;
	/**
	 * 裁剪大小-y-chatbg
	 */
	public static final int IMAGE_RESULT_CODE_CHATBGZOOM_Y = 600;

	/**
	 * 裁剪大小-比例-1：1
	 */
	public static final int IMAGE_RESULT_CODE_ZOOM_CHATBG_1_Y = 1;
	/**
	 * 裁剪大小-比例-1：1
	 */
	public static final int IMAGE_RESULT_CODE_ZOOM_Proportion_1_Y = 2;
	/**
	 * 裁剪大小-比例-1：2
	 */
	public static final int IMAGE_RESULT_CODE_ZOOM_Proportion_2_Y = 3;
	
	/**
	 * handler 相机
	 */
	public static final int IMAGE_RESULT_XIANGJI = 40004;
	/**
	 * handler 相册
	 */
	public static final int IMAGE_RESULT_XIANGCE = 40005;
	/**
	 * handler 裁剪
	 */
	public static final int IMAGE_RESULT_ZOOM = 40006;
	
	/**-------------------------------------------新浪微博----------------------------------------------------------*/
	// 应用的key 请到官方申请正式的appkey替换APP_KEY
	public static final String SINA_APP_KEY      = "3439076292"; //"3439076292"
    // 替换为开发者REDIRECT_URL
    public static final String SINA_REDIRECT_URL = "http://www.sina.com";
    
    // QQ应用的appkey
    public static final String QQ_APP_KEY      = "100461329";
    /**-------------------------------------------新浪微博----------------------------------------------------------*/
	
	public static final int i8HttpRequestSuccess = 2000;//请求服务器成功
	public static final int i8HttpRequestError = 2001;//请求服务器失败
	public static final int i8HttpRequestErrorStatus = 2002;//请求服务器失败()
	public static final int i8HttpRequestFrequently = 1011; // 请求频繁
	public static final int i8HttpRequestPhoneStacts = 1007; // 手机号已存在
	public static final int i8HttpRequestCodeError = 1008; // 验证码错误或过期
	public static final int i8HttpRequestNoData = 1009; // 查无数据
	public static final String httpRequestError = "request error !";//请求服务器失败
	
//	public static final int i8HttpResponseErrorStatus_1 = 20010
	
	/**
	 * 爱吧小助手---加好友帐号
	 */
	public static final String i8Chat_Root_Helper_Friend_Status_ID = "00000000001";
	/**
	 * 爱吧小助手---加好友帐号
	 */
	public static final String i8Chat_Root_Helper_Friend_Status_Name = "爱吧小助手";
	/**
	 * 爱吧小助手---新闻-其他
	 */
	public static final String i8Chat_Root_Helper_News = "00000000002";
	
	/**
	 * 普通文字
	 */
	public static final int i8chat_message_type_text = 0;
	/**
	 * 普通文字
	 */
	public static final int i8chat_message_type_video = 1001;
	/**
	 * 好友关系
	 */
	public static final int i8chat_message_type_friend_status = 1006;
	
	
	public static final int i8GetFriendListHandler = 101;//获取好友列表
	public static final int i8GetFriendListNullHandler = 102;//获取好友列表 空
	public static final int i8GetFriendListErrorHandler = 103;//获取好友列表 空
	public static final int i8GetFriendListCompareHandler = 104;//比较好友列表
	public static final int i8GetFriendListCompareNoHandler = 105;//比较好友列表 没有更新
	public static final int i8GetFriendListCompareFHandler = 106;//比较好友列表 失败
	
	public static final int i8FriendItemTypeHandler = 10000;//好友关系
	/**
	 * 请求加为好友
	 */
	public static final int i8RequestFriendItemTypeHandler = 10001;
	/**
	 * 同意加为好友
	 */
	public static final int i8AgreeFriendItemTypeHandler = 10002;
	/**
	 * 请求解除好友
	 */
	public static final int i8IgnoreFriendItemTypeHandler = 10003;
	/**
	 * 同意解除好友好友
	 */
	public static final int i8UnbindFriendItemTypeHandler = 10004;
	
	/**
	 * 通知好友列表页有新好友申请
	 */
	public static final String i8BroadcastOfHomeHasNewFriend = "i8BroadcastOfHomeHasNewFriend";
	
	
	public static final int i8MessageTypeOfText = 0;//文本消息
	public static final int i8MessageTypeOfVideo = 1001;//语音消息
	
	public static final int i8FriendItemChatMessage = 1000000;//加载聊天消息记录
	public static final int i8HomeCleanFriendItemChatMessage = 1000001;//清除单个聊天消息记录
	public static final int i8FriendItemChatSendMessage = 1000002;//发送聊天消息
	public static final int i8HomeChatMessage = 1000003;//加载聊天消息记录
	public static final int i8FriendItemChatMessageError = 1000004;//加载聊天消息记录异常
	public static final String i8FriendItemChatMessageAction = "i8FriendItemChatMessageAction";//加载聊天消息记录
	
	public static final int i8GetFriendOfTuijian = 2000000;//获取推荐好友列表信息
	public static final int i8GetFriendListByName = 2000001;//获取推荐好友列表信息
	public static final int i8GetFriendInfoByID = 2000002;//获取用户详细信息
	public static final int i8GetUserPublicInfoByID = 2000003;//获取用户发布信息
	public static final int i8GetNearPublicInfo = 2000004;//获取周围用户发布信息
	public static final int i8CheckFriend = 2000005;//检查是否是自己的好友
	public static final int i8GetFriendOfNear = 2000008;//获取推荐好友列表信息
	
	
	public static final int CardQrCodeResultCode = 3000000;//二维码返回结果
	
	
	public static final int NearCameraLocalImgList = 10000010;
	public static final int NearCameraLocalImgListNotifi = 10000011;
	
	public static final int NearSendBcO = 30000001;
	public static final int NearSendBcN = 30000002;
	public static final int NearSendBcF = 30000003;
	public static final int NearSendBcS = 30000004;
	
	public static final int NearSendBcSendO = 30000006;
	public static final int NearSendBcSendN = 30000007;
	public static final int NearSendBcSendF = 30000008;
	public static final int NearSendBcSendS = 30000009;
	

	public static final int handlerMsgWhatNearGetPhotoO = 40000001;
	public static final int handlerMsgWhatNearGetPhotoN = 40000002;
	public static final int handlerMsgWhatNearGetPhotoF = 40000003;
	public static final int handlerMsgWhatNearGetPhotoS = 40000004;
	public static final int handlerMsgWhatNearGetPhotoM = 40000005;
	
	/**-------------------------------------------瀑布流----------------------------------------------------------*/
	// 缓存目录
	public static final String IMAGE_FOLDER_PATH = Environment.getExternalStorageDirectory()
														+ File.separator + "I8ChatFolder"
														+ File.separator + "I8Chat Images";
	// 拍照保存目录
	public static final String CAMERA_FOLDER_PATH = Environment.getExternalStorageDirectory()
			+ File.separator + "I8ChatFolder"
			+ File.separator + "I8ChatCamera";
	
	public static final String newServerImageURL = "http://api.i8i8i8.com/mobile/piclist";
	
	/**-------------------------------------------瀑布流----------------------------------------------------------*/
	
	/**
	 * 请求服务器接口
	 * @param url
	 * @param nameValuePairs
	 * @return response
	 */
	/*public static String httpRequestForServer(String url,List<NameValuePair> nameValuePairs){
		String response = null;
		QHttpClient http = new QHttpClient();
		try {
			response = http.httpPost(url, nameValuePairs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Common.debugE("请求失败" + e.getMessage());
			return "";
		}
		return response;
	}*/
	/**
	 * 请求服务器接口
	 * @param url
	 * @param nameValuePairs
	 * @return response
	 */
	/*public static String httpRequestForServerByGet(String url,HashMap<String , String> map){
		String response = null;
		QHttpClient http = new QHttpClient();
		try {
			response = http.httpGet(url, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Common.debugE("请求服务器失败" + e.getMessage() + "   " + e.toString() + "   " + e.getCause());
			e.printStackTrace();
			return "";
		}
		return response;
	}
	*//**
	 * 上传数据和图片到服务器, 接收返回json信息
	 * @param urlString 接口地址
	 * @param params 请求参数
	 * @param filepath 文件本地地址
	 * @param fileParamName 文件标识符
	 * @return
	 *//*
	public static String httpPostDataAndFile(String urlString,Map<String,String> params,
		String filepath, String fileParamName) {

		String result = "";

		StringBuilder builder = new StringBuilder();
		String line = null;
		try {
			// 封装请求参数
			MultipartEntity mpEntity = new MultipartEntity();
			if (params != null && !params.isEmpty()) {
				for (Map.Entry<String, String> entry : params.entrySet()) {
					StringBody par = new StringBody(entry.getValue());
					mpEntity.addPart(entry.getKey(), par);
				}
			}
			// 图片
			if (StringUtils.isNotEmpty(filepath)) {
				FileBody file = new FileBody(new File(filepath));
				mpEntity.addPart(fileParamName, file);
			}
			// 使用HttpPost对象设置发送的URL路径
			HttpPost post = new HttpPost(urlString);
			// 发送请求体
			post.setEntity(mpEntity);
			// 创建一个浏览器对象，以把POST对象向服务器发送，并返回响应消息
			DefaultHttpClient dhc = new DefaultHttpClient();
			HttpResponse response = dhc.execute(post);

			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream inputStream = entity.getContent();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(inputStream));

				while ((line = reader.readLine()) != null) {
					builder.append(line);
				}
				result = builder.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.e("HDD","上传请求失败" + e.getMessage());
			return "";
		}
		return result;
	}*/
	
	/**
	 * 上传文件至Server的方法
	 * @param uploadFilePath
	 * @return
	 */
	public static String uploadFileAudioMethod(String uploadFilePath) {
		String uploadPicId = "";
		int uploadFileLength = uploadFilePath.split("/").length;
		String newName = uploadFilePath.split("/")[uploadFileLength - 1];
		String actionUrl = uplodeVideoUrl;

		String end = "\r\n";
		String twoHyphens = "--";
		String boundary = "*****";
		try {
			URL url = new URL(actionUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			/* 允许Input、Output，不使用Cache */
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setUseCaches(false);
			/* 设置传送的method=POST */
			con.setRequestMethod("POST");
			/* setRequestProperty */
			con.setRequestProperty("Connection", "Keep-Alive");
			con.setRequestProperty("Charset", "UTF-8");
			con.setRequestProperty("Content-Type",
					"multipart/form-data;boundary=" + boundary);
			/* 设置DataOutputStream */
			DataOutputStream ds = new DataOutputStream(con.getOutputStream());
			ds.writeBytes(twoHyphens + boundary + end);
			ds.writeBytes("Content-Disposition: form-data; "
					+ "name=\"file1\";filename=\"" 
					+ newName 
					+ "\"" 
					+ end);
			ds.writeBytes(end);

			/* 取得文件的FileInputStream */
			FileInputStream fStream = new FileInputStream(uploadFilePath);
			/* 设置每次写入1024bytes */
			int bufferSize = 1024;
			byte[] buffer = new byte[bufferSize];

			int length = -1;
			/* 从文件读取数据至缓冲区 */
			while ((length = fStream.read(buffer)) != -1) {
				/* 将资料写入DataOutputStream中 */
				ds.write(buffer, 0, length);
			}
			ds.writeBytes(end);
			ds.writeBytes(twoHyphens + boundary + twoHyphens + end);

			/* close streams */
			fStream.close();
			ds.flush();

			/* 取得Response内容 */
			InputStream is = con.getInputStream();
			int ch;
			StringBuffer b = new StringBuffer();
			while ((ch = is.read()) != -1) {
				b.append((char) ch);
			}
			/* 关闭DataOutputStream */
			ds.close();
			
			// 判断图片是否上传成功
			String strRst = b.toString();
			uploadPicId = strRst;
		} catch (Exception e) {
			e.printStackTrace();
			Log.e("HDD","请求失败" + e.getMessage());
			return "";
		}
		return uploadPicId;
	}
	
	/**
	 * 
	 * 获取配置文件
	 * @param ctx
	 * @param param
	 * @return
	 */
	public static String get(Context ctx, String param) {
		
		String id = getID(ctx, COMMON_USER_ID, false);
		
		SharedPreferences settings = ctx.getSharedPreferences(PREFS_NAME, 0);
		String result = settings.getString(id + param, "");
		return result;
	}
	/**
	 * 
	 * 获取配置文件
	 * @param ctx
	 * @param param
	 * @return
	 */
	public static String getID(Context ctx, String param,boolean isNow) {
		SharedPreferences settings = ctx.getSharedPreferences(PREFS_NAME, 0);
		String result = settings.getString(param, "");
		return result;
	}
	/**
	 * 删除配置文件
	 * @param ctx
	 * @param param
	 */
	public static void removePreference(Context ctx, String param) {
		String id = getID(ctx, COMMON_USER_ID, false);
		SharedPreferences settings = ctx.getSharedPreferences(PREFS_NAME,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.remove(id + param);
		editor.commit();
	}
	/**
	 * 删除配置文件
	 * @param ctx
	 * @param param
	 */
	public static void removePreferenceNoId(Context ctx, String param) {
		SharedPreferences settings = ctx.getSharedPreferences(PREFS_NAME,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.remove(param);
		editor.commit();
	}

	/**
	 * 添加配置文件
	 * @param ctx
	 * @param param
	 * @param value
	 */
	public static void setParam(Context ctx, String param, String value) {
		String id = getID(ctx, COMMON_USER_ID, false);
		SharedPreferences settings = ctx.getSharedPreferences(PREFS_NAME,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(id + param, value);
		editor.commit();
	}
	/**
	 * 添加配置文件
	 * @param ctx
	 * @param param
	 * @param value
	 */
	public static void setUserParam(Context ctx, String param, String value) {
		
		SharedPreferences settings = ctx.getSharedPreferences(PREFS_NAME,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(param, value);
		editor.commit();
	}
	
	public static void debug(String strValue) {
		boolean b_debug = true;
		if(b_debug){
			Log.i("HDD"," " + strValue);
		}
	}
	public static void debugE(String strValue) {
		boolean b_debug = true;
		if(b_debug){
			Log.e("HDD"," " + strValue);
		}
	}
		
	public static void debug(String TAG, boolean blnDebug, String strFlag,
			String strValue) {
		boolean b_debug = false;
		if (strFlag.equals("e")) {
			Log.e(TAG + " error Log", strValue);
			return;
		}
		if (b_debug && blnDebug) {
			if (strFlag.equals("i")) {
				Log.i(TAG + " coming==>", strValue);
			} else {
				Log.d(TAG + " debug", strValue);
			}
		}
	}
}
