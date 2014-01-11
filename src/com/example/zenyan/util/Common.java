package com.example.zenyan.util;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Log;

public class Common {
	
	public static final String PREFS_NAME = "OceanxPreference";//Preference
	public static final int IsTimeShow = 1;//Preference
	/**
	 *  ��һ������
	 */
	public static final String COMMON_USER_FIRST_START = "COMMON_USER_FRIST_START"; 

	/**
	 * app�ƹ�ҳ
	 */
	public static final String I8Chat_APP_Promotion_Page = "http://app.i8i8i8.com/index.html";
	
	/**
	 * app�ƹ�ҳ
	 */
	public static final String I8Chat_APP_Promotion_Message = "һ��ʹ�ð��ɣ�" + "  " + Common.I8Chat_APP_Promotion_Page;
	
	/**
	 * app�ƹ�ҳ
	 */
	public static final String I8Chat_APP_Promotion_Email = "�Ҹոհ�װ��һ���µ��罻Ӧ�� ���� ������漫�ˣ�\n�����û�а�װ�����������Կ��� ����������Ӧ�õ����ӣ�\n\n" + Common.I8Chat_APP_Promotion_Page + "\n\n��װ�����Ӧ������ͨѶ¼�п����ң����û�����ң��������û����ң��һ���㣺��     " + "\n\n" + "�����ҵ�android";
	
//	public static final String OpenFireAddressIP = "59.188.0.23";//192.168.0.43
	//���Է�����
	public static final String OpenFireAddress = "xmpp.i8i8i8.com";//192.168.0.43
	public static final String SERVER_API_URL = "http://club.i8i8i8.com/api";//�������ӿڵ�ַhttp://xmpp.i8i8i8.com
	public static final String PUSH_API_URL = "http://push.i8i8i8.com/push";//���ͽӿڵ�ַ
	public static final String SERVER_API_AUTH_CODE = "i8chatauth0000000001";
	
	public static final String XmppDomain="xmpp.xxx.com";//xmpp��ַ
	
	public static final String ChatAccountKey = "ChatAccountKey";//�Լ��ʺ�(��ֹ)
	public static final String ChatAccountPassWord = "ChatAccountPassWord";//�Լ����루��ֹ��
	
	public static final String RememberTheUserName = "RememberTheUserName";//Preference
	
	
	/**
	 * ������Ƭ��ֵ ��
	 */
	public static final String Photos = "PHOTOS";
	/**
	 * ������Ƭ��ֵ ��
	 */
	public static final String WaterFall = "WaterFall";
	/**
	 * �Ƿ����ٲ���
	 */
	public static final boolean isWaterFall = true;

	/**
	 * ��������չʾ��ֵ ��
	 */
	public static final String Contacts = "CONTACTS";
	
	/**
	 * ֪ͨ����ʾͼ��
	 */
	public static final String setting_privacy_box_notifiaction = "setting_privacy_box_notifiaction";
	
