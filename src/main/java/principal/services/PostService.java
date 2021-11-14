package principal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import principal.domain.Post;
import principal.repository.PostRepository;
import principal.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public List<Post> findAll(){
		return repository.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Resource not found. Id: " + id));
	}
	
	public Post insert(Post obj) {
		return repository.insert(obj);
	}
	
	public void deleteById(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public List<Post> findByTitle (String text){
		return repository.findByTitleContainingIgnoreCase(text);
	}
	
}
