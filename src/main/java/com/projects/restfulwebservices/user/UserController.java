package com.projects.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable long id){
        return userService.getUserById(id);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable long id, @RequestBody UpdateUserRequest updateUserRequest){
        return userService.updateUser( id,updateUserRequest);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
         userService.deleteUser( id);
    }
}
