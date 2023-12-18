package lk.ijse.todo.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class UserDTO {
    private String email;
    private String name;
    private String password;
}
