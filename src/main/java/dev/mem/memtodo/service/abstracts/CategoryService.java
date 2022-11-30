package dev.mem.memtodo.service.abstracts;

import dev.mem.memtodo.model.Category;
import dev.mem.memtodo.model.ToDo;
import dev.mem.memtodo.utilities.results.DataResult;
import dev.mem.memtodo.utilities.results.Result;

import java.util.List;

public interface CategoryService {

    DataResult<Category> getCategoryByCategoryId(int id);

    DataResult<Category> getCategoryByName(String name);

    Result save(Category category);

    Result deleteById(int categoryId);

    DataResult<List<Category>> getAll();
}
