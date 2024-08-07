package com.pack.vtiger.serviceimpl;

import com.pack.vtiger.dto.UserDTO;
import com.pack.vtiger.model.User;
import com.pack.vtiger.repository.UserRepository;
import com.pack.vtiger.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = this.dtoToEntity(userDTO);
        User saveUser = this.userRepository.save(user);
        return this.entityToDTO(saveUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDTO getUserById(Integer id) {
        return null;
    }

    @Override
    public UserDTO updateUser(Integer id, UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteUser(Integer id) {

    }

    // convert dto to entity
    public User dtoToEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    }

    // convert entity to dto
    public UserDTO entityToDTO(User user){
        return modelMapper.map(user, UserDTO.class);
    }
}
