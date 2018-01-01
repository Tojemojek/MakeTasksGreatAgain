package pl.kostrowski.mtga.spring;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kostrowski.mtga.MakeTasksGreatAgain.model.Project;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class SpringAnnotationContextTest {

    @Test
    public void testXmlContext() {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "beans\\beans.xml");

        Project projectFromXml = (Project) context.getBean("nowaStacja");

        assertThat(projectFromXml.getName()).isEqualTo("Nowa Stacja");
        assertThat(projectFromXml.getBranch().getName()).isEqualTo("Warszawa");

        System.out.println(projectFromXml);

        ((ClassPathXmlApplicationContext) context).close();

    }

    LocalDateTime ld = LocalDateTime.parse("2017-11-15 12:22:11");



}
