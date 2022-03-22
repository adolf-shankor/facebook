package com.facebook.service;

import java.util.List;

import com.facebook.controller.Facebookuser;
import com.facebook.entity.FacebookUser;
import com.facebook.entity.TimelineDetails;

public interface FacebookServiceInterface {

	int createProfileService(FacebookUser fu);

	int searchprofileOfExistingUser(FacebookUser fu);

	int timeline(TimelineDetails tld);

	int deleteprofile(FacebookUser fu);

	FacebookUser viewprofile(FacebookUser fu);

	List<FacebookUser> viewallprofile();

	List<FacebookUser> searchallprofile(FacebookUser fu);

	int editprofile(FacebookUser fu);

	

}
