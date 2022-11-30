package dev.mem.memtodo.controller;

import dev.mem.memtodo.model.User;
import dev.mem.memtodo.service.abstracts.UserService;
import dev.mem.memtodo.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/users/")
public class UsersController  {
    @Autowired
    UserService userService;

    @GetMapping("getAll")
    public DataResult<List<User>> getAll() {
        return this.userService.getAll();
    }

    @GetMapping("getUserByUserId")
    public DataResult<User> getUserByUserId(@RequestParam int userId) {
        return this.userService.getUserByUserId(userId);
    }

    @GetMapping("getUserByUsername")
    public DataResult<User> getUserByUsername(@RequestParam String username) {
        return this.userService.getUserByUsername(username);
    }

    @GetMapping("getUserByEmail")
    public DataResult<User> getUserByEmail(@RequestParam String email) {
        return this.userService.getUserByEmail(email);
    }

    @PostMapping("updatePassword")
    public Result updatePassword(@RequestParam int userId,@RequestParam String oldPassword,@RequestParam String newPassword){
        return this.userService.updatePassword(userId,oldPassword,newPassword);
    }

    @PostMapping("delete")
    public Result delete(@RequestParam int userId) {
        return this.userService.delete(userId);
    }

    @PostMapping("save")
    public Result save(@RequestBody User user) {
        return this.userService.save(user);
    }
}
