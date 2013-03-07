package com.geniusgithub.lazyloaddemo.util;


public class FileManager {

	public static String getSaveFilePath() {
		if (CommonUtil.hasSDCard()) {
			return CommonUtil.getRootFilePath() + "com.geniusgithub/files/";
		} else {
			return CommonUtil.getRootFilePath() + "com.geniusgithub/files/";
		}
	}
}
