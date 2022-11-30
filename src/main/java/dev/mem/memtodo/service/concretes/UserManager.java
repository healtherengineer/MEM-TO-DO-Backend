package dev.mem.memtodo.service.concretes;

import dev.mem.memtodo.model.User;
import dev.mem.memtodo.repository.UserRepository;
import dev.mem.memtodo.service.abstracts.UserService;
import dev.mem.memtodo.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class UserManager implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Result save(User user) {
        User oldUser = userRepository.getByUserId(user.getUserId());
        user.setUsername(user.getUsername().toLowerCase(Locale.ENGLISH));
        if (oldUser != null) {
            user.setCreatedAt(oldUser.getCreatedAt());
        }
        try {
            this.userRepository.save(user);
            return new SuccessResult("User saved successfully");
        } catch (Exception e) {
            return new ErrorResult("Error user not saved! => " + e.getMessage());
        }
    }

    @Override
    public Result updatePassword(int userId, String oldPassword, String newPassword) {
        // HASH EKLENECEK
        User user = userRepository.getByUserId(userId);

        if (user != null) {
            if (user.getPassword().equals(oldPassword)) {
                user.setPassword(newPassword);
                try {
                    this.userRepository.save(user);
                    return new SuccessResult("User password updated successfully!");
                } catch (Exception e) {
                    return new ErrorResult("Error user not saved! => " + e.getMessage());
                }
            } else {
                return new ErrorResult("User old password is not correct!");
            }
        } else {
            return new ErrorResult("User Not Found!");
        }
    }

    @Override
    public Result delete(int userId) {
        User user = userRepository.getByUserId(userId);
        if (user != null) {
            this.userRepository.delete(user);
            return new SuccessResult("User deleted successfully!");
        } else {
            return new ErrorResult("User not found!");
        }
    }

    @Override
    public Result delete(User user) {
        User tempUser = userRepository.getByUserId(user.getUserId());
        if (tempUser != null) {
            this.userRepository.delete(tempUser);
            return new SuccessResult("User deleted successfully!");
        } else {
            return new ErrorResult("User not found!");
        }
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<>(this.userRepository.findAll(), "All users fetched!");
    }

    @Override
    public DataResult<User> getUserByUserId(int userId) {
        User user = userRepository.getByUserId(userId);
        if (user != null) {
            return new SuccessDataResult<>(user, "User fetched successfully!");
        } else {
            return new ErrorDataResult<>(null, "User not found!");
        }
    }

    @Override
    public DataResult<User> getUserByUsername(String username) {
        User user = userRepository.getByUsername(username);
        if (user != null) {
            return new SuccessDataResult<>(user, "User fetched successfully!");
        } else {
            return new ErrorDataResult<>(null, "User not found!");
        }
    }

    @Override
    public DataResult<User> getUserByEmail(String email) {
        User user = userRepository.getByEmail(email);
        if (user != null) {
            return new SuccessDataResult<>(user, "User fetched successfully!");
        } else {
            return new ErrorDataResult<>(null, "User not found!");
        }
    }
}
