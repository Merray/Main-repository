package com.example.demo.videoclub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.videoclub.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
	@Query("select distinct u.role from UserRole u where u.user.username=?1")
	List<String> findCustomRoleByUsername(String username);
}
