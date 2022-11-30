package dev.mem.memtodo.controller;

import dev.mem.memtodo.dto.ToDoRequestDto;
import dev.mem.memtodo.model.ToDo;
import dev.mem.memtodo.model.User;
import dev.mem.memtodo.service.abstracts.ToDoService;
import dev.mem.memtodo.utilities.results.DataResult;
import dev.mem.memtodo.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/todos/")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @PostMapping("save")
    public Result save(@RequestBody ToDoRequestDto toDoRequestDto) {
        return this.toDoService.save(toDoRequestDto);
    }

    @GetMapping("getAll")
    public DataResult<List<ToDo>> getAll() {
        return this.toDoService.getAll();
    }
}
