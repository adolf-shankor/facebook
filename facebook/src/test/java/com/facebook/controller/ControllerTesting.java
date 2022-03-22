package com.facebook.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControllerTesting {

	FacebookControllerInterface fc=null;
	@Before
	public void setUp() throws Exception {
		fc=new FacebookController();
	}

	@After
	public void tearDown() throws Exception {
		fc=null;
	}

	@Test
	/*public void testFacebookController() {
		int i=
	}

	@Test
	public void testCreateFacebookController() {
		fail("Not yet implemented");
	}*/

	
	public void testSearchprofileOfExistingUser() {
		int i=fc.searchprofileOfExistingUser();
		assert  i>0:"test case failed";
	}

	@Test
	public void testDeleteprofile() {
		int i=fc.deleteprofile();
		assert i>0:"test case failed";
	}

	@Test
	public void testViewprofile() {
		int i=fc.viewprofile();
		assert i>0:"test case failed";
	}

	@Test
	public void testViewallprofile() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchprofile() {
		fail("Not yet implemented");
	}

	@Test
	public void testTimeline() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditprofile() {
		fail("Not yet implemented");
	}

}
