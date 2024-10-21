package com.realState.realState.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//This repository is responsible for data access
@Repository
public interface UserRepository extends JpaRepository<UserApp, Long>{
	// JpaRepository contains already all the methods we need to make queries (ex: findOne, findAll, saveAll, etc...).

}
