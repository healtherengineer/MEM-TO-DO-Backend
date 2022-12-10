package dev.mem.memtodo.controller;

import dev.mem.memtodo.dto.ToDoRequestDto;
import dev.mem.memtodo.model.ToDo;
import dev.mem.memtodo.model.User;
import dev.mem.memtodo.service.abstracts.ToDoService;
import dev.mem.memtodo.utilities.results.DataResult;
import dev.mem.memtodo.utilities.results.Result;
import dev.mem.memtodo.utilities.results.SuccessDataResult;
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

    @PostMapping("delete")
    public Result delete(@RequestParam int toDoId) {
        return this.toDoService.delete(toDoId);
    }

    @GetMapping("getAll")
    public DataResult<List<ToDo>> getAll() {
        return this.toDoService.getAll();
    }

    @GetMapping("getToDoByToDoId")
    public DataResult<ToDo> getToDoByToDoId(@RequestParam int toDoId) {
        return this.toDoService.getToDoByToDoId(toDoId);
    }

    @GetMapping("getToDosByCategoryId")
    public DataResult<List<ToDo>> getToDosByCategoryId(@RequestParam int categoryId) {
        return this.toDoService.getToDosByCategoryId(categoryId);
    }

    @GetMapping("getToDosByToDoListId")
    public DataResult<List<ToDo>> getToDosByToDoListId(@RequestParam int toDoListId) {
        return this.toDoService.getToDosByToDoListId(toDoListId);
    }

    @GetMapping("getToDosByToDoListIdAndCategoryId")
    public DataResult<List<ToDo>> getToDosByToDoListIdAndCategoryId(@RequestParam int toDoListId, @RequestParam int categoryId) {
        return this.toDoService.getToDosByToDoListIdAndCategoryId(toDoListId, categoryId);
    }

    @GetMapping("getToDosByToDoListIdAndCategoryIdSortedPriorityAsc")
    public DataResult<List<ToDo>> getToDosByToDoListIdAndCategoryIdSortedPriorityAsc(@RequestParam int toDoListId, @RequestParam int categoryId) {
        return this.toDoService.getToDosByToDoListIdAndCategoryIdSortedPriorityAsc(toDoListId, categoryId);
    }

    @GetMapping("getToDosByToDoListIdAndCategoryIdSortedPriorityDesc")
    public DataResult<List<ToDo>> getToDosByToDoListIdAndCategoryIdSortedPriorityDesc(@RequestParam int toDoListId, @RequestParam int categoryId) {
        return this.toDoService.getToDosByToDoListIdAndCategoryIdSortedPriorityDesc(toDoListId, categoryId);
    }
}
