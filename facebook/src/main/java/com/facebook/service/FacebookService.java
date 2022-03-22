package com.facebook.service;

import java.util.List;

import com.facebook.controller.Facebookuser;
import com.facebook.dao.FacebookDAOInterface;
import com.facebook.entity.FacebookUser;
import com.facebook.entity.TimelineDetails;
import com.facebook.utility.DAOFactory;

public class FacebookService implements FacebookServiceInterface {

	FacebookDAOInterface fd = null;
	
	public FacebookService() {
		fd = DAOFactory.createObject();
	}
	
	public int createProfileService(FacebookUser fu) {

		int i = fd.createFacebookDAO(fu);
		return i;
		
	}

	public int searchprofileOfExistingUser(FacebookUser fu) {
		int i=fd.searchprofileOfExistingUser(fu);
		return i;
	}

	public int timeline(TimelineDetails tld) {
		int i=fd.timeline(tld);
		return i;
	}

	public int deleteprofile(FacebookUser fu) {
		int i=fd.deleteprofile(fu);
		return i;
		
	}

	public FacebookUser viewprofile(FacebookUser fu) {
		FacebookUser i=fd.viewprofile(fu);
		return i;
	}

	@Override
	public List<FacebookUser> viewallprofile() {
		List<FacebookUser> i=fd.viewallprofile();
		return i;
	}

	@Override
	public List<FacebookUser> searchallprofile(FacebookUser fu) {
		List<FacebookUser> i=fd.searchallprofile(fu);
		return i;
	}

	@Override
	public int editprofile(FacebookUser fu) {
		int i=fd.editprofile(fu);
		return i;
	}

}
