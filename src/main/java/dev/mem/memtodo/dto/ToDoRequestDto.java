package dev.mem.memtodo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ToDoRequestDto {
    private int toDoId;
    private String message;
    private boolean isFinished;
    private int priority;
//    private LocalDateTime deadline;
    private int toDoListId;
    private int categoryId;
}
