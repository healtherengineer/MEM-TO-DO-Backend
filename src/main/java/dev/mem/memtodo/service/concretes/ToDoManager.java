package dev.mem.memtodo.service.concretes;

import dev.mem.memtodo.dto.ToDoRequestDto;
import dev.mem.memtodo.model.Category;
import dev.mem.memtodo.model.ToDo;
import dev.mem.memtodo.model.ToDoList;
import dev.mem.memtodo.repository.ToDoRepository;
import dev.mem.memtodo.service.abstracts.ToDoService;
import dev.mem.memtodo.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoManager implements ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public Result save(ToDoRequestDto toDoRequestDto) {
//        Category category = categoryRepository.getByCategoryId(toDoRequestDto.getCategoryId());
//        ToDoList toDoList = toDoListRepository.getByToDoListId(toDoRequestDto.getToDoListId());
//        ToDo toDo = new ToDo(toDoRequestDto, toDoList, category);
//        this.toDoRepository.save(toDo);
        return new SuccessResult("Post saved successfully!");
    }

}
