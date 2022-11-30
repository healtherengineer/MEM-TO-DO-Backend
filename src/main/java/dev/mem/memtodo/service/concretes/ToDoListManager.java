package dev.mem.memtodo.service.concretes;

import dev.mem.memtodo.model.Category;
import dev.mem.memtodo.model.ToDoList;
import dev.mem.memtodo.repository.ToDoListRepository;
import dev.mem.memtodo.service.abstracts.ToDoListService;
import dev.mem.memtodo.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoListManager implements ToDoListService {

    @Autowired
    private ToDoListRepository toDoListRepository;

    @Override
    public DataResult<ToDoList> getByToDoListId(int id) {

        ToDoList toDoList = this.toDoListRepository.getByToDoListId(id);
        if (toDoList != null) {
            return new SuccessDataResult<>(toDoList);
        } else {

            return new ErrorDataResult<>(null, "TodoList is not found with this todoListId .");
        }


    }

    @Override
    public DataResult<ToDoList> getByName(String name) {
        ToDoList toDoList = this.toDoListRepository.getByName(name);
        if (toDoList != null) {
            return new SuccessDataResult<>(toDoList);
        } else {
            return new ErrorDataResult<>(null, "ToDoList is not found with this name.");
        }
    }

    @Override
    public Result addToDoList(ToDoList toDoList) {
        this.toDoListRepository.save(toDoList);
        return new SuccessResult("TodoList saved successfully");
    }

    @Override
    public Result deleteById(int toDoListId) {

        this.toDoListRepository.deleteById(toDoListId);
        return new SuccessResult("TodoList deleted successfully");


    }

    @Override
    public Result updateTodoList(int toDoListId, ToDoList toDoList) {
        ToDoList todoListOld = this.toDoListRepository.getByToDoListId(toDoListId);
        if (todoListOld != null) {
            //Id yi eşitlemezsek yeni kayıt ekler. Bu yüzden Id yi setliyorum.
            toDoList.setToDoListId(todoListOld.getToDoListId());
            this.toDoListRepository.save(toDoList);
            return new SuccessResult("TodoList updated succesfully.");
        } else {
            return new ErrorResult("TodoList was not updated.It may not be founded.");
        }
    }

    @Override
    public DataResult<List<ToDoList>> getAll() {
        return new SuccessDataResult<>(this.toDoListRepository.findAll());
    }
}
