package dev.mem.memtodo.repository;

import dev.mem.memtodo.model.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Integer> {

    ToDoList getByToDoListId(int toDoListId);

    ToDoList getByName(String name);


}
