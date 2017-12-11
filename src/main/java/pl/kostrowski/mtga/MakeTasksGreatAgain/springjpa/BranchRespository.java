package pl.kostrowski.mtga.MakeTasksGreatAgain.springjpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kostrowski.mtga.MakeTasksGreatAgain.model.Branch;

@Repository
public interface BranchRespository extends CrudRepository<Branch, String> {
    public Branch findByName(String searchedName);
}
