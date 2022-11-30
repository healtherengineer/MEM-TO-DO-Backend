package dev.mem.memtodo.service.concretes;

import dev.mem.memtodo.model.Category;
import dev.mem.memtodo.repository.CategoryRepository;
import dev.mem.memtodo.service.abstracts.CategoryService;
import dev.mem.memtodo.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public DataResult<Category> getCategoryByCategoryId(int id) {
        Category category = this.categoryRepository.getByCategoryId(id);
        if (category != null) {
            return new SuccessDataResult<>(category,"Category fetched!");
        } else {
            return new ErrorDataResult<>(null, "Category is not found with this categoryId .");
        }

    }

    @Override
    public DataResult<Category> getCategoryByName(String name) {
        Category category = this.categoryRepository.getByName(name);
        if (category != null) {
            return new SuccessDataResult<>(category,"Category fetched");
        } else {
            return new ErrorDataResult<>(null, "Category is not found with this name.");
        }
    }

    @Override
    public Result save(Category category) {
        Category oldCategory = categoryRepository.getByCategoryId(category.getCategoryId());
        if (oldCategory != null) {
            category.setCreatedAt(oldCategory.getCreatedAt());
        }

        try {
            this.categoryRepository.save(category);
            return new SuccessResult("Category saved successfully");
        } catch (Exception e) {
            return new ErrorResult("Error Category not saved! => " + e.getMessage());
        }
    }

    @Override
    public Result deleteById(int categoryId) {
        Category category = categoryRepository.getByCategoryId(categoryId);
        if (category != null) {
            this.categoryRepository.delete(category);
            return new SuccessResult("Category deleted successfully.");
        } else {
            return new ErrorResult("Category not found!");
        }
    }

    @Override
    public DataResult<List<Category>> getAll() {
        return new SuccessDataResult<>(this.categoryRepository.findAll());
    }
}
