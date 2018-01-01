package pl.kostrowski.mtga.spring;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kostrowski.mtga.MakeTasksGreatAgain.model.Project;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class SpringAnnotationContextTest {

    @Test
    public void testAnnotationContext() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);

        Project projectFromBeans = (Project)ctx.getBean("project");

        assertThat(projectFromBeans.getName()).isEqualTo("Nowa Stacja");
        assertThat(projectFromBeans.getBranch().getName()).isEqualTo("Warszawa");

    }

}