	/**
	 *  Ψһ�豸id
	 */
	public static final String COMMON_USER_IMEI = "commonUserImei";
	/**
	 *  �û�id
	 */
	public static final String COMMON_USER_ID = "commonUserId"; 
	/**
	 *  �û���
	 */
	public static final String COMMON_USER_NAME = "commonUserName"; 
	/**
	 *  �û��ֻ��
	 */
	public static final String COMMON_USER_PHONE = "commonUserPhone";
	/**
	 *  �û�����
	 */
	public static final String COMMON_USER_PASSWORD = "commonUserPassword";
	/**
	 *  �û�Show
	 */
	public static final String COMMON_USER_SHOW = "commonUserShow"; 
	/**
	 *  �û�ͷ���ַ
	 */
	public static final String COMMON_USER_PORTRAIT = "commonUserPortrait";
	/**
	 *  �û��Ա�0���У�1��Ů��
	 */
	public static final String COMMON_USER_SEX = "commonUserSex"; 
	/**
	 *  �û�����
	 */
	public static final String COMMON_USER_BACKGROUND = "commonUserBackground";
	/**
	 *  �û����챳��
	 */
	public static final String COMMON_USER_CHATBACKGROUND = "commonUserChatBackground";
	/**
	 *  �û�����
	 */
	public static final String COMMON_USER_LONGITUDE = "commonUserLongitude";
	/**
	 *  �û�γ��
	 */
	public static final String COMMON_USER_LATITUDE = "commonUserLatitude"; 
	/**
	 *  �û�����λ�� ����
	 */
	public static final String COMMON_USER_LOCATION = "commonUserLocation";
	/**
	 *  �û�����λ�� ��ϸ��ַ
	 */
	public static final String COMMON_USER_ADDRESS = "commonUserAddress";
	/**
	 *  �û�����λ�� �ֵ�
	 */
	public static final String COMMON_USER_STREET = "commonUserStreet";
	/**
	 *  �������ӿ���ֵ֤
	 */
	public static final String COMMON_API_AUTH_TOKEN = "commonApiAuthToken"; 
	public static final String ChatFriendUserListKey = "ChatFriendUserListKey";//��������б�
	
	public static String NEWHOME_ACTION = "oceanx.chat.newhome";//�㳡-�¶�̬
	public static String NEWINVITE_ACTION = "oceanx.chat.newinvite";//���붯̬
	public static String NEWMESSAGE_ACTION = "oceanx.chat.newmessage";//��ǰ�����˵�����Ϣ
	/**
	 * ���Ͳ����ɹ��㲥
	 */
	public static String NEW_NEAR_BROADCAST_SEND_ACTION = "NEW_NEAR_BROADCAST_SEND_ACTION";
	
	/**
	 * ��ǰ����������
	 */
	public static String NEWONLINE_ACTION = "oceanx.chat.newonline";
	/**
	 * ��ǰ����������
	 */
	public static String NEWOFFLINE_ACTION = "oceanx.chat.newoffline";
	
	public static String i8LOGINORREGISTERSUCCESS = "i8LOGINORREGISTERSUCCESS";//��¼����ע��ɹ�
	
	/**
	 * �����������¶���
	 */
	public static String OPENFIRE_CONNECTION_ONERROR = "OPENFIRE_CONNECTION_ONERROR";
	/**
	 * �������ߵ�������¶���
	 */
	public static String OPENFIRE_CONNECTION_ONERROR_STREAM_ERROR = "OPENFIRE_CONNECTION_ONERROR_STREAM_ERROR";
	/**
	 * ���粻��
	 */
	public static String NETWORK_CONNECTION_ONERROR = "NETWORK_CONNECTION_ONERROR";
	/**
	 * �Ѿ���¼OpenFire��
	 */
	public static String OPENFIRE_CONNECTION_EXPECTION = "Already logged in to server";
	/**
	 * ��¼OpenFire����Ӧ
	 */

	public static String OPENFIRE_CONNECTION_NO_RESPONSE = "No response from the server";

	/**
	 * û�����ӵ�¼OpenFire����Ӧ
	 */
	public static String OPENFIRE_CONNECTION_NOT_CONNECTION = "Not connected to server";

	
	/**
	 * openfire���߿�ʼ����
	 */
	public static String OPENFIRE_CONNECTION_START = "OPENFIRE_CONNECTION_START";
	/**
	 * openfire���������ɹ�
	 */
	public static String OPENFIRE_CONNECTION_YES = "OPENFIRE_CONNECTION_YES";
	/**
	 * openfire��������ʧ��
	 */
	public static String OPENFIRE_CONNECTION_ERROR = "OPENFIRE_CONNECTION_ERROR";
	
	
	public static String com_i8i8i8_i8chat_language = "com.i8i8i8.i8chat.language";
	public static String com_i8i8i8_i8chat_font = "com.i8i8i8.i8chat.font";

	public static String com_i8i8i8_i8chat_setting_clear_sql = "com_i8i8i8_i8chat_setting_clear_sql";
	
