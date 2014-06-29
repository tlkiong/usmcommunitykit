package com.example.usmcommunitykit;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

@SuppressLint("SetJavaScriptEnabled")
public class AboutUsActivity extends ActionBarActivity {
	WebView webview ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_us);
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		//set about us as webview
		webview = (WebView) findViewById(R.id.webview);
		webview.setWebChromeClient(new WebChromeClient());
		WebSettings webSettings = webview.getSettings();
		webview.getSettings().setSupportZoom(true);
		webview.getSettings().setBuiltInZoomControls(false);
		//webview.loadData(readTextFromResource(R.raw.index), "text/html", "utf-8");
		webSettings.setJavaScriptEnabled(true);
		webview.addJavascriptInterface(new WebAppInterface(this), "Android");
		webview.loadUrl("file:///android_asset/index.html");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about_us, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


}
