package pl.kostrowski.mtga.MakeTasksGreatAgain;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kostrowski.mtga.MakeTasksGreatAgain.model.Branch;
import pl.kostrowski.mtga.MakeTasksGreatAgain.springjpa.BranchRespository;


@RunWith(SpringRunner.class)
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

        System.out.println(branchRespository.findByName("Warszawa"));



    }

}
