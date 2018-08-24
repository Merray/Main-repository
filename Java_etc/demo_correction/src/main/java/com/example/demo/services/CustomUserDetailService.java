package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.videoclub.model.User;
import com.example.demo.videoclub.repositories.UserRoleRepository;
import com.example.demo.videoclub.repositories.UsersRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		Optional<User> opt = usersRepository.findById(arg0);
		if (opt.isPresent()) {
			return new CustomUserDetails(opt.get(), userRoleRepository.findCustomRoleByUsername(arg0));
		} else {
			throw new UsernameNotFoundException("utilisateur inconnu");
		}
	}

}
