package com.rui6._9.hotmail.workshopmongo.resources.util;

import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;

public class URL {
	
	public static String decodeParam(String text)
	{
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch(UnsupportedEncodingException e)
		{
			return "";
		}
	}

}
