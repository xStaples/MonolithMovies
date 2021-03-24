package com.revature.methods;

import com.revature.models.User;
import com.revature.models.UserType;
import com.revature.service.UserService;
import com.revature.service.UserTypeService;

public class Setup {

	public static void initialValues() {
		UserType ut1 = new UserType("Basic");
		UserType ut2 = new UserType("Admin");
		
		UserTypeService.insert(ut1);
		UserTypeService.insert(ut2);
		
		User u1 = new User ("Batman", "batz", "Bruce", "Wayne", ut1);

		UserService.insert(u1);
	}
}
