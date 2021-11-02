package principal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import principal.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>  {

}
