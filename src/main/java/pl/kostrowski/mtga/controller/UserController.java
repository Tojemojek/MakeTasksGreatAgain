package pl.kostrowski.mtga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.kostrowski.mtga.model.User;
import pl.kostrowski.mtga.springjpa.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String displayUsers() {
        return "index";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String displayUsers(Model model) {
        model.addAttribute("user", new User());
        return "userEdit";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String saveNewUser(User user) {
        userRepository.save(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String saveNewUser(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    @RequestMapping(value = "/users/edit/{id}", method = RequestMethod.GET)
    public String updateUser(Model model, @PathVariable(name="id") Integer id) {
        model.addAttribute("user", userRepository.findOne(id));
        return "userEdit";
    }

    @RequestMapping(value = "/users/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable(name="id") Integer id) {
        userRepository.delete(id);
        return "redirect:/";
    }


}


