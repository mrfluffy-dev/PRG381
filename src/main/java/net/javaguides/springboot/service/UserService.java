package net.javaguides.springboot.service;

import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.web.dto.UserRegistrationDto;

import java.util.List;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
	List<User> getAllUsers();
	Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	User getUserById(long id);
	void deleteUserById(long id);
	void saveUser(User user);

}
