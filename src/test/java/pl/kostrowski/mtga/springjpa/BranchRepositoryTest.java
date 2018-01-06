package pl.kostrowski.mtga.springjpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kostrowski.mtga.model.Branch;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class BranchRepositoryTest {

    @Autowired
    private BranchRespository branchRespository;

    @Test
    public void shouldAddBranches() {
        Branch b1 = new Branch();
        b1.setId("286");
        b1.setName("Warszawa");

        Branch b2 = new Branch();
        b2.setId("299");
        b2.setName("Gdańsk");

        branchRespository.save(b1);
        branchRespository.save(b2);

        Branch testBranch = branchRespository.findByName("Warszawa");

        assertThat(testBranch.getName()).isNotEmpty()
                .isEqualTo("Warszawa")
                .isNotEqualTo("Gdańsk");

        assertThat(testBranch.getId()).isNotEmpty()
                .isEqualTo("286")
                .isNotEqualTo("299");
    }

}
