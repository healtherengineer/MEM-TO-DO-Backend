package dev.mem.memtodo.controller;

import dev.mem.memtodo.dto.ToDoRequestDto;
import dev.mem.memtodo.service.abstracts.ToDoService;
import dev.mem.memtodo.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
