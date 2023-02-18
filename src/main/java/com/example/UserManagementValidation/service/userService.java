package com.example.UserManagementValidation.service;

import com.example.UserManagementValidation.dao.userRepository;
import com.example.UserManagementValidation.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {

    @Autowired
    userRepository userrepository;

    public User addUser(User user){
        return userrepository.save(user);
    }

    public List<User> getUsers(){
        return userrepository.findAll();
    }
    public User getUser(Integer userid){
        return userrepository.findById(userid).get();
    }

    public void updateUser(Integer userid,User newuser){
        User user=userrepository.findById(userid).get();
        //user.setUserId(newuser.getUserId());
        user.setUserName(newuser.getUserName());
        user.setDateOfBirth(newuser.getDateOfBirth());
        user.setPhoneNumber(newuser.getPhoneNumber());
        user.setEmail(newuser.getEmail());
        user.setDate(newuser.getDate());
        user.setTime(newuser.getTime());
        userrepository.save(user);

    }

    public void deleteUser(Integer userid){
        userrepository.deleteById(userid);
    }

}
