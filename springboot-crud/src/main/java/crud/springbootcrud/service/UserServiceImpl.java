package crud.springbootcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import Exception.CustomException;
import crud.springbootcrud.entity.User;
import crud.springbootcrud.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userrepository;
	
	private CustomException customexception;
	
	public User CreateUser(User user) {
		return userrepository.save(user);
		
	}
	
	
	
	
	@Override
	public Optional<User> getUserById(int id) {
		Optional<User> findById =	userrepository.findById(id);
		if(findById.isPresent()) {
			return userrepository.findById(id);
		}
		 
		return  null;
		
	}
	
	

	
	public User UpdateUser(User user) {
		 User existingUser = userrepository.findById(user.getId()).get();
	        existingUser.setName(user.getName());
	        existingUser.setId(user.getId());
	        existingUser.setAge(user.getAge());
	        User updatedUser = userrepository.save(existingUser);
	        return updatedUser;
		
	}
	public void DeleteUser(int id){
		userrepository.deleteById(id);
		
	}
	public List<User> getAllUsers() {
		return userrepository.findAll();
	}
	
}
