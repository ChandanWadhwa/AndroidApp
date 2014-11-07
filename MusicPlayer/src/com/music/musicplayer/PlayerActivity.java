package com.music.musicplayer;



import java.util.concurrent.TimeUnit;

import com.example.globals.Global;
import com.music.mediafile.RetrieveFileNames;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.TimeUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class PlayerActivity extends Activity {

	ImageView imgButtonPlay,imgButtonNext,imgButtonPrevious,imgSetting;
	TextView txtSongName,txtDuration;
	
	MediaPlayer mediaPlayer=Global.mediaPlayer;
	SeekBar seekbar;
	int songPosition=0;
	int duration;
	Handler myHandler = new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_player);
	
	//initialization
	
	txtDuration=(TextView)findViewById(R.id.txtduration);
	txtSongName=(TextView)findViewById(R.id.txtsongname);
	seekbar=(SeekBar)findViewById(R.id.seekBar1);
	imgButtonPlay=(ImageView)findViewById(R.id.btnplay);
	imgButtonNext=(ImageView)findViewById(R.id.btnnext);
	imgButtonPrevious=(ImageView)findViewById(R.id.btnprevious);
	imgSetting=(ImageView)findViewById(R.id.imgsetting);
	imgSetting.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		Intent songListIntent=new Intent(getApplicationContext(),SongsListActivity.class);
		startActivity(songListIntent);
		}
	});
	
	//get values from bundle 
	if(getIntent().hasExtra("song"))
	{
	Bundle bundle= getIntent().getExtras();
	String songName=	bundle.getString("song");
	Log.d("Selected Song --------> ",songName);
		try {
		
		mediaPlayer.reset();
		mediaPlayer.setDataSource(songName);
		mediaPlayer.prepare();
		mediaPlayer.start();				
		mediaPlayer.setLooping(true);
		seekbar.setMax((int) mediaPlayer.getDuration());
		duration=mediaPlayer.getDuration();
		double minuts,seconds;
		minuts=TimeUnit.MILLISECONDS.toMinutes(duration);
		seconds=TimeUnit.MILLISECONDS.toSeconds(duration);
		txtDuration.setText(Double.toString(minuts)+" : "+Double.toString(seconds));		
	
		mediaPlayer.setLooping(true);
		Runnable UpdateSongTime = new Runnable() {
	      public void run() {
	         
	    	  seekbar.setProgress(mediaPlayer.getCurrentPosition());
	    	  Log.d("Seek ",mediaPlayer.getCurrentPosition()+"");
	         myHandler.postDelayed(this, 100);
	      }
	   };
	   myHandler.postDelayed(UpdateSongTime,100);
}  catch (Exception e) {
	// TODO Auto-generated catch block
	Log.d("Error ","File not found");
}

	}
	else
	{
		Log.d("Bundle ---------->","Empty");
	}
	
	RetrieveFileNames fileNames =new RetrieveFileNames();
	fileNames.fileName();
	//Play Button 
	imgButtonPlay.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
		
			String artist="none";
			String title="none";
		
			if(Global.specificType.size()>=0)
			{
				MediaMetadataRetriever metaRetriever = new MediaMetadataRetriever();
				metaRetriever.setDataSource(Global.specificType.get(songPosition));
				artist =  metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
				title = metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
				Global.currentPlaying= Global.specificType.get(songPosition).substring(Global.specificType.get(songPosition).lastIndexOf("/"));
				txtSongName.setText("Now Playing "+Global.currentPlaying);
			
				Toast.makeText(getApplicationContext(), "Artist"+ artist,1000).show();
//				Log.d("Artist Name",artist);
//				Log.d("Title",title);
			
			
				Log.d("Next File ",Global.specificType.get(songPosition) );
				try {
					mediaPlayer.reset();
					mediaPlayer.setDataSource(Global.specificType.get(0));
					mediaPlayer.prepare();
					mediaPlayer.start();				
					mediaPlayer.setLooping(true);
					seekbar.setMax((int) mediaPlayer.getDuration());
					duration=mediaPlayer.getDuration();
					double minuts,seconds;
					minuts=TimeUnit.MILLISECONDS.toMinutes(duration);
					seconds=TimeUnit.MILLISECONDS.toSeconds(duration);
					txtDuration.setText(Double.toString(minuts)+" : "+Double.toString(seconds));		
				
					mediaPlayer.setLooping(true);
					Runnable UpdateSongTime = new Runnable() {
				      public void run() {
				         
				    	  seekbar.setProgress(mediaPlayer.getCurrentPosition());
				    	  Log.d("Seek ",mediaPlayer.getCurrentPosition()+"");
				         myHandler.postDelayed(this, 100);
				      }
				   };
				   myHandler.postDelayed(UpdateSongTime,100);
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				Log.d("Error ","File not found");
			}
		}
			else
			{
				Toast.makeText(getApplicationContext(), "No song available to play", Toast.LENGTH_SHORT).show();
				
			}
		}
		
	});
	
	//Next Button 
	imgButtonNext.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
		
			String artist="none";
			String title="none";
			if(songPosition< (Global.specificType.size()-1))
			{
			songPosition++;
			
			
			MediaMetadataRetriever metaRetriever = new MediaMetadataRetriever();
			metaRetriever.setDataSource(Global.specificType.get(songPosition));
			artist =  metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
			title = metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
			Global.currentPlaying= Global.specificType.get(songPosition).substring(Global.specificType.get(songPosition).lastIndexOf("/"));
			txtSongName.setText("Now Playing "+Global.currentPlaying);
			
			Toast.makeText(getApplicationContext(), "Artist"+ artist,1000).show();
//			Log.d("Artist Name",artist);
//			Log.d("Title",title);
			
			
			Log.d("Next File ",Global.specificType.get(songPosition) );
			try {
				mediaPlayer.reset();
				mediaPlayer.setDataSource(Global.specificType.get(songPosition));
				mediaPlayer.prepare();
				mediaPlayer.start();
				mediaPlayer.setLooping(true);
				seekbar.setMax((int) mediaPlayer.getDuration());
				duration=mediaPlayer.getDuration();
				double minuts,seconds;
				minuts=TimeUnit.MILLISECONDS.toMinutes(duration);
				seconds=TimeUnit.MILLISECONDS.toSeconds(duration);
				txtDuration.setText(Double.toString(minuts)+" : "+Double.toString(seconds));			
				mediaPlayer.setLooping(true);
				Runnable UpdateSongTime = new Runnable() {
				      public void run() {
				         
				    	  seekbar.setProgress(mediaPlayer.getCurrentPosition());
				    	  Log.d("Seek ",mediaPlayer.getCurrentPosition()+"");
				         myHandler.postDelayed(this, 100);
				      }
				   };
				   myHandler.postDelayed(UpdateSongTime,100);
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				Log.d("Error ","File not found");
			}
		}
			else
			{
				Toast.makeText(getApplicationContext(), "No song available to play", Toast.LENGTH_SHORT).show();
			}
		}
	});
	
	//Previous Button 
	imgButtonPrevious.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
		
			String artist="none";
			String title="none";
			if(songPosition>0)
			{
			songPosition--;
						
			MediaMetadataRetriever metaRetriever = new MediaMetadataRetriever();
			metaRetriever.setDataSource(Global.specificType.get(songPosition));
			artist =  metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
			title = metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
			Global.currentPlaying= Global.specificType.get(songPosition).substring(Global.specificType.get(songPosition).lastIndexOf("/"));
			txtSongName.setText("Now Playing "+Global.currentPlaying);
			Toast.makeText(getApplicationContext(), "Artist"+ artist,1000).show();
//			Log.d("Artist Name",artist);
//			Log.d("Title",title);
			
			
			Log.d("Next File ",Global.specificType.get(songPosition) );
			try {
				mediaPlayer.reset();
				mediaPlayer.setDataSource(Global.specificType.get(songPosition));
				mediaPlayer.prepare();
				mediaPlayer.start();
				mediaPlayer.setLooping(true);
				seekbar.setMax((int) mediaPlayer.getDuration());
				duration=mediaPlayer.getDuration();
				double minuts,seconds;
				minuts=TimeUnit.MILLISECONDS.toMinutes(duration);
				seconds=TimeUnit.MILLISECONDS.toSeconds(duration);
				txtDuration.setText(Double.toString(minuts)+" : "+Double.toString(seconds));
				
				mediaPlayer.setLooping(true);
				Runnable UpdateSongTime = new Runnable() {
				      public void run() {
				         
				    	  seekbar.setProgress(mediaPlayer.getCurrentPosition());
				    	  Log.d("Seek ",mediaPlayer.getCurrentPosition()+"");
				         myHandler.postDelayed(this, 100);
				      }
				   };
				   myHandler.postDelayed(UpdateSongTime,100);
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				Log.d("Error ","File not found");
			}
			}
			else
			{
				Toast.makeText(getApplicationContext(), "No song available to play", Toast.LENGTH_SHORT).show();
			}
		}
	});
		
	
	
	seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
		
		@Override
		public void onStopTrackingTouch(SeekBar arg0) {
			// TODO Auto-generated method stub
			mediaPlayer.seekTo(seekbar.getProgress());
			
		}
		
		@Override
		public void onStartTrackingTouch(SeekBar arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
			// TODO Auto-generated method stub
			
			
		}
	});
	}

	
}
