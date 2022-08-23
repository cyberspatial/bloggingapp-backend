package com.ravipsingh.bloggingapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravipsingh.bloggingapp.entity.User;
import com.ravipsingh.bloggingapp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userepo;
	
	public User addUser(User user)
	{
		return userepo.save(user);
	}
	public User fetchUserByEmail(String email)
	{
		return userepo.findItemByEmail(email);
	}
	
	public User fetchUserByEmailIdAndPassword(String email,String password)
	{
		return userepo.findItemByEmailAndPassword(email, password);
	}
	
	public User updatePass(String email,String newpassword) throws Exception
	{
		User usrObj= null;
		if(email !=null && newpassword!=null)
		{
			usrObj = userepo.findItemByEmail(email);
			usrObj.setPassword(newpassword);
			
		}
		if(usrObj == null)
		{
			throw new Exception("User exist");
		}
		return userepo.save(usrObj);
	}

}
