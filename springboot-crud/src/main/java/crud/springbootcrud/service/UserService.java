package crud.springbootcrud.service;

import java.util.List;
import java.util.Optional;

import crud.springbootcrud.entity.User;

public interface UserService {
	public User CreateUser(User user);
	public Optional<User> getUserById(int id);
	public User UpdateUser(User user);
	public void DeleteUser(int id);
	public List<User> getAllUsers();
	
}
