package com.easy.skin_diseases_backend.service.IMPL;

import com.easy.skin_diseases_backend.dto.UserDTO;
import com.easy.skin_diseases_backend.entity.User;
import com.easy.skin_diseases_backend.repository.UserRepository;
import com.easy.skin_diseases_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {


        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id "+id));

        return user;
    }

    @Override
    public void updateUser(Integer id, User user) {
        //check Weather the user is in database or not
        userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id "+id));

//        deleteUser(id);
        user.setId(id);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        //check Weather the user is in database or not
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id "+id));

        userRepository.delete(user);
    }

    @Override
    public void updateName(Integer id, UserDTO userDTO) {
        //check Weather the user is in database or not
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id "+id));

        user.setName(userDTO.getName());

        userRepository.save(user);
    }
}
