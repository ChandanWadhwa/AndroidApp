package com.music.mediafile;

import java.io.File;
import java.util.ArrayList;
import com.example.globals.Global;
import android.os.Environment;
import android.util.Log;


public class RetrieveFileNames {
	private File root;
	private ArrayList<File> fileList = new ArrayList<File>();
	

	
	public void fileName(){
		Global.listSongName.clear();
		Global.specificType.clear();
		root = new File("/storage/sdcard0/");
		
		getfile(root);

	}
	
	
	public ArrayList<File> getfile(File dir) {
//		System.out.println("Directory Name "+dir);
		File listFile[] = dir.listFiles();
		if (listFile != null && listFile.length > 0) {
			for (int i = 0; i < listFile.length; i++) {
//				Log.d("File ",listFile[i]+"");
				if (listFile[i].isDirectory()) {
					fileList.add(listFile[i]);
					
					getfile(listFile[i]);

				} else {
					if (listFile[i].getName().endsWith(".mp3"))
//							|| listFile[i].getName().endsWith(".jpg")
//							|| listFile[i].getName().endsWith(".jpeg")
//							|| listFile[i].getName().endsWith(".gif"))

					{
						
						fileList.add(listFile[i]);
						Global.currentPlaying=listFile[i].getName().toString();
					
						Global.specificType.add(dir+"/"+listFile[i].getName().toString());
						Global.listSongName.add(listFile[i].getName().toString());
					}
				}

			}
		}
		return fileList;
	}
}
