package dev.mem.memtodo.dto;

import dev.mem.memtodo.model.User;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ToDoListRequestDto {
    private int toDoListId;
    private String name;
    private Date createdAt;
    private int userId;
}
