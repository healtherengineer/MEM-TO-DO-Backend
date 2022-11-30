package dev.mem.memtodo.service.abstracts;

import dev.mem.memtodo.model.Category;
import dev.mem.memtodo.model.ToDo;
import dev.mem.memtodo.utilities.results.DataResult;
import dev.mem.memtodo.utilities.results.Result;

import java.util.List;

public interface CategoryService {

    DataResult<Category> getByCategoryId(int id);

    DataResult<Category> getByName(String name);

    Result addCategory(Category category);

    Result deleteById(int categoryId);

    Result updateCategory(int categoryId , Category category);

    DataResult<List<Category>> getAll();

    DataResult<List<ToDo>>  getTodosByCategoryId(int id);


}
