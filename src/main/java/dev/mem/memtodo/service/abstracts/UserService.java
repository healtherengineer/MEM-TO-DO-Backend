package dev.mem.memtodo.service.abstracts;

import dev.mem.memtodo.model.User;
import dev.mem.memtodo.utilities.results.DataResult;
import dev.mem.memtodo.utilities.results.Result;

import java.util.List;

public interface UserService {
    Result save(User user);

    Result updatePassword(int userId, String oldPassword, String newPassword);

    Result delete(int userId);

    Result delete(User user);

    DataResult<List<User>> getAll();

    DataResult<User> getUserByUserId(int userId);

    DataResult<User> getUserByUsername(String username);
    DataResult<User> getUserByEmail(String email);
}
