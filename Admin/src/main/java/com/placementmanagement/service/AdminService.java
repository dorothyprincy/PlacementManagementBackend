package com.placementmanagement.service;

//package com.tns.Admin;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.placementmanagement.entity.Admin;
import com.placementmanagement.exception.AdminServiceException;
import com.placementmanagement.repo.AdminRepository; 
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
 
@Service 
public class AdminService  
{ 
  
    @Autowired 
    private AdminRepository repo;
    
    Logger logger=LoggerFactory.getLogger(AdminService.class);
      
    public List<Admin> listAll()  
    { 
        return repo.findAll(); 
    } 
    public void addAdmin(Admin admin)
    {
       
    	try 
        {
            if (admin == null) 
            {	
            	logger.error("Admin record is null");
                throw new AdminServiceException("Admin record cannot be null.");
            }

            // Add admin to the system
            repo.save(admin);
            logger.info("Admin record added successfully",admin);

        } catch (AdminServiceException ex) {
            // Rethrow the exception to be handled by GlobalExceptionHandler
        	logger.warn("AdminService Exception occured",ex.getMessage());
            throw ex;
        } catch (Exception ex) 
    	{
            // Catching unexpected exceptions
        	logger.error("An unexpected error occurred while adding the admin record",ex);
        	
            throw new AdminServiceException("An error occurred while adding the admin.", ex);
        }
    }

      
    public void save(Admin admin)  
    { 
        repo.save(admin); 
    } 
      
   public Admin get(Integer id)  
    { 
       return repo.findById(id).get(); 
   } 
    
    public Admin getAdminById(Integer id) 
    {
        try
        {
            Admin admin = repo.findById(id)
                    .orElseThrow(() -> new AdminServiceException("Admin not found with ID: " + id));
            logger.info("Retrieved admin :{}",admin);
            return admin;
             }
        catch (AdminServiceException ex) 
        {
            // Rethrow the exception to be handled by GlobalExceptionHandler
        	logger.warn("AdminService Exception occured",ex.getMessage());
            throw ex;
        } catch (Exception ex)
        {
            // Catching unexpected exceptions
        	logger.error("An unexpected error occurred while adding the admin record",ex);
            throw new AdminServiceException("An error occurred while retrieving the admin.", ex);
        }
    }
 
    public void delete(Integer id)  
    { 
        repo.deleteById(id); 
    }
}
