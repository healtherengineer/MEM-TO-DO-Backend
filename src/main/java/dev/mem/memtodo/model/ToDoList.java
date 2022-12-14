package dev.mem.memtodo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.mem.memtodo.dto.ToDoListRequestDto;
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
@Table(name = "to_do_lists")
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "to_do_list_id")
    private int toDoListId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now(ZoneId.of("Europe/Istanbul"));

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ToDoList(ToDoListRequestDto toDoListRequestDto,User user){
        this.toDoListId = toDoListRequestDto.getToDoListId();
        this.name = toDoListRequestDto.getName();
        this.user = user;
    }
}
