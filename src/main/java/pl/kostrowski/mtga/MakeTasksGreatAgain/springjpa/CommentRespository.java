package pl.kostrowski.mtga.MakeTasksGreatAgain.springjpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kostrowski.mtga.MakeTasksGreatAgain.model.Comment;


@Repository
public interface CommentRespository extends CrudRepository<Comment, Integer> {

}
