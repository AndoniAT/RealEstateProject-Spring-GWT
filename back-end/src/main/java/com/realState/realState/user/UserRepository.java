package com.realState.realState.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//This repository is responsible for data access
@Repository
public interface UserRepository extends JpaRepository<UserApp, Long>{
	// JpaRepository contains already all the methods we need to make queries (ex: findOne, findAll, saveAll, etc...).
	
	@Query("SELECT u FROM UserApp u where u.email = ?1")
	Optional<UserApp> findUserByEmail(String email);

}
