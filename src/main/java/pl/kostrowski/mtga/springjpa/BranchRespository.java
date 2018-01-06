package pl.kostrowski.mtga.springjpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kostrowski.mtga.model.Branch;


@Repository
public interface BranchRespository extends CrudRepository<Branch, String> {
    public Branch findByName(String searchedName);
}
