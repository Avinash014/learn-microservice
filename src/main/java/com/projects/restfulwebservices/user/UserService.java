package com.projects.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(long id, UpdateUserRequest updateUserRequest) {
        User user = new User();
        user.setId(id);
        user.setAge(updateUserRequest.getAge());
        user.setName(updateUserRequest.getName());
        return userRepository.save(user);
    }
    public void deleteUser(long id) {

         userRepository.deleteById(id);
    }
}
