package dev.mem.memtodo.config;

import dev.mem.memtodo.utilities.hashCreator.HashCreator;
import org.springframework.security.crypto.password.PasswordEncoder;

public class IndigenousPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return HashCreator.create(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return HashCreator.create(rawPassword.toString()).equals(encodedPassword);
    }
}
