package dev.mem.memtodo.service.abstracts;

import dev.mem.memtodo.dto.ToDoRequestDto;
import dev.mem.memtodo.utilities.results.Result;

public interface ToDoService {
    public Result save(ToDoRequestDto toDoRequestDto);
}
