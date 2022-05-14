package com.javeatechie.api.service;

import com.javeatechie.api.dto.UserRequest;
import com.javeatechie.api.entity.User;
import com.javeatechie.api.exception.UserNotFoundException;
import com.javeatechie.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


public User saveUser(UserRequest userRequest){
    User user = User.build(0,userRequest.getName(),userRequest.getEmail(),userRequest.getGender(),
            userRequest.getMobile(),userRequest.getAge(),userRequest.getNationality());
return userRepository.save(user);
}


public List<User> getAllUser(){
    return userRepository.findAll();
}


public User getUser(int id) throws UserNotFoundException {
    User user = userRepository.findByUserId(id);
    if(user != null){
        return user;
    }else{
        throw new UserNotFoundException("User Not Found with Id" + id);
    }
}


}
