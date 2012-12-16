package org.fabrelab.pagekit;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;


public class MappingUtil {
	private static final Logger log = Logger.getLogger(MappingUtil.class.getName());
	
	public static String parseString(HttpServletRequest request, String para) {
		String value = request.getParameter(para);
		value = StringUtils.trim(value);
		return value;
	}
	
	public static Long parseLong(HttpServletRequest request, String para) {
		String value = request.getParameter(para);
		if(value!=null){
			try {
				Long result = Long.parseLong(value);
				return result;
			} catch (NumberFormatException e) {
				log.log(Level.SEVERE, " parse " + para + " with " + value + " failed " + e.getMessage());
			}
		}
		return null;
	}
	
	public static Integer parseInt(HttpServletRequest request, String para) {
		String value = request.getParameter(para);
		if(value!=null){
			try {
				Integer result = Integer.parseInt(value);
				return result;
			} catch (NumberFormatException e) {
				log.log(Level.SEVERE, " parse " + para + " with " + value + " failed " + e.getMessage());
			}
		}
		return null;
	}
	
	public static Boolean parseBoolean(HttpServletRequest request, String para) {
		String value = request.getParameter(para);
		if(value!=null){
			try {
				Boolean result = Boolean.parseBoolean(value);
				return result;
			} catch (NumberFormatException e) {
				log.log(Level.SEVERE, " parse " + para + " with " + value + " failed " + e.getMessage());
			}
		}
		return null;
	}
}
