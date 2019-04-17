package br.usp.parquecientec.account.controller;

import br.usp.parquecientec.account.model.User;
import br.usp.parquecientec.account.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/api/account/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/user")
    public  @ResponseBody User createUser(@RequestBody User user){
        User savedUser = userRepository.save(user);
        return savedUser;

    }

    @GetMapping(path = "/user")
    public  @ResponseBody
    Iterable<User> listUser(){
        Iterable<User> all = userRepository.findAll();
        return all;
    }

    @PutMapping(path = "/user/{userCode}")
    public ResponseEntity<User> updateUser(@PathVariable Integer userCode, @RequestBody User user) throws Exception {
        Optional<User> userOptional = userRepository.findById(userCode);
        if (userOptional.isPresent()) {
            User savedUser = userOptional.get();
            savedUser.setFirstName(user.getFirstName());
            userRepository.save(savedUser);
            return new ResponseEntity(savedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
