package principal.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import principal.domain.Post;
import principal.dto.CommentDTO;
import principal.services.PostService;

@RestController
@RequestMapping(value = "/comments")
public class CommentResource {
	
	@Autowired
	private PostService postService;
	
	@GetMapping
	public ResponseEntity<List<CommentDTO>> findAll(){
		List<Post> posts = postService.findAll();		
		List<CommentDTO> comments = new ArrayList<CommentDTO>();
		
		for (Post p : posts) {
			comments.addAll(p.getComments());
		}
				
		return ResponseEntity.ok().body(comments);	
	}

	@GetMapping(value = "/post")
	public ResponseEntity<List<CommentDTO>> findCommentsByPostId(@RequestParam(value="postId", defaultValue="") String id){
		Post obj = postService.findById(id);
		List<CommentDTO> comments = obj.getComments();		                                           
		return ResponseEntity.ok().body(comments);	
	}
		
}
