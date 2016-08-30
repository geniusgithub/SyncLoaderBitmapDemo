package com.geniusgithub.lazyloaddemo.cache;

import android.content.Context;

import com.geniusgithub.lazyloaddemo.util.FileManager;

public class FileCache extends AbstractFileCache{

	public FileCache(Context context) {
		super(context);
	
	}


	@Override
	public String getSavePath(String url) {
		String filename = String.valueOf(url.hashCode());
		return getCacheDir() + filename;
	}

	@Override
	public String getCacheDir() {
		
		return FileManager.getCacheFileSavePath();
	}

}
