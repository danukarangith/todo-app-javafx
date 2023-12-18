package lk.ijse.todo.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class TaskDTO {
    private int task_id;
    private String email;
    private String description;
    private LocalDate dueDate;
    private int isCompleted;


}
