package dev.mem.memtodo.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    private int userId;
    private String username;
    private String token;
}