	/**
	 * Ӧ���ѹ���
	 */
	public static String com_i8i8i8_i8chat_frame_app_overdue = "com_i8i8i8_i8chat_frame_app_overdue";
	
	public static final String getSmsCode = SERVER_API_URL + "/sendsms";//��ȡ��֤��
	public static final String newUserRegister = SERVER_API_URL + "/register";//ע��
	public static final String userLogin = SERVER_API_URL + "/login";//�û���¼
	public static final String resetPassword = SERVER_API_URL + "/resetpassword"; // ��������
	public static final String externalLogin = SERVER_API_URL + "/externallogin"; // �����½
	public static final String updateUserLocation = SERVER_API_URL + "/user/location"; // �ϴ��û���γ��
	public static final String updateUserInfo = SERVER_API_URL + "/user/update"; // �޸��û���Ϣ
	public static final String updateUserPortrait = SERVER_API_URL + "/user/avatar/upload"; // �޸��û�ͷ��
	public static final String updateUserBackground = SERVER_API_URL + "/user/background/upload"; // �޸��û���ҳ����
	
	public static final String getFriendListByName = SERVER_API_URL + "/user/search";//ģ���ѯ�û��б�
	public static final String getFriendInfoItem = SERVER_API_URL + "/user/get";//��ȡ�����û���Ϣ
	public static final String getFriendOfTuijian = SERVER_API_URL + "/user/recommand";//��ȡ�Ƽ������б�
	public static final String getFriendOfNear = SERVER_API_URL + "/user/near";//��ȡ�����û��б�
	public static final String uplodeVideoUrl = SERVER_API_URL + "/voice/upload";//�ϴ�¼��
	public static final String getPersonPublicInfo = SERVER_API_URL + "/message/my"; // ��ȡָ���û���������Ϣ
	public static final String getNearPublicInfo = SERVER_API_URL + "/message/near"; // ��ȡ��Χ�û���������Ϣ
	public static final String putLikeNearPublicInfo = SERVER_API_URL + "/message/like/post"; // ����Ϣ
	public static final String nearSendBroadcast = SERVER_API_URL + "/message/post"; // ������Ϣ
	public static final String nearSendBroadcastUploadPhoto = SERVER_API_URL + "/message/photo/upload"; // �ϴ���Ƭ
	public static final String nearSendBroadcastUploadPhotoTest = SERVER_API_URL + "/message/photo/uptest"; // �ϴ���Ƭ
	/**
	 *  ��ȡͼ����Ƭ
	 */
	public static final String getNearPhoto = SERVER_API_URL + "/message/photo/near"; 
	
	public static final String putUserFeedback = SERVER_API_URL + "/user/feedback"; // �����
	
	public static final String getNewversion = SERVER_API_URL + "/version";//�°汾Newversion
	
	public static final String barCodeScanning = SERVER_API_URL + "/book/get";//������ɨ��
	
	public static final int getNewversionOK = 30000;//�°汾Newversion��
	public static final int getNewversionN = 30001;//�°汾Newversionû��
	public static final int getNewversionF = 30002;//�°汾Newversionʧ��
	public static final int getNewversionS = 30003;//�°汾Newversionʧ��
	public static final int getNewversionM = 30004;//���
	
	
	public static final int MessageShowCountNum = 30;//ÿҳ��ʾ��Ϣ����
	public static final int HandlerMessageShowCountNum = 4000000;//�̸߳��·�ҳ��Ϣ
	
