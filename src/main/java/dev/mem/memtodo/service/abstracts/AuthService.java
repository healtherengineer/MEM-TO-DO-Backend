package dev.mem.memtodo.service.abstracts;

import dev.mem.memtodo.dto.LoginResponseDto;
import dev.mem.memtodo.model.User;
import dev.mem.memtodo.utilities.results.DataResult;
import dev.mem.memtodo.utilities.results.Result;

public interface AuthService {
    DataResult<LoginResponseDto> login(String username, String password);

    Result register(User user);
}
