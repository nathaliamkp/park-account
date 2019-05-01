package br.usp.parquecientec.account.controller;

import br.usp.parquecientec.account.model.User;
import br.usp.parquecientec.account.repository.UserRepository;
import br.usp.parquecientec.account.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import static java.util.Objects.nonNull;

@Controller
@RequestMapping(path = "/api/account/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping(path = "/user")
    public @ResponseBody
    User createUser(@RequestBody User user) {
        return userServiceImpl.save(user);
    }

    @GetMapping(path = "/user")
    public @ResponseBody
    Iterable<User> listUser() {
        return userRepository.findAll();
    }

    @PutMapping(path = "/user/{userCode}")
    public ResponseEntity<User> updateUser(@PathVariable Integer userCode, @RequestBody User user) {
        User updatedUser = userServiceImpl.update(userCode, user);
        if (nonNull(updatedUser)) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/user/{userCode}")
    public ResponseEntity<User> getUser(@PathVariable Integer userCode) {
        User getUser = userServiceImpl.getUser(userCode);
        if (nonNull(getUser)) {
            return new ResponseEntity<>(getUser, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping(path = "/user/{userCode}")
    public ResponseEntity<User> delete(@PathVariable Integer userCode) {
        User delete = userServiceImpl.delete(userCode);
        if (nonNull(delete)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


