package pl.kostrowski.mtga.MakeTasksGreatAgain.springjpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kostrowski.mtga.MakeTasksGreatAgain.model.User;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldAddAndfindByNameAndSurname() {

        User testUser1 = new User();
        testUser1.setName("Jan");
        testUser1.setSurname("Kowalski");
        testUser1.setRole("uberMaster");

        userRepository.save(testUser1);

        User resultUser1 = userRepository.findByNameAndSurname("Jan", "Kowalski");

        User resultUser2 = userRepository.findByNameAndSurname("jan", "kowalski");

        assertThat(resultUser1.getId()).isNotNull();
        assertThat(resultUser2).isNull();

        assertThat(resultUser1.getName()).isNotEmpty()
                .isEqualTo("Jan");
        assertThat(resultUser1.getSurname()).isNotEmpty()
                .isEqualTo("Kowalski");
        assertThat(resultUser1.getRole()).isNotEmpty()
                .isEqualTo("uberMaster");
    }
}