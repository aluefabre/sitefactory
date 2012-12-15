package org.fabrelab.sitefactory.util;

public class LongUtils {
	public static boolean equalsAndNotNull(Long one, Long another){
		if(one ==null){
			return false;
		}
		if(another ==null){
			return false;
		}
		if(!one.equals(another)){
			return false;
		}
		return true;
	}
}
