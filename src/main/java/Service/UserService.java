package Service;

import Model.User;
import Repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserRepository repository;
    @Autowired
    public UserService(UserRepository repository){this.repository=repository;}
    public User save(User user){return repository.save(user);}
    public List<User>findAll(){return repository.findAll();}
    public Optional<User>findById(int id){return repository.findById(id);}
}
