package br.usp.parquecientec.account.controller;

import br.usp.parquecientec.account.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/account/v1")
public class UserController {

    @PostMapping(path = "/user")
    public  @ResponseBody User createUser(@RequestBody User user){
        return user;
    }

    @GetMapping(path = "/user")
    public  @ResponseBody User listUser(){
        return new User();
    }
    
}
