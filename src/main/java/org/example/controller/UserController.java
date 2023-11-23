package org.example.controller;
import model.User;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/users")

public class UserController {
    @GetMapping
    public String hello(){
        return "hola muchachos";
    }
    public User createUser(@RequestBody User User){
        return User;
    }
    @PutMapping("/{id")
    public  User updateUser(@PathVariable String id, @RequestBody User user){
        return  user;
    }
    @DeleteMapping("/{id")
    public void deleteUser(@PathVariable String id){

    }
}
