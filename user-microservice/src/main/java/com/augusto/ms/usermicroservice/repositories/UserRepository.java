package com.augusto.ms.usermicroservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.augusto.ms.usermicroservice.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID>{
  
}
