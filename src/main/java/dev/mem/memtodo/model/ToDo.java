package dev.mem.memtodo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.mem.memtodo.dto.ToDoRequestDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "to_dos")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "to_do_id")
    private int toDoId;

    @Column(name = "message", nullable = false, columnDefinition = "TEXT")
    private String message;

    @Column(name = "is_finished", nullable = false)
    private boolean isFinished;

    @Column(name = "priority", nullable = true) // 1 = low, 2 = normal, 3 = high
    private int priority;

    @Column(name = "deadline", nullable = true)
    private LocalDateTime deadline;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now(ZoneId.of("Europe/Istanbul"));

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "to_do_list_id")
    private ToDoList toDoList;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public ToDo(ToDoRequestDto toDoRequestDto, ToDoList toDoList, Category category) {
        this.toDoId = toDoRequestDto.getToDoId();
        this.message = toDoRequestDto.getMessage();
        this.isFinished = toDoRequestDto.isFinished();
        this.priority = toDoRequestDto.getPriority();
        this.deadline = toDoRequestDto.getDeadline();
        this.toDoList = toDoList;
        this.category = category;
    }
}
