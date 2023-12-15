package com.augusto.ms.usermicroservice.services;

import com.augusto.ms.usermicroservice.producers.UserProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.augusto.ms.usermicroservice.models.UserModel;
import com.augusto.ms.usermicroservice.repositories.UserRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
  
  @Autowired
  UserRepository userRepository;

  @Autowired
  UserProducer userProducer;

  @Transactional
  public UserModel save(UserModel user) {
    user = userRepository.save(user);
    userProducer.publishMessageEmail(user);
    return user;
  }
}
