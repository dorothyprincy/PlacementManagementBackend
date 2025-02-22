package com.placementmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.placementmanagement.entity.Certificate; 
public interface CertificateRepository extends JpaRepository<Certificate, Integer>  
{ 
}
