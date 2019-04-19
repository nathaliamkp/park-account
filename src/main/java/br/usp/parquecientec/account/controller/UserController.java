package br.usp.parquecientec.account.controller;

import br.usp.parquecientec.account.model.User;
import br.usp.parquecientec.account.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/api/account/v1")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "/user")
    public @ResponseBody
    User createUser(@RequestBody User user) {
        return userRepository.save(user);

    }

    @GetMapping(path = "/user")
    public @ResponseBody
    Iterable<User> listUser() {
        return userRepository.findAll();
    }

    @PutMapping(path = "/user/{userCode}")
    public ResponseEntity<User> updateUser(@PathVariable Integer userCode, @RequestBody User user) {
        Optional<User> userOptional = userRepository.findById(userCode);
        if (userOptional.isPresent()) {
            User savedUser = userOptional.get();
            savedUser.setFirstName(user.getFirstName());
            userRepository.save(savedUser);
            return new ResponseEntity<>(savedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/user/{userCode}")
    public ResponseEntity<User> getUser(@PathVariable Integer userCode) {
        Optional<User> userOptional = userRepository.findById(userCode);
        if (userOptional.isPresent()) {
            User getUser = userOptional.get();
            return new ResponseEntity<>(getUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

