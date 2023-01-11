package com.test.crud.pojo;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeVO {

    @NotNull
    private String identificationCard;
    @NotNull
    private String firstname;
    @NotNull
    private String second_name;
    @NotNull
    private String first_surname;
    @NotNull
    private String second_surname;
    @NotNull
    private String email;
    @NotNull
    private String gender;
    @NotNull
    private String date_birth;
}
