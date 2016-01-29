package com.example.ql1;


import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {
	ScrollView scroll;
	LinearLayout linear;
	TextView text1;
	TextView text2;
	TextView text3;
	TextView text4;
	TextView text5;
	int i=0;
	private Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 1:
				if(i!=0){
					View view=linear.getChildAt(0);
					linear.removeViewAt(0);
					linear.addView(view);
					scroll.scrollTo(0, 0);
				}
				scroll.smoothScrollTo(0, text1.getHeight());
				i++;
				break;
			}
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		scroll=(ScrollView)findViewById(R.id.scroll);
		linear=(LinearLayout)findViewById(R.id.linear);
		text1=(TextView)findViewById(R.id.text1);
		text2=(TextView)findViewById(R.id.text2);
		text3=(TextView)findViewById(R.id.text3);
		text4=(TextView)findViewById(R.id.text4);
		text5=(TextView)findViewById(R.id.text5);
		
		
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				
				handler.sendEmptyMessage(1);
			}
		}, 2000, 2000);
		
		
		
	}


}
