package pl.kostrowski.mtga.springjpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kostrowski.mtga.model.Customer;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRespository customerRespository;

    @Test
    public void shouldAddAndfindByCustomerName() {

        Customer testCustomer1 = new Customer();
        testCustomer1.setName("Jan");

        Customer testCustomer2 = new Customer();
        testCustomer2.setName("Jan");

        customerRespository.save(testCustomer1);
        customerRespository.save(testCustomer2);

        Customer foundCustomer = customerRespository.findFirstByName("Jan");

        List<Customer> foundCustomers = customerRespository.findAllByName("Jan");

        assertThat(foundCustomers.size()).isEqualTo(2);

        assertThat(foundCustomer.getId()).isBetween(1,2);

    }
}