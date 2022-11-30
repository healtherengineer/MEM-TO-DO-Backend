package dev.mem.memtodo.service.concretes;

import dev.mem.memtodo.dto.ToDoListRequestDto;
import dev.mem.memtodo.model.ToDoList;
import dev.mem.memtodo.model.User;
import dev.mem.memtodo.repository.ToDoListRepository;
import dev.mem.memtodo.repository.UserRepository;
import dev.mem.memtodo.service.abstracts.ToDoListService;
import dev.mem.memtodo.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoListManager implements ToDoListService {

    @Autowired
    private ToDoListRepository toDoListRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public DataResult<ToDoList> getToDoListByToDoListId(int id) {
        ToDoList toDoList = this.toDoListRepository.getByToDoListId(id);
        if (toDoList != null) {
            return new SuccessDataResult<>(toDoList, "ToDoList fetched!");
        } else {

            return new ErrorDataResult<>(null, "TodoList is not found with this todoListId.");
        }
    }

    @Override
    public DataResult<ToDoList> getToDoListByName(String name) {
        ToDoList toDoList = this.toDoListRepository.getByName(name);
        if (toDoList != null) {
            return new SuccessDataResult<>(toDoList, "ToDoList fetched!");
        } else {
            return new ErrorDataResult<>(null, "ToDoList is not found with this name.");
        }
    }

    @Override
    public Result save(ToDoListRequestDto ToDoListRequestDto) {
        User user = userRepository.getByUserId(ToDoListRequestDto.getUserId());
        if (user == null) {
            return new ErrorResult("No user found for given userId");
        }

        ToDoList toDoList = new ToDoList(ToDoListRequestDto, user);
        ToDoList oldToDoList = toDoListRepository.getByToDoListId(ToDoListRequestDto.getToDoListId());
        if (oldToDoList != null) {
            toDoList.setCreatedAt(oldToDoList.getCreatedAt());
        }

        try {
            this.toDoListRepository.save(toDoList);
            return new SuccessResult("todolist saved successfully");
        } catch (Exception e) {
            return new ErrorResult("Error todolist not saved! => " + e.getMessage());
        }
    }

    @Override
    public Result deleteById(int toDoListId) {
        ToDoList toDoList = toDoListRepository.getByToDoListId(toDoListId);
        if (toDoList != null) {
            this.toDoListRepository.delete(toDoList);
            return new SuccessResult("TodoList deleted successfully!");
        } else {
            return new ErrorResult("TodoList not found!");
        }
    }

    @Override
    public DataResult<List<ToDoList>> getAll() {
        return new SuccessDataResult<>(this.toDoListRepository.findAll());
    }
}
