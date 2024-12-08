package com.jpqlandcriteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpqlandcriteria.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Long>{
  
	@Query(value = "select * from users u where u.email = :email", nativeQuery=true)
	Users findUserByEmail(@Param("email") String email);
}
