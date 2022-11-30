package dev.mem.memtodo.service.concretes;

import dev.mem.memtodo.model.Category;
import dev.mem.memtodo.model.ToDo;
import dev.mem.memtodo.repository.CategoryRepository;
import dev.mem.memtodo.service.abstracts.CategoryService;
import dev.mem.memtodo.utilities.results.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryManager implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public DataResult<Category> getByCategoryId(int id) {

        Category category = this.categoryRepository.getByCategoryId(id);
        if (category != null) {
            return new SuccessDataResult<>(category);
        } else {

            return new ErrorDataResult<>(null, "Category is not found with this categoryId .");
        }

    }

    @Override
    public DataResult<Category> getByName(String name) {

        Category category = this.categoryRepository.getByName(name);
        if (category != null) {
            return new SuccessDataResult<>(category);
        } else {
            return new ErrorDataResult<>(null, "Category is not found with this name.");
        }


    }

    @Override
    public Result addCategory(Category category) {
        this.categoryRepository.save(category);
        return new SuccessResult("Category saved succesfully.");
    }

    @Override
    public Result deleteById(int categoryId) {

        this.categoryRepository.deleteById(categoryId);
        return new SuccessResult("Category deleted succesfully.");

    }

    @Override
    public Result updateCategory(int categoryId, Category category) {
        Category categoryOld = this.categoryRepository.getByCategoryId(categoryId);
        if (categoryOld != null) {
            category.setCategoryId(categoryOld.getCategoryId());
            this.categoryRepository.save(category);
            return new SuccessResult("Category updated succesfully.");
        } else {
            return new ErrorResult("Category was not updated.");
        }

    }

    @Override
    public DataResult<List<Category>> getAll() {
        return new SuccessDataResult<>(this.categoryRepository.findAll());
    }

    @Override
    public DataResult<List<ToDo>> getTodosByCategoryId(int id) {

        List<ToDo> todoList = this.categoryRepository.getTodosByCategoryId(id);
        if (!todoList.isEmpty()) {
            return new SuccessDataResult<>(todoList);
        } else {
            return new ErrorDataResult<>(todoList, "TodosList is empty!");
        }
    }
}
