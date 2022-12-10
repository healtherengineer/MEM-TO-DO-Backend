package dev.mem.memtodo.service.concretes;

import dev.mem.memtodo.config.IndigenousPasswordEncoder;
import dev.mem.memtodo.dto.LoginResponseDto;
import dev.mem.memtodo.model.User;
import dev.mem.memtodo.repository.UserRepository;
import dev.mem.memtodo.service.abstracts.AuthService;
import dev.mem.memtodo.service.abstracts.JwtUserDetailsService;
import dev.mem.memtodo.utilities.jwt.JwtTokenUtil;
import dev.mem.memtodo.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class AuthManager implements AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private IndigenousPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public DataResult<LoginResponseDto> login(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            return new ErrorDataResult<>(null, "Login Unsuccessful!");
        }

        final User user = userRepository.getByUsername(username);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = jwtTokenUtil.generateToken(userDetails);

        LoginResponseDto response = new LoginResponseDto(user.getUserId(), user.getUsername(), token);
        return new SuccessDataResult<>(response, "Login Successful!");
    }

    @Override
    public Result register(User user) {
        user.setUsername(user.getUsername().toLowerCase(Locale.ENGLISH));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return new SuccessResult("User Registered Successfully");
    }
}