	/**
	 * ����ͼƬ
	 */
	public static final String IMAGE_UNSPECIFIED = "image/*";
	/**
	 * �ϴ�����ͼƬ
	 */
	public static final int IMAGE_UNSPECIFIEDNUM = 3;
	/**
	 * ������ͼƬ������
	 */
	public static final int IMAGE_RESULT_CODE_XIANGCe = 10000;
	/**
	 * ������ͼƬ������
	 */
	public static final int IMAGE_RESULT_CODE_CAMERA = 10001;
	/**
	 * �ü�ͼƬ������
	 */
	public static final int IMAGE_RESULT_CODE_PHOTOZOOM = 10005;
	/**
	 * �ü���С-x-ͷ��
	 */
	public static final int IMAGE_RESULT_CODE_PHOTOZOOM_X = 200;
	/**
	 * �ü���С-y-ͷ��
	 */
	public static final int IMAGE_RESULT_CODE_PHOTOZOOM_Y = 200;
	/**
	 * �ü���С-x-bg
	 */
	public static final int IMAGE_RESULT_CODE_BGZOOM_X = 400;
	/**
	 * �ü���С-y-bg
	 */
	public static final int IMAGE_RESULT_CODE_BGZOOM_Y = 400;
	/**
	 * �ü���С-x-chatbg
	 */
	public static final int IMAGE_RESULT_CODE_CHATBGZOOM_X = 600;
	/**
	 * �ü���С-y-chatbg
	 */
	public static final int IMAGE_RESULT_CODE_CHATBGZOOM_Y = 600;

	/**
	 * �ü���С-����-1��1
	 */
	public static final int IMAGE_RESULT_CODE_ZOOM_CHATBG_1_Y = 1;
	/**
	 * �ü���С-����-1��1
	 */
	public static final int IMAGE_RESULT_CODE_ZOOM_Proportion_1_Y = 2;
	/**
	 * �ü���С-����-1��2
	 */
	public static final int IMAGE_RESULT_CODE_ZOOM_Proportion_2_Y = 3;
	
	/**
	 * handler ���
	 */
	public static final int IMAGE_RESULT_XIANGJI = 40004;
	/**
	 * handler ���
	 */
	public static final int IMAGE_RESULT_XIANGCE = 40005;
	/**
	 * handler �ü�
	 */
	public static final int IMAGE_RESULT_ZOOM = 40006;
	
	/**-------------------------------------------����΢��----------------------------------------------------------*/
	// Ӧ�õ�key �뵽�ٷ�������ʽ��appkey�滻APP_KEY
	public static final String SINA_APP_KEY      = "3439076292"; //"3439076292"
    // �滻Ϊ������REDIRECT_URL
    public static final String SINA_REDIRECT_URL = "http://www.sina.com";
    
    // QQӦ�õ�appkey
    public static final String QQ_APP_KEY      = "100461329";
    /**-------------------------------------------����΢��----------------------------------------------------------*/
	
	public static final int i8HttpRequestSuccess = 2000;//����������ɹ�
	public static final int i8HttpRequestError = 2001;//���������ʧ��
	public static final int i8HttpRequestErrorStatus = 2002;//���������ʧ��()
	public static final int i8HttpRequestFrequently = 1011; // ����Ƶ��
	public static final int i8HttpRequestPhoneStacts = 1007; // �ֻ���Ѵ���
	public static final int i8HttpRequestCodeError = 1008; // ��֤���������
	public static final int i8HttpRequestNoData = 1009; // �������
	public static final String httpRequestError = "request error !";//���������ʧ��
	
//	public static final int i8HttpResponseErrorStatus_1 = 20010
	
	/**
	 * ����С����---�Ӻ����ʺ�
	 */
	public static final String i8Chat_Root_Helper_Friend_Status_ID = "00000000001";
	/**
	 * ����С����---�Ӻ����ʺ�
	 */
	public static final String i8Chat_Root_Helper_Friend_Status_Name = "����С����";
	/**
	 * ����С����---����-����
	 */
	public static final String i8Chat_Root_Helper_News = "00000000002";
	
