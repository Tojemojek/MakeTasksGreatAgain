package pl.kostrowski.mtga.springjpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kostrowski.mtga.model.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, String> {

}
