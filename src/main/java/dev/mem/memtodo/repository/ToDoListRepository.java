package dev.mem.memtodo.repository;

import dev.mem.memtodo.model.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Integer> {

    ToDoList getByToDoListId(int toDoListId);

    ToDoList getByName(String name);

    @Query("FROM ToDoList t WHERE t.user.userId=:userId")
    List<ToDoList> getToDoListsByUserId(int userId);
}
