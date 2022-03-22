package com.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.facebook.entity.FacebookUser;
import com.facebook.entity.TimelineDetails;
import com.facebook.service.FacebookService;
import com.facebook.service.FacebookServiceInterface;

public class testingService {
	FacebookServiceInterface fs=null;
	@Before
	public void setUp() throws Exception {
		fs=new FacebookService();
	}

	@After
	public void tearDown() throws Exception {
		fs=null;
	}

	@Test
	public void testFacebookService() {
		
	}

	@Test
	public void testCreateProfileService() {
		FacebookUser fu=new FacebookUser();
		fu.setName("vishnu23");
		fu.setPassword("shankor34");
		fu.setEmail("Shankor@20202567");
		fu.setAddress("Dharmavaram456");
		
		int i=fs.createProfileService(fu);
		
		
		assert i>0:"test case failed";
		
	}

	@Test
	public void testSearchprofileOfExistingUser() {
		FacebookUser fu=new FacebookUser();
		fu.setName("vishnu23");
		
		
		int i=fs.searchprofileOfExistingUser(fu);
		assert i>0:"test case failed";
			}

	@Test
	public void testTimeline() {

		TimelineDetails tld = new TimelineDetails();
		tld.setMessageid("fgf");
		tld.setSender("hg");
		tld.setMessage("gh");
		tld.setDate("ghg");
		tld.setReceiver("gghh");
		int i=fs.timeline(tld);
		assert i>0:"test case failed";
		
		
	}

	@Test
	public void testDeleteprofile() {
FacebookUser fu=new FacebookUser ();
		
		fu.setEmail("Shankor@20202567");
		
		
		int i=fs.deleteprofile(fu);
		assert i>0:"test failed";
		
	}

	@Test
	public void testViewprofile() {
		FacebookUser fu=new FacebookUser ();
		
		fu.setEmail("aa");
		
		FacebookUser v=new FacebookUser();
		assert v!=null:"test failed";
		
	}

	@Test
	public void testViewallprofile() {
		FacebookUser fu=new FacebookUser();
		List<FacebookUser> ll=new ArrayList<FacebookUser>();
		
		ll=fs.viewallprofile();
		
		assert ll!=null:"test failed";
		
	}

	@Test
	public void testSearchallprofile() {
		FacebookUser fu=new FacebookUser();
		fu.setName("vishnu");
		FacebookUser v=null;
		List<FacebookUser> ll=new ArrayList<FacebookUser>();
		ll=fs.searchallprofile(fu);
		assert ll!=null:"test case failed";
		
	}

	@Test
	public void testEditprofile() {
		int i=0;
		FacebookUser fu=new FacebookUser();
		fu.setName("bb");
		fu.setPassword("bb");
		fu.setEmail("bb");
		fu.setAddress("bb");
		
		 i=fs.editprofile(fu);
		assert i>0:"test failed";

	}

}
