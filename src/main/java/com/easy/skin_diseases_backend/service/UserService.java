package com.easy.skin_diseases_backend.service;

import com.easy.skin_diseases_backend.dto.UserDTO;
import com.easy.skin_diseases_backend.entity.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> getUsers();

    User getUser(Integer id);

    void updateUser(Integer id, User user);

    void deleteUser(Integer id);

    void updateName(Integer id, UserDTO userDTO);
}
