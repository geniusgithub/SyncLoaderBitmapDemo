package com.geniusgithub.lazyloaddemo.util;


public class FileManager {

	public static String getCacheFileSavePath() {
		if (CommonUtil.hasSDCard()) {
			return CommonUtil.getRootFilePath() + "lazyloaddemo/cache/";
		} else {
			return CommonUtil.getRootFilePath() + "lazyloaddemo/cache/";
		}
	}

}
