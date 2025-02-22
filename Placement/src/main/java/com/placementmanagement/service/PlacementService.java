package com.placementmanagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placementmanagement.entity.Placement;
import com.placementmanagement.exception.PlacementServiceException;
import com.placementmanagement.repo.PlacementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class PlacementService 
{
	 @Autowired
	 private PlacementRepository repo;
	 Logger logger=LoggerFactory.getLogger(PlacementService.class);
	 
	 public List<Placement> listAll() 
	 {
	 return repo.findAll();
	 }
	 
	 public void save(Placement placement) 
	 {
	 repo.save(placement);
	 }
	 public void addPlacementRecord(Placement placement)
	 { 
	   try
	   { 
		   if (placement == null) 
		   { 
			   logger.error("Placement record is null.");
			   throw new PlacementServiceException("Placement record cannot be null.");
		   } 
		   // Add placement record to database 
		   repo.save(placement); 
		   logger.info("Placement record added successfully:",placement);
		   } 
	   catch (PlacementServiceException ex) 
	   { 
		   // Rethrow the exception to be handled by GlobalExceptionHandler
		   logger.warn("PlacementServiceException occured",ex.getMessage());
		   throw ex; 
		   } 
	   catch (Exception ex) 
	   {
		   // Catching unexpected exceptions
		      logger.error("An unexpected error occured while adding the placement record.",ex);
		      
			   throw new PlacementServiceException("An error occurred while adding the placement record.", ex); 
			   }
	   } 
	 // Method to retrieve a placement by ID
	 public Placement getPlacementById(int id) 
	 {
		 try 
		 { 
			 
			 Placement placement = repo.findById(id) .orElseThrow(() -> new PlacementServiceException("Placement not found with ID: " + id)); 
			 logger.info("Retrieved placement",placement);
			 return placement; 
			 } 
		 catch (PlacementServiceException ex) 
		 { 
				 // Rethrow the exception to be handled by GlobalExceptionHandler
			     logger.warn("PlacementServiceException occured",ex.getMessage());
				 throw ex;
				 
		 }
		 catch (Exception ex) 
		 { 
			 // Catching unexpected exceptions 
			 logger.error("An error occured while retrieving the placement record",ex);
			 throw new PlacementServiceException("An error occurred while retrieving the placement record.", ex); 
			 }
		 }  
	 public Placement get(Integer id) 
	 {
	 return repo.findById(id).get();
	 }
	 
	 public void delete(Integer id) 
	 {
	 repo.deleteById(id);
	 }
	}
