package com.example.kepler.function;

import android.os.Handler.Callback;
import android.os.Message;

import com.example.kepler.tools.WIFIreceiver;

public class Update_function {

	static public void updatedata(String data){
		new WIFIreceiver(new Callback() {
			
			@Override
			public boolean handleMessage(Message arg0) {
				// TODO Auto-generated method stub
				//ͨ��httptoolȥ���ʷ�������ʧ�ܾͷ����ȴ���һ��wifi�㲥��
				return false;
			}
		});
	}
}
