package com.placementmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.placementmanagement.entity.Placement;



public interface PlacementRepository extends JpaRepository<Placement, Integer>{
	
	
	
}

