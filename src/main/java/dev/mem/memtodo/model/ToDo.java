package dev.mem.memtodo.model;

import dev.mem.memtodo.dto.ToDoRequestDto;
import lombok.*;

import javax.persistence.*;
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

    @Column(name = "deadline", nullable = true)
    private Date deadline;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "to_do_list_id")
    private ToDoList toDoList;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public ToDo(ToDoRequestDto toDoRequestDto, ToDoList toDoList, Category category) {
        // DONUSUMLER YAPILACAK
//        this.postId = postTemporaryDTO.getPostId();
//        this.message = postTemporaryDTO.getMessage();
//        this.user = user;
    }
}
