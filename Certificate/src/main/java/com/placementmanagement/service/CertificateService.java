package com.placementmanagement.service;

import java.util.List; 
import jakarta.transaction.Transactional; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.placementmanagement.entity.Certificate;
import com.placementmanagement.exception.CertificateServiceException;
import com.placementmanagement.repo.CertificateRepository; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service 
@Transactional 
public class CertificateService  
{ 

  @Autowired 
  private CertificateRepository repo;
  private static final Logger logger=LoggerFactory.getLogger(CertificateService.class);
    
  public List<Certificate> listAll()  
  { 
      return repo.findAll(); 
  } 
    
  public void save(Certificate certificate)  
  { 
      repo.save(certificate); 
  } 
    
//  public Certificate get(Integer id)  
//  { 
//      return repo.findById(id).get(); 
//  } 
  
  public Certificate get(Integer id) {
      try 
      {		
    	
          Certificate certificate = repo.findById(id)
                  .orElseThrow(() -> new CertificateServiceException("Certificate not found with ID: " + id));
          logger.info("Retrieved Certificate ",certificate);
          return certificate;
      }
      catch (CertificateServiceException ex) 
      {
          // Rethrow the exception to be handled by GlobalExceptionHandler
    	  logger.warn("CertficateServiceException occured ",ex.getMessage());
          throw ex;
      } 
      catch (Exception ex) {
          // Catching unexpected exceptions
    	  logger.error("An unexpected error occured while issuing the certificate",ex);
          throw new CertificateServiceException("An error occurred while retrieving the certificate.", ex);
          
      }
  }

  public void delete(Integer id)  
  { 
      repo.deleteById(id); 
  } 
  public void issueCertificate(Certificate certificate) {
      try {
          if (certificate == null)
          {
             logger.error("Certificate record is null");
        	  throw new CertificateServiceException("Certificate cannot be null.");
              
          }

          // Issue certificate (store in the repository)
         repo.save(certificate);
         logger.info(" Certificate issued successfully",certificate);

      } catch (CertificateServiceException ex) {
          // Rethrow the exception to be handled by GlobalExceptionHandler
    	  logger.warn(" certificateserviceException occured ",ex.getMessage());
          throw ex;
      } catch (Exception ex) 
      {
          // Catching unexpected exceptions
    	  logger.error("An unexpected error occured while issuing the certificate",ex);
          throw new CertificateServiceException("An error occurred while issuing the certificate.", ex);
      }
  }

} 
