package dev.mem.memtodo.dto;

import lombok.*;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {
    private String username;
    private String password;
}
