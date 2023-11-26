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
	@PostMapping("add")
    public User createUser(@RequestBody User user){
        User savedUser = userservice.CreateUser(user);
        
        LOGGER.info("Data inserted successfully");
        return savedUser;
    }
    // http://localhost:8080/api/users/1
	 @GetMapping("{id}")
	 public ResponseEntity<User> getUserById(@PathVariable int id) {
	        try {
	            Optional<User> user = userservice.getUserById(id);
	            LOGGER.info("Particular data viewed successfully");
	            return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                    .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
	        } catch (ResourceNotFoundException ex) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }


	
//    @GetMapping("{id}")
//    public Optional<User> getUserById(@PathVariable int id){
//      Optional<User> user = userservice.getUserById(id);
    	// Optional<User> user = userrepository.findById(id).orElseThrow(
//    	User user= userservice.findById(id).orElseThrow(
   // 			 ()-> new ResourceNotFoundException("data" id)
//    			 
    //			);
//        LOGGER.info("Particular data viewed successfully");
//        return user;
//    }

   
    // http://localhost:8080/api/users
    @GetMapping
    public List<User> getAllUsers(){
        List<User> users = userservice.getAllUsers();
        LOGGER.info(" data viewed successfully");
        return users;
        
    }
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        try {
            user.setId(id);
            User updatedUser = userservice.UpdateUser(user);
            LOGGER.info(" Data Updated successfully");
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            LOGGER.error("User not found with id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//     //Build Update User REST API
//    @PutMapping("{id}")
////     http://localhost:8080/api/users/1
//    public User updateUser(@PathVariable int id,
//                                           @RequestBody User user){
//        user.setId(id);
//        User updatedUser = userservice.UpdateUser(user);
//        LOGGER.info(" Data Updated successfully");
//        return updatedUser;
//    }

    // Build Delete User REST API
//   @DeleteMapping("{id}")
//    public String deleteUser(@PathVariable int id){
//        userservice.DeleteUser(id);
//        LOGGER.info(" Data Deleted  successfully");
//        return "User successfully deleted!";
//    }
//}
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        try {
            userservice.DeleteUser(id);
            LOGGER.info(" Data Deleted  successfully");
            return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            LOGGER.error("User not found with id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}



