package com.ravipsingh.bloggingapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ravipsingh.bloggingapp.entity.User;
import com.ravipsingh.bloggingapp.services.UserService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	private UserService uservice;
	
	
	@PostMapping("/register")
	@ResponseBody
	public User adduser(@Valid @RequestBody User user) throws Exception
	{   String tempemail = user.getEmail();
	 if( tempemail != null && !"".equals(tempemail) )
	 {
		 User userobj = uservice.fetchUserByEmail(tempemail);
		 if(userobj !=null)
		 {
			 throw new Exception("user with " + tempemail + "already Exists");
		 }
	 }
	
		return uservice.addUser(user);
	} 
	   @PostMapping("/login")
	   @ResponseBody
       public User loginUser(@RequestBody User user)  throws Exception
       {
    	   String tempemail = user.getEmail();
    	   String tempass = user.getPassword();
    	   User userobj=null;
    	   if(tempemail != null && tempass!=null)
    	   {
    		   userobj = uservice.fetchUserByEmailIdAndPassword(tempemail, tempass);
    		   
    	   }
    		   if(userobj == null)
    		   {
    			   throw new Exception("User doesn't exist");
    		   }
    	   
    	   return userobj;
    	   
       }
	   
	   @PutMapping("/forgot")
	   @ResponseBody
	   public User updatePassword(String[] arrstring) throws Exception
		{
			  System.out.println(arrstring);
			  return uservice.updatePass(arrstring[0],arrstring[1]);	   
		   
		}

}
