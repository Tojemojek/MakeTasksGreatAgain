package pl.kostrowski.mtga.springjpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kostrowski.mtga.model.Comment;


@Repository
public interface CommentRespository extends CrudRepository<Comment, Integer> {

}
