package com.example.UserManagementValidation.controller;

import com.example.UserManagementValidation.model.User;
import com.example.UserManagementValidation.service.userService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    userService service;

    //http://localhost:8080/user/add-user
//    @PostMapping("add-user")
//    public User addUser(@RequestBody User user){
//        return service.addUser(user);
//    }

    @PostMapping("add-user")
//    public User addUser(@RequestBody String requestuser){
//
//        JSONObject json=new JSONObject(requestuser);
//        if(validateuser(json)!=null){return service.addUser(validateuser(json));}
//        return null;
//
//    }

    public ResponseEntity<String> addUser(@RequestBody String requestuser){

        JSONObject json=new JSONObject(requestuser);
        if(validateuser(json)!=null){
            service.addUser(validateuser(json));
            return new ResponseEntity<>("All the details are saved successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Fill all the details correctly", HttpStatus.BAD_REQUEST);

    }


    //http://localhost:8080/user/get-users
    @GetMapping("get-users")
    public List<User> getUsers(){
   return service.getUsers();
    }

    //http://localhost:8080/user/get-user?userid=
    @GetMapping("get-user")
    public User getUser(@RequestParam Integer userid){
        return service.getUser(userid);
    }

    //http://localhost:8080/user/update-user?userid=
    @PutMapping("update-user")
    public void updateUser(@RequestParam Integer userid,@RequestBody User newuser){
       service.updateUser(userid,newuser);
    }

   // http://localhost:8080/user/delete-user?userid=
    @DeleteMapping("delete-user")
    public void deleteUser(@RequestParam Integer userid){
        service.deleteUser(userid);
    }

    public User validateuser(JSONObject json){

        User user=new User();

        if(json.has("userName")){

          user.setUserName(json.getString("userName"));
        }else{
        return null;
        }

        if(json.has("dateOfBirth") && json.getString("dateOfBirth").charAt(2)=='-' && json.getString("dateOfBirth").charAt(5)=='-' ){
            String birthdate=json.getString("dateOfBirth");

                user.setDateOfBirth(birthdate);


        }else{
            return null;
        }
        if(json.has("email")){
         user.setEmail(json.getString("email"));
        }else{
            return null;
        }
        if(json.has("phoneNumber") && json.getString("phoneNumber").length()==12 ){

            String ph_no=json.getString("phoneNumber");
         user.setPhoneNumber(ph_no);


        }else{
            return null;
        }
        if(json.has("date")){
       user.setDate(json.getString("date"));
        }else{
            return null;
        }
        if(json.has("time")){
           user.setTime(json.getString("time"));
        }
        if(json.has("userId")){
            user.setUserId((int)(json.get("userId")));
        }
        return user;
    }




}
