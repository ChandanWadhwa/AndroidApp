package com.example.facebookshareintent;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

public class IntentShareActivity extends Activity {

	EditText shareTxt;
	WebView wv;
	String url = "https://www.facebook.com/plugins/like.php?href=https://www.facebook.com/iSupportNamo/like";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent_share);
		shareTxt=(EditText)findViewById(R.id.txtshare);
		wv=(WebView)findViewById(R.id.web);
		
	}
	
	public void share(View v)
	{
		Intent shareIntent=new Intent();
		shareIntent.setAction(Intent.ACTION_SEND);
		shareIntent.setType("text/plain");
		shareIntent.putExtra(Intent.EXTRA_TEXT, shareTxt.getText());
		startActivity(Intent.createChooser(shareIntent, "Share your thoughts"));
	}
	
	public void like(View v)
	{
		
		wv.loadUrl(url);
		wv.setWebViewClient(new LikeWebviewClient());
	}
	public class LikeWebviewClient  extends WebViewClient {
	    public boolean shouldOverrideUrlLoading(WebView view, String url) {
	        view.loadUrl(url);
	        return true;
	    }
	}
	
}
