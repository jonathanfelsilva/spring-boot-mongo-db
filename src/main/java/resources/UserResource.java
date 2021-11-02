package resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User jonathan = new User("2", "Jonathan Silva", "jonathan@gmail.com");
		
		List<User> users = new ArrayList<>();
		
		users.addAll(Arrays.asList(jonathan, maria));
		
		return ResponseEntity.ok().body(users);	
	}

	
}
