package com.facebook.utility;

import com.facebook.controller.FacebookController;
import com.facebook.controller.FacebookControllerInterface;

public class ControllerFactory {

	public static FacebookControllerInterface createObject() {

		
		return new FacebookController();
		
	}

}
