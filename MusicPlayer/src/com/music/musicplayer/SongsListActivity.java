package com.music.musicplayer;


import com.example.globals.Global;
import com.music.mediafile.RetrieveFileNames;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SongsListActivity extends Activity {

	ListView  songsList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_songs_list);
		songsList=(ListView)findViewById(R.id.songslist);
		RetrieveFileNames fileNames =new RetrieveFileNames();
		fileNames.fileName();
	
		songsList.setAdapter(new ArrayAdapter(getApplicationContext(),R.layout.songitem, Global.listSongName));
		songsList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
				Intent PlayerActivity=new Intent(getApplicationContext(), PlayerActivity.class);
				PlayerActivity.putExtra("song", Global.specificType.get(pos));
				startActivity(PlayerActivity);
				finish();
				
			}
			
		});
		
	}

	
}
