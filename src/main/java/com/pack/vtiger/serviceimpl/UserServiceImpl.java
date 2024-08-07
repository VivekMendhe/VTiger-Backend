package com.pack.vtiger.serviceimpl;

import com.pack.vtiger.dto.UserDTO;
import com.pack.vtiger.model.User;
import com.pack.vtiger.repository.UserRepository;
import com.pack.vtiger.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collectors;

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
		List<User> users = userRepository.findAll();
		return users.stream().map(this::entityToDTO).collect(Collectors.toList());
	}

	@Override
	public UserDTO getUserById(Integer id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResolutionException("User Id not found"));
		return entityToDTO(user);
	}

	@Override
	public UserDTO updateUser(Integer id, UserDTO userDTO) {
		User existingUser = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User with ID " + id + " not found"));
		modelMapper.map(userDTO, existingUser);
		User updatedUser = userRepository.save(existingUser);
		return entityToDTO(updatedUser);
	}

	@Override
	public void deleteUser(Integer id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
		} else {
			throw new RuntimeException("User with ID " + id + " not found");
		}
	}

	// convert dto to entity
	public User dtoToEntity(UserDTO userDTO) {
		return modelMapper.map(userDTO, User.class);
	}

	// convert entity to dto
	public UserDTO entityToDTO(User user) {
		return modelMapper.map(user, UserDTO.class);
	}
}
