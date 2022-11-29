package dev.mem.memtodo.dto;

import dev.mem.memtodo.model.ToDoList;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ToDoRequestDto {
    private int toDoId;
    private String message;
    private boolean isFinished;
    private Date deadline;
    private Date createdAt;
    private int toDoListId;
    private int categoryId;
}
