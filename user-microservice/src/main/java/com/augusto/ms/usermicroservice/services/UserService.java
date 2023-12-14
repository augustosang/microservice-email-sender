package com.augusto.ms.usermicroservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.augusto.ms.usermicroservice.models.UserModel;
import com.augusto.ms.usermicroservice.repositories.UserRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
  
  @Autowired
  UserRepository userRepository;

  @Transactional
  public UserModel save(UserModel user) {
    return userRepository.save(user);
  }
}
