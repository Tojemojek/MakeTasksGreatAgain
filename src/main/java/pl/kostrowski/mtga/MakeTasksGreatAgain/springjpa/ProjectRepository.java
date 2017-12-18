package pl.kostrowski.mtga.MakeTasksGreatAgain.springjpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kostrowski.mtga.MakeTasksGreatAgain.model.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, String> {

}
