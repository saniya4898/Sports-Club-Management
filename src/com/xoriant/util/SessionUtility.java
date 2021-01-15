package com.xoriant.util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionUtility {
	private static HttpSession httpSession;
	static public  HttpSession openSession() {
		if(SessionUtility.httpSession==null) {
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			SessionUtility.httpSession= attr.getRequest().getSession(true);
		}
		return SessionUtility.httpSession;
	}
	public static void invalidateSession() {
		SessionUtility.httpSession.invalidate();
		SessionUtility.httpSession=null;
	}
	
	public static boolean isAdminLoggedIn() {
		boolean result;
		if(SessionUtility.httpSession==null)
			result=false;
		else if(SessionUtility.httpSession.getAttribute("admin")!=null)
			result=true;
		else
			result=false;
		return result;
	}
	public static  boolean isClerkLoggedIn() {
		boolean result;
		if(SessionUtility.httpSession==null)
			result=false;
		else if(SessionUtility.httpSession.getAttribute("clerk")!=null)
			result=true;
		else
			result=false;
		return result;
	}

}
