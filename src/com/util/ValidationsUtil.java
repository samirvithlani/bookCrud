package com.util;

public class ValidationsUtil {

	public static boolean isEmpty(String param) {
		boolean isError = false;
		if (param == "" || param == null || param.trim().length() <= 0) {
			isError = true;
		}

		return isError;
	}
}
