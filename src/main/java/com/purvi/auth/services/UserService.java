package com.purvi.auth.services;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.purvi.auth.models.Role;
import com.purvi.auth.models.User;
import com.purvi.auth.repository.RoleRepository;
import com.purvi.auth.repository.UserRepository;

@Service("userService")
public class UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserService(UserRepository userRepository,
			RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public void saveUser(User user) {
		user.password = bCryptPasswordEncoder.encode(user.password);
		Role userRole = roleRepository.findByRole("ADMIN");
		user.roles = (new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}
}