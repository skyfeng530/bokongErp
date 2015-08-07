/**
 * 
 */
package com.erp.util;

/**
 * @author jason_000
 *
 */
public class StringUtil {

	public static String parseNullStrToEmpty(String value) {
		if (null == value) {
			return "";
		}
		return value.trim();
	}

	public static String parseEmptyToNull(String value) {
		if ("".equals(value)) {
			return null;
		}

		return value.trim();
	}

}
