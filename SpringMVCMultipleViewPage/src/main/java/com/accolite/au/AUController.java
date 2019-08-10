package com.accolite.au;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accolite.Service.AUService;

@Controller
public class AUController {
	
	@Autowired
	AUService auService;
	
	@RequestMapping("/signIn")
	public String signIn() {
		return "Welcome";
	}

	@RequestMapping("/registration")
	public String register() {
		return "Registration";
	}

	@RequestMapping("/adminLogin")
	public String adminLogin() {
		return "AdminLogin";
	}
	
	@RequestMapping("/registerUser")
	public String registerUser(HttpServletRequest request)
	{
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String userName = request.getParameter("username");
		String password = request.getParameter("pass");
		
		auService.addUser(firstName, lastName, userName, password);
		
		return "hello";
	}
	
	@RequestMapping("/signInUser")
	public String signInUser(HttpServletRequest request)
	{
		String userName = request.getParameter("username");
		String password = request.getParameter("pass");
		
		return auService.findUser(userName, password);
		
	}
	
	@RequestMapping("/loginAdmin")
	public String loginAdmin(HttpServletRequest request)
	{
		String adminName = request.getParameter("username");
		String password = request.getParameter("pass");
		
		return auService.loginAdmin(adminName, password);
	}
	
	@RequestMapping("/unlockUser")
	public String unlockUser(HttpServletRequest request) 
	{
		String listOfUser = request.getParameter("hiddenUnlockUserList");
		if(listOfUser.equals(""))
			return "AdminIndex";
		System.out.println(listOfUser);
		return auService.unlockUser(listOfUser);
		
	}
	
	
}
