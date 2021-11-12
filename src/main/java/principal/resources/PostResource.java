package principal.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import principal.domain.Post;
import principal.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@GetMapping
	public ResponseEntity<List<Post>> findAll(){
		List<Post> posts = service.findAll();		
		return ResponseEntity.ok().body(posts);	
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);	
	}
//	
//	@PostMapping
//	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){
//		User user = service.fromDTO(objDto);
//		service.insert(user);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
//		return ResponseEntity.created(uri).build();
//	}
//	
//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<Void> deleteById(@PathVariable String id){
//		service.deleteById(id);
//		return ResponseEntity.noContent().build();
//	}
//	
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO objDto){
//		User user = service.fromDTO(objDto);
//		user.setId(id);
//		user = service.updateUser(user);
//		return ResponseEntity.noContent().build();
//	}
//
//	
//	@GetMapping(value = "/{id}/posts")
//	public ResponseEntity<List<Post>> returnPosts(@PathVariable String id){
//		User user = service.findById(id);
//		return ResponseEntity.ok().body(user.getPosts());	
//	}
	
}
