package dev.mem.memtodo.service.abstracts;

import dev.mem.memtodo.dto.ToDoRequestDto;
import dev.mem.memtodo.model.ToDo;
import dev.mem.memtodo.utilities.results.DataResult;
import dev.mem.memtodo.utilities.results.Result;

import java.util.List;

public interface ToDoService {
    Result save(ToDoRequestDto toDoRequestDto);

    Result delete(int toDoId);

    DataResult<ToDo> getToDoByToDoId(int toDoId);

    DataResult<List<ToDo>> getAll();

    DataResult<List<ToDo>> getToDosByCategoryId(int categoryId);

    DataResult<List<ToDo>> getToDosByToDoListId(int toDoListId);

    DataResult<List<ToDo>> getToDosByToDoListIdAndCategoryId(int toDoListId, int categoryId);

    DataResult<List<ToDo>> getToDosByToDoListIdAndCategoryIdSortedPriorityAsc(int toDoListId, int categoryId);

    DataResult<List<ToDo>> getToDosByToDoListIdAndCategoryIdSortedPriorityDesc(int toDoListId, int categoryId);


}
