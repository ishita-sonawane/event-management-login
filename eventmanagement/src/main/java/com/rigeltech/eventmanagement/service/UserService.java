package com.rigeltech.eventmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.rigeltech.eventmanagement.entity.User;
import com.rigeltech.eventmanagement.exception.UserCredentialNotFoundException;
import com.rigeltech.eventmanagement.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	

	// to add data
	public void saveData(String email, String password) {

		User user = new User();
		user.setEmail(email);
		user.setPassword(password);

		userRepository.save(user);

	}
	
	public String addUserView(String email, String password) {

		User user = new User();
		user.setEmail(email);
		user.setPassword(password);

		userRepository.save(user);
		return "add-user";
	}

	// to show data
	public List<User> showAll() {
		return userRepository.findAll();

	}

	// method for updating records
	public User update(int id, String email, String password) {

		// fetching existing record for updating
		Optional<User> updatedUser = userRepository.findById(id);

		User existingUser = updatedUser.get();

		// setting updated values for entity
		existingUser.setEmail(email);
		existingUser.setPassword(password);

		// save updated record
		userRepository.save(existingUser);
		return existingUser;
	}

	// method to delete records
	public String delete(int id) {

		userRepository.deleteById(id);
		return "deleted successfully!";
	}

	public String login(String email, String password, Model m) {
		User user = userRepository.findByEmail(email);
		if (user != null) {
			String encodedPassword = user.getPassword();
			if (encodedPassword.equals(String.valueOf(password))) {
				m.addAttribute("email", email);
				m.addAttribute("password", password);
				System.out.println("password matches="+password);
				return "welcome";
			}
			System.out.println("password doesnt match");
		}
		System.out.println("email "+email);
		m.addAttribute("error", "Incorrect Email & Password");
		m.addAttribute("link1", "/form");
		return "error-page";
		// throw new Exception("User cannot be authenticated");
	}
	
	public String loginApi(String email, String password, Model m) throws UserCredentialNotFoundException{
		User user = userRepository.findByEmail(email);
		if (user != null) {
			String encodedPassword = user.getPassword();
			if (encodedPassword.equals(String.valueOf(password))) {
				
				System.out.println("password matches="+password);
				return "success";
			}
			System.out.println("password doesnt match");
		}
		
	throw new UserCredentialNotFoundException("User cannot be authenticated");
	}
}
