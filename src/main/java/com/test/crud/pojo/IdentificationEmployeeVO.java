package com.test.crud.pojo;

import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class IdentificationEmployeeVO {

    @Length(min = 10, max = 10, message = "The identification card must be between 10 and 10 characters")
    @NotNull
    String identificationCard;

}
