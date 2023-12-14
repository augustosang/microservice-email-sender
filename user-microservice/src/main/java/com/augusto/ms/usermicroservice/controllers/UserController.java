package com.augusto.ms.usermicroservice.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.augusto.ms.usermicroservice.dtos.UserRecordDto;
import com.augusto.ms.usermicroservice.models.UserModel;
import com.augusto.ms.usermicroservice.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;
  
  @PostMapping
  public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecordDto userRecordDto) {
    var userModel = new UserModel();
    BeanUtils.copyProperties(userRecordDto, userModel);
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
  }
}
