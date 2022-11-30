package dev.mem.memtodo.controller;

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

    @GetMapping("getByToDoListId")
    public DataResult<ToDoList> getByToDoListId(@RequestParam int id) {
        return this.toDoListService.getByToDoListId(id);
    }

    @GetMapping("getByName")
    public DataResult<ToDoList> getByName(@RequestParam String name) {

        return this.toDoListService.getByName(name);
    }

    @PostMapping("save")
    public Result addToDoList(@RequestBody ToDoList toDoList) {

        return this.toDoListService.addToDoList(toDoList);
    }

    @PostMapping("delete")
    public Result deleteById(@RequestParam int toDoListId) {
        return this.toDoListService.deleteById(toDoListId);
    }

    @PostMapping("update")
    public Result updateTodoList(@RequestParam int toDoListId, @RequestBody ToDoList toDoList) {

        return this.toDoListService.updateTodoList(toDoListId, toDoList);
    }

    @GetMapping("getAll")
    public DataResult<List<ToDoList>> getAll() {

        return this.toDoListService.getAll();
    }


}
