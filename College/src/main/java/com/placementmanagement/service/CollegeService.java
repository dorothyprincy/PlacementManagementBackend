package com.placementmanagement.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.placementmanagement.entity.College;
import com.placementmanagement.exception.CollegeServiceException;
import com.placementmanagement.repo.CollegeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class CollegeService
{
    @Autowired
    private CollegeRepo repo;
    private static final Logger logger=LoggerFactory.getLogger(CollegeService.class);
    public List<College> searchAll() {
        return repo.findAll();
    }

   public void save(College college) {
       repo.save(college);
   }
    // Method to add a college record
    public void addCollegeRecord(College college) 
    {
        try 
        {
            if (college == null) 
            {
            	
            	logger.error("College record is null.");
                throw new CollegeServiceException("College record cannot be null.");
                
            }

            // Add college record to database
            repo.save(college);
            logger.info("college record added successfully",college);

        } catch (CollegeServiceException ex)
        {
            // Rethrow the exception to be handled by GlobalExceptionHandler
        	logger.warn("CollegeServiceException occured ",ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            // Catching unexpected exceptions
        	logger.error("An unexpected error occured while adding the college record",ex);
            throw new CollegeServiceException("An error occurred while adding the college record.", ex);
        }
    }

    // Method to retrieve a college by ID
    public College getCollegeById(Integer id) {
        try
        {
        	
            College college = repo.findById(id)
                    .orElseThrow(() -> new CollegeServiceException("College not found with ID: " + id));
            logger.error("Retrieved college", college);
            return college;
        } 
        catch (CollegeServiceException ex) 
        {
            // Rethrow the exception to be handled by GlobalExceptionHandler
        	logger.warn("CollegeServiceException occured ",ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            // Catching unexpected exceptions
        	logger.error("An unexpected error occured while adding the college record",ex);
            throw new CollegeServiceException("An error occurred while retrieving the college record.", ex);
        }
    }


    public College get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

