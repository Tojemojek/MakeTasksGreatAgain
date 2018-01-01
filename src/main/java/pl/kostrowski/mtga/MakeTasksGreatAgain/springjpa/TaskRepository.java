package pl.kostrowski.mtga.MakeTasksGreatAgain.springjpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kostrowski.mtga.MakeTasksGreatAgain.model.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, String> {

}