	/**
	 * ��ͨ����
	 */
	public static final int i8chat_message_type_text = 0;
	/**
	 * ��ͨ����
	 */
	public static final int i8chat_message_type_video = 1001;
	/**
	 * ���ѹ�ϵ
	 */
	public static final int i8chat_message_type_friend_status = 1006;
	
	
	public static final int i8GetFriendListHandler = 101;//��ȡ�����б�
	public static final int i8GetFriendListNullHandler = 102;//��ȡ�����б� ��
	public static final int i8GetFriendListErrorHandler = 103;//��ȡ�����б� ��
	public static final int i8GetFriendListCompareHandler = 104;//�ȽϺ����б�
	public static final int i8GetFriendListCompareNoHandler = 105;//�ȽϺ����б� û�и���
	public static final int i8GetFriendListCompareFHandler = 106;//�ȽϺ����б� ʧ��
	
	public static final int i8FriendItemTypeHandler = 10000;//���ѹ�ϵ
	/**
	 * �����Ϊ����
	 */
	public static final int i8RequestFriendItemTypeHandler = 10001;
	/**
	 * ͬ���Ϊ����
	 */
	public static final int i8AgreeFriendItemTypeHandler = 10002;
	/**
	 * ���������
	 */
	public static final int i8IgnoreFriendItemTypeHandler = 10003;
	/**
	 * ͬ������Ѻ���
	 */
	public static final int i8UnbindFriendItemTypeHandler = 10004;
	
	/**
	 * ֪ͨ�����б�ҳ���º�������
	 */
	public static final String i8BroadcastOfHomeHasNewFriend = "i8BroadcastOfHomeHasNewFriend";
	
	
	public static final int i8MessageTypeOfText = 0;//�ı���Ϣ
	public static final int i8MessageTypeOfVideo = 1001;//������Ϣ
	
	public static final int i8FriendItemChatMessage = 1000000;//����������Ϣ��¼
	public static final int i8HomeCleanFriendItemChatMessage = 1000001;//����������Ϣ��¼
	public static final int i8FriendItemChatSendMessage = 1000002;//����������Ϣ
	public static final int i8HomeChatMessage = 1000003;//����������Ϣ��¼
	public static final int i8FriendItemChatMessageError = 1000004;//����������Ϣ��¼�쳣
	public static final String i8FriendItemChatMessageAction = "i8FriendItemChatMessageAction";//����������Ϣ��¼
	
	public static final int i8GetFriendOfTuijian = 2000000;//��ȡ�Ƽ������б���Ϣ
	public static final int i8GetFriendListByName = 2000001;//��ȡ�Ƽ������б���Ϣ
	public static final int i8GetFriendInfoByID = 2000002;//��ȡ�û���ϸ��Ϣ
	public static final int i8GetUserPublicInfoByID = 2000003;//��ȡ�û�������Ϣ
	public static final int i8GetNearPublicInfo = 2000004;//��ȡ��Χ�û�������Ϣ
	public static final int i8CheckFriend = 2000005;//����Ƿ����Լ��ĺ���
	public static final int i8GetFriendOfNear = 2000008;//��ȡ�Ƽ������б���Ϣ
	
	
	public static final int CardQrCodeResultCode = 3000000;//��ά�뷵�ؽ��
	
	
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
	
	/**-------------------------------------------�ٲ���----------------------------------------------------------*/
	// ����Ŀ¼
	public static final String IMAGE_FOLDER_PATH = Environment.getExternalStorageDirectory()
														+ File.separator + "I8ChatFolder"
														+ File.separator + "I8Chat Images";
	// ���ձ���Ŀ¼
	public static final String CAMERA_FOLDER_PATH = Environment.getExternalStorageDirectory()
			+ File.separator + "I8ChatFolder"
			+ File.separator + "I8ChatCamera";
	
	public static final String newServerImageURL = "http://api.i8i8i8.com/mobile/piclist";
	
	/**-------------------------------------------�ٲ���----------------------------------------------------------*/
	
