package com.training.usermanagementassignment.adapter.rest;

import com.training.usermanagementassignment.exception.UserNotFoundException;
import com.training.usermanagementassignment.model.User;
import com.training.usermanagementassignment.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")

public class UserController {

     private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Get Post Patch

    @GetMapping("/{id}")
    public User gettingUser(@PathVariable String id){
        return userService.findById(id).orElseThrow(()->new UserNotFoundException(id));
    }

    @PostMapping
    public String saveUser(User user){
        return userService.register(user);
    }
   @PatchMapping("/{id}")
      public User updateUser(String id,User user){
       return userService.updateUserData(id, user).orElseThrow(()->new UserNotFoundException(id));
   }
   @DeleteMapping("/{id}")
    public User removeUser(String id){
       return userService.deleteUser(id).orElseThrow(()->new UserNotFoundException(id));
   }
}
