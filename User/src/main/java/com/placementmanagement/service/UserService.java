package com.placementmanagement.service;

//package com.example.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.placementmanagement.entity.User;
import com.placementmanagement.exception.UserServiceException;
import com.placementmanagement.repo.UserRepository;


import jakarta.transaction.Transactional;
@Service
@Transactional
public class UserService 
{
	 @Autowired 
	    private UserRepository repo; 
	 
	 Logger logger=LoggerFactory.getLogger(AdminService.class);
	 
	// @Autowired
	 //private BCryptPasswordEncoder passwordEncoder;
	 public User registerUser(User user) {
	        // Encrypt password before saving (use BCryptPasswordEncoder)
	        return repo.save(user);
	    }

	    public User loginUser(String username, String password) {
	        User user = repo.findByUsername(username);
	        if (user != null && user.getPassword().equals(password)) {
	            return user;
	        }
	        return null;
	    }
	 
	 
	      
	    public List<User> listAll()  
	    { 
	        return repo.findAll(); 
	    } 
	      
	    public void save(User use)  
	    { 
	        repo.save(use); 
	    } 
	    public void addUser(User user)
	    {
	        try {
	            if (user == null) 
	            {
	                logger.error("User record is null.");
	                throw new UserServiceException("User record cannot be null.");
	            }

	            repo.save(user);
	            logger.info("User record added successfully: {}", user);

	        } 
	        catch (UserServiceException ex) 
	        {
	            logger.warn("UserServiceException occurred: {}", ex.getMessage());
	            throw ex;
	        } 
	        catch (Exception ex) 
	        {
	            logger.error("An unexpected error occurred while adding the user record.", ex);
	            throw new UserServiceException("An error occurred while adding the user record.", ex);
	        }
	    }

	      
	   public User get(Integer id)  
      {
	     return repo.findById(id).get(); 
	  } 
      public User getUserById(int id) 
      {
        try 
        {
            User user = repo.findById(id)
                    .orElseThrow(() -> new UserServiceException("User not found with ID: " + id));
            logger.info("Retrieved user: {}", user);
            return user;
        } 
        catch (UserServiceException ex) 
        {
            logger.warn("UserServiceException occurred: {}", ex.getMessage());
            throw ex;
        } catch (Exception ex) 
        {
            logger.error("An error occurred while retrieving the user record.", ex);
            throw new UserServiceException("An error occurred while retrieving the user record.", ex);
        }
    }


	      
	    public void delete(Integer id)  
	    { 
	        repo.deleteById(id); 
	    }
}
