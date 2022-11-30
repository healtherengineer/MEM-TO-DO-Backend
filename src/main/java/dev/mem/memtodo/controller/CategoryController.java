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
    
    @GetMapping("getCategoryByCategoryId")
    public DataResult<Category> getCategoryByCategoryId(@RequestParam int id) {
        return this.categoryService.getCategoryByCategoryId(id);
    }

    @GetMapping("getCategoryByName")
    public DataResult<Category> getCategoryByName(@RequestParam String name) {
        return this.categoryService.getCategoryByName(name);
    }

    @PostMapping("save")
    public Result addCategory(@RequestBody Category category) {
        return this.categoryService.save(category);
    }

    @PostMapping("delete")
    public Result deleteById(@RequestParam int categoryId) {
        return this.categoryService.deleteById(categoryId);
    }

    @GetMapping("getAll")
    public DataResult<List<Category>> getAll() {
        return this.categoryService.getAll();
    }
}
