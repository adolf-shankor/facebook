package com.facebook.controller;

import java.util.*;


import com.facebook.entity.FacebookUser;
import com.facebook.entity.TimelineDetails;
import com.facebook.service.FacebookServiceInterface;
import com.facebook.utility.ServiceFactory;
import java.util.logging.Logger;

public class FacebookController implements FacebookControllerInterface {
	Logger log = Logger.getLogger("ProjectController1");
	
	FacebookServiceInterface fs = null;
	
	public FacebookController() {
		fs = ServiceFactory.createObject();
	}

	public void createFacebookController() {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Name: ");
		String name = sc.next();
		
		System.out.println("Enter Password: ");
		String password = sc.next();
		
		System.out.println("Enter Email: ");
		String email = sc.next();
		
		System.out.println("Enter Address: ");
		String address = sc.next();
		
		FacebookUser fu = new FacebookUser();
		fu.setName(name);
		fu.setPassword(password);
		fu.setEmail(email);
		fu.setAddress(address);
		
		int i = fs.createProfileService(fu);
		if(i>0) {
			System.out.println("CREATED");
		}
		else {
			System.out.println("not");
		}

	}

	public int searchprofileOfExistingUser() {
		Scanner sc=new Scanner(System.in);
		log.info("Enter the email");
		String email=sc.next();
		log.info("Enter the password");
		String password=sc.next();
		
		FacebookUser fu=new  FacebookUser();
		fu.setEmail(email);
		fu.setPassword(password);
		
		

		
		int ll=fs.searchprofileOfExistingUser(fu);
		//List<SwiggyUser> ll = ss.viewAllProfilesService();
		//System.out.println(ll.size()+"records found in database");
		// ll.forEach( (n) -> { System.out.println(n);});
			
			/*ll.forEach(s->{
				
				System.out.println("***********");
				System.out.println(s.getName());
				System.out.println(s.getPassword());
				System.out.println(s.getEmail());
				System.out.println(s.getAddress());
				
			});*/
			return ll;
		
	}

	public int deleteprofile() {
		Scanner sc=new Scanner(System.in);
		log.info("Enter the mail");
		String email=sc.next();
		
		FacebookUser fu = new FacebookUser();
		fu.setEmail(email);
		
		
		int i=fs.deleteprofile(fu);
		if(i>0) {
			log.info("deleted");
		}
		else {
			log.info("not deleted");
		}
		return i;
		
		
	}

	public int viewprofile() {
		int j=0;
		//Scanner sc=new Scanner (System.in);
		Scanner sc=new Scanner(System.in);
		log.info("Enter the mail");
		String email=sc.next();
		
		
		
		FacebookUser fu = new FacebookUser();
		fu.setEmail(email);
		
		
		FacebookUser i=fs.viewprofile(fu);
		
		if(i!=null) {
			log.info("Name is "+i.getName());
			log.info("Password is "+i.getPassword());
			log.info("Email is "+i.getEmail());
			log.info("Address is "+i.getAddress());
			
			j=1;
			
		}
		else {
			log.info("Norecord found");
		}
		return j;
		
		
		
		
	}

	public void viewallprofile() {

	
		List<FacebookUser> ll=fs.viewallprofile();
		//List<SwiggyUser> ll = ss.viewAllProfilesService();
		log.info(ll.size()+"records found in database");
		// ll.forEach( (n) -> { System.out.println(n);});
			
			ll.forEach(s->{
				
				log.info("***********");
				log.info(s.getName());
				log.info(s.getPassword());
				log.info(s.getEmail());
				log.info(s.getAddress());
				
			});
			
		
		
		
	}

	public void searchprofile() {
		Scanner sc=new Scanner(System.in);
		log.info("Enter the name");
		String name=sc.next();
		
		
		FacebookUser fu=new  FacebookUser();
		fu.setName(name);
		//fu.setPassword(password);
		

		
		List<FacebookUser> ll=fs.searchallprofile(fu);
		//List<SwiggyUser> ll = ss.viewAllProfilesService();
		log.info(ll.size()+"records found in database");
		// ll.forEach( (n) -> { System.out.println(n);});
			
			ll.forEach(s->{
				
				log.info("***********");
				log.info(s.getName());
				log.info(s.getPassword());
				log.info(s.getEmail());
				log.info(s.getAddress());
				
			});
			//return i;
		
	
		
		
	}

	public int timeline() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter message id");
		String messageid = sc.next();
		
		System.out.println("enter sender userid");
		String sender = sc.next();
		
		//receiver id should be in userdetails table
		System.out.println("enter reciver id");
		String receiver = sc.next();
		
		System.out.println("enter message");
		String message = sc.next();
		
		System.out.println("enter date");
		String date = sc.next();
		
		
		
		
		
		TimelineDetails tld = new TimelineDetails();
		tld.setMessageid(messageid);
		tld.setSender(sender);
		tld.setMessage(message);
		tld.setDate(date);
		tld.setReceiver(receiver);
	
		
		
		
		int i= fs.timeline(tld);
		
		if(i>0) {
			System.out.println("timeline updated");
		}
		else {
			System.out.println("oops! something went wrong");
		}
		return i;
		
		
	}

	public void editprofile() {
		
		log.info("Older data");
		int o=viewprofile();
		if(o!=0) {
		Scanner sc=new Scanner (System.in);
		
		log.info("Enter new or old name");
		String name=sc.next();
		
		log.info("Enter new or old password");
		String password=sc.next();
		
		log.info("Enter old email");
		String email=sc.next();
		
		log.info("Enter new or old address");
		String address=sc.next();
		
		
		FacebookUser fu=new FacebookUser();
		
		fu.setName(name);
		fu.setEmail(email);
		fu.setPassword(password);
		fu.setAddress(address);
		
		
		int i=fs.editprofile(fu);
		if(i>0) {
			log.info("edited");
		}
		else {
			log.info("not edited");
		}
		}
		//return i;
	
		
		
	}

}
