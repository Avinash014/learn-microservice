package com.projects.restfulwebservices.user;

import com.projects.restfulwebservices.exception.BusinessValidationException;
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
        return userRepository.findById(id).orElseThrow(() ->  new BusinessValidationException("not_found","user not found"));
    }

    public User updateUser(long id, UpdateUserRequest updateUserRequest) {
        User user = userRepository.findById(id).orElse(null);
        if(user ==null) {
            throw new BusinessValidationException("not_found","user not found");
        }
        User userReq = new User();
        userReq.setId(id);
        userReq.setAge(updateUserRequest.getAge());
        userReq.setName(updateUserRequest.getName());
        return userRepository.save(userReq);
    }
    public void deleteUser(long id)  {
        User user = userRepository.findById(id).orElse(null);
        if(user ==null) {
            throw new BusinessValidationException("not_found","user not found");
        }
         userRepository.deleteById(id);
    }
}
