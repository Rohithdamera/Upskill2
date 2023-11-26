package crud.springbootcrud.entitytest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
 
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
 
import crud.springbootcrud.entity.User;
import crud.springbootcrud.repository.UserRepository;
import crud.springbootcrud.service.UserServiceImpl;


public class ServiceTest {
	
	@Mock
    private UserRepository userRepository;
 
    @InjectMocks
    private UserServiceImpl userService;
 
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
 
    @Test
    public void testCreateUser() {
    	User studentToCreate = new User(1, "Rohith", 25);
        when(userRepository.save(studentToCreate)).thenReturn(studentToCreate);
 
        User createdStudent = userService.CreateUser(studentToCreate);
 
        assertEquals(studentToCreate, createdStudent);
        verify(userRepository, times(1)).save(studentToCreate);
    }
 
    @Test
    public void testGetUserById() {
        User existingStudent = new User(1, "Rohith", 25);
        when(userRepository.findById(1)).thenReturn(Optional.of(existingStudent));
 
        Optional<User> retrievedStudent = userService.getUserById(1);
 
        assertTrue(retrievedStudent.isPresent());
        assertEquals(existingStudent, retrievedStudent.get());
        verify(userRepository, times(1)).findById(1);
    }
 
    @Test
    public void testGetAllUser() {
    	User user1 = new User(1, "Rohith", 25);
    	User user2 = new User(2, "Rohith", 30);
 
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));
 
        List<User> retrievedStudents = userService.getAllUsers();
 
        assertEquals(2, retrievedStudents.size());
        assertEquals(user1, retrievedStudents.get(0));
        assertEquals(user2, retrievedStudents.get(1));
        verify(userRepository, times(1)).findAll();
    }
 
	  @Test
	  public void testUpdateUser() {
		  User existingUser = new User(1,"Rohith", 25);
		  User updatedUser = new User(1, "Updated Rohith", 30);
	  when(userRepository.findById(1)).thenReturn(Optional.of(existingUser));
	  when(userRepository.save(updatedUser)).thenReturn(updatedUser);
	  User resultUser = userService.UpdateUser(updatedUser);
	  assertEquals(updatedUser, resultUser);
	  verify(userRepository,times(1)).findById(1);
	  verify(userRepository, times(1)).save(updatedUser); }
	  
      @Test
      public void testDeleteUser() {
    	User existingStudent = new User(1, "Rohith", 25);
        when(userRepository.findById(1)).thenReturn(Optional.of(existingStudent));
 
        userService.DeleteUser(1);
 
        verify(userRepository, times(1)).findById(1);
        verify(userRepository, times(1)).deleteById(1);
    }
}
 
