package principal.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import principal.domain.Post;
import principal.dto.AuthorDTO;
import principal.dto.CommentDTO;
import principal.repository.PostRepository;
import principal.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	@Autowired
	private UserService userService;
	
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
	
	public Post updatePost(Post obj) {
		Post newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public void updateData(Post newObj, Post obj) {
		newObj.setBody(obj.getBody());
		newObj.setDate(obj.getDate());
		newObj.setTitle(obj.getTitle());
	}
	
	public List<Post> findByTitle (String text){
		return repository.findByTitleComArrobaQuery(text);
	}
	
	public List<Post> fullSearch (String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repository.fullSearch(text, minDate, maxDate);
	}
	
	public Post insertComment(String idPost, String idAuthor, CommentDTO comment) {
		Post post = findById(idPost);
		AuthorDTO author = new AuthorDTO(userService.findById(idAuthor));
		
		comment.setAuthor(author);
		
		post.getComments().add(comment);
		return repository.save(post);
	}
	
}
