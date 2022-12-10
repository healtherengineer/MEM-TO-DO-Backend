package dev.mem.memtodo.controller;

import dev.mem.memtodo.dto.ToDoListRequestDto;
import dev.mem.memtodo.model.ToDoList;
import dev.mem.memtodo.service.abstracts.ToDoListService;
import dev.mem.memtodo.utilities.results.DataResult;
import dev.mem.memtodo.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/todoLists/")
public class ToDoListController {

    @Autowired
    private ToDoListService toDoListService;

    @GetMapping("getToDoListByToDoListId")
    public DataResult<ToDoList> getToDoListByToDoListId(@RequestParam int id) {
        return this.toDoListService.getToDoListByToDoListId(id);
    }

    @GetMapping("getToDoListByName")
    public DataResult<ToDoList> getByName(@RequestParam String name) {
        return this.toDoListService.getToDoListByName(name);
    }

    @GetMapping("getToDoListsByUserId")
    public DataResult<List<ToDoList>> getToDoListsByUserId(@RequestParam int userId) {
        return this.toDoListService.getToDoListsByUserId(userId);
    }

    @PostMapping("save")
    public Result addToDoList(@RequestBody ToDoListRequestDto ToDoListRequestDto) {
        return this.toDoListService.save(ToDoListRequestDto);
    }

    @PostMapping("delete")
    public Result deleteById(@RequestParam int toDoListId) {
        return this.toDoListService.deleteById(toDoListId);
    }

    @GetMapping("getAll")
    public DataResult<List<ToDoList>> getAll() {
        return this.toDoListService.getAll();
    }
}
