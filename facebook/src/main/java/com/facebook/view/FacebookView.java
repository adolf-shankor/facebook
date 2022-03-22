package com.facebook.view;

import java.util.*;

import com.facebook.controller.FacebookControllerInterface;
import com.facebook.utility.ControllerFactory;

public class FacebookView {

	public static void main(String[] args) {

		String s = "y";
		
		Scanner sc = new Scanner(System.in);
		
		while(s.equals("y")) {
			
			System.out.println("Main Menu");
			
			System.out.println("Press 1 to SignUp");
			System.out.println("press 2 to SignIn");
			
			System.out.println("Enter your choice");
			int ch = sc.nextInt();
			
			FacebookControllerInterface fc = ControllerFactory.createObject();
			
			switch(ch) {
				
				case 1:
					fc.createFacebookController();
					break;
				case 2:
					{System.out.println("Opted for SignIn");
					System.out.println("Enter the Name and Email");
					int i=fc.searchprofileOfExistingUser();//signin
					if(i==1) {
						System.out.println("YOU ARE WELCOME");
						System.out.println("Select the below operations");
						System.out.println("Press 1 to delete  profile");
						System.out.println("Press 2 to  view  profile");
						System.out.println("Press 3 to view all  profile");
						System.out.println("Press 4 to search profile");
						System.out.println("Press 5 to edit the profile");
						System.out.println("Press 6 to view the timeline");
						int ch2=sc.nextInt();
						
						switch(ch2) {
						case 1:
							
							fc.deleteprofile();
							break;
						case 2:
							fc.viewprofile();
							break;
						case 3:
							fc.viewallprofile();
							break;
						case 4:
							fc.searchprofile();
							break;
						case 5:
							fc.editprofile();
							break;
						case 6:
							fc.timeline();
							break;
						default:
							System.out.println("please enter the valid one");
						
											
						}
						
						
						
						
						
						
					}}
					break;
				
				default:
					System.out.println("wrong choice");
				
			}
			
			System.out.println("Press y to continue");
			s = sc.next();
			
		}

	}

}
