package com.placementmanagement.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.*;

import com.placementmanagement.entity.College;

public interface CollegeRepo extends JpaRepository<College,Long> {

	Optional<College> findById(Integer id);

}
