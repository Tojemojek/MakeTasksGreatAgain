package pl.kostrowski.mtga.MakeTasksGreatAgain.springjpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.kostrowski.mtga.MakeTasksGreatAgain.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByNameAndSurname(String name, String Surname);

}
