package com.facebook.utility;

import com.facebook.dao.FacebookDAO;
import com.facebook.dao.FacebookDAOInterface;

public class DAOFactory {

	public static FacebookDAOInterface createObject() {

		
		return new FacebookDAO();
		
	}

}
