package com.example.spring_tp3.models.forms;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EditorForm {

    private String name;
    private String parentCompany;
    private LocalDate creationDate;
}
