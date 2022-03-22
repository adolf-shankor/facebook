package com.facebook.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.facebook.entity.FacebookUser;
import com.facebook.entity.TimelineDetails;

public class FacebookDAO implements FacebookDAOInterface {
	
	Connection con = null;
	
	public FacebookDAO() {
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

	public int createFacebookDAO(FacebookUser fu) {

		int i = 0;
		
		try {
			
			PreparedStatement ps=con.prepareStatement("insert into facebookUser values(?,?,?,?)");
			ps.setString(1, fu.getName());
			ps.setString(2, fu.getPassword());
			ps.setString(3, fu.getEmail());
			ps.setString(4, fu.getAddress());
			
			i = ps.executeUpdate();
			System.out.println("here is i"+i);
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return i;
		
	}


	public int searchprofileOfExistingUser(FacebookUser fu) {
		FacebookUser v=null;
		List<FacebookUser> ll=new ArrayList<FacebookUser>();
		int j=0;
		
		try {
			
		/*PreparedStatement ps=con.prepareStatement("select * from facebookuser where name=?");
		ps.setString(1,fu.getName());*/
			PreparedStatement ps=con.prepareStatement("select * from facebookuser where email=? AND password=?");
			ps.setString(1,fu.getEmail());
			ps.setString(2, fu.getPassword());
		
		
		
		ResultSet res=ps.executeQuery();
		
		
		while(res.next()) {
			String n=res.getString(1);
			String p=res.getString(2);
			String e=res.getString(3);
			String a=res.getString(4);
			
			v=new FacebookUser();
			v.setName(n);
			v.setPassword(p);
			v.setEmail(e);
			v.setAddress(a);
			
			ll.add(v);
		}
		if(ll!=null) {
			 j=1;
		}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return j;
		

		
		
	}


	
	public int timeline(TimelineDetails tld) {
		int i=0;
		PreparedStatement ps = null;
		try {
			
			ps = con.prepareStatement("insert into timelinedetails values(?,?,?,?,?)");
			
			ps.setString(1, tld.getMessageid());
			ps.setString(2, tld.getSender());	
			ps.setString(3, tld.getMessage());
			ps.setString(4, tld.getDate());
			ps.setString(5, tld.getReceiver());
			
			
			
			i=ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		} 
		
		finally {
			if(ps!=null) {
					try {
						ps.close();}
				catch (SQLException e) {
					e.printStackTrace();}
				}
			}
		return i;
		
		
	}


	
	public int deleteprofile(FacebookUser fu) {
		int i=0;
		try {

		//	Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		PreparedStatement ps=con.prepareStatement("delete from facebookuser where email=?");
		ps.setString(1, fu.getEmail());
		
		 i=ps.executeUpdate();
		 System.out.println("here is i"+i);
		
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return i;

		
		
		
	}


	
	public FacebookUser viewprofile(FacebookUser fu) {
		FacebookUser v=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		PreparedStatement ps=con.prepareStatement("select * from facebookuser where email=?");
		ps.setString(1, fu.getEmail());
		
		ResultSet res=ps.executeQuery();
		if(res.next()) {
			String n=res.getString(1);
			String p=res.getString(2);
			String e=res.getString(3);
			String a=res.getString(4);
			
			v=new FacebookUser();
			v.setName(n);
			v.setPassword(p);
			v.setEmail(e);
			v.setAddress(a);
		}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return v;
	
		
		
	}


	@Override
	public List<FacebookUser> viewallprofile() {
		FacebookUser v=null;
		List<FacebookUser> ll=new ArrayList<FacebookUser>();
		
		try {
		PreparedStatement ps=con.prepareStatement("select * from facebookuser");
		
		
		ResultSet res=ps.executeQuery();
		
		
		while(res.next()) {
			String n=res.getString(1);
			String p=res.getString(2);
			String e=res.getString(3);
			String a=res.getString(4);
			
			v=new FacebookUser();
			v.setName(n);
			v.setPassword(p);
			v.setEmail(e);
			v.setAddress(a);
			
			ll.add(v);
		}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ll;
	
		
	}


	
	public List<FacebookUser> searchallprofile(FacebookUser fu) {
		FacebookUser v=null;
		List<FacebookUser> ll=new ArrayList<FacebookUser>();
		
		try {
			
		PreparedStatement ps=con.prepareStatement("select * from facebookuser where name=? ");
		ps.setString(1,fu.getName());
		//ps.setString(2, fu.getPassword());
		
		
		
		ResultSet res=ps.executeQuery();
		
		
		while(res.next()) {
			String n=res.getString(1);
			String p=res.getString(2);
			String e=res.getString(3);
			String a=res.getString(4);
			
			v=new FacebookUser();
			v.setName(n);
			v.setPassword(p);
			v.setEmail(e);
			v.setAddress(a);
			
			ll.add(v);
		}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ll;
		
	
		
	}


	@Override
	public int editprofile(FacebookUser fu) {
           int i=0;
		
		try {

		
		
			PreparedStatement ps=con.prepareStatement("update facebookuser set name=?,password=?,address=? where email=?");
		 
			ps.setString(1,fu.getName());
			ps.setString(2,fu.getPassword());
			ps.setString(4,fu.getEmail());
			ps.setString(3,fu.getAddress());
			
			 i=ps.executeUpdate();
			System.out.println(i);
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		return i;

		
	}

}
