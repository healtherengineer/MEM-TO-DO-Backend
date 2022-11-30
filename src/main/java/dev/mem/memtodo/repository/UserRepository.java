package dev.mem.memtodo.repository;

import dev.mem.memtodo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getByUserId(int userId);

    User getByUsername(String username);

    User getByEmail(String email);
}
