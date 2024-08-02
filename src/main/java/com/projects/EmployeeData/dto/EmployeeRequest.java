package com.projects.EmployeeData.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class EmployeeRequest {
    private int Id;
    @NotBlank(message = "First Name should not be null")
    private String fname;
    @NotBlank(message ="Last Name should not be null" )
    private String lname;
    @Min(value = 15,message = "Employee age should be above 15")
    @Max(value = 50,message = "Employee should be below 50")
    private int age;

}
