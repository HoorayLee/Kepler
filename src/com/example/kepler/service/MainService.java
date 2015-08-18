package com.example.kepler.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.example.kepler.LBS.gaode;
import com.example.kepler.object.LBSInfo;
import com.example.kepler.object.POI_Info;
import com.example.kepler.tools.LBS_table_SQL;
import com.example.kepler.tools.POI_table_SQL;
import com.example.kepler.tools.WIFIreceiver;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;

public class MainService extends Service{
	gaode gaode_server;
	WIFIcallback wificallback;
	String userid;
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		super.onStartCommand(intent, flags, startId);
		// TODO Auto-generated method stub
		Bundle bundle = intent.getBundleExtra("username");
		if(bundle!=null){
			this.userid = bundle.getString("username");
			mycallback callback = new mycallback();
			init(this.getApplicationContext(),callback);
			return 1;
		}
		else{
			return -1;
		}
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	private void init(Context context,mycallback callback){
		LBS_table_SQL.init(userid, context);
		POI_table_SQL.init(userid, context);
		//baidu_server = new baidu(context,callback);
		//baidu_server.start();
		gaode_server = new gaode(context,callback);
		//tencent_server = new tencent(context,callback);
	}
}
