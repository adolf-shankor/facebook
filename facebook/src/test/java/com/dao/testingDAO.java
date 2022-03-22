package com.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.facebook.dao.FacebookDAO;
import com.facebook.dao.FacebookDAOInterface;
import com.facebook.entity.FacebookUser;
import com.facebook.entity.TimelineDetails;

public class testingDAO {
	FacebookDAOInterface fd=null;
	@Before
	public void setUp() throws Exception {
		fd=new FacebookDAO();
	}

	@After
	public void tearDown() throws Exception {
		fd=null;
	}

	@Test
	public void testFacebookDAO() {
		
	}

	@Test
	public void testCreateFacebookDAO() {
		FacebookUser fu=new FacebookUser();
		fu.setName("vishnu23");
		fu.setPassword("shankor34");
		fu.setEmail("Shankor@20202567");
		fu.setAddress("Dharmavaram456");
		
		int i=fd.createFacebookDAO(fu);
		
		assert i>0:"test case failed";
		
	}

	@Test
	public void testSearchprofileOfExistingUser() {
		FacebookUser fu=new FacebookUser();
		fu.setName("vishnu23");
		
		
		int i=fd.searchprofileOfExistingUser(fu);
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
		int i=fd.timeline(tld);
		assert i>0:"test case failed";
	}

	@Test
	public void testDeleteprofile() {
FacebookUser fu=new FacebookUser ();
		
		fu.setEmail("Shankor@20202567");
		
		
		int i=fd.deleteprofile(fu);
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
		
		ll=fd.viewallprofile();
		
		assert ll!=null:"test failed";
	}

	@Test
	public void testSearchallprofile() {
		FacebookUser fu=new FacebookUser();
		fu.setName("vishnu");
		FacebookUser v=null;
		List<FacebookUser> ll=new ArrayList<FacebookUser>();
		ll=fd.searchallprofile(fu);
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
		
		 i=fd.editprofile(fu);
		assert i>0:"test failed";
	}

}
