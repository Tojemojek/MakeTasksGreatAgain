package pl.kostrowski.mtga.springjpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kostrowski.mtga.model.Customer;

import java.util.List;

@Repository
public interface CustomerRespository extends CrudRepository<Customer, Integer> {
    public Customer findFirstByName(String name);
    public List<Customer> findAllByName(String name);

}
