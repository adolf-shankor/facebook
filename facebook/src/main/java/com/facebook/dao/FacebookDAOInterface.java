package com.facebook.dao;

import java.util.List;

import com.facebook.entity.FacebookUser;
import com.facebook.entity.TimelineDetails;

public interface FacebookDAOInterface {

	int createFacebookDAO(FacebookUser fu);

	int searchprofileOfExistingUser(FacebookUser fu);

	int timeline(TimelineDetails tld);

	int deleteprofile(FacebookUser fu);

	FacebookUser viewprofile(FacebookUser fu);

	List<FacebookUser> viewallprofile();

	List<FacebookUser> searchallprofile(FacebookUser fu);

	int editprofile(FacebookUser fu);

}
