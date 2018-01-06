package pl.kostrowski.mtga.springjpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kostrowski.mtga.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByNameAndSurname(String name, String Surname);

}
