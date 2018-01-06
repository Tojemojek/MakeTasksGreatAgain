package pl.kostrowski.mtga.spring;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.kostrowski.mtga.MakeTasksGreatAgain.model.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SpringAnnotationConfig {

    @Bean(name = "branch")
    public Branch returnBranchWarsaw() {
        Branch branch = new Branch();

        branch.setName("Warszawa");
        branch.setId("286");

        return branch;
    }

    @Bean(name = "branchGdańsk")
    public Branch returnBranchGdansk() {
        Branch branch = new Branch();

        branch.setName("Gdańsk");
        branch.setId("299");

        return branch;
    }

    @Bean(name = {"salesman", "orderedBy"})
    public User returnJanusz() {
        User user = new User();

        user.setName("Janusz");
        user.setSurname("G");
        user.setRole("Handlowiec");

        return user;
    }

    @Bean(name = {"executedBy"})
    public User returnKrzysiek() {
        User user = new User();

        user.setName("Krzysztof");
        user.setSurname("O");
        user.setRole("Technik");

        return user;
    }

    @Bean(name = "customer")
    public Customer returnKarmar() {
        Customer customer = new Customer();

        customer.setName("Karmar");

        return customer;
    }


    @Bean(name = "KL3")
    public Task returnKL3() {

        Task task = new Task();
        return task;

    }

    @Bean(name = "KL4")
    public Task returnKL4() {

        Task task = new Task();
        return task;

    }


    @Bean(name = "tasks")
    public List<Task> returnTasks() {
        List<Task> tasks = new ArrayList<>();

        tasks.add(returnKL3());
        tasks.add(returnKL4());

        return tasks;
    }

    @Bean(name = "project")
    public Project returnProject(){
        Project project = new Project();

        project.setName("Nowa Stacja");
        project.setCustomer(returnKarmar());
        project.setBranch(returnBranchWarsaw());
        project.setTasks(returnTasks());
        project.setSalesman(returnJanusz());

        return project;
    }
}
