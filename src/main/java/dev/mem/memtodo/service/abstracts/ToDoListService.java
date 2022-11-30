package dev.mem.memtodo.service.abstracts;


import dev.mem.memtodo.dto.ToDoListRequestDto;
import dev.mem.memtodo.model.ToDoList;
import dev.mem.memtodo.utilities.results.DataResult;
import dev.mem.memtodo.utilities.results.Result;

import java.util.List;

public interface ToDoListService {
    DataResult<ToDoList> getToDoListByToDoListId(int id);

    DataResult<ToDoList> getToDoListByName(String name);

    Result save(ToDoListRequestDto ToDoListRequestDto);

    Result deleteById(int toDoListId);

    DataResult<List<ToDoList>> getAll();

}
