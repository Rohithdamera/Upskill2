package crud.springbootcrud.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Exception.ResourceNotFoundException;
//import Exception.ResourceNotFoundException;
import crud.springbootcrud.entity.User;
import crud.springbootcrud.repository.UserRepository;
import crud.springbootcrud.service.UserService;
import crud.springbootcrud.service.UserServiceImpl;

@RestController
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserRepository userrepository;
	
	private static final org.slf4j.Logger LOGGER =LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserServiceImpl userservice;
	
	
	
	  // http://localhost:8080/add
	
	
	@PostMapping("add")
    public User createUser(@RequestBody User user){
        User savedUser = userservice.CreateUser(user);
        
        LOGGER.info("Data inserted successfully");
        return savedUser;
    }

	 @GetMapping("{id}")
	    public Optional<User> getUserById(@PathVariable int id){
	        Optional<User> user = userservice.getUserById(id);
	        LOGGER.info("Particular data viewed successfully");
	        return user;
	    }
	 
    
    @GetMapping
    public List<User> getAllUsers(){
        List<User> users = userservice.getAllUsers();
        LOGGER.info(" data viewed successfully");
        return users;
        
    }

    @PutMapping("{id}")

    public User updateUser(@PathVariable int id, @RequestBody User user){
        user.setId(id);
        User updatedUser = userservice.UpdateUser(user);
        LOGGER.info(" Data Updated successfully");
        return updatedUser;
    }

  
   @DeleteMapping("{id}")
    public String deleteUser(@PathVariable int id){
        userservice.DeleteUser(id);
        LOGGER.info(" Data Deleted  successfully");
        return "User successfully deleted!";
    }


    }



