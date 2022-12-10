package dev.mem.memtodo.repository;

import dev.mem.memtodo.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
    ToDo getByToDoId(int toDoId);

    @Query("FROM ToDo t WHERE t.category.categoryId=:categoryId")
    List<ToDo> getToDosByCategoryId(int categoryId);

    @Query("FROM ToDo t WHERE t.toDoList.toDoListId=:toDoListId")
    List<ToDo> getToDosByToDoListId(int toDoListId);

    @Query("FROM ToDo t WHERE t.toDoList.toDoListId=:toDoListId AND t.category.categoryId=:categoryId")
    List<ToDo> getToDosByToDoListIdAndCategoryId(int toDoListId, int categoryId);

    @Query("FROM ToDo t WHERE t.toDoList.toDoListId=:toDoListId AND t.category.categoryId=:categoryId ORDER BY t.priority ASC")
    List<ToDo> getToDosByToDoListIdAndCategoryIdSortedPriorityAsc(int toDoListId, int categoryId);

    @Query("FROM ToDo t WHERE t.toDoList.toDoListId=:toDoListId AND t.category.categoryId=:categoryId ORDER BY t.priority DESC")
    List<ToDo> getToDosByToDoListIdAndCategoryIdSortedPriorityDesc(int toDoListId, int categoryId);
}
