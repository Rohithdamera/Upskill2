package crud.springbootcrud.entitytest;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
 
import crud.springbootcrud.entity.User;
 
class UserTest {
 
	 private User user;
 
	    @BeforeEach
	    public void setUp() {
	        user = new User(1, "Rohith", 25);
	    }
 
	    @Test
	    public void testGetId() {
	        assertEquals(1, user.getId());
	    }
 
	    @Test
	    public void testSetId() {
	        user.setId(2);
	        assertEquals(2, user.getId());
	    }
 
	    @Test
	    public void testGetName() {
	        assertEquals("Rohith", user.getName());
	    }
 
	    @Test
	    public void testSetName() {
	        user.setName("Rohith");
	        assertEquals("Rohith", user.getName());
	    }
 
	    @Test
	    public void testGetAge() {
	        assertEquals(25, user.getAge());
	    }
 
	    @Test
	    public void testSetAge() {
	        user.setAge(30);
	        assertEquals(30, user.getAge());
	    }
 
	    @Test
	    public void testParameterizedConstructor() {
	        User newUser = new User(3, "chinna", 28);
	        assertEquals(3, newUser.getId());
	        assertEquals("chinna", newUser.getName());
	        assertEquals(28, newUser.getAge());
	    }
 
	    @Test
	    public void testDefaultConstructor() {
	        User newUser = new User();
	        assertNull(newUser.getName());
	        assertEquals(0, newUser.getId());
	        assertEquals(0, newUser.getAge());
	    }
 
		/*
		 * @Test public void testEquals() { User newUser1 = new User(1, "John Doe", 25);
		 * User newUser2 = new User(2, "Ron Doe", 25);
		 * assertTrue(newUser1.equals(newUser2) && newUser2.equals(newUser1));
		 * assertTrue(newUser1.hashCode() == newUser2.hashCode()); }
		 */
	    
	    @Test
	    public void testNotEquals() {
	        User newUser = new User(2, "Rohith", 30);
	        assertFalse(user.equals(newUser) || newUser.equals(user));
	    }
}