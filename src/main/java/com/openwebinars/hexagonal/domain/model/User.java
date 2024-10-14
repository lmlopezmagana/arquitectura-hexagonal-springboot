package com.openwebinars.hexagonal.domain.model;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class User {

    @Setter(AccessLevel.NONE)
    private UserId id;

    private String name;
    private String email;
    private String password;
    @Builder.Default
    private String role = "USER";



}
