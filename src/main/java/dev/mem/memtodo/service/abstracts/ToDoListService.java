package dev.mem.memtodo.service.abstracts;


import dev.mem.memtodo.model.ToDoList;
import dev.mem.memtodo.utilities.results.DataResult;
import dev.mem.memtodo.utilities.results.Result;

import java.util.List;

public interface ToDoListService {
    DataResult<ToDoList> getByToDoListId(int id);

    DataResult<ToDoList> getByName(String name);

    Result addToDoList(ToDoList toDoList);

    Result deleteById(int toDoListId);

    Result updateTodoList(int toDoListId, ToDoList toDoList);

    DataResult<List<ToDoList>> getAll();


}
