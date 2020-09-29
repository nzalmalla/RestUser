package Controller;

import Model.User;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserService service;
    @Autowired
    public UserController(UserService service){ this.service=service;}

    @GetMapping("/user")
    public List<User>getAllUser(){return service.findAll();}

    @GetMapping("/user/{id}")
    public Optional<User>getById(@PathVariable int id){return service.findById(id);}

    @PostMapping("/user")
    public User save(@RequestBody User user){return service.save(user);}

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return "login";
}
