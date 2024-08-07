package com.pack.vtiger.service;

import com.pack.vtiger.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO addUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Integer id);
    UserDTO updateUser(Integer id, UserDTO userDTO);
    void deleteUser(Integer id);
}
