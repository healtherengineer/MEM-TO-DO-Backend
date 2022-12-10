package dev.mem.memtodo.service.concretes;

import dev.mem.memtodo.dto.ToDoRequestDto;
import dev.mem.memtodo.model.*;
import dev.mem.memtodo.repository.*;
import dev.mem.memtodo.service.abstracts.ToDoService;
import dev.mem.memtodo.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoManager implements ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    ToDoListRepository toDoListRepository;

    @Override
    public Result save(ToDoRequestDto toDoRequestDto) {
        Category category = categoryRepository.getByCategoryId(toDoRequestDto.getCategoryId());
        if (category == null) {
            return new ErrorResult("No category found for given categoryId");
        }

        ToDoList toDoList = toDoListRepository.getByToDoListId(toDoRequestDto.getToDoListId());
        if (toDoList == null) {
            return new ErrorResult("No todolist found for given todolistId");
        }

        ToDo toDo = new ToDo(toDoRequestDto, toDoList, category);
        ToDo oldToDo = toDoRepository.getByToDoId(toDoRequestDto.getToDoId());
        if (oldToDo != null) {
            toDoList.setCreatedAt(oldToDo.getCreatedAt());
        }

        try {
            this.toDoRepository.save(toDo);
            return new SuccessResult("toDo saved successfully");
        } catch (Exception e) {
            return new ErrorResult("Error todo not saved! => " + e.getMessage());
        }
    }

    @Override
    public Result delete(int toDoId) {
        ToDo toDo = toDoRepository.getByToDoId(toDoId);
        if (toDo != null) {
            this.toDoRepository.delete(toDo);
            return new SuccessResult("ToDo deleted successfully!");
        } else {
            return new ErrorResult("ToDo not found!");
        }
    }

    @Override
    public DataResult<ToDo> getToDoByToDoId(int toDoId) {
        ToDo toDo = toDoRepository.getByToDoId(toDoId);
        if (toDo != null) {
            return new SuccessDataResult<>(toDo, "ToDo fetched successfully!");
        } else {
            return new ErrorDataResult<>(null, "ToDo not found!");
        }
    }

    @Override
    public DataResult<List<ToDo>> getAll() {
        return new SuccessDataResult<>(this.toDoRepository.findAll(), "All todos fetched!");
    }

    @Override
    public DataResult<List<ToDo>> getToDosByCategoryId(int categoryId) {
        return new SuccessDataResult<>(this.toDoRepository.getToDosByCategoryId(categoryId), "Category Filtered Todos Fetched!");
    }

    @Override
    public DataResult<List<ToDo>> getToDosByToDoListId(int toDoListId) {
        return new SuccessDataResult<>(this.toDoRepository.getToDosByToDoListId(toDoListId), "ToDoList Filtered Todos Fetched!");
    }

    @Override
    public DataResult<List<ToDo>> getToDosByToDoListIdAndCategoryId(int toDoListId, int categoryId) {
        return new SuccessDataResult<>(this.toDoRepository.getToDosByToDoListIdAndCategoryId(toDoListId,categoryId), "Todos Fetched!(Category AND ToDoList Filtered)");
    }

    @Override
    public DataResult<List<ToDo>> getToDosByToDoListIdAndCategoryIdSortedPriorityAsc(int toDoListId, int categoryId) {
        return new SuccessDataResult<>(this.toDoRepository.getToDosByToDoListIdAndCategoryIdSortedPriorityAsc(toDoListId, categoryId), "Todos Fetched!(Category AND ToDoList Filtered ASC)");
    }

    @Override
    public DataResult<List<ToDo>> getToDosByToDoListIdAndCategoryIdSortedPriorityDesc(int toDoListId, int categoryId) {
        return new SuccessDataResult<>(this.toDoRepository.getToDosByToDoListIdAndCategoryIdSortedPriorityDesc(toDoListId, categoryId), "Todos Fetched!(Category AND ToDoList Filtered DESC)");
    }

}
