package dev.mem.memtodo.controller;

import dev.mem.memtodo.dto.LoginRequestDto;
import dev.mem.memtodo.dto.LoginResponseDto;
import dev.mem.memtodo.model.User;
import dev.mem.memtodo.service.abstracts.AuthService;
import dev.mem.memtodo.utilities.results.DataResult;
import dev.mem.memtodo.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/auth/")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public DataResult<LoginResponseDto> userLogin(@RequestBody LoginRequestDto loginRequestDto) {
        return this.authService.login(loginRequestDto.getUsername(), loginRequestDto.getPassword());
    }

    @PostMapping("register")
    public Result userRegister(@RequestBody User user) {
        return this.authService.register(user);
    }
}
