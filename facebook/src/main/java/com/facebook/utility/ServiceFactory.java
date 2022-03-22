package com.facebook.utility;

import com.facebook.service.FacebookService;
import com.facebook.service.FacebookServiceInterface;

public class ServiceFactory {

	public static FacebookServiceInterface createObject() {

		
		return new FacebookService();
		
	}

}
