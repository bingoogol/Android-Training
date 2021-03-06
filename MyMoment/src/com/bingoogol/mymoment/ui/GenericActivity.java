package com.bingoogol.mymoment.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;

import com.bingoogol.mymoment.App;

public abstract class GenericActivity extends Activity implements OnClickListener {
	protected String tag;
	protected App app;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		app = (App) getApplicationContext();
		app.addActivity(this);
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		tag = getClass().getSimpleName();
		initView();
	}

	private void initView() {
		loadViewLayout();
		findViewById();
		setListener();
		processLogic();
	}

	protected abstract void loadViewLayout();

	protected abstract void findViewById();

	protected abstract void setListener();

	protected abstract void processLogic();
	
	@Override
	protected void onDestroy() {
		app.removeActivity(this);
		super.onDestroy();
	}
}
