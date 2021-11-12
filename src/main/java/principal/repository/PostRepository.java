package principal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import principal.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>  {

}
