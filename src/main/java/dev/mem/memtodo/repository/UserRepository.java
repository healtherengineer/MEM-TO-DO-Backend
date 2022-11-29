package dev.mem.memtodo.repository;

import dev.mem.memtodo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
