package dev.mem.memtodo.repository;

import dev.mem.memtodo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User getByUserId(int userId);

    User getByUsername(String username);

    User getByEmail(String email);
}
