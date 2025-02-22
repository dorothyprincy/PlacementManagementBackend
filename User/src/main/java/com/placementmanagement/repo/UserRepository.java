package com.placementmanagement.repo;

//package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.placementmanagement.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>
{
 @Query(value="select * from User where name=:name",nativeQuery=true)
	User findByUsername(@Param("name")String name);


}
