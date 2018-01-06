package pl.kostrowski.mtga.spring;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kostrowski.mtga.MakeTasksGreatAgain.model.Project;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class SpringXmlContextTest {

    @Test
    public void testXmlContext() {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "beans\\beans.xml");

        Project projectFromXml = (Project) context.getBean("nowaStacja");

        assertThat(projectFromXml.getName()).isEqualTo("Nowa Stacja");
        assertThat(projectFromXml.getBranch().getName()).isEqualTo("Warszawa");

        ((ClassPathXmlApplicationContext) context).close();

    }


}
