package pl.kostrowski.mtga.springjpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kostrowski.mtga.model.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, String> {

}
