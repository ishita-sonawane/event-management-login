package com.rigeltech.eventmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rigeltech.eventmanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByEmail(String email);

}
