package dev.mem.memtodo.controller;

import dev.mem.memtodo.model.Category;
import dev.mem.memtodo.model.ToDo;
import dev.mem.memtodo.service.abstracts.CategoryService;
import dev.mem.memtodo.utilities.results.DataResult;
import dev.mem.memtodo.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/categories/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("hi")
    public String hello() {
        return "Welcome to MEM Todo Project";
    }


    @GetMapping("getByCategoryId")
    public DataResult<Category> getByCategoryId(@RequestParam int id) {
        return this.categoryService.getByCategoryId(id);
    }

    @GetMapping("getByName")
    public DataResult<Category> getByName(@RequestParam String name) {
        return this.categoryService.getByName(name);
    }

    @PostMapping("save")
    public Result addCategory(@RequestBody Category category) {
        return this.categoryService.addCategory(category);
    }

    @PostMapping("delete")
    public Result deleteById(@RequestParam int categoryId) {
        return this.categoryService.deleteById(categoryId);
    }

    @PostMapping("update")
    public Result updateCategory(@RequestParam int categoryId, @RequestBody Category category) {

        return this.categoryService.updateCategory(categoryId, category);
    }

    @GetMapping("getAll")
    public DataResult<List<Category>> getAll() {
        return this.categoryService.getAll();
    }

    @GetMapping("getTodosByCategoryId")
    public DataResult<List<ToDo>> getTodosByCategoryId(int id) {
        return this.categoryService.getTodosByCategoryId(id);
    }

}
