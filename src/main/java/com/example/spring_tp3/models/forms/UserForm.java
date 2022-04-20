package com.example.spring_tp3.models.forms;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserForm {

    private String username;
    private String password;
    private String email;

}