	/**
	 * ����������ӿ�
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
			Common.debugE("����ʧ��" + e.getMessage());
			return "";
		}
		return response;
	}*/
	/**
	 * ����������ӿ�
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
			Common.debugE("���������ʧ��" + e.getMessage() + "   " + e.toString() + "   " + e.getCause());
			e.printStackTrace();
			return "";
		}
		return response;
	}
	*//**
	 * �ϴ���ݺ�ͼƬ��������, ���շ���json��Ϣ
	 * @param urlString �ӿڵ�ַ
	 * @param params �������
	 * @param filepath �ļ����ص�ַ
	 * @param fileParamName �ļ���ʶ��
	 * @return
	 *//*
	public static String httpPostDataAndFile(String urlString,Map<String,String> params,
		String filepath, String fileParamName) {

		String result = "";

		StringBuilder builder = new StringBuilder();
		String line = null;
		try {
			// ��װ�������
			MultipartEntity mpEntity = new MultipartEntity();
			if (params != null && !params.isEmpty()) {
				for (Map.Entry<String, String> entry : params.entrySet()) {
					StringBody par = new StringBody(entry.getValue());
					mpEntity.addPart(entry.getKey(), par);
				}
			}
			// ͼƬ
			if (StringUtils.isNotEmpty(filepath)) {
				FileBody file = new FileBody(new File(filepath));
				mpEntity.addPart(fileParamName, file);
			}
			// ʹ��HttpPost�������÷��͵�URL·��
			HttpPost post = new HttpPost(urlString);
			// ����������
			post.setEntity(mpEntity);
			// ����һ������������԰�POST��������������ͣ���������Ӧ��Ϣ
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
			Log.e("HDD","�ϴ�����ʧ��" + e.getMessage());
			return "";
		}
		return result;
	}*/
	
	/**
	 * �ϴ��ļ���Server�ķ���
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
			/* ����Input��Output����ʹ��Cache */
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setUseCaches(false);
			/* ���ô��͵�method=POST */
			con.setRequestMethod("POST");
			/* setRequestProperty */
			con.setRequestProperty("Connection", "Keep-Alive");
			con.setRequestProperty("Charset", "UTF-8");
			con.setRequestProperty("Content-Type",
					"multipart/form-data;boundary=" + boundary);
			/* ����DataOutputStream */
			DataOutputStream ds = new DataOutputStream(con.getOutputStream());
			ds.writeBytes(twoHyphens + boundary + end);
			ds.writeBytes("Content-Disposition: form-data; "
					+ "name=\"file1\";filename=\"" 
					+ newName 
					+ "\"" 
					+ end);
			ds.writeBytes(end);

			/* ȡ���ļ���FileInputStream */
			FileInputStream fStream = new FileInputStream(uploadFilePath);
			/* ����ÿ��д��1024bytes */
			int bufferSize = 1024;
			byte[] buffer = new byte[bufferSize];

			int length = -1;
			/* ���ļ���ȡ����������� */
			while ((length = fStream.read(buffer)) != -1) {
				/* ������д��DataOutputStream�� */
				ds.write(buffer, 0, length);
			}
			ds.writeBytes(end);
			ds.writeBytes(twoHyphens + boundary + twoHyphens + end);

			/* close streams */
			fStream.close();
			ds.flush();

			/* ȡ��Response���� */
			InputStream is = con.getInputStream();
			int ch;
			StringBuffer b = new StringBuffer();
			while ((ch = is.read()) != -1) {
				b.append((char) ch);
			}
			/* �ر�DataOutputStream */
			ds.close();
			
			// �ж�ͼƬ�Ƿ��ϴ��ɹ�
			String strRst = b.toString();
			uploadPicId = strRst;
		} catch (Exception e) {
			e.printStackTrace();
			Log.e("HDD","����ʧ��" + e.getMessage());
			return "";
		}
		return uploadPicId;
	}
	
	/**
	 * 
	 * ��ȡ�����ļ�
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
	 * ��ȡ�����ļ�
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
	 * ɾ�������ļ�
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
	 * ɾ�������ļ�
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
	 * ��������ļ�
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
	 * ��������ļ�
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
	
	public static boolean strIsEmpty(String str){
		return str == null || "".equals(str);
	}
}
